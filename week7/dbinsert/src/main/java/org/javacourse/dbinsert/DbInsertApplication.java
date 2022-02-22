package org.javacourse.dbinsert;

import org.javacourse.dbinsert.entity.Order;

import java.sql.*;
import java.util.Date;
import java.util.Random;

public class DbInsertApplication {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdemo";

    private static final String USER = "test";
    private static final String PASSWORD = "test";

    private static int RUN_TIME = 1000000;


    private static Order genOrder(int seed, String way){
        Order order = new Order();
        order.setId(new Random(seed).nextLong());
        order.setCode("test" + way + seed);
        order.setName("test" + way + seed);
        order.setStatus("编辑");
        order.setTotal(0);
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return order;
    }


    public static void main(String [] args) throws Exception{
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();

            //直接插入方式
            Date start = new Date();
            for(int i = 0 ; i< RUN_TIME; i++) {
                Order order = genOrder(i, "plain");
                String insertSql = "insert into order (id , code, name ,total, status, create_time) values ("
                        + order.getId() + "," + order.getCode() + "," + order.getName() + ","
                        + order.getTotal()+"," + order.getStatus() + "," + order.getCreateTime() + "," + order.getUpdateTime()
                        + ")";
                statement.executeUpdate(insertSql);
            }
            Date end = new Date();
            long interval = start.getTime() - end.getTime();
            System.out.println("Plain inser way use time :" + interval);

            //采用PreparedStatement方式
            start = new Date();
            for(int i = 0 ; i< RUN_TIME; i++) {
                Order order = genOrder(i, "preparedStament");
                String insertSql = "insert into order (id , code, name ,total, status, create_time) values (?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(insertSql);
                preparedStatement.setLong(1,order.getId());
                preparedStatement.setString(2, order.getCode());
                preparedStatement.setString(3, order.getName());
                preparedStatement.setDouble(4, order.getTotal());
                preparedStatement.setString(5, order.getStatus());
                preparedStatement.setTimestamp(6, order.getCreateTime());
                preparedStatement.executeUpdate();
            }
            end = new Date();
            interval = start.getTime() - end.getTime();
            System.out.println("PreparedStatement inser way use time :" + interval);

            //批处理方式
            start = new Date();
            for(int i = 0 ; i< RUN_TIME; i++) {
                Order order = genOrder(i, "batch");
                String insertSql = "insert into order (id , code, name ,total, status, create_time) values (?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(insertSql);
                preparedStatement.setLong(1,order.getId());
                preparedStatement.setString(2, order.getCode());
                preparedStatement.setString(3, order.getName());
                preparedStatement.setDouble(4, order.getTotal());
                preparedStatement.setString(5, order.getStatus());
                preparedStatement.setTimestamp(6, order.getCreateTime());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            end = new Date();
            interval = start.getTime() - end.getTime();
            System.out.println("Batch inser way use time :" + interval);


            connection.close();
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            if(statement != null){
                statement.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
