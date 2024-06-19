import queue_simulation.QueueSimulator;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        populateQueue();


        while (!QueueSimulator.getServiceQueue().isEmpty()){
            QueueSimulator.processService();
        }


        if (!QueueSimulator.getPeopleServed().isEmpty()){
            System.out.println(QueueSimulator.getPeopleServed());
            System.out.println("Average Wait Time: "+QueueSimulator.averageWaitTime());
            System.out.println("Average Time in the System: "+QueueSimulator.averageTimeInTheSystem());
            System.out.println("Server Occupancy Rate: "+QueueSimulator.serverOccupancyRate()+"%");
            System.out.println("Idle Time: "+QueueSimulator.getIdleTime());
        }else {
            System.out.println("The line is empty!");
        }




    }

    static void populateQueue(){

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;


        try{
            while (keepRunning) {
                System.out.println("\nMenu:");
                System.out.println("1 - Add Persons Automatically");
                System.out.println("2 - Enter Persons Data");
                System.out.println("3 - Quit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Adding persons automatically...");
                        QueueSimulator.addClients();
                        keepRunning = false;
                        break;
                    case 2:
                        System.out.println("Entering persons data...");
                        QueueSimulator.getDataFromUser(scanner);
                        keepRunning = false;
                        break;
                    case 3:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("Invalid option. Please try again.");
            populateQueue();
        }

        scanner.close();

    }

}