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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
