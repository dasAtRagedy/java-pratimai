import java.util.ArrayList;

public class Main {
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        if (solveBoard(board)) {
            System.out.println("Solution:");
            printBoard(board);
        }
        else {
            System.out.println("No solution found");
        }

        /*
        System.out.println("Original board:");
        printBoard(board);
        System.out.println();

        shuffleBoard(board);
        System.out.println("Shuffled board:");
        printBoard(board);
        System.out.println();

        System.out.println("Valid board:");
        generateValidBoard(board);
        printBoard(board);
        System.out.println();
        */

    }


    // check if number is in row
    private static boolean checkRow(int[][] board, int row, int num) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    // check if number is in column
    private static boolean checkColumn(int[][] board, int col, int num) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    //check if number is in 3x3 grid
    private static boolean checkGrid(int[][] board, int row, int col, int num) {
        for (int i = row - row % (GRID_SIZE / 3); i < row - row % (GRID_SIZE / 3) + (GRID_SIZE / 3); i++) {
            for (int j = col - col % (GRID_SIZE / 3); j < col - col % (GRID_SIZE / 3) + (GRID_SIZE / 3); j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    // check if placement is valid
    private static boolean isValid(int[][] board, int row, int col, int num) {
        return !checkRow(board, row, num) &&
                !checkColumn(board, col, num) &&
                !checkGrid(board, row, col, num);
    }

    private static boolean isValidBoard(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (!isValid(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solveBoard(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= GRID_SIZE; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solveBoard(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // print board
    private static void printBoard(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] shuffleBoard(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                int rand = (int) (Math.random() * GRID_SIZE);
                int temp = board[i][j];
                board[i][j] = board[i][rand];
                board[i][rand] = temp;
            }
        }
        return board;
    }

    // change random number to 0
    private static int[][] changeRandom(int[][] board) {
        int randRow = (int) (Math.random() * GRID_SIZE);
        int randCol = (int) (Math.random() * GRID_SIZE);
        board[randRow][randCol] = 0;
        return board;
    }

    // check if solved
    private static boolean isSolved(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] != 0) {
                    if (!checkRow(board, i, board[i][j]) ||
                            !checkColumn(board, j, board[i][j]) ||
                            !checkGrid(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // use changeRandom until valid board is generated
    private static void generateValidBoard(int[][] board) {
        int[][] boardCopy = board;
        while (!isValidBoard(boardCopy) && !solveBoard(boardCopy)) {
            board = changeRandom(board);
            boardCopy = board;
        }
    }

    // implement quicksort for arraylist with Comparators



    // generate random board
    private static void generateRandomBoard(int[][] board) {
        int[] arr = new int[GRID_SIZE * GRID_SIZE];
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
            arr[i] = i + 1;
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                board[i][j] = arr[i * GRID_SIZE + j];
            }
        }
    }

    // generate board
    private static void generateBoard(int[][] board) {
        generateValidBoard(board);
        generateRandomBoard(board);
    }
}

