package V4.Model;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Misson {
    private int[][] sample;

    private int[][] isConst;

    private static String IN_FILE;

    private static String OUT_FILE;

    private static String NAME_USER;

    private static final String LIST_USER = "src\\V4\\data\\user\\";

    private static final String LIST_MISSON = "src\\V4\\data\\misson\\";


    public static void setNAME_USER(String name_user) {
        NAME_USER = name_user;
    }

    public static void setOUT_FILE(String oUT_FILE) {
        OUT_FILE = oUT_FILE;
    }

    public static void setInFile(String inFile) {
        IN_FILE = inFile;
    }

    public int[][] getIsConst() {
        return isConst;
    }

    public Misson() {
        super();
    }

    public int[][] getSample() {
        return sample;
    }

    public void read_file() {
        try {
            FileInputStream file = new FileInputStream(IN_FILE);
            Scanner scanner = new Scanner(file);
            int[][] sample = new int[Generator.getSize()][Generator.getSize()];
            for (int i = 0; i < Generator.getSize(); i++) {
                for (int j = 0; j < Generator.getSize(); j++) {
                    sample[i][j] = scanner.nextInt();
                }
            }
            int[][] isConst = new int[Generator.getSize()][Generator.getSize()];
            for (int i = 0; i < Generator.getSize(); i++) {
                for (int j = 0; j < Generator.getSize(); j++) {
                    isConst[i][j] = scanner.nextInt();
                }
            }
            this.isConst = isConst;
            this.sample = sample;
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void setfile_new() {
        setInFile(LIST_USER + NAME_USER + ".txt");
        setOUT_FILE(LIST_USER + NAME_USER + ".txt");
    }

    public void load_list_misson() {
        Random random = new Random();
        int misson = random.nextInt(2) + 1;
        if(misson == 1) {
            setInFile(LIST_MISSON + "misson_1.txt");
            setOUT_FILE(LIST_USER + NAME_USER + ".txt");
        }
        else{
            setInFile(LIST_MISSON + "misson_2.txt");
            setOUT_FILE(LIST_USER + NAME_USER + ".txt");
        }
    }

    public boolean compair_user_with_misson(){
        int count1 = 0, count2 = 0;
        try {
            FileInputStream file = new FileInputStream(IN_FILE);
            Scanner scanner = new Scanner(file);
            int[][] sample = new int[Generator.getSize()][Generator.getSize()];
            for (int i = 0; i < Generator.getSize(); i++) {
                for (int j = 0; j < Generator.getSize(); j++) {
                    sample[i][j] = scanner.nextInt();
                }
            }
            scanner.close();
            FileInputStream file1 = new FileInputStream(LIST_MISSON + "misson_1.txt");
            Scanner scanner1 = new Scanner(file1);
            int[][] sample1 = new int[Generator.getSize()][Generator.getSize()];
            for (int i = 0; i < Generator.getSize(); i++) {
                for (int j = 0; j < Generator.getSize(); j++) {
                    sample1[i][j] = scanner1.nextInt();
                }
            }
            scanner1.close();

            FileInputStream file2 = new FileInputStream(LIST_MISSON + "misson_2.txt");
            Scanner scanner2 = new Scanner(file2);
            int[][] sample2 = new int[Generator.getSize()][Generator.getSize()];
            for (int i = 0; i < Generator.getSize(); i++) {
                for (int j = 0; j < Generator.getSize(); j++) {
                    sample2[i][j] = scanner2.nextInt();
                }
            }
            scanner2.close();
            for(int i = 0; i < Generator.getSize(); i++){
                for(int j = 0; j < Generator.getSize(); j++){
                    if(sample[i][j] == sample1[i][j]){
                        count1++;
                    }
                }
            }
            for(int i = 0; i < Generator.getSize(); i++){
                for(int j = 0; j < Generator.getSize(); j++){
                    if(sample[i][j] == sample2[i][j]){
                        count2++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        if(count1 == Generator.getSize()*Generator.getSize() || count2 == Generator.getSize()*Generator.getSize()){
            return true;
        }
        else{
            return false;
        }
    }

    public void add_new_user() {
        try {
            FileOutputStream file = new FileOutputStream(LIST_USER + NAME_USER + ".txt");
            file.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public boolean check_user_available(String name) {
        File file = new File(LIST_USER + name + ".txt");
        if(file.exists()){
            return true;
        }
        else{
            return false;
        }
    }

    public void save_misson(Node[][] arr) {
        try {
            FileWriter file = new FileWriter(OUT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(file);

            for (int i = 0; i < Generator.getSize(); i++) {
                for (int j = 0; j < Generator.getSize(); j++) {
                    bufferedWriter.write(Integer.toString(arr[i][j].getValue()));
                    bufferedWriter.write(" ");
                }
                bufferedWriter.write("\n");
            }
            for (int i = 0; i < Generator.getSize(); i++) {
                for (int j = 0; j < Generator.getSize(); j++) {
                    bufferedWriter.write(Integer.toString(arr[i][j].getIsConst()));
                    bufferedWriter.write(" ");
                }
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
