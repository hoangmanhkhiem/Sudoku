package V3.View;

import V3.Controller.Controller;

public class Show_Dialog {
    public void displayInputPrompt() {
        System.out.println();
        System.out.println("Số lần sai còn lại : " + Controller.c + "\n" +
                "Số ô trống: " + Controller.otrong);
        System.out.println("Nhập Giá Trị: ");
        System.out.print("Cấu trúc  <số hàng> <số cột>: ");
    }

    public void display_value() {
        System.out.println();
        System.out.print("Nhập Giá Trị Diền: ");
    }
    public void displayInputNotValid() {
        System.out.println("Giá trị nhập vào không hợp lệ");
    }

    public void displayInputisConst() {
        System.out.println("Giá trị nhập vào là giá trị cố định");
    }

    public void displayWelcome() {
        System.out.println("-----------------------------------");
        System.out.println("Chào mừng bạn đến với trò chơi Sudoku !!");
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

    public void displayWin() {
        System.out.println("Chúc mừng bạn đã chiến thắng!");
    }

    public void displayGameOver() {
        System.out.println("Game Over!");
    }
}
