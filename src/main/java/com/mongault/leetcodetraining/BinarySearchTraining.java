package com.mongault.leetcodetraining;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BinarySearchTraining {

    public static void main(String[] args) {
        int[] input = {-1,0,3,5,9,12};
        int target = 12;

        System.out.println("index of the target : " + search(input, target));

    }

    public static int search(int[] nums, int target) {
        int result = -1;
        int rangeMin = 0;
        int rangeMax = nums.length-1;

        while (rangeMin <= rangeMax) {

            int indexToCheck = (rangeMax - rangeMin) /2 + rangeMin;

            if(nums[indexToCheck] > target) {
                rangeMax = indexToCheck -1;
            }
            else if (nums[indexToCheck] < target) {
                rangeMin = indexToCheck + 1;
            }
            else {
                result = indexToCheck;
                break;
            }
        }

        return result;
    }

}
