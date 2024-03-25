package V4.View;

import V4.Controller.Controller;

public class Show_Dialog {
    public void displayInputPrompt() {
        System.out.println();
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

    public void displayWin() {
        System.out.println("Chúc mừng bạn đã chiến thắng!");
    }

    public void displayGameOver() {
        System.out.println("Game Over!");
    }

    public void display_Name() {
        System.out.print("Nhập tên của bạn: ");
    }

    public void displayMisson() {
        System.out.println("Truoc do ban da choi cac man sau:");
    }

    public void display_select_misson() {
        System.out.println("Ban co muon choi tiep khong? (Y/N) Default: Y - Enter");
    }

    public void has_been_won() {
        System.out.println("Ban da chien thang o van truoc roi nen se bat dau tu dau");
    }

    public void chaomungtrolai(){
        System.out.println("Chào mừng bạn trở lại");
    }

    public void chaomungnguoimoi(){
        System.out.println("Chào mừng người mới");
    }

}
