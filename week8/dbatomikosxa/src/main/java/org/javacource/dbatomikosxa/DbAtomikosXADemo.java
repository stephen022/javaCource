package org.javacource.dbatomikosxa;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DbAtomikosXADemo {

    public static void main(String[] args) throws IOException, SQLException {
        DataSource dataSource = getShardingDatasource();
        cleanupData(dataSource);

        TransactionTypeHolder.set(TransactionType.XA);

        Connection conn = dataSource.getConnection();
        String insertSql = "insert into order (id , user_id, code, name ,total, status, create_time) values (?,?,?,?,?,?,?)";


        System.out.println("First XA Start insert data");
        try (PreparedStatement preparedStatement = conn.prepareStatement(insertSql)) {
            conn.setAutoCommit(false);
            for (int i = 1; i < 16; i++) {
                preparedStatement.setLong(1,i);
                preparedStatement.setLong(2, i);
                preparedStatement.setString(3, "test"+i);
                preparedStatement.setString(4, "test"+i);
                preparedStatement.setDouble(5, 0);
                preparedStatement.setString(6, "编辑");
                preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                preparedStatement.executeUpdate();
            }
            conn.commit();
        }catch (Exception e) {
            System.out.println("First XA insert failed");
            conn.rollback();
        } finally {
            conn.close();
        }

        System.out.println("First XA insert successful");

        System.out.println("Second XA Start insert data");
        try (PreparedStatement preparedStatement = conn.prepareStatement(insertSql)) {
            conn.setAutoCommit(false);
            for (int i = 1; i < 16; i++) {
                preparedStatement.setLong(1,i+10);
                preparedStatement.setLong(2, i+10);
                preparedStatement.setString(3, "test"+i);
                preparedStatement.setString(4, "test"+i);
                preparedStatement.setDouble(5, 0);
                preparedStatement.setString(6, "编辑");
                preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                preparedStatement.executeUpdate();
            }
            conn.commit();
        } catch (Exception e) {
            System.out.println("Second XA insert failed");
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    private static void cleanupData(DataSource dataSource) {
        System.out.println("Delete all Data");
        try (Connection conn = dataSource.getConnection(); Statement statement = conn.createStatement()) {
            statement.execute("delete from order;");
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Delete all Data successful");
    }

    static private DataSource getShardingDatasource() throws IOException, SQLException {
        String fileName = "resources/sharding-databases-tables.yaml";
        File yamlFile = new File(fileName);
        return YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
    }

}
