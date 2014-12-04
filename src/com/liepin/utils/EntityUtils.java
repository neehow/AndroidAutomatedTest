package com.liepin.utils;

import java.util.List;


public class EntityUtils {

    public static boolean isArrayNotNullOrEmpty(Object[] entitys){
        return entitys!=null&&entitys.length>0;
    }
    
    public static <T> boolean isListNotNullOrEmpty(List<T> list){
        return list!=null&&list.size()>0;
    }
}
