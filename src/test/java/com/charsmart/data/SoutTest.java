package com.charsmart.data;

import org.junit.Test;

/**
 * @Author: Wonder
 * @Date: Created on 2022/1/4 下午3:31
 */
public class SoutTest {
    @Test
    public void test(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "hello";
    }
}
