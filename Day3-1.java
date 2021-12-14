package com.company;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public static void main(String[] args) {
        try {
            File myObj = new File("./day03.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            int i4 = 0;

            int[] ones = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            StringBuilder gamma = new StringBuilder();
            StringBuilder epsilon = new StringBuilder();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                while (i < 12) {
                    if (data.charAt(i) == '1') {
                        ones[i] = ones[i] + 1;
                    }
                    i++;
                }
                i = 0;
            }

            while (i4 < 12) {
                if (ones[i4] > 500) {
                    gamma.append('1');
                    epsilon.append('0');
                }
                else {
                    gamma.append('0');
                    epsilon.append('1');
                }
                i4++;
            }

            String gamma2 = gamma.toString();
            String epsilon2 = epsilon.toString();
            int power = Integer.parseInt(gamma2, 2) * Integer.parseInt(epsilon2,2);
            System.out.println(power);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
