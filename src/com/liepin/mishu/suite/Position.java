package com.liepin.mishu.suite;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.liepin.mishu.page.HomePage;
import com.liepin.mishu.page.LoginPage;


public class Position {

    public static Test suite(){
        TestSuite suite = new TestSuite(Position.class.getName());
        suite.addTest(TestSuite.createTest(LoginPage.class,"testLogin"));
        suite.addTest(TestSuite.createTest(HomePage.class, "testPosition"));
        
        return suite;
    }
}
