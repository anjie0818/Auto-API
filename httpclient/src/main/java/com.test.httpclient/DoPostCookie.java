package com.test.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @创建人 anjie
 * @创建时间 2019/3/11
 * @描述
 */
@Test
public class DoPostCookie {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test(dependsOnMethods = "testGetCookies")
    public void selectAll() throws IOException {
        String selectAllUrl=url+bundle.getString("article");
        HttpGet httpGet=new HttpGet(selectAllUrl);
        DefaultHttpClient httpClient=new DefaultHttpClient();
        httpClient.setCookieStore(store);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        System.out.println(result);
    }
    @Test(dependsOnMethods = "testGetCookies")
    public void tests() throws IOException {

    }
    @Test(dependsOnMethods = "testGetCookies")
    public void addArticle() throws IOException {
        String addAriticleUrl=url+bundle.getString("addArticle");
        String param="id=-1&title=%E6%A0%87%E9%A2%98&mdContent=%E5%86%85%E5%AE%B9&htmlContent=%3Cp%3E%E5%86%85%E5%AE%B9%3C%2Fp%3E%0A&cid=66&state=1&dynamicTags=&\n";
        HttpPost httpPost=new HttpPost(addAriticleUrl);
        DefaultHttpClient httpClient=new DefaultHttpClient();
        //添加cookie
        httpClient.setCookieStore(store);
        //添加请求头
        httpPost.setHeader("content-type","application/x-www-form-urlencoded");
        //添加参数
        StringEntity entity = new StringEntity(param.toString(),"");
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        //将返回的响应结果字符串转化成为json对象
        JSONObject resultJson = new JSONObject(result);
    }
    @Test
    public void testGetCookies() throws IOException {
        String getCookieStr=url+bundle.getString("login");
        String param="username=sang&password=anjie&";
        HttpPost httpPost=new HttpPost(getCookieStr);
        DefaultHttpClient httpClient=new DefaultHttpClient();
        //添加请求头
        httpPost.setHeader("content-type","application/x-www-form-urlencoded");
        //添加参数
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        //将返回的响应结果字符串转化成为json对象
        JSONObject resultJson = new JSONObject(result);

        //获取cookie
        store = httpClient.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name
                    + ";  cookie value = " + value);
        }


    }
}