class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null){
            return null;
        }else if(matrix.length == 0){
            return new ArrayList<Integer>();
        }
        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while(topRow <= bottomRow && leftCol <= rightCol){
            
            for(int c = leftCol; c <= rightCol; c++){
                res.add(matrix[topRow][c]);
            }
            topRow++;
            
            for(int r = topRow; r <= bottomRow; r++){
                res.add(matrix[r][rightCol]);
            }
            rightCol--;
            
            //bottomrow. rightcol to left col
            if(bottomRow>=topRow){
                for(int c = rightCol; c>=leftCol; c--){
                    res.add(matrix[bottomRow][c]);
                }
                bottomRow--;
            }
            //bottomrow. rightcol to left col
            if(leftCol<=rightCol){
                for(int r= bottomRow; r>=topRow; r--){
                    res.add(matrix[r][leftCol]);
                }
                leftCol++;
            }
        }
        return res; 
    }
}
