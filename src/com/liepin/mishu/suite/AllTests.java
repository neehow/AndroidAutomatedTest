package com.liepin.mishu.suite;

import com.liepin.mishu.page.GuidePage;
import com.liepin.mishu.page.HomePage;
import com.liepin.mishu.page.LoginPage;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

    public static Test suite(){
        TestSuite suite = new TestSuite(AllTests.class.getName());
        suite.addTest(TestSuite.createTest(GuidePage.class,"testGuide"));
        suite.addTest(TestSuite.createTest(LoginPage.class,"testLogin"));
        suite.addTest(TestSuite.createTest(HomePage.class, "testShowMe"));
        return suite;
    }
}
