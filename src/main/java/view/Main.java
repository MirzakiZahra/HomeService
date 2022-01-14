package view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************welcome********");
        String firstInput = new String();
           do {
               System.out.println("1.admin\n2.customer\n3.expert\n4.Exit");
               firstInput = scanner.next();
               switch (firstInput){
                   case "1":
                       //todo
                   case "2":
                       //todo
                   case "3":
                       //todo
                   case "4":
                       break;
                   default:
                       System.out.println("Please Enter right Number");
               }
           } while (!"4".equals(firstInput));



    }
}
