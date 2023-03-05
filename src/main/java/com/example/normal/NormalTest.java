package com.example.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class NormalTest {

    @Test
    public int findRepeatNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return num;
            }
            list.add(num);
        }
        return nums[nums.length -1];
    }

    @Test
    public void test1(){
        Set<Integer> set = new HashSet<>();
        int[] nums = new int[]{1,2,2};
        set.add(2);
        boolean add = set.add(2);
        System.out.println(add);
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] nums = new int[]{1,2,2};
        System.out.println(set.add(2));
        int i = 2;
        boolean add = set.add(i);
        System.out.println(i);
    }
}
