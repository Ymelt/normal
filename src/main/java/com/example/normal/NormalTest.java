package com.example.normal;

import com.example.normal.annotaion.FieldImport;
import com.example.normal.entity.Doctors;
import com.example.normal.entity.TheApple;
import com.example.normal.entity.Tree;
import com.example.normal.pojo.MyThread;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;


public class NormalTest {


    @Test
    public void test1() {
        Set<Integer> set = new HashSet<>();

        int[] nums = new int[]{1, 2, 2};
        set.add(2);
        boolean add = set.add(2);
        System.out.println(add);
    }


    @Test
    public void test2() {
//        ManPlus u = (ManPlus) new Human();
//        System.out.println(u.getHumanAge());
//
//        u.changeAge(7);
//        Human u1 = u;
//        System.out.println(u1.getHumanAge());

        System.out.println(42 == 42.0);
    }

    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        System.out.println("Arrays" + " from the season");


        System.out.println(Arrays.toString(nums));
        System.out.println(left);
        return left;

    }

    @Test
    public void test3() {
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] ints = {1};
        int i = removeElement(ints, 2);

    }

    public int removeDuplicates(int[] nums) {
        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }

        }


        System.out.println(Arrays.toString(nums));
        System.out.println(i);
        return i;
    }


    @Test
    public void test4() {
//        int[] ints = {1,1,1,2,2,3};
        int[] ints = {1};
        removeDuplicatesSecond(ints);
    }

    public int removeDuplicatesSecond(int[] nums) {
        boolean mark = true;
        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[j - 1]) {
                nums[i] = nums[j];
                i++;
                if (!mark) {
                    mark = true;
                }
            } else if (nums[j] == nums[j - 1] && mark) {
                nums[i] = nums[j];
                i++;
                mark = false;
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(i);
        return i;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        boolean i = false;
        int k = 0;

        for (Integer key : map.keySet()) {
            if (!i) {
                k = key;
                i = true;
            } else {
                if (map.get(key) > map.get(k)) {
                    k = key;
                }
            }
        }
        return k;
    }

    @Test
    public void test5() {
//        int[] nums = new int[]{2,2,1,1,1,2,2};
//        int[] nums = new int[]{1};
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
//        int[] nums = new int[]{2,2,1,1,1,2,2};

        int i = majorityElement2(nums);

        System.out.println(i);

        Random random = new Random();
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement2(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    public void rotate(int[] nums, int k) {
        //创建轮转后的
        int[] rotateOne = new int[nums.length];

        k = k % nums.length;

        for (int j = nums.length - k; j < nums.length; j++) {
            rotateOne[j + k - nums.length] = nums[j];
        }

        if (nums.length - k >= 0) System.arraycopy(nums, 0, rotateOne, k + 0, nums.length - k);

        System.arraycopy(rotateOne, 0, nums, 0, rotateOne.length);

        nums = rotateOne;

        System.out.println(Arrays.toString(rotateOne));

    }

    @Test
    public void test6() {
//        int[] nums = new int[]{1};
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
        rotate2(nums, 3);
    }

    //翻转方法
    public void reverse(int[] nums, int begin, int end) {
        int temp;

        while (begin < end) {
            temp = nums[begin];

            nums[begin] = nums[end];

            nums[end] = temp;

            begin++;
            end--;
        }

    }


    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }


    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 1) {
            return profit;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            for (int k = i + 1; k < prices.length; k++) {
                int inner = prices[k] - prices[i];
                if (inner > profit) {
                    profit = inner;
                }
            }
        }
        return profit;
    }

    @Test
    public void test7() {
//        int[] nums = new int[]{1};
        int[] nums = new int[]{6, 10, 5, 6};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = maxProfit2(nums);
        System.out.println(i);
    }


    /**
     * 该算法的思想是，假设遍历数组每天是我们出售股票的时间，那么在之前记录下最低价，
     * 就能知道这天出售股票的话能获取的最大利润是多少，比较下每天出售的最大利润
     */
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int maxProfit3(int[] prices) {
        /**
         * 当出现后面的值比当前值高的时候开始考虑可以购入卖出的情况
         * 当第3个数是降低的时候可以在前两个数购入卖出
         * 当第3个数仍是升高的情况 找到降低的数
         */

        int minPrice = prices[0];
        int sumProfit = 0;
        int i = 0;
        while (i < prices.length - 1) {
            if (prices[i] > prices[i + 1]) {

                if (i != 0) {
                    sumProfit += prices[i] - minPrice;
                }
                minPrice = prices[i + 1];
            } else if (i == prices.length - 2) {
                sumProfit += prices[i + 1] - minPrice;
            }
            i++;

        }
        return sumProfit;
    }


    @Test
    public void test8() {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = maxProfit3(nums);
        System.out.println(i);
    }

    public boolean canJump(int[] nums) {
        int maxRoad = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxRoad) {
                int nowRoad = i + nums[i];
                if (i + nums[i] >= nums.length - 1) {
                    return true;
                }
                if (nowRoad > maxRoad) {
                    maxRoad = nowRoad;
                }
            }
        }
        return false;

    }

    @Test
    public void test9() {
        int[] nums1 = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{3, 2, 1, 0, 4};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
        boolean i = canJump(nums1);
        System.out.println(i);
    }

    @Test
    public void test10() {
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(6, 2);
        map.put(3, 4);
        map.put(7, 8);
        System.out.println(map.toString());

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(6, 2);
        map1.put(3, 4);
        map1.put(7, 8);
        System.out.println(map1.toString());

    }


    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    @Test
    public void test11() {
        int[] nums1 = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = jump(nums1);
        System.out.println(i);
    }

    public int hIndex(int[] citations) {
        int resultH = 0;
        Arrays.sort(citations);
        Map<Integer, Integer> map = new HashMap<>();
        for (int citation : citations) {

            for (Integer key : map.keySet()) {
                if (citation > key) {
                    map.put(key, map.get(key) + 1);
                }
            }
            if (map.containsKey(citation)) {
                map.put(citation, map.get(citation) + 1);
            } else {
                map.put(citation, 1);
            }

        }

        for (Integer key : map.keySet()) {
            int j = Math.min(map.get(key), key);
            if (j > resultH) {
                resultH = j;
            }
        }
        return resultH;
    }

    @Test
    public void test12() {
        int[] nums1 = new int[]{0, 3, 2, 0};
//        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = hIndex(nums1);
        System.out.println(i);
    }


    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] leftArr = new int[length];
        int[] rightArr = new int[length];

        //turn leftArr
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                leftArr[0] = 1;
            } else {
                leftArr[i] = leftArr[i - 1] * nums[i - 1];
            }
        }

        System.out.println("left: " + Arrays.toString(leftArr));

        //turn rightArr
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                rightArr[length - 1] = 1;
            } else {
                rightArr[i] = rightArr[i + 1] * nums[i + 1];
            }
        }

        System.out.println("right: " + Arrays.toString(rightArr));

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = leftArr[i] * rightArr[i];
        }

        return leftArr;

    }


    @Test
    public void test13() {
        int[] nums1 = new int[]{1, 2, 3, 4};
//        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
//        int i = productExceptSelf(nums1);
//        System.out.println(i);

        int[] ints = productExceptSelf(nums1);
        System.out.println("finals:" + Arrays.toString(ints));
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;

        for (int i = 0; i < length; i++) {
            int gasCount = 0;
            int costCount = 0;
            int lag = 0;
            for (; lag < length; lag++) {
                int j = (i + lag) % length;
                gasCount += gas[j];
                costCount += cost[j];
                if (gasCount < costCount) {
                    break;
                }
            }
            if (lag < length) {
                i = i + lag;
            } else {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test14() {
        int[] nums1 = new int[]{5, 8, 2, 8};
        int[] nums = new int[]{6, 5, 6, 6};
        int i = canCompleteCircuit(nums1, nums);
//        int[] nums = new int[]{2,2,1,1,1,2,2};
//        int i = productExceptSelf(nums1);
//        System.out.println(i);

        System.out.println("finals:" + i);
    }

    public int candy(int[] ratings) {

        int[] candy = new int[ratings.length];

        candy[0] = 1;
        for (int i = 0;i<ratings.length-1;i++){
            if (ratings[i] < ratings[i + 1]){
                candy[i+1] = candy[i] + 1;
            }else {
                candy[i+1] = 1;
            }
        }

        for (int i = ratings.length-1;i > 0;i--){
            while (ratings[i] < ratings[i -1] && candy[i] >= candy[i -1]){
                candy[i-1]++;
            }
        }
        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;

    }

    @Test
    public void test15() {
        int[] nums1 = new int[]{1,3,4,5,2};
//        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
//        int i = productExceptSelf(nums1);
//        System.out.println(i);

        int ints = candy(nums1);
        System.out.println("finals:" + ints);
    }


    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if (left < right){
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }

        }
        return true;


    }

    @Test
    public void test16(){
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);

    }


    public boolean isSubsequence(String s, String t) {
        //判断是否是子序列
        int i = 0;
        int j = 0;

        for (;i<s.length();i++){
            while (j < t.length() && s.charAt(i) != t.charAt(j)){
                j++;
            }
            if (j == t.length()){
                return false;
            }
            j++;

        }
        return true;
    }

    @Test
    public void test17(){
        String s = "aaaaaa";
        String t = "bbaaaa";
        boolean palindrome = isSubsequence(s,t);
        System.out.println(palindrome);

    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int[] result = new int[2];
        for (;i<numbers.length;i++){
            //查找
            int mid = (i + 1 + numbers.length - 1) / 2 + 1;



//            for (int j = i + 1;j < numbers.length;j++){
//                int sum = numbers[i] + numbers[j];
//                if (sum == target){
//                    result[0] = i+1;
//                    result[1] = j+1;
//                    return result;
//                }else if(sum > target){
//                    break;
//                }
//            }
        }
        return null;
    }

    @Test
    public void test18(){
        int[] s = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = twoSum(s, target);
        System.out.println(Arrays.toString(ints));

    }

    @Test
    public void test19(){
        SimpleSingleton simpleSingleton = new SimpleSingleton();
        SimpleSingleton simpleSingleton2 = new SimpleSingleton();
        System.out.println(simpleSingleton2 == simpleSingleton);

    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length;
        for (int i = 0;i<nums.length;i++){
            int count = 1;
            int counting = nums[i];
            int j = i;
            while(counting < target && j < nums.length - 1){
                j++;
                counting += nums[j];

                count++;
            }
            if (i == 0 &&counting < target){
                return 0;
            }else {
                if (count < min && counting >= target){
                    min = count;
                }

            }


        }
        return min;
    }

    @Test
    public void test20(){
        int[] arr = new int[]{1,4,4};
        int i = minSubArrayLen(4, arr);
        System.out.println(i);
    }

    @Test
    public void test21(){
        Thread thread = new Thread(new MyThread());
        thread.start();
        System.out.println("is going end");

    }

    public static void main(String[] args) {
        Class<Doctors> aClass = Doctors.class;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldImport.class)) {
                FieldImport ab = field.getAnnotation(FieldImport.class);
                System.out.println(ab.clownName());
                System.out.println(ab.clownNameInCh());
                System.out.println(ab.orderValue());
            }
        }

    }


}
