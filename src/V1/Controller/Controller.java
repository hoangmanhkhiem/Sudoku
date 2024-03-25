package V1.Controller;

import V1.Model.Game;
import V1.View.View;

import java.util.Scanner;

public class Controller {
    private Game game;
    private View view;

    public Controller() {
        game = new Game();
        view = new View();
    }

    public void Menu() {
        view.displayWelcome();
        view.displayMenu();
        int choice;
        while(true){
            Scanner scanner = new Scanner(System.in);
            view.displayOptionPrompt();
            choice = scanner.nextInt();
            if(choice == 1){
                start_game();
                break;
            } else if(choice == 2){
                view.displayGoodbye();
                break;
            } else {
                view.displayInputNotValid();
            }
        }

    }

    public void start_game() {
        Scanner scanner = new Scanner(System.in);
        String _row, _col, _value;
        view.displayGameBoard(game.getBoard_game());
        while (true) {
            view.displayInputPrompt();
            _row = scanner.next();
            _col = scanner.next();
            _value = scanner.next();
            if(_row.equals("Khiem") || _col.equals("Vip") || _value.equals("Pro")) {
                view.displayCheating();
                game.cheating();
                view.displayGameBoard(game.getBoard_game());
                view.displayWinner();
                break;
            }
            int row = Integer.parseInt(_row);
            int col = Integer.parseInt(_col);
            int value = Integer.parseInt(_value);
            row -= 1;
            col -= 1;
            if (row < 0 || row > 8 || col < 0 || col > 8 || value < 0 || value > 9) {
                view.displayInputNotValid();
                continue;
            }
            if (game.checkInput(row, col)) {
                view.displayInputisConst();
                continue;
            }
            if (!game.checkValue(row, col, value)) {
                view.displayWrongInput();
                continue;
            }
            game.setValue(row, col, value);
            view.displayGameBoard(game.getBoard_game());
            if (game.checkWin()) {
                view.displayWinner();
                break;
            }
        }
    }
}
