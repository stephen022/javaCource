package org.javacourse.dbrwmultisource.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class ManagementCenter {

    @Autowired
    @Qualifier("write")
    DataSource writeDataSource;
    @Autowired
    @Qualifier("read1")
    DataSource read1DataSource;
    @Autowired
    @Qualifier("read2")
    DataSource read2DataSource;

    int readDbIndex = 1;

    public DataSource getWriteDataSource() {
        return writeDataSource;
    }


    public DataSource getReadDataSource() {
        if (readDbIndex == 1) {
            readDbIndex = 2;
            return read1DataSource;
        }
        readDbIndex = 1;
        return read2DataSource;
    }
}
