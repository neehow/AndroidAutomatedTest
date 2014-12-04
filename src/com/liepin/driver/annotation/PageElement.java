package com.liepin.driver.annotation;

import android.view.View;

public interface PageElement {
    public View getView();
    public void click();
    public void typeText(String text);
}