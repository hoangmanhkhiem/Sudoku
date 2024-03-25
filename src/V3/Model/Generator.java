package V3.Model;


public class Generator {
    private static int size = 9;
    private static int  sizeBox = (int) Math.sqrt(size);

    private static int[][] sample = {
            {3, 1, 6, 5, 7, 8, 4, 9, 2},
            {5, 2, 9, 1, 3, 4, 7, 6, 8},
            {4, 8, 7, 6, 2, 9, 5, 3, 1},
            {2, 6, 3, 4, 1, 5, 9, 8, 7},
            {9, 7, 4, 8, 6, 3, 1, 2, 5},
            {8, 5, 1, 7, 9, 2, 6, 4, 3},
            {1, 3, 8, 9, 4, 7, 2, 5, 6},
            {6, 9, 2, 3, 5, 1, 8, 7, 4},
            {7, 4, 5, 2, 8, 6, 3, 1, 9}
    };

    public Generator() {
        super();
    }

    public Generator(int size) {
        super();
        this.size = size;
        sizeBox = (int) Math.sqrt(size);
    }

    public Node [][] GeneratorGame() {
        Node [][] arr = new Node [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = new Node(i, j, sample[i][j], true);
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
                arr[i][j].setIsConst(false);
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

    public static int[][] getSample() {
        return sample;
    }

}
