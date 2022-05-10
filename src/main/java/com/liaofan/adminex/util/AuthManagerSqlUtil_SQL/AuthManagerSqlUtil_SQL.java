package com.liaofan.adminex.util.AuthManagerSqlUtil_SQL;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * SQL工具类
 */
public class AuthManagerSqlUtil_SQL {
    /**
     * 利用SQL来控制权限的方法
     * 仅限于查询
     *
     * @param String 返回经过权限处理之后的SQL语句
     */
    public String authorityManagerSQL_SQL(String strSql, String... noauthority_args) throws Exception {
        //转换成小写
        strSql = strSql.toLowerCase(Locale.ROOT);
        String strSQL_Select = strSql.substring(0, 6);

        if (!"select".equals(strSQL_Select)) {
            throw new Exception("请检查SQL语句，没有获取到select字符串");
        }

        //获取在第一个select和from之间的语句
        String strBetweenSelectFromSQL = strSql.substring(strSql.indexOf(strSQL_Select) + 6, strSql.indexOf("from")).trim();

        //获取form之后的语句
        String strAfeterFromSQL = strSql.substring(strSql.indexOf("from"));

        //生成新的SQL
        String strNewSQL = "";

        for (String noauthority_arg : noauthority_args) {
            //分割字段
            String[] sqlFiled = strBetweenSelectFromSQL.split(",");


            String[] sqlFiledList = sqlFiled;  //将数组转换成list
            for (String sqlFiled_str : sqlFiledList) {   //遍历list
                String sqlFiled_str_arr_1 = "";   //字段名
                String strFiled_str_arr_0 = "";   //字段名
                if(sqlFiled_str.contains(".")) {  //如果包含.则是表名.字段名，否则是字段名
                    String[] sqlFiled_str_arr = sqlFiled_str.split("\\."); //分割字段
                    sqlFiled_str_arr_1 = sqlFiled_str_arr[1]; //获取第二个字段名
                    strFiled_str_arr_0 = sqlFiled_str_arr[0]; //获取第一个字段名
                } else {
                    sqlFiled_str_arr_1 = sqlFiled_str;  //否则就是字段名
                }

                if (noauthority_arg.equals(sqlFiled_str_arr_1)) {  //如果字段名相同
                    boolean contains = strBetweenSelectFromSQL.contains("." + noauthority_arg); //判断是否包含


                    String strRemoveFileld = "";

                    if (contains) {  //如果包含
                        String strBeforeDot = strFiled_str_arr_0;  //获取第一个字段名
                        strRemoveFileld = strBeforeDot + "." + noauthority_arg;   //获取第一个字段名.字段名
                    } else {
                        strRemoveFileld = noauthority_arg;  //否则就是字段名
                    }


                    if(strRemoveFileld.contains(",")) {    //如果包含,则是多个字段
                        strRemoveFileld = strRemoveFileld.replaceAll(",", "");  //去除多个字段
                    }

                    System.out.println(strRemoveFileld);   //输出字段名

                    //删除字段
                    strBetweenSelectFromSQL = strBetweenSelectFromSQL.replace(strRemoveFileld, "");
                }
            }
        }

        if (strBetweenSelectFromSQL.trim().length() <= 0) {  //如果没有字段
            throw new Exception("无法找到相应字段,请检查权限配置字段是否合理");
        }

        if (strBetweenSelectFromSQL.contains(",")) {  //如果包含,则是多个字段
            //去除多个字段
            strBetweenSelectFromSQL = strBetweenSelectFromSQL.substring(0, strBetweenSelectFromSQL.lastIndexOf(","));
        }

        //判断是否包含字母
        if (strBetweenSelectFromSQL.matches("[a-zA-Z]+")) {
            //如果包含字母，则是表名
            strBetweenSelectFromSQL = strBetweenSelectFromSQL;
        } else {
            throw new Exception("已屏蔽所有字段,请检查权限配置字段是否合理");
        }
        //生成新的SQL
        strNewSQL = strSQL_Select + " " + strBetweenSelectFromSQL + " " + strAfeterFromSQL;

        String strSQL_select = "SELECT" + strBetweenSelectFromSQL + " from (" + strNewSQL + ")";
        System.out.println(strSQL_select);  //输出新的SQL
        return strSQL_select;  //返回新的SQL
    }


    public static void main(String[] args) {
        AuthManagerSqlUtil_SQL sqlUtil = new AuthManagerSqlUtil_SQL();

        try {
            String strSQL = "select a.name,b.sex,age,realname from db INNER JOIN xxm b ON a.sex=b.sex";
            sqlUtil.authorityManagerSQL_SQL(strSQL, "name", "age","sex");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
