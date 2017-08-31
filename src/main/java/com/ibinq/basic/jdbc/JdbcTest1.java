package com.ibinq.basic.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Created by Administrator on 2017/8/31.
 */
public class JdbcTest1 {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";

    public static final String DBURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

    public static final String DBUSER = "root";

    public static final String DBPASS = "root";

    @Test
    public void testJdbc2()throws Exception{
        Connection con = null; //表示数据库的连接对象
        Class.forName(DBDRIVER); //1、使用CLASS 类加载驱动程序
        con = DriverManager.getConnection(DBURL,DBUSER,DBPASS); //2、连接数据库
        String sql = "INSERT INTO USER (NAME ,address) VALUES (?,?)";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,"wangwu");
        pstmt.setString(2,"fuyang");
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }


    /**
     * 使用Statement
     * @throws Exception
     */
    @Test
    public void testJdbc() throws Exception {
        Connection con = null; //表示数据库的连接对象
        Class.forName(DBDRIVER); //1、使用CLASS 类加载驱动程序
        con = DriverManager.getConnection(DBURL,DBUSER,DBPASS); //2、连接数据库
        System.out.println(con);

        Statement statement = con.createStatement();

        //插入
       // statement.execute("INSERT INTO USER (name,address) VALUES ('zhangsan','hefie')");

        //查询
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            int id = resultSet.getInt("id");
            System.out.println("name="+name+"address="+address+"id="+id);
        }

        //更新
        statement.executeUpdate("UPDATE USER SET NAME='lisi',address='bengbu' WHERE id=2 ");

        //删除
        statement.execute("DELETE FROM USER WHERE id=1");
        resultSet.close();
        statement.close();
        con.close(); // 3、关闭数据库

    }
}
