package com.wjn.admin;

import com.wjn.admin.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class CommonTest {
    protected String a = "这是个常量";
    final Admin admin = new Admin("code","username","password","nickname","phone","email");
    @Test
    public void test1(){
        a = "aaa";
        change();
        System.out.println(a);
    }

    public void change(){
        a+=1;
    }

    @Test
    public void test2(){
        String[] s = new String[]{"1","2","3"};
        List<String> list = Arrays.asList(s);
        System.out.println(list.toString().substring(1,list.toString().length()-1));
    }

    @Test
    public void test3(){
        BigDecimal bigDecimal = new BigDecimal(100.000);
        System.out.println(bigDecimal);
    }

    @Test
    public void test4(){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        List<Integer> subList = getSubList(list, new Pageable() {
            int page = 0;
            int size = 3;
            @Override
            public int getPageNumber() {
                return page;
            }

            @Override
            public int getPageSize() {
                return size;
            }

            @Override
            public long getOffset() {
                return page*size;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });
        for (Integer integer : subList) {
            System.out.println(integer);
        }
    }

    public List<Integer> getSubList(List<Integer> list , Pageable pageable){
        Integer beginIndex = Math.toIntExact(pageable.getOffset());
        Integer endIndex = beginIndex + pageable.getPageSize();
        return list.subList(beginIndex > list.size() ? list.size() : beginIndex, endIndex > list.size() ? list.size() : endIndex);
    }

    @Test
    public void test5() throws IllegalAccessException, NoSuchFieldException {
        Class<Admin> adminClass = Admin.class;
        Admin admin = new Admin("code1", "username", "passwo234234rd", "nickname", "phone", "email");
        Field code = adminClass.getDeclaredField("code");
        code.setAccessible(true);
        Object o = code.get(admin);
        System.out.println(o);
    }

}
