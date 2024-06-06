package queue_simulation;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSimulator {

    public static Queue<Person> serviceQueue = new LinkedList<>();

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




}
