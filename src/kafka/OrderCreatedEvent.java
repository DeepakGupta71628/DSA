package kafka;

public class OrderCreatedEvent {
    private Long orderId;
    private Long customerId;
    private double amount;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(Long orderId,
                             Long customerId,
                             double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }
}
