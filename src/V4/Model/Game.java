package V4.Model;

public class Game {
    private Node[][] boardRes;
    private Node[][] boardMission;

    private int n;
    private final Generator generator = new Generator();


    // Constructor
    public Game() {
    }
    public Game(int n) {
        initData(n);
    }

    public Node[][] getBoardMissing() {
        return boardMission;
    }

    public void initData(int n) {
        boardRes = generator.GeneratorGame();
        boardMission = generator.coppyArray2d(boardRes);
        generator.removeDigits(boardMission, n);
        this.n = n;
    }

    public void initData_File(){
        boardRes = generator.GeneratorGame();
        boardMission = generator.coppyArray2d(boardRes);
        int res = 0;
        for (int i = 0; i < boardMission.length; i++) {
            for (int j = 0; j < boardMission.length; j++) {
                if(boardMission[i][j].getIsConst() == 0){
                    res ++;
                }
            }
        }
        this.n = res;
    }
}
