package com.liepin.driver;

import com.liepin.driver.annotation.PageElement;
import com.liepin.driver.annotation.WebDriver;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MySolo {

    private Solo                solo;

    private final static String LOGGER = "AUTOTEST";
    public final static int     RIGHT  = Solo.RIGHT;
    public final static int     LEFT   = Solo.LEFT;
    public final static int     UP     = Solo.UP;
    public final static int     DOWN   = Solo.DOWN;
    private WebDriver           pageDriver;

    public MySolo(Instrumentation instrumentation, Activity activity) {
        this.solo = new Solo(instrumentation, activity);
         pageDriver = new RemoteWebDriver(activity, solo);
    }

    private void handleFailure(String notice) {
        Log.e(LOGGER, "fail to " + notice);
        takeScreenshot();
    }

    public void click(PageElement view) {
        view.click();
    }

    /**
     * Scrolls horizontally.
     * 
     * @param side
     *            the side to scroll; {@link #RIGHT} or {@link #LEFT}
     */
    public void scrollToSide(int side) {
        solo.scrollToSide(side);
    }

    public void sleep(int time) {
        Log.i(LOGGER, "sleep " + time);
        solo.sleep(time);
    }

    public void takeScreenshot() {
        Log.i(LOGGER, "take screenshot");
        solo.takeScreenshot();
    }

    /**
     * 
     * @author : chenDoInG
     * @date : 2014-8-25
     * @param text
     *            the text want to search
     * @return true if found, false not found
     */
    public boolean searchText(String text) {
        Log.i(LOGGER, "Start to search text:" + text);
        boolean result = solo.searchText(text);
        if (!result) {
            handleFailure("fail to search text:" + text);
        }
        return result;
    }

    /**
     * @author : chenDoInG
     * @date : 2014-9-1
     * @param text
     *            the text want to search
     * @return true if found, false not found
     */
    public boolean searchTextWithoutScroll(String text) {
        Log.i(LOGGER, "Start to search text:" + text);
        return solo.searchText(text, 0, false);
    }

    /**
     * Searches for a Button displaying the specified text
     * 
     * @author : chenDoInG
     * @date : 2014-8-29
     * @param text
     *            text of the button
     * @return boolean {@code true} if at least one Button is found. Will
     *         automatically scroll when needed.
     */
    public boolean searchButton(String text) {
        Log.i(LOGGER, "Start to search Button:" + text);
        boolean result = solo.searchButton(text);
        if (!result)
            handleFailure("fail to search button:" + text);
        return result;
    }

    /**
     * Clicks a Button displaying the specified text. Will automatically scroll
     * when needed.
     * 
     * @param text
     *            the text displayed by the {@link Button}. The parameter will
     *            be interpreted as a regular expression
     */
    public void clickOnButton(String name) {
        Log.i(LOGGER, "click button:" + name);
        ignoreUpdate();
        solo.clickOnButton(name);
    }

    /**
     * Clicks a View or WebElement displaying the specified text. Will
     * automatically scroll when needed.
     * 
     * @author : chenDoInG
     * @date : 2014-8-29
     */
    public void clickOnText(String text) {
        Log.i(LOGGER, "click button: " + text);
        ignoreUpdate();
        solo.clickOnText(text);
    }

    /**
     * Clicks the specified View.
     * 
     * @param view
     *            the {@link View} to click
     */
    public void clickOnView(View view) {
        ignoreUpdate();
        Log.i(LOGGER, "click on view");
        solo.clickOnView(view);
    }

    public void clearEditText(EditText editText) {
        try {
            Log.i(LOGGER, "clear text");
            solo.clearEditText(editText);
        } catch (Exception e) {
            handleFailure("fail to clear editText!");
        }
    }

    public void typeText(PageElement element,String text){
        element.typeText(text);
    }
    
    public void goBack() {
        try {
            solo.goBack();
        } catch (Exception e) {
            // TODO 增加返回错误处理
        }
    }

    public void finishOpenedActivities() {
        solo.finishOpenedActivities();
    }

    /**
     * ignore the dialog of app update information
     * 
     * @author : chenDoInG
     * @date : 2014-9-1
     */
    public void ignoreUpdate() {
        if (searchTextWithoutScroll("更新提示")) {
            Log.i(LOGGER, "忽略App更新提示框");
            solo.clickOnButton("暂不更新");
        }
    }

    public WebDriver getWebDriver() {
        return pageDriver;
    }
}
