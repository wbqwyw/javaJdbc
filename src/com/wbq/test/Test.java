package com.wbq.test;

import cn.hutool.core.util.StrUtil;

/**
 * 包名：com.wbq.test
 * 工程：learnworkspace
 * 作者: wangbq
 * 时间:  2021-04-02 下午2:20
 */
public class Test {
    public static void main(String[] args) {
        String str = "abcdefgh";
        String strSub1 = StrUtil.sub(str, 2, 3); //strSub1 -> c
        System.out.println(strSub1);
    }
}
