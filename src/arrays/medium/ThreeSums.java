package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/3sum/description/
 */
public class ThreeSums {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if( i == 0 || (i > 0 && nums[i] > nums[i-1])) {
                int left = i+1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[i] + nums[left] + nums[right] == 0) {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else {
                        if( nums[i] + nums[left] + nums[right] > 0) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
        }
        return list;
    }
}

class TestThreeSums {

    @Test
    public void testThreeSum() {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1,-1,2));
        expected.add(Arrays.asList(-1,0,1));

        List<List<Integer>> output = ThreeSums.threeSum(input);
        assertArrayEquals(output.toArray(), expected.toArray());

    }

    @Test
    public void testThreeSum1() {
        int[] input = new int[]{3,0,-2,-1,1,2};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-2,-1,3));
        expected.add(Arrays.asList(-2,0,2));
        expected.add(Arrays.asList(-1,0,1));

        List<List<Integer>> output = ThreeSums.threeSum(input);
        assertArrayEquals(output.toArray(), expected.toArray());

    }

    @Test
    public void testThreeSum2() {
        int[] input = new int[]{0,1,1};
        List<List<Integer>> expected = new ArrayList<>();


        List<List<Integer>> output = ThreeSums.threeSum(input);
        assertArrayEquals(output.toArray(), expected.toArray());

    }

    @Test
    public void testThreeSum3() {
        int[] input = new int[]{0,0,0,0};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0,0,0));

        List<List<Integer>> output = ThreeSums.threeSum(input);
        assertArrayEquals(output.toArray(), expected.toArray());

    }
}
