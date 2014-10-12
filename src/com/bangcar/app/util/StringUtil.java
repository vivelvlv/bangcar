package com.bangcar.app.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xus5985 on 2014/6/26.
 */
public class StringUtil {

    public static boolean isMobileNO(String mobiles){

        Pattern p = Pattern.compile("^(1[3-9][0-9])\\d{8}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();

    }

    /**

     正则表达式，java与android稍有不同，如java中\s+ 需要加多\ 变成\\s+,

     android匹配字符



     *+ Zero or more (possessive).
     ?+ Zero or one (possessive).
     ++ One or more (possessive).
     {n}+ Exactlyn(possessive).
     {n,}+ At leastn(possessive).
     {n,m}+ At leastnbut not more thanm(possessive).



     **/

    /**
     * 是否为账号规范
     * 如：
     * 6~18个字符，可使用字母、数字、下划线，需以字母开头
     *
     * @param text
     * @return
     * @author luman
     */
    public static boolean isAccountStandard(String text) {
        //不能包含中文
        if(hasChinese(text)){
            return false;
        }

/**
 * 正则匹配：
 * [a-zA-Z]:字母开头
 * \\w :可包含大小写字母，数字，下划线,@
 * {5,17} 5到17位，加上开头字母 字符串长度6到18
 */
        String format = "[a-zA-Z](@?+\\w){5,17}+";
        if(text.matches(format)){
            return true;
        }
        return false;
    }


    /**
     * 是否为密码规范
     *
     * @param text
     * @return
     * @author luman
     */
    public static boolean isPasswordStandard(String text) {


        //不能包含中文
        if(hasChinese(text)){
            return false;
        }


/**
 * 正则匹配
 * \\w{6,20}匹配所有字母、数字、下划线 字符串长度6到20（不含空格）
 */
        String format = "[0-9a-zA-Z_]{6,20}+";
        int flag = 0;
        if(text.matches(format)){
            if(text.matches(".*[0-9].*")){
                flag++;
            }
            if(text.matches(".*[a-z].*")){
                flag++;
            }
            if(text.matches(".*[A-Z].*")){
                flag++;
            }
            if(flag>=2){
                return true;
            }
        }
        return false;
    }



    /**
     * 中文识别
     *
     *@author luman
     */
    public static boolean hasChinese(String source) {
        String reg_charset = "([\\u4E00-\\u9FA5]*+)";
        Pattern p = Pattern.compile(reg_charset);
        Matcher m = p.matcher(source);
        boolean hasChinese=false;
        while (m.find())
        {
            if(!"".equals(m.group(1))){
                hasChinese=true;
            }


        }
        return hasChinese;
    }



}
