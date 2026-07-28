class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left=0;
        int right  = cols-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int row = maxelement(mat,mid);
            int leftvalue = (mid > 0) ? mat[row][mid-1]:-1;
            int rightvalue = (mid < cols-1) ? mat[row][mid+1]:-1;

             if (mat[row][mid] > leftvalue &&
                mat[row][mid] > rightvalue) {

                return new int[]{row, mid};
            }

            else if (leftvalue > mat[row][mid]) {

                right = mid - 1;
            }

            else {

                left = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }
    private int maxelement(int[][] mat,int mid){
        int row = 0;
        for(int i=1;i<mat.length;i++){
            if(mat[i][mid]>mat[row][mid]){
                row = i;
            }
        }
        return row;

    }
}