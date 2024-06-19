package queue_simulation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class QueueSimulator {

    private static final Queue<Person> serviceQueue = new LinkedList<>();

    private static final List<Person> peopleServed = new ArrayList<>();

    private static int idleTime = 0;

    static Random generator = new Random();

    public static void addClients(){

        serviceQueue.add(new Person("Joao"));
        serviceQueue.add(new Person("Amanda"));
        serviceQueue.add(new Person("Yan"));
        serviceQueue.add(new Person("Maria"));

    }

    public static void addSpecificClients(Person p1, Person p2, Person p3, Person p4){

        serviceQueue.addAll(Arrays.asList(p1,p2,p3,p4));
        System.out.println(serviceQueue);

    }


    public static void processService(){
        Person person = serviceQueue.poll();


        // If is not the first in line, Set the system idle time and the respective waitTime
        if (person.getTicket()>1){

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

        var average = (float) sum / peopleServed.size();

        return average;
    }

    public static float averageTimeInTheSystem(){

        int sum=0;

        for (Person person : peopleServed ){
            sum+=person.getWaitTime()+person.getServiceTime();
        }

        var average = (float) sum / peopleServed.size();

        return average;
    }

    public static BigDecimal serverOccupancyRate(){

        int sum=0;

        for (Person person : peopleServed ){
            sum+=person.getServiceTime();
        }

        var rate = (float) sum / (sum + idleTime);

        BigDecimal rateScaled = BigDecimal.valueOf(rate*100).setScale(2, RoundingMode.CEILING);

        return rateScaled;

    }



    public static void getDataFromUser(Scanner scanner) {

        boolean keepRunning = true;

        try{
            while (keepRunning) {
                System.out.println("\n*****************   Menu Queue Simulator   ****************\n\n\n");
                System.out.println("1 - Add a person inline;");
                System.out.println("2 - Process Service;");
                System.out.println("3 - Show Line;");
                System.out.println("4 - Quit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Adding a person...");
                        addPersonByUser(scanner);
                        break;
                    case 2:
                        System.out.println("Processing service...");
                        keepRunning = false;
                        break;
                    case 3:
                        System.out.println("Showing Line.");
                        System.out.println(QueueSimulator.getServiceQueue());
                        break;
                    case 4:
                        System.out.println("Exiting the application.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }

        }catch (Exception e){
            System.out.println("Invalid option. Please try again.");
            getDataFromUser(new Scanner(System.in));
        }



        scanner.close();

    }

    private static void addPersonByUser(Scanner scanner) {

        boolean validInput = false;

        while (!validInput) {
            System.out.println("\nFill out the person's details:");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Arrival Time (between 1 and 10): ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Service Time (between 5 and 20): ");
            int serviceTime = scanner.nextInt();

            // Validate inputs
            if (!name.isBlank() && (arrivalTime >= 1 && arrivalTime <= 10) && (serviceTime >= 5 && serviceTime <= 20)) {
                System.out.println("Person added successfully!");
                serviceQueue.add(new Person(name,arrivalTime,serviceTime));
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter values between the specified ranges.");
            }
        }


    }


    public static int generateArrivalTime(){

        int arrivalTime = generator.nextInt(10) + 1; //between 1 and 10 minutes
        return arrivalTime;
    }

    public static int generateServiceTime(){

        int serviceTime = generator.nextInt(15) + 5; //between 5 and 20 minutes
        return serviceTime;
    }

    public static Queue<Person> getServiceQueue() {
        return serviceQueue;
    }

    public static List<Person> getPeopleServed() {
        return peopleServed;
    }

    public static int getIdleTime() {
        return idleTime;
    }

}
