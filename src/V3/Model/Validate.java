package V3.Model;

public class Validate {
    public static boolean Validate_data(Node[][] arr, Node n) {
        return ValidateRow(arr, n.getY(), n.getValue()) &&
                ValidateCol(arr, n.getX(), n.getValue()) &&
                ValidateSquare(arr, n.getX(), n.getY(), n.getValue());
    }
    // Ham kiem tra hang
    public static boolean ValidateRow(Node[][] arr, int row, int val) {
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra cot
    public static boolean ValidateCol(Node[][] arr, int col, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra hinh vuong
    public static boolean ValidateSquare(Node[][] arr, int row, int col, int val) {
        int rowStart = row - row % Generator.getSizeBox();
        int colStart = col - col % Generator.getSizeBox();
        for (int i = rowStart; i < rowStart + Generator.getSizeBox(); i++) {
            for (int j = colStart; j < colStart + Generator.getSizeBox(); j++) {
                if (arr[i][j].getValue() == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
