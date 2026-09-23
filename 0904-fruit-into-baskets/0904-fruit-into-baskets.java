class Solution {
    public int totalFruit(int[] fruits) {
        int low=0;
        int maxLen=0;
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int high=0;high<fruits.length;high++){
            int fruit = fruits[high];
            map.put(fruit,map.getOrDefault(fruit,0)+1);
            while(map.size()>2){
                int leftfruit = fruits[low];
                map.put(leftfruit , map.get(leftfruit)-1);

                if(map.get(leftfruit)==0){
                    map.remove(leftfruit);
                }
                low++;

            }
            int len = high - low + 1;

            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
