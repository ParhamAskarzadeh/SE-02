package PaymentServices;

public class PhoneOrderService implements OrderService {
    private final OrderService orderService;

    public PhoneOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

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
        orderService.onSiteOrderRegister(customerName);
    }

    @Override
    public void phoneOrderPayment(int totalAmount) {
        orderService.onSiteOrderPayment(totalAmount);
    }
}