package com.zxm.crawler.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CrawlerFirst {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");


        CloseableHttpResponse resp = httpClient.execute(httpGet);

        if (resp.getStatusLine().getStatusCode() == 200){
            HttpEntity entity = resp.getEntity();
            String content = EntityUtils.toString(entity, "utf-8");
            System.out.println(content);
        }

    }
}
