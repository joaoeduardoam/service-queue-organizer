import queue_simulation.Person;
import queue_simulation.QueueSimulator;

import java.util.Queue;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        QueueSimulator.addClients();
        QueueSimulator.addClient(new Person("Pedro"));
        QueueSimulator.processService();

        System.out.println("customerArrivalTime: "+QueueSimulator.customerArrivalTime());

        System.out.println("serviceTime: "+QueueSimulator.serviceTime());


    }
}