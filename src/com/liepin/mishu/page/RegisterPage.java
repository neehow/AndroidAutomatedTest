package com.liepin.mishu.page;

import com.liepin.driver.annotation.FindBy;
import com.liepin.driver.annotation.PageElement;
import com.liepin.utils.Generator;
import com.lietou.mishu.R;
import com.lietou.mishu.activity.UserRegister;

public class RegisterPage extends Page<UserRegister> {

    @FindBy(id=R.id.username)
    private PageElement username;
    
    public RegisterPage() {
        super(UserRegister.class);
    }

    public void testRegister() throws Exception {
        solo.typeText(username, Generator.createUser().getPhone());
        solo.clickOnButton("注册");
    }
}
