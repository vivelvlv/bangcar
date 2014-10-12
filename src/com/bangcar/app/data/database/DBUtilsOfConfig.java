package com.bangcar.app.data.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xus5985 on 2014/6/27.
 */
public class DBUtilsOfConfig implements DBConsts {

    /**
     * 查询不到返回值
     */
    public static final int BACKNULL = -1;
    /**
     * 是第一次登陆
     */
    public static final String ISFIRSTOPEN = "1";//
    /**
     * 不是第一次登陆
     */
    public static final String NOTFIRSTOPEN = "0";//
    public static final String mEMPTY = "";
    private SQLiteDatabase db;

    public DBUtilsOfConfig(SQLiteDatabase db) {
        this.db = db;
    }


    /**
     * Configuration: 初次打开设置配置信息
     */
    public void onFirstOpen() {
        ContentValues values = new ContentValues();
        values.put("config_type", "first_login");
        values.put("config_value", ISFIRSTOPEN);
        db.insert(TABLE_CONFIG, null, values);            //是否第一次登陆，1为是，0为否
        values = new ContentValues();
        values.put("config_type", "version");
        values.put("config_value", "1.0");
        db.insert(TABLE_CONFIG, null, values);            //App版本
    }

    public void newUserInfo(String account, String email) {
        ContentValues values = new ContentValues();
        values.put("config_type", "userAccount");
        values.put("config_value", account);
        db.insert(TABLE_CONFIG, null, values);
        values.put("config_type", "userEmail");
        values.put("config_value", email);
        db.insert(TABLE_CONFIG, null, values);

    }

    public List<String> getUserInfo() {
        List<String> list = new ArrayList<String>();

        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"userAccount"}, null, null, null);
        try {
            if (cursor.moveToNext()) {
                list.add(cursor.getString(cursor.getColumnIndex("config_value")));
            } else {
                return null;
            }
        } finally {
            cursor.close();
        }
        cursor = db.query(TABLE_CONFIG,new String[]{"config_value"},"config_type=?", new String[]{"userEmail"},null,null,null);
        try{
            if(cursor.moveToNext()){
                list.add(cursor.getString(cursor.getColumnIndex("config_value")));
            }else{
                return null;
            }
        }finally {
            cursor.close();
        }
        return list;
    }

    //把用户的注册手机号和邮箱信息保存到本地数据库中
    public void setUserInfo(String account, String email) {

        ContentValues values = new ContentValues();
        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"userAccount"}, null, null, null);
        try {
            if (cursor.moveToNext()) {
                values.put("config_type", "userAccount");
                values.put("config_value", account);
                db.update(TABLE_CONFIG, values, "config_type=?", new String[]{"userAccount"});
                values.put("config_type", "userEmail");
                values.put("config_value", email);
                db.update(TABLE_CONFIG, values, "config_type=?", new String[]{"userEmail"});
            } else {
                newUserInfo(account, email);
            }
        } finally {
            cursor.close();
        }
    }

    public void setCatcha(String catcha, String time) {
        ContentValues values = new ContentValues();
        values.put("config_type", "catcha");
        values.put("config_value", catcha);
        db.insert(TABLE_CONFIG, null, values);
        values.put("config_type", "catcha_time");
        values.put("config_value", time);
        db.insert(TABLE_CONFIG, null, values);
    }

    //新建一个数据库表单，记录发送验证码的次数， 创建验证码的发送时间表单
    public void setSendCaptchaCount() {
        ContentValues values = new ContentValues();
        values.put("config_type", "sendedCaptchaCount");
        values.put("config_value", 0);
        db.insert(TABLE_CONFIG, null, values);

        values.put("config_type", "captchaTime");
        values.put("config_value", System.currentTimeMillis());

        db.insert(TABLE_CONFIG, null, values);

    }

    //发送验证码次数自增++
    public void addCaptchaCount() {
        ContentValues values = new ContentValues();

        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"sendedCaptchaCount"}, null, null, null);
        try {
            if (cursor.moveToNext()) {
                int olderCount = Integer.parseInt(cursor.getString(cursor.getColumnIndex("config_value")));
                values.put("config_type", "sendedCaptchaCount");
                values.put("config_value", olderCount + 1);
                db.update(TABLE_CONFIG, values, "config_type=?", new String[]{"sendedCaptchaCount"});
            } else {
                setSendCaptchaCount();
            }
        } finally {
            cursor.close();
        }
    }

    //获得验证码的发送次数
    public int getCaptchaCount() {


        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"sendedCaptchaCount"}, null, null, null);

        try {
            if (cursor.moveToNext()) {
                return Integer.parseInt(cursor.getString(cursor.getColumnIndex("config_value")));
            } else {
                return 0;
            }
        } finally {
            cursor.close();
        }
    }

    //获得发送验证码的时间
    @SuppressWarnings("finally")
    public String getCaptchaTime() {
        String timeString = null;
        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"captchaTime"}, null, null, null);
        try {
            if (cursor.moveToNext()) {
                timeString = cursor.getString(cursor.getColumnIndex("config_value"));
            }
        } finally {
            cursor.close();
            return timeString;
        }
    }

    //重置发送验证码的时间
    public void resetCaptchaTime() {
        ContentValues values = new ContentValues();
        values.put("config_type", "captchaTime");
        values.put("config_value", System.currentTimeMillis());
        db.update(TABLE_CONFIG, values, "config_type=?", new String[]{"captchaTime"});
    }


    //重置验证码的发送次数
    public void resetCaptchaCount() {
        ContentValues values = new ContentValues();
        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"sendedCaptchaCount"}, null, null, null);
        try {
            if (cursor.moveToNext()) {

                values.put("config_type", "sendedCaptchaCount");
                values.put("config_value", 0);
                db.update(TABLE_CONFIG, values, "config_type=?", new String[]{"sendedCaptchaCount"});

            } else {

            }
        } finally {
            cursor.close();
        }
    }

    public void updateCatcha(String catcha, String time) {

        ContentValues values = new ContentValues();


        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"catcha"}, null, null, null);
        try {
            if (cursor.moveToNext()) {
                values.put("config_type", "catcha");
                values.put("config_value", catcha);
                db.update(TABLE_CONFIG, values, "config_type=?", new String[]{"catcha"});
                values.put("config_type", "catcha_time");
                values.put("config_value", time);
                db.update(TABLE_CONFIG, values, "config_type=?", new String[]{"catcha_time"});
            } else {
                setCatcha(catcha, time);
            }

        } finally {
            cursor.close();
        }


    }

    public String getCatcha() {
        Cursor cursor = db.query(TABLE_CONFIG, new String[]{"config_value"}, "config_type=?", new String[]{"catcha"}, null, null, null);
        try {
            if (cursor.moveToNext()) {
                return Integer.parseInt(cursor.getString(cursor.getColumnIndex("config_value"))) + "";
            } else
                return null;
        } finally {
            cursor.close();
        }
    }


}
