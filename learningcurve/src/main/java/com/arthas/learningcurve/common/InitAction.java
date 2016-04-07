package com.arthas.learningcurve.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arthas on 16/4/7.
 */
public class InitAction {
    private static Map<String,String> mobileToSmsMap;

    public static void init(){
        mobileToSmsMap = new HashMap<String, String>();
    }

    public static Map<String, String> getMobileToSmsMap() {
        return mobileToSmsMap;
    }
}
