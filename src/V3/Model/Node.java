package V3.Model;

public class Node {

    private int x;
    private int y;
    private int value;

    private boolean isConst;

    public Node(int x, int y,int value, boolean isConst){
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

    public boolean getIsConst(){
        return isConst;
    }

    public void setIsConst(boolean isConst){
        this.isConst = isConst;
    }
}
