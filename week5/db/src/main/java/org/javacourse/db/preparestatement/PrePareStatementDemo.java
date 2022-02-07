package org.javacourse.db.preparestatement;

import lombok.Data;

import java.sql.*;

public class PrePareStatementDemo {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdemo";

    private static final String USER = "test";
    private static final String PASSWORD = "test";

    @Data
    private static class Student{
        private int id;
        private String name;
        private int age;
        private int value;
        Student(int id , String name, int age){
            this.id = id;
            this.name = name;
            this.age = age;
        }
        Student(int id , String name, int age, int value){
            this.id = id;
            this.name = name;
            this.age = age;
            this.value = value;
        }
    }

    public static void main(String [] args) throws Exception{
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();

            String updateSql = "update student set name =? where id = ?";
            preparedStatement = connection.prepareStatement(updateSql);

            preparedStatement.setInt(2,3);
            preparedStatement.setString(1,"test-3");
            preparedStatement.executeUpdate();
            connection.commit();

            //批处理方式
            preparedStatement.setInt(2,1);
            preparedStatement.setString(1,"test-1");
            preparedStatement.addBatch();
            preparedStatement.setInt(2,2);
            preparedStatement.setString(1,"test-2");
            preparedStatement.addBatch();
            preparedStatement.setInt(2,3);
            preparedStatement.setString(1,"test-3");
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            connection.commit();


            //事务处理方式
            String selectSql = "select * from student where id = 3";
            ResultSet resultSet = statement.executeQuery(selectSql);
            resultSet.next();
            int nowValue = resultSet.getInt("value");

            String deleteSql2 = "delete from class where id = ?";
            preparedStatement = connection.prepareStatement(deleteSql2);
            preparedStatement.setInt(1,3);
            preparedStatement.executeUpdate();

            if(nowValue + 100 < 500) {
                String updateSql2 = "update student set value =? where id = ?";
                preparedStatement = connection.prepareStatement(updateSql2);
                preparedStatement.setInt(1, nowValue + 100);
                preparedStatement.setInt(2, 3);
                preparedStatement.executeUpdate();
            }
            else{
                connection.rollback();
                System.out.println("事务回滚");
            }

            connection.commit();

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
