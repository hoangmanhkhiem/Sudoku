package V1.View;

import V1.Model.Node;

public class View {
    public void displayInputPrompt() {
        System.out.println("Nhập Giá Trị: ");
        System.out.print("Cấu trúc  <số hàng> <số cột> <giá trị>: ");
    }
    public void displayInputNotValid() {
        System.out.println("Giá trị nhập vào không hợp lệ");
    }

    public void displayInputisConst() {
        System.out.println("Giá trị nhập vào là giá trị cố định");
    }

    public void displayWinner() {
        System.out.println("Chúc mừng bạn đã chiến thắng!");
    }

    public void displayWrongInput() {
        System.out.println("Giá trị nhập vào sai!");
    }

    public void displayGameBoard(Node[][] gameBoard) {
        System.out.println("\t------------Sudoku Game------------");
        System.out.println("\t    1  2  3   4  5  6   7  8  9");
        System.out.println("\t  +---------+---------+---------+");
        for (int i = 0; i < 9; i++) {
            System.out.print("\t" + (i + 1) + " |");
            for (int j = 0; j < 9; j++) {
                if (gameBoard[i][j].getValue() == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(" " + gameBoard[i][j].getValue() + " ");
                }
                if (j == 2 || j == 5) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
            if (i == 2 || i == 5) {
                System.out.println("\t  +---------+---------+---------+");
            }
        }
    }

    public void displayWelcome() {
        System.out.println("-----------------------------------");
        System.out.println("Chào mừng bạn đến với trò chơi Sudoku!");
        System.out.println("-----------------------------------");
        System.out.println("Hướng dẫn chơi: ");
        System.out.println("1. Mỗi hàng, mỗi cột và mỗi ô vuông 3x3 không chứa giá trị trùng nhau");
        System.out.println("2. Nhập vào số hàng, số cột và giá trị cần điền");
        System.out.println("3. Sử dụng số 0 để xóa giá trị");
        System.out.println("4. Nhấn Enter để xác nhận");
        System.out.println("5. Chúc bạn chơi vui vẻ!");
        System.out.println("-----------------------------------");
    }

    public void displayMenu() {
        System.out.println("-----------------------------------");
        System.out.println("Menu: ");
        System.out.println("1. Bắt đầu chơi");
        System.out.println("2. Thoát");
        System.out.println("-----------------------------------");
    }

    public void displayGoodbye() {
        System.out.println("-----------------------------------");
        System.out.println("Cảm ơn bạn đã chơi!");
        System.out.println("-----------------------------------");
    }

    public void displayInvalidOption() {
        System.out.println("-----------------------------------");
        System.out.println("Lựa chọn không hợp lệ");
        System.out.println("-----------------------------------");
    }

    public void displayOptionPrompt() {
        System.out.println("-----------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }

    public void displayCheating() {
        System.out.println("Cheating by Khiem Vip Pro");
    }
}
