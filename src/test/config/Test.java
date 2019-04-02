package test.config;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args){
        System.out.println("Hello world");
        // 创建数据源连接池
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/ilibrary");
        ds.setUsername("root");
        ds.setPassword("5201314");
        ds.setMaxTotal(10);
        ds.setInitialSize(5);

        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection connection = null;
        try {
            connection = ds.getConnection();
            stmt = connection.prepareStatement(
                    "select * from dpc_books_collection");
            rs = stmt.executeQuery();
            System.out.println("Hi");
            while(rs.next()){
                System.out.println(rs.getString("coll_Cno") + " " +
                        rs.getString("coll_Bno") + " " +
                        rs.getString("coll_Lid") + " " +
                        rs.getString("coll_Cstate"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }finally {
            if(null != rs){
                try{
                    rs.close();
                }catch (SQLException e){}
            }
            if(null != stmt){
                try{
                    stmt.close();
                }catch (SQLException e){}
            }
            if(null != connection){
                try{
                    connection.close();
                }catch (SQLException e){}
            }
        }

    }
}
