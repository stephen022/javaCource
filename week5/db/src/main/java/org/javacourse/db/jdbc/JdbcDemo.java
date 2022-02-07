package org.javacourse.db.jdbc;

import lombok.Data;

import java.sql.*;

public class JdbcDemo {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdemo";

    private static final String USER = "test";
    private static final String PASSWORD = "test";

    @Data
    private static class Student{
        private int id;
        private String name;
        private int age;
        Student(int id , String name, int age){
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String [] args) throws Exception{
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();
            
            String selectSql = "select * from student";
            ResultSet resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                Student student = new Student(resultSet.getInt("id")
                        ,resultSet.getString("name")
                        ,resultSet.getInt("age"));
                System.out.println("id:" + student.getId());
                System.out.println("name:" + student.getName());
                System.out.println("age:" + student.getAge());
            }
            if(resultSet != null) {
                resultSet.close();
            }

            String updateSql = "update student set name = 'test-1' where id = 1";
            statement.executeUpdate(updateSql);

            String insertSql = "insert into student (id , name ,age) values (3, 'test3', 30)";
            statement.executeUpdate(insertSql);

            String deleteSql = "delete from student where id = 1";
            statement.executeUpdate(deleteSql);


            statement.close();
            connection.close();
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
