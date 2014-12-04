package com.liepin.mishu.page;

import com.liepin.driver.MySolo;
import com.liepin.driver.annotation.FindBy;
import com.liepin.driver.annotation.PageElement;
import com.lietou.mishu.Guide;
import com.lietou.mishu.R;

public class GuidePage extends Page<Guide> {

    @FindBy(id=R.id.main_guide)
    private PageElement main_guide;
    
    public GuidePage() {
        super(Guide.class);
    }

    public void testGuide() throws Exception {
        solo.scrollToSide(MySolo.RIGHT);
        solo.scrollToSide(MySolo.RIGHT);
        solo.click(main_guide);
        assertTrue(solo.searchText("登录"));
    }

    public void testGuide2() throws Exception{
        solo.scrollToSide(MySolo.RIGHT);
        solo.scrollToSide(MySolo.LEFT);
    }
}
