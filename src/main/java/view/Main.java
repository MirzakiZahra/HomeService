package view;

import model.user.Customer;
import service.CustomerService;
import service.OrderService;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CustomerService customerService = new CustomerService();
    static OrderService orderService = new OrderService();
    public static void main(String[] args) {

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

    public static void customerMenu(Customer customer) {
        String customerSecondInput = new String();
        do {
            System.out.println("1.Change Password\n2.Add Order\n" +
                    "3.Show offers for specific Order\n4.Select Expert" +
                    "\n5.Score Expert\n6.Exit");
            customerSecondInput = scanner.next();
            switch (customerSecondInput){
                case "1":
                    System.out.println("Please Enter old Password");
                    String oldPassword = scanner.next();
                    customerService.checkOldPassword(oldPassword);
                    System.out.println("Please Enter New Password");
                    String newPassword = scanner.next();
                    customerService.changePassword(newPassword,customer.getEmail());
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    break;
                default:
                    System.out.println("Enter Valid Number");
                    break;
            }
        } while (!"6".equals(customerSecondInput));


    }
}

