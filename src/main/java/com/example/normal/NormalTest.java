package com.example.normal;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class NormalTest {


    @Test
    public void test1(){
        Set<Integer> set = new HashSet<>();

        int[] nums = new int[]{1,2,2};
        set.add(2);
        boolean add = set.add(2);
        System.out.println(add);
    }


    @Test
    public void test2(){
//        ManPlus u = (ManPlus) new Human();
//        System.out.println(u.getHumanAge());
//
//        u.changeAge(7);
//        Human u1 = u;
//        System.out.println(u1.getHumanAge());

        System.out.println(42 == 42.0);
    }
}
