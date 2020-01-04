package Zadanie2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shape {
    static Scanner sc = new Scanner(System.in);
    static String info = "";

        static void withThreeVariables(int a, int b, int c) {

            if (a + b > c && a + c > b && b + c > a) {
                if (a == b && b == c) {
                    info = "Trojkąt równoboczny";
                } else if ((a != b) && (b != c) && (a != c)) {
                    info = "Trójkąt różnoramienny";
                } else if ((a == b && a != c) || (a == c && b != c) || (b == c && a != c)) {
                    info = "równoramienny";
                }
            } else {
                info = "nierozpoznano";
            }
            System.out.println(info);
        }

        static void withFourVariables(int a, int b, int c, int d) {
            if (a + b + d > c && a + c + d > b && b + c + d > a && a + b + c > d) {
                if (a == b && c == d && a == c) {
                    info = "kwadrat";
                } else if ((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {
                    info = "prostokąt";
                } else info = "czworobok";

            } else {
                info = "nierozpoznano";
            }
            System.out.println(info);
        }

        static String printFunction() {
            int choice, a1,a2, b1, b2, c1, c2, d2;

            try {
                System.out.print(" 3 - trójkąty \n 4 - wielobok\n Ile boków sprawdzamy? : ");

                choice = sc.nextInt();
                if(choice!=3 && choice!=4){
                    System.out.println("Proszę wybrać między wartością 3 lub 4.");
                    //sc.close();
                    printFunction();
                }else
                    switch (choice) {
                        case 3:
                            System.out.print("Podaj bok: a= ");
                            a1 = sc.nextInt();
                            System.out.print("Podaj bok: b= ");
                            b1 = sc.nextInt();
                            System.out.print("Podaj bok: c= ");
                            c1 = sc.nextInt();
                            //sc.close();
                            withThreeVariables(a1,b1,c1);
                            break;
                        case 4:
                            System.out.print("Podaj bok: a= ");
                            a2 = sc.nextInt();
                            System.out.print("Podaj bok: b= ");
                            b2 = sc.nextInt();
                            System.out.print("Podaj bok: c= ");
                            c2 = sc.nextInt();
                            System.out.print("Podaj bok: d= ");
                            d2 = sc.nextInt();
                            //sc.close();
                            withFourVariables(a2, b2, c2, d2);
                            break;
                    }
            } catch (InputMismatchException e){
                System.out.println("Źle wprowadzona wartość. Jeszcze raz!!!");
                printFunction();
            }return info;
        }

    public static void main(String[] args) {
        printFunction();
    }
}
