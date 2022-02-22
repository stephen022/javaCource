package org.javacourse.dbrwmultisource;


import org.javacourse.dbrwmultisource.datasource.ManagementCenter;
import org.javacourse.dbrwmultisource.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootApplication
class DbRwMultisourceApplication {

    @Autowired
    private static OrderService orderService;

    private static ManagementCenter managementCenter;

    public static void main(String[] args) {
        //test write
        String insertSql = "insert into order (id , code, name ,total, status, create_time) values (111,'test1','test1',100,'sale','2020-02-21')";
        orderService.insertOne(managementCenter.getWriteDataSource(),insertSql);

        //test read
        String readSql = "select * from order";
        List<Map<String, Object>>  result = orderService.query(managementCenter.getReadDataSource(),readSql);

        //test read
        result = orderService.query(managementCenter.getReadDataSource(),readSql);
    }

}
