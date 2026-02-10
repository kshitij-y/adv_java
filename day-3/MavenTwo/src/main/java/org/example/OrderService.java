package org.example;


public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public String placeOrder(double amount){
        System.out.println("[OrderService] Placing order....");

        if(validateAndPlaceOrder(amount)){
            return "ORDER PLACED";
        }
        return "PAYMENT FAILED";
    }

    public boolean validateAndPlaceOrder(double amount) {
        if(amount < 0) {
            return false;
        }
        return paymentService.processPayment(amount);
    }

}
