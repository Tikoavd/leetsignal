class Solution {
    public int singleNonDuplicate(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while(min < max)
        {
            int mid = (min + max) / 2;
            if(((mid % 2 == 0) && nums[mid + 1] == nums[mid]) ||
               ((mid % 2 == 1) && nums[mid - 1] == nums[mid])) min = mid + 1;
            else max = mid;
        }
        return nums[min];
    }
}
