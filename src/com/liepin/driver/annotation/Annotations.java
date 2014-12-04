package com.liepin.driver.annotation;

import java.lang.reflect.Field;

public class Annotations {

    private Field            field;
    private final static int ELEMENT_NOT_FOUND = -1;

    public Annotations(Field field) {
        this.field = field;
    }

    /**
     * 返回注解上的id
     * @author     : chenDoInG
     * @date       : 2014-9-16
     * @return 
     * int 注解上的id
     */
    public int buildBy() {
        int ans = ELEMENT_NOT_FOUND;
        FindBy findBy = field.getAnnotation(FindBy.class);
        if (ans == ELEMENT_NOT_FOUND && findBy != null) {
            ans = buildByFromFindBy(findBy);
        }
        return ans;
    }

    private int buildByFromFindBy(FindBy findBy) {
        if (findBy.id() != ELEMENT_NOT_FOUND)
            return findBy.id();
        return ELEMENT_NOT_FOUND;
    }
}
