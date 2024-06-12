package queue_simulation;

import java.util.*;

public class QueueSimulator {

    public static Queue<Person> serviceQueue = new LinkedList<>();

    public static List<Person> peopleServed = new ArrayList<>();

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

        if (person.getTicket()==1){
            person.setArrivalTime(0);
        }else {
            person.setArrivalTime(generateArrivalTime());
        }

        person.setServiceTime(generateServiceTime());




        peopleServed.add(person);


    }

    public static int generateArrivalTime(){

        int arrivalTime = generator.nextInt(10) + 1; //between 1 and 10 minutes
        System.out.println(arrivalTime);
        return arrivalTime;
    }

    public static int generateServiceTime(){

        int serviceTime = generator.nextInt(15) + 5; //between 5 and 29 minutes
        System.out.println(serviceTime);
        return serviceTime;
    }


}
