class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        int[] nums = new int[nums1.length + nums2.length];
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        
        int j = 0;        
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                nums[j++] = nums2[i];
                set.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(nums, 0, j);
    }
}
