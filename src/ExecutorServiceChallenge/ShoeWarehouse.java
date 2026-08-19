package ExecutorServiceChallenge;

import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse {

    public final List<String> product_list= List.of("Sandals","Sports Shoes","Kito");
    private List<Order> shippingItems;


    public ShoeWarehouse() {
        this.shippingItems= new ArrayList<>();
    }

    synchronized Order fulfillOrder(){

        while (shippingItems.isEmpty()){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Order item=shippingItems.remove(0);
        System.out.println("fullfilled "+ item);
        notifyAll();
        return item;
    }

    synchronized void  recieveOrder(Order item){

        while (shippingItems.size()>10){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        shippingItems.add(item);
        System.out.println("Incoming "+ item);
        notifyAll();
    }
}
