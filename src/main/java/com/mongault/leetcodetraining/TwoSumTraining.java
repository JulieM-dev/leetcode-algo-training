package com.mongault.leetcodetraining;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TwoSumTraining {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] numsReversed = new int[nums.length];
        int counter = 1;
        for(int num : nums) {
            numsReversed[nums.length - (counter)] = num;
            counter++;
        }
        int target = 9;

        System.out.println(Arrays.toString(numsReversed));
        System.out.println(target);
        System.out.println(Arrays.toString(twoSum2(numsReversed, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> checkedValues = new HashMap<>();
        int counter = 0;
        for(int num: nums) {
            int difference = target - num;
            if(checkedValues.containsKey(difference)) {
                return new int[]{checkedValues.get(difference), counter};
            }
            checkedValues.put(num, counter);
            counter++;
        }

        throw new RuntimeException("sum is impossible");
    }

    public static int[] twoSum2(int[] nums, int target) {
        int n=nums.length;
        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                if(nums[j]+nums[j-i]==target){
                    return new int[]{j-i,j};
                }
            }
        }
        return new int[]{};
    }
}
