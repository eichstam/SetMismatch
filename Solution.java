/**
 * 645. Set Mismatch

The set S originally contains numbers from 1 to n. But unfortunately,
due to the data error, one of the numbers in the set got duplicated
to another number in the set, which results in repetition of one number
and loss of another number.

Given an array nums representing the data status of this set after
the error. Your task is to firstly find the number occurs twice and
then find the number that is missing. Return them in the form of
an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Note:

    The given array size will in the range [2, 10000].
    The given array's numbers won't have any order.
 *
 */
public class Solution {
  public int[] findErrorNums(int[] nums) {
    boolean[] boolNums = new boolean[nums.length];
    int[] result = new int[2];

    for(int i = 0; i < nums.length; i++) {
      boolNums[i] = false;
    }
    for(int i = 0; i < nums.length; i++) {
      if(boolNums[nums[i]-1] == false) {
        boolNums[nums[i]-1] = true;
      } else {
        // nums[i] is a duplicate
        result[0] = nums[i];
      }
    }
    for(int i = 0; i < nums.length; i++) {
      if(boolNums[i] == false) {
        result[1] = i+1;
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = {1,2,2,4};
    int[] nums2 = {2,2};
    int[] nums3 = {1,1};
    int[] nums4 = {3,2,3,4,6,5};
        
    int[] result1 = s.findErrorNums(nums1);
    System.out.println("result1:" + result1[0] + " result1:" + result1[1]);
    int[] result2 = s.findErrorNums(nums2);
    System.out.println("result2:" + result2[0] + " result2:" + result2[1]);
    int[] result3 = s.findErrorNums(nums3);
    System.out.println("result3:" + result3[0] + " result3:" + result3[1]);
    int[] result4 = s.findErrorNums(nums4);
    System.out.println("result4:" + result4[0] + " result4:" + result4[1]);
  }
}
