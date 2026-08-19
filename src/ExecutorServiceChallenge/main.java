package ExecutorServiceChallenge;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {

    private static final Random random=new Random();
    public static void main(String[] args) {

        ShoeWarehouse warehouse=new ShoeWarehouse();

        ExecutorService threadPool= Executors.newCachedThreadPool();


        threadPool.submit(()-> {
            for(int i=0;i<10;i++){
                warehouse.recieveOrder(new Order(random.nextInt(1,100),warehouse.product_list.get(random.nextInt(0,3)),5));            }
        });

        for(int j = 0; j <2; j++){
            threadPool.submit(()->{
                for(int k = 0; k <5; k++){
                    Order item=warehouse.fulfillOrder();
                }
            });


        }

        threadPool.shutdown();

    }
}
