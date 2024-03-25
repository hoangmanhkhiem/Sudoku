package V2.Model;

public class Node {

    private int x;
    private int y;
    private int value;

    public Node(int x, int y,int value){
        this.x = x;
        this.y = y;
        this.value = value;
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
}
