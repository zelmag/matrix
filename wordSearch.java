//dfs search. 
class Solution {
    int[][] changes = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        //look for first letter. if find that, mark as visited and look in all 4 directions for next letter
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == word.charAt(0) && help(0,word,r,c,board)){ //found first letter and the rest. 
                    return true; 
                }
            }
        }
        return false; 
    }
    
    public boolean help(int idxChar, String word, int currR, int currC, char[][] board){
        if(idxChar == word.length()){
            return true; 
        }else if((currR < 0 || currR >= board.length) || (currC < 0 || currC >= board[0].length)
                 || board[currR][currC] != word.charAt(idxChar)){
            return false; //out of bounds. back up 
        }
        //mark current as visited
        char oldOne = board[currR][currC];
        board[currR][currC] = '.'; //mark as visited
        boolean found = help(idxChar+1, word, currR+1, currC, board) || help(idxChar+1, word, currR-1, currC, board) || help(idxChar+1, word, currR, currC-1, board) || help(idxChar+1, word, currR, currC+1, board);
        board[currR][currC] = oldOne;
        return found; 
    }
}
