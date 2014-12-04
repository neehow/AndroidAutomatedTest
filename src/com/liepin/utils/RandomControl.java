package com.liepin.utils;

import java.util.List;


public class RandomControl {

    public static <T> T getOneRandom(List<T> list) throws NullPointerException{
        return list.remove((int)Math.random()*list.size());
    }
    
    public static void main(String[] args){
        System.out.print("~!@#$%^&*()");
    }
}
