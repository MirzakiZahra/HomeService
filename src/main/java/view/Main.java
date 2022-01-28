package view;

import data.repository.OfferRepository;
import data.repository.OrderRepository;
import data.repository.ServiceRepository;
import data.repository.SubServiceRepository;
import data.dto.*;
import exception.InputException;
import data.model.enums.OrderStatus;
import data.model.user.Customer;
import service.*;
import util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    static AddressService addressService = new AddressService();
    static OfferService offerService = new OfferService();
    static OfferRepository offerRepository = new OfferRepository();
    static OrderRepository orderRepository = new OrderRepository();
    static ServiceRepository serviceRepository = new ServiceRepository();
    static MainServiceService mainServiceService = new MainServiceService();
    static SubServiceRepository subServiceRepository = new SubServiceRepository();
    static SubServiceDto subServiceDto = new SubServiceDto();
    static AdminService adminService = new AdminService();


    public static void main(String[] args) {

        System.out.println("************welcome********");
        String firstInput = new String();
        do {
            System.out.println("1.admin\n2.customer\n3.expert\n4.Exit");
            firstInput = scanner.next();
            switch (firstInput) {
                case "1":
                    String firstAdminInput = new String();
                    do {
                        System.out.println("1.Login\n2.SignUp\n3.Exit");
                        firstAdminInput = scanner.next();
                        switch (firstAdminInput) {
                            case "1":
                                System.out.println("Please Enter Your Email");
                                String email = scanner.next();
                                if (validator.checkEmail(email) == true) {
                                    AdminDto adminDto = adminService.findManagerByEmail(email);
                                    adminMenu(adminDto);
                                }
                                break;
                            case "2":
                                System.out.println("Please Enter your Email");
                                email = scanner.next();
                                if (validator.checkEmailPatternAndExistence(email) == true) {
                                    System.out.println("Please Enter Password");
                                    String password = scanner.next();
                                    if (validator.checkPassword(password) == true) {
                                        adminSignUp(email, password);
                                    }
                                }
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("Please Enter Valid Number");
                                break;
                        }
                    } while (!"3".equals(firstAdminInput));
                    break;
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
                                if (validator.checkEmailPatternAndExistence(email) == true) {
                                    System.out.println("Please Enter Password");
                                    String password = scanner.next();
                                    if (validator.checkPassword(password) == true) {
                                        customerSignUp(email, password);
                                    }
                                }
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("Please Enter Valid Number");
                                break;
                        }
                        System.out.println("");
                    } while (!"3".equals(firstCustomerInput));
                    break;
                case "3":
                    String firstExpertInput = new String();
                    do {
                        System.out.println("1.Login\n2.SignUp\n3.Exit");
                        firstExpertInput = scanner.next();
                        switch (firstExpertInput) {
                            case "1":
                                System.out.println("Please Enter Your Email");
                                String email = scanner.next();
                                if (validator.checkEmail(email) == true) {
                                    ExpertDto expertDto = expertService.findExpertByEmail(email);
                                    expertMenu(expertDto);
                                }
                                break;
                            case "2":
                                System.out.println("Please Enter your Email");
                                email = scanner.next();
                                if (validator.checkEmailPatternAndExistence(email) == true) {
                                    System.out.println("Please Enter Password");
                                    String password = scanner.next();
                                    if (validator.checkPassword(password) == true) {
                                        expertSignUp(email, password);
                                    }
                                }
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("Please Enter Valid Number");
                                break;
                        }
                        System.out.println("");
                    } while (!"3".equals(firstExpertInput));
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Please Enter right Number");
            }
        } while (!"4".equals(firstInput));
    }

    public static void customerSignUp(String email, String password) {
        System.out.println("Please Enter  country, " +
                "city, street, plaque, FirstName, Lastname");
        AddressDto addressDto = AddressDto.builder()
                .country(scanner.next())
                .city(scanner.next())
                .street(scanner.next())
                .plaque(scanner.next())
                .build();
        customerService.createCustomer(scanner.next(), scanner.next(), addressDto, email,
                password);
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

    public static void expertMenu(ExpertDto expertDto) {
        String expertInput = scanner.next();
        do {
            System.out.println("1.Change Password\n2.See Order\n" +
                    "3.Make Offer\n4.Start Doing\n5.Finish Doing\n6.Exit");
            expertInput = scanner.next();
            switch (expertInput) {
                case "1":
                    System.out.println("Please Enter old Password");
                    String oldPassword = scanner.next();
                    expertService.checkOldExpertPassword(oldPassword);
                    System.out.println("Please Enter New Password");
                    String newPassword = scanner.next();
                    expertService.changePassword(newPassword, expertDto.getEmail());
                    break;
                case "2":
                    expertService.expertRelatedOrders().stream().forEach(i ->
                            System.out.println(i));
                    break;
                case "3":
                    System.out.println("Please enter Order Id");
                    int orderId = scanner.nextInt();
                    System.out.println("Please enter  price, basePrice,\n" +
                            "                             creationDate,startDate");
                    String creationDate = scanner.next();
                    String startDate = scanner.next();
                    offerService.createOffer
                            (scanner.nextFloat(), orderId, scanner.nextFloat(),
                                    convertStringToDate(creationDate),
                                    convertStringToDate(startDate), expertDto.getEmail());
                    break;
                case "4":
                    System.out.println("Please enter Order Id");
                    orderId = scanner.nextInt();
                    orderService.changeOrderStatus(OrderStatus.STARTED, orderId);
                    break;
                case "5":
                    System.out.println("Please enter Order Id");
                    orderId = scanner.nextInt();
                    orderService.changeOrderStatus(OrderStatus.DONE, orderId);
                    orderService.transferMoney(orderId, expertDto.getEmail());
                    break;
                case "6":
                    break;
            }
        } while (!"6".equals(expertInput));
    }

    public static void adminMenu(AdminDto managerDto) {
        String managerInput = new String();
        do {
            System.out.println("1.Add MainService\n2.Add SubService\n3.Delete MainService" +
                    "\n4.Delete SubService\n5.Exit");
            managerInput = scanner.next();
            switch (managerInput) {
                case "1":
                    System.out.println("Please enter name Of MainService");
                    String mainServiceName = scanner.next();
                    if (mainServiceService.checkExistOfMainService(mainServiceName) == true) {
                        throw new InputException("MainService Exist");
                    } else {
                        mainServiceService.createMainService(mainServiceName);
                    }
                    break;
                case "2":
                    System.out.println("Please enter name Of MainService");
                    mainServiceName = scanner.next();
                    if (mainServiceService.checkExistOfMainService(mainServiceName) == true) {
                        System.out.println("Please Enter SubServiceName & Description&price");
                        subServiceService.createSubService(scanner.next()
                                , scanner.next(), scanner.nextFloat(), mainServiceName);
                    } else {
                        mainServiceService.createMainService(mainServiceName);
                        System.out.println("Please Enter SubServiceName & Description&price");
                        subServiceService.createSubService(scanner.next()
                                , scanner.next(), scanner.nextFloat(), mainServiceName);
                    }
                    break;
                case "3":
                    System.out.println("Please Enter MainServiceName");
                    mainServiceService.deleteMainService(scanner.next());
                    break;
                case "4":
                    System.out.println("Please enter name Of SubService");
                    subServiceService.deleteSubServiceByName(scanner.next());
                    break;
                case "5":
                    break;
                default:
                    break;

            }
        } while (!"5".equals(managerInput));
    }

    public static void adminSignUp(String email, String password) {
        System.out.println("Please Enter FirstName, Lastname,username");
        adminService.createAdmin(scanner.next(), scanner.next(), email
                , password, scanner.next());
    }

    public static void expertSignUp(String email, String password) {
        System.out.println("Please Enter FirstName, Lastname");

        expertService.createExpert(scanner.next(), scanner.next(), email);
    }
}

