class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]);
            if(nums[index - 1] < 0)
            {
                numbers.add(index);
            }
            else
            {
                nums[index - 1] = -nums[index - 1];
            }
        }
        return numbers;
    }
}
