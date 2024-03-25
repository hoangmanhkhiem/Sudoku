package V4.Controller;

import V4.Model.*;
import V4.View.Display_Board;
import V4.View.Show_Dialog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    public static final Game game = new Game();
    private final Display_Board showBoard = new Display_Board();

    private Scanner input = new Scanner(System.in);
    private final Show_Dialog stageGame = new Show_Dialog();
    // Bien trong game
    public static int otrong;
    public static boolean g = true;

    private boolean check = false;

    private int size = 9;
    public int x, y, value; // Toa do va gia tri nhap vao

    // File

    private final Misson misson = new Misson();


    public Controller(int o, int s) {
        otrong = o;
        size = s;
    }
    public Controller() {
        this.otrong = 10;
        size = 9;
    }
    private void run() {
        if(check){
            game.initData_File();
        }
        else{
            game.initData(otrong);
        }
        Node[][] arr = game.getBoardMissing();
        while (g && otrong > 0) {
            showBoard.show(arr);
            stageGame.displayInputPrompt();
            nhaptoado();
            if(arr[x][y].getIsConst() == 1){
                stageGame.displayInputisConst();
                continue;
            }
            else {
                nhapGiatri();
                if(this.value == 0){
                    arr[x][y].setValue(0);
                    arr[x][y].setIsConst(0);
                    otrong++;
                }
                else if (Validate.Validate_data(arr, new Node(x, y, this.value, 0))) {
                    arr[x][y].setValue(this.value);
                    otrong--;
                }
                else {
                    stageGame.displayInputNotValid();
                }
            }
            if (otrong == 0){
                stageGame.displayWin();
                break;
            }
            stageGame.display_select_misson();
            //ignore
            String ignore = input.nextLine();
            String select = input.nextLine();
            if(select.equals("N") || select.equals("n")){
                break;
            }
        }
        misson.save_misson(arr);
        input.close();
    }

    private  void nhaptoado(){
        try{
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
            this.value = input.nextInt();
            if (this.value < 0 || this.value > size) {
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

    public void init_game() {
        stageGame.displayWelcome();
        run();
    }

    public void menu_start(){
        stageGame.display_Name();
        String name = input.nextLine();
        if(misson.check_user_available(name)){
            misson.setNAME_USER(name);
            stageGame.chaomungtrolai();
            stageGame.display_select_misson();
            String select = input.nextLine();
            if(select.equals("N") || select.equals("n")){
                misson.load_list_misson();
            }
            else{
                misson.setfile_new();
                boolean _check = misson.compair_user_with_misson();
                if(_check){
                    stageGame.has_been_won();
                    misson.load_list_misson();
                }
                this.check = true;
            }
            init_game();
        }
        else{
            stageGame.chaomungnguoimoi();
            misson.setNAME_USER(name);
            misson.add_new_user();
            misson.load_list_misson();
            init_game();
        }
    }

}
