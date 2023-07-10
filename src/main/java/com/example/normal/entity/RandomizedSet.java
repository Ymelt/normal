package com.example.normal.entity;

import java.util.*;

public class RandomizedSet {

    List<Integer> nums;

    Map<Integer,Integer> mapValue;

    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        mapValue = new HashMap<>();
        random = new Random();
    }

    public Boolean insert(int val){
        if (mapValue.containsKey(val)){
            return false;
        }
        int lag = nums.size();
        mapValue.put(val,lag);
        nums.add(val);
        return true;
    }

    public Boolean remove(int val){
        if (!mapValue.containsKey(val)){
            return false;
        }
        int index = mapValue.get(val);
        nums.set(index,nums.get(nums.size() - 1));
        mapValue.put(nums.get(nums.size() - 1),index);
        mapValue.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int random(){
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }




}
