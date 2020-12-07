package ru.geekbrains;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAllAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})));

        System.out.println(isOneOrFourCheckArray(new int[]{4,4}));
    }

    public static int[] getAllAfterLastFour(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 4){
                return Arrays.copyOfRange(nums,  ++i, nums.length);
            }
        }
        throw new RuntimeException();
    }

    public static boolean isOneOrFourCheckArray(int[] nums){
        boolean haveOne = false;
        boolean haveFour = false;
        for (int num : nums) {
            if (num == 1) haveOne = true;
            if (num == 4) haveFour = true;
        }
        return haveOne & haveFour;
    }

}


