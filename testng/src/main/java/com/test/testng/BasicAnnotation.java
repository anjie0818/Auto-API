package com.test.testng;

import com.mongodb.annotations.ThreadSafe;
import org.testng.annotations.*;

/**
 * @创建人 anjie
 * @创建时间 2019/3/6
 * @描述
 */
public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("-----testCase1");
    }
    @Test(dependsOnMethods = {"testCase1"})
    public void testCase2(){
        System.out.println("-----testCase2");
    }
    @Test(enabled = false)
    public void testCase3(){
        System.out.println("-----testCase3------------");
    }
    @Test(expectedExceptions = Exception.class)
    public void testException() throws Exception {
        System.out.println("异常测试");
        throw new Exception();
    }
    @Test(timeOut = 2000)
    public void testSleep() throws InterruptedException {
        Thread.sleep(20022);
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("-----BeforeMethod");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("-----AfterMethod");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("------BeforeClass");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("------AfterClass");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("------BeforeSuite");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("------AfterSuite");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("------AfterTest");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("------BeforeTest");
    }
}
