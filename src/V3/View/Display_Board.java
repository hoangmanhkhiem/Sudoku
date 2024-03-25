package V3.View;

import V3.Model.Node;
import V3.Model.Generator;

public class Display_Board {
    public void show(Node[][] arr) {
        System.out.print("   1 2 3   4 5 6   7 8 9");
        System.out.println();
        for (int i = 0; i < Generator.getSize(); i++) {
            if (i % Generator.getSizeBox() == 0){
                for(int k = 0; k < Generator.getSize(); k++){
                    System.out.print("---");
                }
                System.out.println();
            }
            System.out.print((i+1));
            for (int j = 0; j < Generator.getSize(); j++) {
                if (j % Generator.getSizeBox() == 0){
                    System.out.print("| ");
                }
                if(arr[i][j].getValue() == 0)
                    System.out.print("- ");
                else System.out.print(arr[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }

}
