//package kafka;
//
//public class ReactiveEmployeeClient {
//    private final WebClient webClient;
//
//    public ReactiveEmployeeClient(
//            WebClient webClient) {
//
//        this.webClient = webClient;
//    }
//    public Mono<EmployeeResponce> getEmployee(Long id){
//        return webClient.get()
//                .url("/api/employee/{id}",id)
//                .retrive()
//                .onStatus(
//                        status->status.value()==404,
//                        responce->Mono.error(
//                                new EmployeeNotFoundException("Employee not found")
//                        )
//                )
//                .bodyToMono(EmployeeResponse.class);
//    }
//}
