import com.example.normal.entity.Human;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondTest {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        if (n != 0) {
//            for (int i = 0; i < n; i++) {
//                nums1[m + i] = nums2[i];
//            }
//        }
//        Human[] arrs = new Human[5];
//
//        Arrays.sort(nums1);
//        for (int i : nums1) {
//            System.out.println(i);
//        }

        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
            System.out.println(sorted[i]);
        }


    }


    @Test
    public void test2() {
        int[] a = new int[]{1, 2, 5, 0, 0, 0};
        int[] b = new int[]{8, 5, 2};
        merge(a, 3, b, 3);
    }

    @Test
    public void test3() {
        int i = 5;
        int j = i++;
        System.out.println(i);
        System.out.println(j);
    }

    public void removeElement(int[] nums, int val) {
        
    }
}
