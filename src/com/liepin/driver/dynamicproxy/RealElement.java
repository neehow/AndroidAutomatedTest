package com.liepin.driver.dynamicproxy;

import com.robotium.solo.Solo;

import android.view.View;


public class RealElement implements WebElement {

    private View view;
    private Solo solo;
    
    @Override
    public void click() {
        solo.clickOnView(view);
    }
}
