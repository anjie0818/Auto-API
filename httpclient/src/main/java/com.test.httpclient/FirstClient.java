package com.test.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @创建人 anjie
 * @创建时间 2019/3/11
 * @描述
 */
public class FirstClient {
    @Test
    public void getTest() throws IOException {
        String result;
        HttpGet httpGet=new HttpGet("http://www.baidu.com");
        HttpClient httpClient=new DefaultHttpClient();
        HttpResponse resp = httpClient.execute(httpGet);
        result = EntityUtils.toString(resp.getEntity(),"utf-8");
        System.out.println(resp);
        System.out.println(result);
    }
}
