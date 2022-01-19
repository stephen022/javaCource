package org.javacourse.nio.client;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author zyb
 */
public class MyHttpClient {


    public CloseableHttpResponse doGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return response;
        }  catch (IOException e) {
            System.out.println("HttpClient throw IOException:" + url);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("HttpClient Close throw IOException" + url);
            }
        }
        return null;
    }

    public CloseableHttpResponse doPost(String url, String body){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(body, "UTF-8");
        stringEntity.setContentType("application/json;charset=utf-8");
        httpPost.setEntity(stringEntity);
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return response;
        }  catch (IOException e) {
            System.out.println("HttpClient throw IOException:" + url);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("HttpClient Close throw IOException"+url);
            }
        }
        return null;
    }


    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8801";

        MyHttpClient httpClient = new MyHttpClient();
        CloseableHttpResponse getResponse =httpClient.doGet(url);

        JSONObject body = new JSONObject();
        body.put("test","test");
        CloseableHttpResponse postResponse = httpClient.doPost(url,body.toString());

    }
}
