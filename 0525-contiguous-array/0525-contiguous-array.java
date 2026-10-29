class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int zerocount = 0;
        int onecount = 0;
        int res = 0;
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zerocount++;
            }
            else{
                onecount++;
            }
            int diff = zerocount - onecount;
            if(map.containsKey(diff)){
                int idx = map.get(diff);
                int len = i-idx;
                res = Math.max(len,res);
            }else{
                map.put(diff,i);
            }
        }
        return res;
    }
}