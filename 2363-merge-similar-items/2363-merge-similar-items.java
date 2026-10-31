class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<items1.length;i++){
           map.put(items1[i][0], map.getOrDefault(items1[i][0], 0) + items1[i][1]);
        }
        for(int i=0;i<items2.length;i++){
           map.put(items2[i][0], map.getOrDefault(items2[i][0], 0) + items2[i][1]);
        }
         List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        // Step 4: Create result
        List<List<Integer>> res = new ArrayList<>();

        for (int key : keys) {
            res.add(Arrays.asList(key, map.get(key)));
        }

        return res;
    }
}