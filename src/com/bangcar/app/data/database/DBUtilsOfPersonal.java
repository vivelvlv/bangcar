package com.bangcar.app.data.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by xus5985 on 2014/6/27.
 */
public class DBUtilsOfPersonal implements DBConsts {
    private SQLiteDatabase db;

    public DBUtilsOfPersonal(SQLiteDatabase db) {
        this.db = db;
    }
    /**
     * Personal: 将密码写入数据库
     * 传入的参数中，密码已经MD5加密
     */
    public void insertPw(int uid, String pw) {
        ContentValues values = new ContentValues();
        values.put("uid", uid);
        values.put("pw", pw);
        Cursor cursor = db.query(TABLE_PERSONAL, new String[]{"pw"}, "uid=?", new String[]{uid + ""}, null, null, null);
        if(cursor.moveToNext())
            db.update(TABLE_PERSONAL, values, "uid=?", new String[]{uid + ""});
        else {
            db.insert(TABLE_PERSONAL, null, values);
        }
    }

    /**
     * Personal: 查找用户指定信息（单条）
     */
    public String queryPersonalSingleInfo(int uid, String column) {
        Cursor cursor = db.query(TABLE_PERSONAL, new String[]{column}, "uid=?", new String[]{uid + ""}, null, null, null);
        try {
            if(cursor.moveToNext())
                return cursor.getString(cursor.getColumnIndex(column));
            else
                return null;
        } finally {
            cursor.close();
        }
    }
}
