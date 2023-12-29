package com.example.kiemtra.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "SanPhamDB", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
///tao câu lệnh tạo sql
        String sql="CREATE TABLE SANPHAM (MASP INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "TENSP TEXT, GIATIEN REAL,IMAGE TEXT)";
        db.execSQL(sql);
        //tao câu lẹnh thêm dữ liệu
        String data="INSERT INTO SANPHAM VALUES(1,'Veggie tomato mix',1.900,'https://static.independent.co.uk/s3fs-public/thumbnails/image/2016/12/29/16/junk-food-istock-zeljkosantrac.jpg')," +
                "(2,'Fishwith mix orange',1.900,'https://rgb.vn/wp-content/uploads/2016/05/nghe-thuat-chup-anh-mon-an-loi-cuon-06.jpg'),"+
                "(3,'Veggie tomato mix',1.900,'https://rgb.vn/wp-content/uploads/2016/05/nghe-thuat-chup-anh-mon-an-loi-cuon-06.jpg')";
        db.execSQL(data);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            // Thực hiện các câu lệnh SQL cập nhật từ phiên bản 1 lên phiên bản 2
            db.execSQL("DROP TABLE IF EXISTS SANPHAM");
            onCreate(db);

        }
    }
}
