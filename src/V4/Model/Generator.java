package V4.Model;

import V4.Model.Misson;
import V4.Model.Game;

public class Generator {
    private static int size = 9;
    private static int  sizeBox = 3;

    private Misson misson = new Misson();

    public Generator() {
        super();
    }

    public Generator(int size) {
        super();
        this.size = size;
        sizeBox = (int) Math.sqrt(size);
    }

    public Node[][] GeneratorGame() {
        misson.read_file();
        int[][] sample = misson.getSample();
        int[][] isConst = misson.getIsConst();
        Node[][] arr = new Node[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = new Node(i, j, sample[i][j], isConst[i][j]);
            }
        }
        return arr;
    }

    public Node[][] coppyArray2d(Node[][] arr) {
        Node[][] arrCopy = new Node[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arrCopy[i][j] = new Node(i, j, arr[i][j].getValue(), arr[i][j].getIsConst());
            }
        }
        return arrCopy;
    }

    public void removeDigits(Node[][] arr, int countRm) {
            int count = 0;
            while (count < countRm) {
                int cellId = randomGenerator(size*size) - 1;
                int i = cellId / size;
                int j = cellId % size;
                if (arr[i][j].getValue() != 0) {
                    count++;
                    arr[i][j].setValue(0);
                    arr[i][j].setIsConst(0);
                }
        }
    }



    private int randomGenerator(int num) {
        return (int) (Math.random() * num + 1);
    }


    public static int getSizeBox() {
        return sizeBox;
    }

    public static void setSizeBox(int s) {
        sizeBox = s;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int s) {
        size = s;
    }

}
