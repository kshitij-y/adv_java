package org.example.OrderAnalytics;


class Order {
    private int orderId;
    private String customerName;
    private String category;
    private int amount;
    private String city;
    private String status;

    public Order ( int orderId,
                   String customerName,
                   String category,
                   int amount,
                   String city,
                   String status)
    {
        this.orderId = orderId;
        this.customerName = customerName;
        this.category = category;
        this.amount = amount;
        this.city = city;
        this.status = status;
    }

    public int getOrderId() {return orderId;}
    public String getCategory() { return category;}
    public String getCustomerName() { return customerName;}
    public int getAmount() {return amount;}
    public String getCity() {return city;}
    public String getStatus() {return status;}
    public boolean isPaid(){return status.equalsIgnoreCase("PAID"); }

    @Override
    public String toString() {
        return "OrderAnalytics{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}