package org.javacourse.dbrwframe.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    private Long id;
    private String code;
    private String name;
    private double total;
    private String status;
    private Timestamp createTime;
    private Timestamp updateTime;
}
