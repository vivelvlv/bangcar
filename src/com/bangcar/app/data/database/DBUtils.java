package com.bangcar.app.data.database;

/**
 * Created by xus5985 on 2014/6/27.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Utils: DBUtils
 * Class: DatabaseHelper
 * Description: 工具类，封装了关于数据库的所有操作，其中包括自定义数据库帮助类DatabaseHelper以及封装在DBUtils中的各种操作
 * @author wangjun
 * @date 2014-2-26 下午3:33:52
 */
public class DBUtils implements DBConsts {

    public static final String	DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + "YGB_DB";	//在手机里存放数据库的位置(/data/data/包名/文件名)
    //单例
    protected volatile static DBUtils uniqueDBUtils;

    //用以普通数据库操作的工具
    private DatabaseHelper databaseHelper;
    //sqlite数据库
    protected static SQLiteDatabase db;

    //用到的数据库子工具，每一个子工具负责一类数据或者一张表的操作
    private DBUtilsOfPersonal utilsOfPersonal;
    private DBUtilsOfConfig utilsOfConfig;


    private DBUtils(Context context, String name, int version) {
        databaseHelper = new DatabaseHelper(context, name, version);
        db = databaseHelper.getWritableDatabase();
        //初始化db
        initAllUtils(db);
    }

    //初始化各个分工具
    private void initAllUtils(SQLiteDatabase db) {
        utilsOfPersonal = new DBUtilsOfPersonal(db);
        utilsOfConfig = new DBUtilsOfConfig(db);

    }

    /**
     * 单例模式的实现
     * @param context
     * @param name
     * @param version
     */
    public static DBUtils getInstance(Context context, String name, int version) {
        if(uniqueDBUtils == null) {
            synchronized (DBUtils.class) {
                if(uniqueDBUtils == null) {
                    uniqueDBUtils = new DBUtils(context, name, version);
                }
            }
        }
        return uniqueDBUtils;
    }

    /**
     * 关闭数据库
     */
    public void closeDB() {
		/*if(db != null && db.isOpen())
			db.close();*/
        DBUtils.uniqueDBUtils = null;
    }

    /**
     * 检测数据库是否存在
     */
    public boolean exist(String dbName) {
        return databaseHelper.exist(dbName);
    }

    //Personal: 查找用户指定信息（单条）
    public String queryPersonalSingleInfo(int uid, String column) {
        return utilsOfPersonal.queryPersonalSingleInfo(uid, column);
    }
    /*
     * Personal: 将密码写入数据库
     * 传入的参数中，密码已经MD5加密
     */
    public void insertPw(int uid, String pw) {
        utilsOfPersonal.insertPw(uid, pw);
    }

    //Configuration: 初次打开设置配置信息
    public void onFirstOpen() {
        utilsOfConfig.onFirstOpen();
    }
    
    
    public String Db_getCaptchaTime()
    {
    	return utilsOfConfig.getCaptchaTime();
    }
    public void Db_resetCaptchaTime()
    {
    	utilsOfConfig.resetCaptchaTime();
    }
    public void Db_resetCaptchaCount(){
    	utilsOfConfig.resetCaptchaCount();
    }
    public int Db_getCaptchaCount(){
    	return utilsOfConfig.getCaptchaCount();
    }
    public void Db_addCaptchaCount(){
    	utilsOfConfig.addCaptchaCount();
    }

    public void Db_setUserAccount(String account,String email){
        utilsOfConfig.setUserInfo(account,email);
    }

    public List<String> Db_getUserInfo(){
        return utilsOfConfig.getUserInfo();
    }

    public void DbsetCatcha(String catcha)
    {
       String result = DbgetCatcha();
       if(result == "" || result.isEmpty() || result==null)
       {
           utilsOfConfig.setCatcha(catcha,System.currentTimeMillis()+"");
       }
       else
       {
           utilsOfConfig.updateCatcha(catcha,System.currentTimeMillis()+"");
       }


    }

    public void DbupdateCatcha(String catcha)
    {
        utilsOfConfig.updateCatcha(catcha,System.currentTimeMillis()+"");
    }

    public String DbgetCatcha()
    {
        return utilsOfConfig.getCatcha();
    }









    /**
     * 数据库功能方法：检查相应名称的表是否存在
     */
    public boolean tableIsExist(SQLiteDatabase db, String tableName) {
        boolean result = false;
        if(tableName == null)
            return false;
        Cursor cursor = null;
        String sql = "select count(*) as c from Sqlite_master  where type ='table' and name ='"+tableName.trim()+"' ";
        cursor = db.rawQuery(sql, null);
        try {
            if(cursor.moveToNext()) {
                if(cursor.getInt(0) > 0)
                    result = true;
            }
            return result;
        } finally {
            cursor.close();
        }
    }

