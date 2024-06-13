package queue_simulation;

import java.util.*;

public class QueueSimulator {

    public static Queue<Person> serviceQueue = new LinkedList<>();

    public static List<Person> peopleServed = new ArrayList<>();

    public static int idleTime = 0;

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

        if (person.getTicket()>1){                      // Check if is the first in line

            int currentArrivalTime = sumOfPreviousArrivalTimes(person.getTicket()) + person.getArrivalTime();

            idleTime += Math.max( 0, currentArrivalTime - sumOfPreviousServiceTimes(person.getTicket()) - idleTime);
            System.out.println("IDLE TIME de "+person.getTicket()+": "+idleTime);

            int waitTime = ( sumOfPreviousServiceTimes(person.getTicket()) + idleTime ) - currentArrivalTime;

            if (waitTime < 0){
                person.setWaitTime(0);
            }else {
                person.setWaitTime(waitTime);
            }

        }else {
            person.setWaitTime(0);
        }


        peopleServed.add(person);

    }

    private static int sumOfPreviousServiceTimes(int ticket) {

        int sum=0;

        for (int i=0; i<ticket-1;i++){
            sum+=peopleServed.get(i).getServiceTime();
        }

        return sum;

    }

    private static int sumOfPreviousArrivalTimes(int ticket) {

        int sum=0;

        for (int i=0; i<ticket-1;i++){
            sum+=peopleServed.get(i).getArrivalTime();
        }

        return sum;

    }

    public static float averageWaitTime(){

        int sum=0;

        for (Person person : peopleServed ){
            sum+=person.getWaitTime();
        }

        var average = sum / peopleServed.size();

        return average;
    }

    public static int generateArrivalTime(){

        int arrivalTime = generator.nextInt(10) + 1; //between 1 and 10 minutes
        return arrivalTime;
    }

    public static int generateServiceTime(){

        int serviceTime = generator.nextInt(5) + 5; //between 5 and 20 minutes
        return serviceTime;
    }


}
