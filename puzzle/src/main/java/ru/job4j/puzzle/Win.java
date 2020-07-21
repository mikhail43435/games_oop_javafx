package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = hasFiveInRowOrColumn(board);
        return rsl;
    }

    // проверка одинаковых значений по вертикали
    public static boolean monoVertical(int[][] board, int column) {
        boolean result = true;
        for (int index = 0; index < board.length; index++) {
            if (board[index][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    // проверка одинаковых значений по горизонтали
    public static boolean monoHorizontal(int[][] board, int row) {
        boolean result = true;

        for (int index = 0; index < board[row].length; index++) {
            if (board[row][index] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean hasFiveInRowOrColumn(int[][] board) {
        boolean result = false;
        int lengthOfMatrix = board.length;
        int neededSymbol = 1;
        //boolean winIsFoound;

        for (int index = 0; index < lengthOfMatrix; index++) {
            if (board[index][index] == neededSymbol) { // нашли Х в ячейке
                // ищем по вертикали и горизонтали
                if (monoHorizontal(board, index) || monoVertical(board, index)) {
                    return true;
                }
            }
        }
        return result;
    }

}




