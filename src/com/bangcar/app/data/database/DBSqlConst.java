package com.bangcar.app.data.database;

/**
 * Created by xus5985 on 2014/6/27.
 */
public class DBSqlConst {

    //数据表sql
    /**
     * TABLE PERSONAL
     * uid(primary key): 用户UID，多个用户使用时记录多个用户的信息
     */
    public static	final	String		TABLE_PERSONAL_CREATE_SQL	= "create table personal(" +
            "uid int(10) not null," +
            "pw varchar(50) null)";
    /**
     * TABLE CONFIG: APP配置信息
     * config_type: 配置项
     * config_value: 配置项的值
     */
    public static	final	String      TABLE_CONFIG_CREATE_SQL		= "create table config(" +
            "config_type varchar(15) not null," +
            "config_value varchar(30) not null)";

}
