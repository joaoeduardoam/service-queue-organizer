package queue_simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueSimulator {

    public static Queue<Person> serviceQueue = new LinkedList<>();

    static Random generator = new Random();

    public static void addClients(){

        System.out.println(serviceQueue);
        serviceQueue.add(new Person("Joao"));
        serviceQueue.add(new Person("Amanda"));
        serviceQueue.add(new Person("Yan"));
        serviceQueue.add(new Person("Maria"));
        System.out.println(serviceQueue);

    }

    public static void addClient(Person person){
        serviceQueue.add(person);
        System.out.println(serviceQueue);
    }

    public static void processService(){
        Person person = serviceQueue.poll();
        System.out.println(serviceQueue);
    }

    public static int customerArrivalTime(){

        int customerArrivalTime = generator.nextInt(10) + 1; //between 1 and 10 minutes
        System.out.println(customerArrivalTime);
        return customerArrivalTime;
    }

    public static int serviceTime(){

        int serviceTime = generator.nextInt(15) + 5; //between 5 and 29 minutes
        System.out.println(serviceTime);
        return serviceTime;
    }




}
