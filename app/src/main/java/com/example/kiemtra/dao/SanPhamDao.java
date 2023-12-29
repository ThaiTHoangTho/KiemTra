package com.example.kiemtra.dao;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.kiemtra.database.DbHelper;
import com.example.kiemtra.model.SanPham;

import java.util.ArrayList;

public class SanPhamDao {
    private final DbHelper dbHelper;
    public SanPhamDao(Context context)
    {
        dbHelper= new DbHelper(context);
    }
    public ArrayList<SanPham> getAllSanPham()
    {
        //tao 1 dsach de add dữ liệu
        ArrayList<SanPham> list= new ArrayList<>();
        SQLiteDatabase database  =  dbHelper.getReadableDatabase();
        //db chạy
        database.beginTransaction();
        try{
            Cursor cursor= database.rawQuery("SELECT * FROM SANPHAM",null);
            if (cursor.getCount()>0)
            {
                cursor.moveToFirst();
                do{
                    list.add(new SanPham(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getDouble(2),
                            cursor.getString(3)));
                }while (cursor.moveToNext());
                database.setTransactionSuccessful();
            }
        }catch (Exception e )
        {
            Log.e(TAG,"get ListSanPham: "+e);
        }
        finally {
            database.endTransaction();
        }
        return list;
    }
    public  long addSanPham(SanPham sp)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        db.beginTransaction();
        //Su dung contentValues ddeeer đưa dữ liệu vào db
        ContentValues values= new ContentValues();
        values.put("TENSP",sp.getTensp());
        values.put("GIATIEN",sp.getGiatien());
        values.put("IMAGE",sp.getImage());
        //if thanh cong trả về giá trị tương ứng
        long check=db.insert("SANPHAM",null,values);
        return check;
    }
    public  boolean updateSanPham(SanPham sp)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        db.beginTransaction();
        //Su dung contentValues ddeeer đưa dữ liệu vào db
        ContentValues values= new ContentValues();
        values.put("TENSP",sp.getTensp());
        values.put("GIATIEN",sp.getGiatien());
        values.put("IMAGE",sp.getImage());
        //if thanh cong trả về giá trị tương ứng
        long check=db.update("SANPHAM",values,"MASP=?",
                new String[]{String.valueOf(sp.getMasp()
                )});
        return check!=-1;

    }
    public  boolean DelteteSanPham(int masp)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        db.beginTransaction();
        long check=db.delete("SANPHAM","MASP=?",
                new String[]{String.valueOf(masp)});
        return check!=-1;

    }

}

