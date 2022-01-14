package view;

import model.user.Customer;
import service.CustomerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        System.out.println("************welcome********");
        String firstInput = new String();
        do {
            System.out.println("1.admin\n2.customer\n3.expert\n4.Exit");
            firstInput = scanner.next();
            switch (firstInput) {
                case "1":
                    //todo
                case "2":
                    String customerInput = new String();
                    String firstCustomerInput = new String();
                    do {
                        System.out.println("1.Login\n2.SignUp\n3.Exit");
                        firstCustomerInput = scanner.next();
                        switch (firstCustomerInput) {
                            case "1":
                                System.out.println("Please Enter Your Email");
                                String email = scanner.next();
                                Customer customer = customerService.findCustomerByEmail(email);
                                customerMenu(customer);
                        }
                        System.out.println("");
                    } while (!"3".equals(firstCustomerInput));

                case "3":
                    //todo
                case "4":
                    break;
                default:
                    System.out.println("Please Enter right Number");
            }
        } while (!"4".equals(firstInput));
    }
    public static void customerMenu(Customer customer){
        System.out.println("1.Change Password\n2.Add Order\n" +
                "3.Show offers for specific Order\n4.Select Expert" +
                "\n5.Score Expert\n6.Exit");
        
    }
}

