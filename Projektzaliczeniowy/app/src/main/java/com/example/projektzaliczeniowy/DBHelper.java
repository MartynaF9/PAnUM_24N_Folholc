package com.example.projektzaliczeniowy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/** Pomocnik SQLite: tworzy tabelę orders i dodaje rekordy */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "KawiarenkaDB";
    private static final int DB_VER = 1;

    public DBHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VER);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE orders (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "product TEXT," +
                        "quantity INTEGER," +
                        "price REAL," +
                        "order_time TEXT)"
        );
    }

    @Override public void onUpgrade(SQLiteDatabase db,int ov,int nv){
        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }

    /** Zapis nowego zamówienia */
    public void addOrder(Order o){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("product", o.getProductName());
        v.put("quantity", o.getQuantity());
        v.put("price", o.getPrice());
        v.put("order_time", o.getOrderTime());
        db.insert("orders", null, v);
        db.close();
    }
}
