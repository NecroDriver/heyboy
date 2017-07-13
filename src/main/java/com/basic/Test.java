package com.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mafh on 2017/6/29 0029.10:27
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println((23&17+27|13));
//        System.out.println((23&17+27|13)%11.31);
        HashMap testMap = new HashMap<>();
        testMap.put("aaa","123");
        if(null == testMap.get("bbb")){
            System.out.println(testMap.get("bbb")+"");
            System.out.println((null) instanceof String);
        }
    }
}
