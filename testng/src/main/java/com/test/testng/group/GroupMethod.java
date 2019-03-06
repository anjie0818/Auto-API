package com.test.testng.group;

import org.testng.annotations.*;

/**
 * @创建人 anjie
 * @创建时间 2019/3/6
 * @描述
 */
public class GroupMethod {
    @Test(groups = "server")
    public void testA(){
        System.out.println("---testA");
    }
    @Test(groups = "server")
    public void testB(){
        System.out.println("---testB");

    }
    @Test(groups = "client")
    public void testC(){
        System.out.println("---testC");
    }
    @Test(groups = "client")
    public void testD(){
        System.out.println("---testD");
    }
    @AfterGroups(groups = "client")
    public void AfterGroupsclient(){
        System.out.println("---AfterGroups---client");
    }
    @BeforeGroups(groups = "client")
    public void BeforeGroupsclient(){
        System.out.println("---BeforeGroups---client");
    }
    @AfterGroups(groups = "server")
    public void AfterGroupsserver(){
        System.out.println("---AfterGroups---server");
    }
    @BeforeGroups(groups = "server")
    public void BeforeGroupsserver(){
        System.out.println("---BeforeGroups---server");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("---AfterClass");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("---BeforeClass");
    }
}
