import queue_simulation.Person;
import queue_simulation.QueueSimulator;

import java.util.Queue;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        QueueSimulator.addClients();
        //QueueSimulator.addClient(new Person("Pedro"));

        while (!QueueSimulator.serviceQueue.isEmpty()){
            QueueSimulator.processService();
        }


        System.out.println(QueueSimulator.peopleServed);

        System.out.println("Average Wait Time: "+QueueSimulator.averageWaitTime());
        System.out.println("Average Time in the System: "+QueueSimulator.averageTimeInTheSystem());
        System.out.println("Server Occupancy Rate: "+QueueSimulator.serverOccupancyRate()+"%");
        System.out.println("Idle Time: "+QueueSimulator.getIdleTime());



//        QueueSimulator.generateArrivalTime();
//        QueueSimulator.generateServiceTime();


    }
}