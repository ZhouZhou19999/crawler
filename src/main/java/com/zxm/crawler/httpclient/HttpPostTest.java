package com.zxm.crawler.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpPostTest {
    public static void main(String[] args){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200){
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
