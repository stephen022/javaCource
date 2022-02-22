package org.javacourse.dbrwframe;


import org.javacourse.dbrwframe.datasource.ShardingReadWriteDataSource;
import org.javacourse.dbrwframe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

class DbRwFrameApplication {
    @Autowired
    private static ShardingReadWriteDataSource shardingReadWriteDataSource;

    @Autowired
    private static OrderService orderService;


    public static void main(String[] args) {

        try {
            //test write
            DataSource dataSource = shardingReadWriteDataSource.createDataSource();
            String insertSql = "insert into order (id , code, name ,total, status, create_time) values (111,'test1','test1',100,'sale','2020-02-21')";
            orderService.insertOne(dataSource, insertSql);

            //test read
            String readSql = "select * from order";
            List<Map<String, Object>>  result = orderService.query(dataSource,readSql);

            //test read
            result = orderService.query(dataSource,readSql);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
