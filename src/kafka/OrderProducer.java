//package kafka;
//
//public class OrderProducer {
//    private final KafkaTemplate<String,OrderCreatedEvent> kafkaTemplate;
//    public OrderProducer(
//            KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void publishOrder(OrderCreatedEvent event){
//        String key=String.valueOf(event.getCustomerId());
//        kafkaTemplate.send(
//                "oders",
//                key,
//                event);
//    }
//
//}
