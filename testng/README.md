## TestNG介绍
### 优点
* 比junit涵盖功能更加全面的测试框架
* junit适合隔离性较强的单元测试
* testng更适合复杂的集成测试
### 注解介绍
#### After VS Before
*  Suite Test  Class Method 按照testngXML文件中的标签的作用域来控制执行顺序
#### 分组测试
* 方法分组
```
@Test(groups = "client")
public void testD(){
    System.out.println("---testD");
}
@AfterGroups(groups = "client")
public void AfterGroupsclient(){
    System.out.println("---AfterGroups---client");
}
```
* 类分组
```
@Test(groups = "teacher")
public class GroupsOnClass3 {

@Test(groups = "teacher")
public class GroupsOnClass4 {
```
#### 忽略测试
```
    @Test(enabled = false)
    public void testCase3(){
        System.out.println("-----testCase3------------");
    }
```
#### 异常测试
```
    @Test(expectedExceptions = Exception.class)
    public void testException() throws Exception {
        System.out.println("异常测试");
        throw new Exception();
    }
```
#### 依赖测试
```
    @Test(dependsOnMethods = {"testCase1"})
    public void testCase2(){
        System.out.println("-----testCase2");
    }
```
#### 参数化测试
#### 超时测试
```
  @Test(timeOut = 2000)
    public void testSleep() throws InterruptedException {
        Thread.sleep(20022);
    }
```
#### 测试线程
* 注解
* xml
### 测试报告
ExtentReport使用