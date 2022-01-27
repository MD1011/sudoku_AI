

public class Main {

    private static final int GRID_SIZE = 9;


    public static void main(String[] args) {

        int[][] board = {
                {0, 5, 6, 8, 3, 7, 1, 4, 9},
                {7, 1, 9, 4, 2, 5, 8, 3, 6},
                {8, 4, 3, 6, 1, 9, 2, 5, 7},
                {4, 6, 7, 1, 5, 8, 9, 2, 3},
                {3, 9, 2, 7, 0, 4, 5, 1, 8},
                {5, 8, 1, 3, 9, 2, 6, 7, 4},
                {1, 7, 8, 2, 4, 6, 3, 9, 5},
                {6, 3, 5, 9, 7, 1, 4, 8, 2},
                {9, 2, 4, 5, 8, 3, 7, 6, 0}
        };
    if (solvedBoard(board)){
        System.out.println("!!!");
    }else {
        System.out.println("---");
    }

    printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++){
            for (int column = 0; column < GRID_SIZE; column++){
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    private static boolean numberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean numberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[column][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean numberInbox(int[][] board, int number, int column, int row) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) ;
            {
                if (board[column][i] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidePlacement (int[][] board, int number, int column, int row) {
        return  !numberInRow(board,number,row) &&
                !numberInColumn(board, number, column) &&
                !numberInbox(board, number,row,column);
    }

    private static boolean solvedBoard (int[][] board){
        for (int row = 0; row < GRID_SIZE; row++){
            for (int column = 0; column < GRID_SIZE; column++){
                if(board[row][column] == 0){
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++){
                        if (isValidePlacement(board,numberToTry,row,column)){
                            board[row][column] = numberToTry;

                            if (solvedBoard(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


}
