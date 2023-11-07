class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<1) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums) {
            set.add(num);
        }
        int res = 1;
        for(Integer x:set) {
            int curr = 1;
            if(!set.contains(x-1)) {
                while(set.contains(x+curr)) {
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}