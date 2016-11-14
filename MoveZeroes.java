/**
 * Created by Christina on 2/20/16.
 */
public class MoveZeroes {
    /**
     * Iterate the array, if the item != 0, index + 1 else stays
     *
     * just remove the zeroes ones
     * get the length of the non zeroes array
     * fill the rest with zeroes
     * */

    //O(n), O(1)
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }
    /**
     * public int moveZeros(int[] nums) {
                int left = 0, right = nums.length - 1;
                while (left < right) {
                        if (nums[left] != 0) {
                                left++;
                                continue;
                        }
                        while (left < right) {
                                if (nums[right] != 0) {
                                        break;
                                }
                                right--;
                        }
                        if (left < right) {
                                nums[left] = nums[right];
                                left++;
                                right--;
                        }
                }
               
                return left;
        }
     */
}
