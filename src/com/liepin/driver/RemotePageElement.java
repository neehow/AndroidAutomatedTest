package com.liepin.driver;

import android.view.View;
import android.widget.EditText;

import com.liepin.driver.annotation.PageElement;
import com.robotium.solo.Solo;

public class RemotePageElement implements PageElement{

    private View view;
    private Solo solo;

    public RemotePageElement(View view, Solo solo){
        this.solo = solo;
        this.view = view;
    }

    @Override
    public void click() {
        solo.clickOnView(view);
    }

    @Override
    public void typeText(String text) {
        solo.typeText((EditText)view, text);
    }

    @Override
    public View getView() {
        return view;
    }

}
