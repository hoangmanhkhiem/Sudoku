package V3.Model;


import V3.View.Display_Board;
import V3.Model.Generator;

public class Game {
    private Node[][] boardRes;
    private Node[][] boardMission;

    private int n;
    private final Generator generator = new Generator();
    private final Display_Board showArray2D = new Display_Board();

    // Constructor
    public Game() {
    }
    public Game(int n) {
        initData(n);
    }

    // Getters and Setters

    public Node[][] getBoardRes() {
        return boardRes;
    }
    public void setBoardRes(Node[][] boardRes) {
        this.boardRes = boardRes;
    }

    public Node[][] getBoardMissing() {
        return boardMission;
    }

    public void setBoardMissing(Node[][] boardMissing) {
        this.boardMission = boardMissing;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void show() {
        showArray2D.show(boardMission);
    }

    public void initMission(int n) {
        boardMission = generator.coppyArray2d(boardRes);
        generator.removeDigits(boardMission, n);
    }
    public void initData(int n) {
        boardRes = generator.GeneratorGame();
        initMission(n);
        this.n = n;
    }
}
