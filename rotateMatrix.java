class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        /*
        1st. transpose. so that cols become rows.  aka rows become cols
        swap r = 1, c = 0 with whatever is r = 0, c = 1
        1 2 3    1 4 7
        4 5 6    2 5 8
        7 8 9    3 6 9
        */
        for(int r = 0; r < n; r++){
            for(int c = r; c < n; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        /*
        2nd. Now 2 pointers @ end and @beg working towards the middle. swapping
        */
        for(int r = 0; r < n; r++){
            int s = 0;
            int e = n - 1;
            while(s < e){
                int temp = matrix[r][s];
                matrix[r][s] = matrix[r][e];
                matrix[r][e] = temp;
                e--;
                s++;
            }
        }
    }
}
