package com.szachnowicz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj numer struktury ktora chesz przetestować");
            int strucNO = scanner.nextInt();
            System.out.println("1 : Tablica");
            if (strucNO == 1) {
                int mId = scanner.nextInt();
                System.out.println("1. dododawanie poczate");

            }
            System.out.println("2: List");
            if (strucNO == 2) {

            }
            System.out.println("3: Kopiec");
            if (strucNO == 3) {


            }

            System.out.println("4: Drzewo");
            if (strucNO == 3) {


            }

        }
    }
}
