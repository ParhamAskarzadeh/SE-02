package PaymentServices;

public interface OrderService {
    void onSiteOrderRegister(String customerName);
    void onlineOrderRegister(String customerName);
    void onSiteOrderPayment(int foodPrice);
    void onlineOrderPayment(int foodPrice);
    void phoneOrderRegister(String customerName);
    void phoneOrderPayment(int totalAmount);
}