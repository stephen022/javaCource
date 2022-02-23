package org.javacource.dbatomikosxa.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    private Long id;
    private Long userId;
    private String code;
    private String name;
    private double total;
    private String status;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Order(Long id, Long userId, String code, String name, double total, String status){
        this.id = id;
        this.userId = userId;
        this.code = code;
        this.name = name;
        this.total = total;
        this.status = status;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public Order(Long id, Long userId){
        this.id = id;
        this.userId = userId;
        this.code = "defualt"+id;
        this.name = "defualt"+id;
        this.total = 0;
        this.status = "编辑";
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString(){
        String result = "id:" + id
                + " user_id:" + userId
                + " code:" + code
                + " name:" + name
                + " total:" + total
                + " status:" + status
                + " create_time:" + createTime
                + " update_time:" + updateTime;
        return result;
    }
}
