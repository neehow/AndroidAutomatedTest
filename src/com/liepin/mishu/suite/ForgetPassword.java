package com.liepin.mishu.suite;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.liepin.mishu.page.LoginPage;


public class ForgetPassword {

    public static Test suite(){
        TestSuite suite = new TestSuite(AllTests.class.getName());
        suite.addTest(TestSuite.createTest(LoginPage.class,"testForgetPassword"));
        return suite;
    }

}
