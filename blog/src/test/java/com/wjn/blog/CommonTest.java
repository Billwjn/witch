package com.wjn.blog;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonTest {
    @Test
    public void test1(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
