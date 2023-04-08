import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public class CompletableFutureExercises {

    static class Order{
        Integer orderId;
        String rfc;

        String status;
        String paymentId;

        public Order(Integer orderId) {
            this.orderId = orderId;
        }

        public void setRfc(String rfc) {
            this.rfc = rfc;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            final int finalI = i;
            //10 threads by default
            CompletableFuture.supplyAsync(()-> getOrder(finalI), Executors.newFixedThreadPool(20))
                    .thenApply(order -> enrich(order))
                    .thenApply( enrichedOrder -> performPayment(enrichedOrder))
                    .exceptionally(e-> {
                        e.printStackTrace();
                        Order o =new Order(0);
                        o.setStatus("FAILED");
                        return o;
                    })
                    .thenAccept( order -> sendEmail(order));

        }


    }

    static Order getOrder(int orderId){
        System.out.println("getOrder");
        return new Order(orderId);
    }

    static Order enrich(Order order){
        order.setRfc("QUAC880803UY8");
        return order;
    }

    static Order performPayment(Order order){
        if (order.orderId>5){
            throw new IllegalArgumentException("Invalid order ID");
        }
        System.out.println("Payment executed on order " +  order.orderId);
        order.setPaymentId("KAJSIEJSHJA093892");
        return order;
    }

    static Order sendEmail(Order order){

      if(!"FAILED".equals(order.getStatus())) {
            System.out.println("Email sent " + order.orderId +
                    " with payment id " + order.paymentId +
                    " and rfc " + order.rfc);
        }
        return order;
    }

}
