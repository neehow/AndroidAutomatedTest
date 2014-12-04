package com.liepin.mishu.page;

import com.liepin.driver.annotation.FindBy;
import com.liepin.driver.annotation.PageElement;
import com.lietou.mishu.R;
import com.lietou.mishu.TabHomeFragmentActivity;

public class HomePage extends Page<TabHomeFragmentActivity> {

    @FindBy(id = R.id.relative_linear_see_mee)
    private PageElement see_me;
    @FindBy(id = R.id.rb_my)
    private PageElement me;
    
    public HomePage() {
        super(TabHomeFragmentActivity.class);
    }

    public void testShowMe() {
        solo.click(me);
        solo.click(see_me);
    }
}