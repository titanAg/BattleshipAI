// Kyle Orcutt - Battleship Solver AI From First Semester
// Simple hunt target mode
// Guesses made only on even squares based on a heat map
public class KyleAI{
    public static String makeGuess(char[][] guesses)
    {
        int row, col;
        int[][] heatMap = new int[10][10];
        boolean hunt = false;

        for (row = 0; row < guesses.length; row++){
            for (col = 0; col < guesses[row].length; col++){
                if (guesses[row][col] == 'X'){
                    hunt = true;
                    if (isValid(row,col+1) == true && guesses[row][col+1] == '.'){
                        heatMap[row][col+1] +=10;
                    }
                    if (isValid(row,col-1) == true && guesses[row][col-1] == '.'){
                        heatMap[row][col-1] +=10;
                    }
                    if (isValid(row+1,col) == true && guesses[row+1][col] == '.'){
                        heatMap[row+1][col] +=10;
                    }
                    if (isValid(row-1,col) == true && guesses[row-1][col] == '.'){
                        heatMap[row-1][col] +=10;
                    }
                }
            }
        }
        if(hunt){
            int bestRow = 0;
            int bestCol = 0;
            int highest = 0;
            for (row = 0; row < guesses.length; row++){
                for (col = 0; col < guesses[row].length; col++){
                    if (heatMap[row][col] > highest){
                        highest = heatMap[row][col];
                        bestRow = row;
                        bestCol = col;

                    }
                    System.out.print(heatMap[row][col] + " ");
                }
                System.out.println();
            }
            row = bestRow;
            col = bestCol;
        }else{
            do{
                row = (int)(Math.random() * 10);
                if (row % 2 == 0){
                    col = (int)(Math.random() * 5)*2;
                }
                else {
                    col = (int)(Math.random() * 5)*2 + 1;
                }
            }while(guesses[row][col] != '.');
        }
        char a = (char)((int)'A' + row);

        String guess = a + Integer.toString(col+1);
        return guess;

    }

    public static boolean isValid(int row, int col){
        if (row <= 9 && row >= 0 && col <= 9 && col >= 0){
            return true;
        }else {
            return false;
        }
    }
}