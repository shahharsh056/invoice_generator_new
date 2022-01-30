package com.example.sem6_project.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;

import com.example.sem6_project.model.customermodel;
import com.example.sem6_project.model.productmodel;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Database extends SQLiteAssetHelper
{
    private static final String DATABASE_NAME = "billgenerator";
    private static final int DATABASE_VERSION = 1;

    public static final String TBL_CUSTOMER = "tbl_customer";
    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String MOBILE = "Mobile";
    public static final String EMAIL = "Email";
    public static final String CITY = "City";

    public static final String TBL_PRODUCT = "tbl_product";
    public static final String P_ID = "ID";
    public static final String P_NAME = "Name";
    public static final String COMPANY = "CompanyName";
    public static final String PRICE = "Price";

    public Database(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    public long insertcustomerdata(String name , String mobile , String email , String city)
    {
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(MOBILE, mobile);
        cv.put(EMAIL, email);
        cv.put(CITY, city);
        SQLiteDatabase db = getWritableDatabase();
        long ID = db.insert(TBL_CUSTOMER, null, cv);
        Log.i("insert :: ", String.valueOf(ID));
        return ID;
    }

    public long insertproductdata(String name , String company , Editable price)
    {
        ContentValues cv = new ContentValues();
        cv.put(P_NAME, name);
        cv.put(COMPANY, company);
        cv.put(PRICE, String.valueOf(price));
        SQLiteDatabase db = getWritableDatabase();
        long ID = db.insert(TBL_PRODUCT, null, cv);
        Log.i("insert :: ", String.valueOf(ID));
        return ID;
    }

    @SuppressLint("Range")
    public ArrayList<customermodel> getuserlist() {
        ArrayList<customermodel> userlist = new ArrayList<>();
        String query = "SELECT * FROM TBL_CUSTOMER";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        for (int i=0; i<cursor.getCount(); i++) {
            customermodel userModel = new customermodel();
            userModel.setID(cursor.getInt(cursor.getColumnIndex(ID)));
            userModel.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            userModel.setCity(cursor.getString(cursor.getColumnIndex(CITY)));
            userModel.setMobile(cursor.getString(cursor.getColumnIndex(MOBILE)));
            userModel.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
            userlist.add(userModel);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return userlist;
    }

    @SuppressLint("Range")
    public ArrayList<productmodel> getproductlist() {
        ArrayList<productmodel> productlist = new ArrayList<>();
        String query = "SELECT * FROM TBL_PRODUCT";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        for (int i=0; i<cursor.getCount(); i++) {
            productmodel productModel = new productmodel();
            productModel.setID(cursor.getInt(cursor.getColumnIndex(P_ID)));
            productModel.setName(cursor.getString(cursor.getColumnIndex(P_NAME)));
            productModel.setCompanyName(cursor.getString(cursor.getColumnIndex(COMPANY)));
            productModel.setPrice(cursor.getString(cursor.getColumnIndex(PRICE)));
            productlist.add(productModel);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return productlist;
    }
}