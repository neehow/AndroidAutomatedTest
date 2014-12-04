package com.liepin.mishu.page;

import com.liepin.driver.MySolo;
import com.liepin.driver.annotation.elementlocator.AjaxElementLocatorFactory;
import com.liepin.driver.annotation.elementlocator.ElementLocatorFactory;
import com.liepin.driver.annotation.factory.PageFactory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

@SuppressLint("NewApi")
public class Page<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

    protected MySolo solo;

    public Page(Class<T> activityClass) {
        super(activityClass);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new MySolo(getInstrumentation(), getActivity());
        ElementLocatorFactory factory = new AjaxElementLocatorFactory(solo.getWebDriver(), 15);
        PageFactory.initElements(factory, this);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

}
