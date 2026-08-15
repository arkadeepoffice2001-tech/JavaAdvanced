package ProducerConsumerChallenge;

import java.util.Random;

public class main {

    private static final Random random=new Random();
    public static void main(String[] args) {

        ShoeWarehouse warehouse=new ShoeWarehouse();

        Thread producerThread= new Thread(()-> {
            for(int i=0;i<=10;i++){
                warehouse.recieveOrder(new Order(random.nextInt(1,100),warehouse.product_list.get(random.nextInt(0,3)),5));            }
        });

        producerThread.start();

        for(int j = 0; j <2; j++){
            Thread consumerThread=new Thread(()->{
                for(int k = 0; k <5; k++){
                    Order item=warehouse.fulfillOrder();
                }
            });

            consumerThread.start();
        }

    }
}
