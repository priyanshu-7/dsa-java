class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums1.length; i++) {
            set.add(nums1[i]);
        }
        for(int i = 0; i<nums2.length; i++) {
            if(set.contains(nums2[i]) && !arr.contains(nums2[i])) {
                arr.add(nums2[i]);
            }
        }
        int[] output = new int[arr.size()];
        for(int x = 0; x < arr.size(); x++) {
            output[x] = arr.get(x);
        }
        return output;
    }
}