    /**
     * 插入insert方法一（根据ContentValues对象插入表数据）
     *
     * @param tableName
     *            表名
     * @param values
     *            ContentValues对象，存放数据
     * @return
     * @author wangj
     */
    public boolean insert(String tableName, ContentValues values) {
        boolean flag = false;
        try {
            db.insert(tableName, null, values);
            flag = true;
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 插入insert方法二 （根据hashMap插入表数据)
     *
     * @param tableName
     *            表名
     * @param parameter
     *            hashMap存放数据
     * @return
     * @author wangj
     */
    public boolean insertForMap(String tableName, HashMap<?, ?> parameter) {
        boolean flag = false;
        String columns = "", values = "";
        Iterator<?> it = parameter.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            columns += key + ",";
            values += parameter.get(key) + ",";
        }
        if (columns.endsWith(","))
            columns = columns.substring(0, columns.lastIndexOf(","));
        if (values.endsWith(","))
            values = values.substring(0, values.lastIndexOf(","));

        String sql = "insert into " + tableName + " (" + columns + ") values (" + values + ")";

        try {
            db.execSQL(sql);
            flag = true;
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 更新update方法二 （根据hashMap更新表数据)
     *
     * @param tableName
     *            表名
     * @param parameter
     *            hashMap存放数据
     * @param wherekey
     *            根据主键更新
     * @param wherevalue
     *            where值
     * @return
     * @author wangj
     */
    public boolean updateForMap(String tableName, HashMap<?, ?> parameter, String wherekey, String wherevalue) {
        boolean flag = false;
        String sql = "update " + tableName + " set ";
        Iterator<?> it = parameter.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            sql = sql + key + "=" + parameter.get(key) + ",";
        }
        if (sql.endsWith(","))
            sql = sql.substring(0, sql.lastIndexOf(","));

        sql = sql + " where " + wherekey + "=" + wherevalue;

        try {
            db.execSQL(sql);
            flag = true;
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 更新
     *
     * @param tableName
     *            表名
     * @param values
     *            ContentValues对象，存放更新内容
     * @param whereClause
     *            条件
     * @param whereArgs
     *            条件参数
     * @author wangj
     */
    public int update(String tableName, ContentValues values, String whereClause, String[] whereArgs) {
        int count = -1;
        try {
            count = db.update(tableName, values, whereClause, whereArgs);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 删除
     *
     * @param tableName
     *            表名
     * @param whereClause
     *            条件
     * @param whereArgs
     *            条件参数
     * @author wangj
     */
    public int delete(String tableName, String whereClause, String[] whereArgs) {
        int count = -1;
        try {
            count = db.delete(tableName, whereClause, whereArgs);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据sql操作数据库，一般是update，delete，insert操作，不需要返回值
     *
     * @param sql
     *            操作sql
     */
    public void doForSql(String sql) {
        try {
            db.execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 根据sql查询数据库
     *
     * @param sql
     * @param selectionArgs
     *            (可以为null,如果不会null，有几个参数，对应sql中的几个？号）
     * @return Cursor游标对象
     */
    public Cursor queryForSql(String sql, String[] selectionArgs) {
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, selectionArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursor;
    }

    /**
     * 建立数据库
     */
    private void createDatabase(SQLiteDatabase db) {
        Log.i("vive", "create db");
        //第一次建立数据库时，需要建立所有的表
        //用户信息
        db.execSQL(DBSqlConst.TABLE_PERSONAL_CREATE_SQL);
        //APP配置信息
        db.execSQL(DBSqlConst.TABLE_CONFIG_CREATE_SQL);


        Log.i("vive", "create db success!!");
    }

    /**
     * 内部类: 数据库帮助类
     */
    class DatabaseHelper extends SQLiteOpenHelper
    {
        public static final int VERSION=1;
        public Context context;

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)	{
            super(context, name, factory, version);
            this.context = context;
        }

        public DatabaseHelper(Context context, String name, int version) {
            this(context, name, null, version);
            this.context = context;
        }

        public DatabaseHelper(Context context, String name) {
            this(context, name, VERSION);
            this.context = context;
        }

        public Context getContext() {
            return context;
        }

        /**
         * 创建数据库
         */
        public void onCreate(SQLiteDatabase db) {
            createDatabase(db);
        }

        /**
         * 数据库升级逻辑
         *1-->2
         * personal：保留内容，新增字段
         */
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            initAllUtils(db);
            if(oldVersion <= 1)
            {
                //TABLE_PERSONAL
				/*db.execSQL("ALTER TABLE " + TABLE_PERSONAL + " RENAME TO temp_personal");
				db.execSQL("CREATE TABLE personal(" +
						"uid int(10) not null," +
						"username varchar(30) null," +
						"pw varchar(50) null)");
				db.execSQL("INSERT INTO " + TABLE_PERSONAL + " SELECT " +
						"uid, \"\", pw FROM temp_personal");
				db.execSQL("DROP TABLE temp_personal");*/
            }
        }

        public boolean deleteDatabase(Context context) {
            return context.deleteDatabase(DB_NAME);
        }

        /**
         * 检查数据库是否存在
         */
        public boolean exist(String dbName) {
            File dbFile = context.getDatabasePath(dbName);
            if(dbFile.exists())
                return true;
            else
                return false;
        }
    }
}
