package V4.Model;

public class Node {

    private int x;
    private int y;
    private int value;

    private int isConst;

    public Node(int x, int y,int value, int isConst){
        this.x = x;
        this.y = y;
        this.value = value;
        this.isConst = isConst;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getIsConst(){
        return isConst;
    }

    public void setIsConst(int isConst){
        this.isConst = isConst;
    }
}
