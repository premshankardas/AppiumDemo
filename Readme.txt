This framework using page factory approach.
Base class is used to instantiate driver and appium session and it also carries the desired capabilities
 which carries device specific informations.
Util class is used to create custom methods for some most used mobile screen operations.
And we have page class and tests class.
Page class is having all activities that will be used in all the pages and
 it also stores the locators of the elements using page factory approach.
These methods can be called on main runner class by creating object of page class.
 Util class methods can be called in page class and page class
methods can be called in test class methods. We are using testNG annotations
like @Test, @BeforeTest, @AfterTest. We have default TestNG reports to
show our test execution report.
In case of further clarifications mail me prem.psdas@gmail.com.