import queue_simulation.Person;
import queue_simulation.QueueSimulator;

import java.util.Queue;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        QueueSimulator.addClients();
        QueueSimulator.addClient(new Person("Pedro"));
        QueueSimulator.processService();

        while (!QueueSimulator.serviceQueue.isEmpty()){
            QueueSimulator.processService();
        }


        System.out.println(QueueSimulator.peopleServed);



//        QueueSimulator.generateArrivalTime();
//        QueueSimulator.generateServiceTime();


    }
}