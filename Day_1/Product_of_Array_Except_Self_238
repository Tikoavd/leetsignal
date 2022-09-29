class Solution {
    public int[] productExceptSelf(int[] nums) {
        prod(nums, 0, 1);
        return nums;
    }
    
    static int prod(int[] nums, int left, int productleft)
    {
        if(left == 0) productleft = 1;
        else productleft *= nums[left - 1];
        if(left < nums.length - 1)
        {
            int right = nums[left + 1] * prod(nums, left + 1, productleft);
            nums[left] = productleft * right;
            return right;
        }
        nums[left] = productleft;
        return 1;
    }
}
