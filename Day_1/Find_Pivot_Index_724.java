class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for ( int n : nums )
            sum += n;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum -= nums[i];
            if(i > 0) sum2 += nums[i - 1];            
            if(sum == sum2) return i;
        }
        return -1;
    }
}
