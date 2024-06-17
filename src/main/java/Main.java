import queue_simulation.QueueSimulator;


public class Main {
    public static void main(String[] args) {

        QueueSimulator.addClients();

        while (!QueueSimulator.getServiceQueue().isEmpty()){
            QueueSimulator.processService();
        }


        System.out.println(QueueSimulator.getPeopleServed());
        System.out.println("Average Wait Time: "+QueueSimulator.averageWaitTime());
        System.out.println("Average Time in the System: "+QueueSimulator.averageTimeInTheSystem());
        System.out.println("Server Occupancy Rate: "+QueueSimulator.serverOccupancyRate()+"%");
        System.out.println("Idle Time: "+QueueSimulator.getIdleTime());



    }
}