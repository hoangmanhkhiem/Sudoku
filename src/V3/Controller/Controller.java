package V3.Controller;

import V3.Model.Game;
import V3.Model.Node;
import V3.Model.Validate;
import V3.View.Show_Dialog;
import V3.View.Display_Board;
import V3.Model.InputException;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    public static final Game game = new Game();
    private final Display_Board showBoard = new Display_Board();
    private final Validate validate = new Validate();
    private Scanner input = new Scanner(System.in);
    private final Show_Dialog stageGame = new Show_Dialog();
    // Bien trong game
    public static int otrong;
    public static boolean g = true;
    public static int c = 10;
    private int size = 9;
    public int x, y, value; // Toa do va gia tri nhap vao

    public Controller(int o, int err, int s) {
        otrong = o;
        c = err;
        size = s;
    }
    public Controller() {
        this.otrong = 20;
        size = 9;
    }
    private void run() {
        game.initData(otrong);
        Node[][] arr = game.getBoardMissing();
        while (g && c > 0 && otrong > 0) {
            showBoard.show(arr);
            stageGame.displayInputPrompt();
            nhaptoado();
            if(arr[x][y].getIsConst()){
                stageGame.displayInputisConst();
                continue;
            }
            else {
                nhapGiatri();
                if(value == 0){
                    arr[x][y].setValue(0);
                    arr[x][y].setIsConst(false);
                    otrong++;
                }
                else if (validate.Validate_data(arr, new Node(x, y, value, false))) {
                    arr[x][y].setValue(value);
                    arr[x][y].setIsConst(false);
                    otrong--;
                }
                else {
                    c--;
                    stageGame.displayInputNotValid();
                }
            }
            if (otrong == 0) {
                stageGame.displayWin();
                break;
            }
            if (c == 0) {
                stageGame.displayGameOver();
                break;
            }
        }
        input.close();
    }

    private  void nhaptoado(){
        stageGame.displayInputPrompt();
        try {
            x = input.nextInt();
            y = input.nextInt();
            x--;
            y--;
            if (x < 0 || x >= size|| y < 0 || y >= size) {
                throw new InputException("Vui long nhap toa do trong khoang 1 den " + (size));
            }
        } catch (InputException e) {
            System.out.println(e.getMessage());
            nhaptoado();
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số nguyên.");
            input.nextLine(); // Xóa dòng không hợp lệ khỏi input
            nhaptoado();
        }

    }
    private void nhapGiatri() {
        stageGame.display_value();
        try{
            value = input.nextInt();
            if (value < 0 || value > size) {
                throw new InputException("Vui long nhap gia tri trong khoang 1 den " + size);
            }
        } catch (InputException e) {
            System.out.println(e.getMessage());
            nhapGiatri();
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số nguyên.");
            input.nextLine();
            nhapGiatri();
        }
    }

    public void menu() {
        stageGame.displayWelcome();
        int choice;
        while(true){
            stageGame.displayMenu();
            stageGame.displayOptionPrompt();
            choice = input.nextInt();
            if(choice == 1){
                run();
                break;
            } else if(choice == 2){
                stageGame.displayGoodbye();
                break;
            } else {
                stageGame.displayInputNotValid();
            }
        }
    }
}
