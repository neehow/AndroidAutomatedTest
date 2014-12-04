package com.liepin.mishu.page;

import com.liepin.driver.annotation.FindBy;
import com.liepin.driver.annotation.PageElement;
import com.lietou.mishu.R;
import com.lietou.mishu.activity.Login;

public class LoginPage extends Page<Login> {

    @FindBy(id = R.id.username)
    private PageElement username;

    @FindBy(id = R.id.password)
    private PageElement password;

    @FindBy(id = R.id.login)
    private PageElement login;

    public LoginPage() {
        super(Login.class);
    }

    public void testLogin() throws Exception {
        solo.typeText(username, "18500038185");
        solo.typeText(password, "qwerty");
        solo.click(login);
        assertTrue(solo.searchText("职位推荐"));
    }
}
