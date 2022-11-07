package 算法高频题;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 */
public class 二数之和 {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] result= twoSum(nums,6);
            System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        if(nums==null){
            return null;
        }

        Map<Integer,Integer> maps=new HashMap<>();

        for(int i=0;i<nums.length;i++){
          Integer index= maps.get(target-nums[i]);
          if(index!=null){
              return new int[]{i,index};
          }
          maps.put(nums[i],i);
        }
        return null;


    }
}
