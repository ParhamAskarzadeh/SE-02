import PaymentServices.OnSiteOrderService;
import PaymentServices.OnlineOrderService;
import PaymentServices.PhoneOrderService;
import PaymentServices.OrderService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = null;
        String customerName;
        Order order;
        int customerAnswerForOrder = 0;
        int customerAnswerForPaymentMethod = 0;

        System.out.println("Enter Customer Name: ");
        customerName = scanner.nextLine();
        order = new Order(customerName);

        // Step 1: Select Order Items
        while (customerAnswerForOrder != 3) {
            System.out.println("For Ordering Sandwich enter 1.");
            System.out.println("For Ordering Pizza enter 2.");
            System.out.println("For submit your order enter 3");
            customerAnswerForOrder = scanner.nextInt();

            if (customerAnswerForOrder == 1) {
                order.addItem(new Food("sandwich", 1000));
            } else if (customerAnswerForOrder == 2) {
                order.addItem(new Food("pizza", 2000));
            }
        }

        // Step 2: Select Payment Method
        System.out.println("Enter Your Payment Method (1 for online, 2 for on-site, 3 for phone):");
        customerAnswerForPaymentMethod = scanner.nextInt();

        if (customerAnswerForPaymentMethod == 1) {
            orderService = new OnlineOrderService();
        } else if (customerAnswerForPaymentMethod == 2) {
            orderService = new OnSiteOrderService();
        } else if (customerAnswerForPaymentMethod == 3) {
            orderService = new PhoneOrderService(new OrderService() {
                @Override
                public void onSiteOrderRegister(String customerName) {
                    System.out.println("On-site order registered for " + customerName);
                }

                @Override
                public void onlineOrderRegister(String customerName) {
                    System.out.println("Online order registered for " + customerName);
                }

                @Override
                public void onSiteOrderPayment(int foodPrice) {
                    System.out.println("On-site Payment with Price: " + foodPrice + " Tomans!");
                }

                @Override
                public void onlineOrderPayment(int foodPrice) {
                    System.out.println("Online Payment with Price: " + foodPrice + " Tomans!");
                }

                @Override
                public void phoneOrderRegister(String customerName) {
                    System.out.println("Phone order registered for " + customerName);
                }

                @Override
                public void phoneOrderPayment(int totalAmount) {
                    System.out.println("Phone Payment with Total Amount: " + totalAmount + " Tomans!");
                }
            });
        }

        // Step 3: Pay Price
        System.out.println("Pay Price:");
        if (orderService != null) {
            orderService.phoneOrderPayment(order.getTotalPrice());
        }

        // Finally Print Bill
        System.out.println(order);
    }
}