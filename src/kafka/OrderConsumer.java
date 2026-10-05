//package kafka;
//
//public class OrderConsumer {
//
//    @KafkaListner(topic="orders",groupId="order-processing-froup")
//    public void consume(OrderCreatedEvent event){
//        System.out.println("Order Id:" + event.getCustomerId());
//    }
//}
