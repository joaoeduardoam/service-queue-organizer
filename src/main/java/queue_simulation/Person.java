package queue_simulation;

public class Person {

    private String name;

    private int ticket;

    private int arrivalTime;

    private int serviceTime;

    private int waitTime;


    private static int count = 0;




    public Person(String name) {
        this.name = name;
        this.ticket = count+1;
        if(ticket==1) {
            this.arrivalTime = 0;
        }else{
            this.arrivalTime = QueueSimulator.generateArrivalTime();
        }
        this.serviceTime=QueueSimulator.generateServiceTime();
        count+=1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ticket=" + ticket +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                ", waitTime=" + waitTime +
                '}';
    }


    public int getTicket() {
        return ticket;
    }


    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }


}
