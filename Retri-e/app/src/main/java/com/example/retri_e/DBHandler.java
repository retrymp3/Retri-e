package com.example.retri_e;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHandler extends SQLiteOpenHelper {
    //final String DATABASE_NAME = "details.db";
    //final String TABLE_NAME = "credentials";
    //Authentication table columns.
    final String col_1 = "NAME";
    final String col_2 = "PASSWORD";
    final String col_3 = "CONTACTNO";
    final String col_4 = "EMAILID";

    //Product details table columns.
    final String col_a = "NAME";
    final String col_b = "PRICE";
    final String col_c = "IMG";

    public DBHandler(Context context) {
        super(context, "details.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table credentials(NAME TEXT,PASSWORD TEXT,CONTACTNO INTEGER,EMAILID TEXT)");
        db.execSQL("create table orders(NAME TEXT,PRICE TEXT,IMG INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS credentials");
        db.execSQL("DROP TABLE IF EXISTS orders");
    }

    public boolean insertData(String name, String password, String emailid, String phoneno) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1, name);
        contentValues.put(col_2, password);
        contentValues.put(col_3, phoneno);
        contentValues.put(col_4, emailid);
        long result = db.insert("credentials", null, contentValues);
        if (result == -1)
            return false;

        else
            return true;
    }

    public Boolean checknamePassword(String name,String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from credentials where NAME = ? and PASSWORD=?", new String[]{name, password});
        if (cursor.getCount() > 0)
            return true;

        else
            return false;

    }

    public void insertItems(String name, String price, int img){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_a, name);
        contentValues.put(col_b, price);
        contentValues.put(col_c, img);
        db.insert("Orders", null, contentValues);
    }

}





