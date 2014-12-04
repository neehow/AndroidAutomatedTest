package com.liepin.driver;

import android.app.Activity;
import android.view.View;

import com.liepin.driver.annotation.PageElement;
import com.liepin.driver.annotation.WebDriver;
import com.robotium.solo.Solo;

public class RemoteWebDriver implements WebDriver {

    private Activity activity;

    private Solo     solo;

    public RemoteWebDriver(Activity activity, Solo solo) {
        this.activity = activity;
        this.solo = solo;
    }

    public RemoteWebDriver(Activity activity) {
        this.activity = activity;
    }

    @Override
    public PageElement findPageElement(int id) {
        return new RemotePageElement(getView(id), solo);
    }

    private View getView(int id) {
        View view;
        try {
            view = activity.findViewById(id);
            if (view != null)
                return view;
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
