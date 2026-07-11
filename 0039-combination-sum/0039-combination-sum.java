class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void solve(int[] candidates, int target, int index,
                      List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            solve(candidates, target - candidates[i], i, list, result);
            list.remove(list.size() - 1);
        }
    }
}