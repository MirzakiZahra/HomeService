package view;

import dto.AddressDto;
import dto.OrderDto;
import dto.SubServiceDto;
import model.Address;
import model.user.Customer;
import model.user.Expert;
import service.CustomerService;
import service.ExpertService;
import service.OrderService;
import service.SubServiceService;
import util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CustomerService customerService = new CustomerService();
    static OrderService orderService = new OrderService();
    static SubServiceService subServiceService = new SubServiceService();
    static ExpertService expertService = new ExpertService();
    static Validator validator = new Validator();

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
                    String firstCustomerInput = new String();
                    do {
                        System.out.println("1.Login\n2.SignUp\n3.Exit");
                        firstCustomerInput = scanner.next();
                        switch (firstCustomerInput) {
                            case "1":
                                System.out.println("Please Enter Your Email");
                                String email = scanner.next();
                                if (validator.checkEmail(email) == true) {
                                    Customer customer = customerService.findCustomerByEmail(email);
                                    customerMenu(customer);
                                }
                                break;
                            case "2":
                                System.out.println("Please Enter your Email");
                                email = scanner.next();
                                if (validator.checkEmailPatternAndExistence(email) == true){
                                    System.out.println("Please Enter Password");
                                    String password = scanner.next();
                                    if (validator.checkPassword(password) == true){

                                    }
                                }
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

    public static void customerSignUp(String email, String password){
        System.out.println("Please Enter  country, " +
                "city, street, plaque, FirstName, Lastname, username,");
        AddressDto addressDto = AddressDto.builder()
                .country(scanner.next())
                .city(scanner.next())
                .street(scanner.next())
                .plaque(scanner.next())
                .build();
        addresses.add(address);
        Customer customer = new Customer(scanner.next(),scanner.next(),
                email,password,addresses);
    }
    public static void customerMenu(Customer customer) {
        String customerSecondInput = new String();
        do {
            System.out.println("1.Change Password\n2.Add Order\n" +
                    "3.Show offers for specific Order\n4.Select Expert" +
                    "\n5.Score Expert\n6.Exit");
            customerSecondInput = scanner.next();
            switch (customerSecondInput) {
                case "1":
                    System.out.println("Please Enter old Password");
                    String oldPassword = scanner.next();
                    customerService.checkOldPassword(oldPassword);
                    System.out.println("Please Enter New Password");
                    String newPassword = scanner.next();
                    customerService.changePassword(newPassword, customer.getEmail());
                    break;
                case "2":
                    List<SubServiceDto> subServiceDtoList = subServiceService.showAllSubService();
                    subServiceDtoList.stream().forEach(i -> System.out.println(i));
                    System.out.println("Choose one of SubService from List");
                    System.out.println("Enter SubService Id:");
                    int subServiceId = scanner.nextInt();
                    subServiceService.checkExistOfSubServiceById(subServiceId);
                    System.out.println("Please Enter Cost, Explanation, beggingDate," +
                            " EndingDate,address");
                    float cost = scanner.nextFloat();
                    String explanation = scanner.next();
                    String beggingDate = scanner.next();
                    String endingDate = scanner.next();
                    String address = scanner.next();
                    orderService.createOrder(cost, explanation,
                            convertStringToDate(beggingDate), convertStringToDate(endingDate),
                            address, customer.getEmail(), subServiceId);
                    System.out.println("Order Successfully Added");
                    break;
                case "3":
                    System.out.println("Please Enter OrderId");
                    int orderId = scanner.nextInt();
                    OrderDto orderDto = orderService.findOrderById(orderId);
                    orderDto.getOfferList().stream().forEach(i -> System.out.println(i));
                    break;
                case "4":
                    System.out.println("Please Enter Offer ID");
                    int offerId = scanner.nextInt();
                    orderService.setOfferForSpecificOrder(offerId);
                    break;
                case "5":
                    List<OrderDto> orderDtoList = orderService.
                            customerDoneOrder(customer.getId());
                    orderDtoList.stream().forEach(i -> System.out.println(i));
                    System.out.println("Please Enter order ID and Score");
                    orderId = scanner.nextInt();
                    float score = scanner.nextFloat();
                    expertService.updateExpertScore(score, orderId);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Enter Valid Number");
                    break;
            }
        } while (!"6".equals(customerSecondInput));


    }

    public static Date convertStringToDate(String date) {
        Date date1 = new Date();
        SimpleDateFormat formatter =
                new SimpleDateFormat("dd/MM/yyyy,HH:mm");
        try {
            date1 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    public static void expertMenu(Expert expert) {
        String expertInput = scanner.next();
        do {
            System.out.println("1.Change Password\n2.See Order\n" +
                    "3.Make Offer\n4.Exit");
            expertInput = scanner.next();
            switch (expertInput) {
                case "1":
                    break;
                case "2":

                    break;
                case "3":
                    break;
                case "4":
                    break;
            }
        } while (!"4".equals(expertInput));
    }
}

