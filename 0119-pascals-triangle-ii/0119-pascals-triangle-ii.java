class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<>();

        long current = 1;

        for (int k = 0; k <= rowIndex; k++) {

            ans.add((int) current);

            current = current * (rowIndex - k) / (k + 1);
        }

        return ans;
    }
}