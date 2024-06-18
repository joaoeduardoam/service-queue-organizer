import org.junit.Test;
import queue_simulation.Person;
import queue_simulation.QueueSimulator;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestQueueSimulator {

    @Test
    public void testWithIdleTimeBiggerThanZero() {

        Person p1 = new Person("Joao", 1, 0, 8);
        Person p2 = new Person("Amanda", 2, 10, 14);
        Person p3 = new Person("Yan", 3, 9, 14);
        Person p4 = new Person("Maria", 4, 3, 7);

        QueueSimulator.addSpecificClients(p1,p2,p3,p4);

        while (!QueueSimulator.getServiceQueue().isEmpty()){
            QueueSimulator.processService();
        }

        System.out.println("PEOPLE SERVED: "+QueueSimulator.getPeopleServed());
        System.out.println("Average Wait Time: "+QueueSimulator.averageWaitTime());
        System.out.println("Average Time in the System: "+QueueSimulator.averageTimeInTheSystem());
        System.out.println("Server Occupancy Rate: "+QueueSimulator.serverOccupancyRate()+"%");
        System.out.println("Idle Time: "+QueueSimulator.getIdleTime());

        float expectedAverageWaitTime = 5.25f;
        float expectedAverageTimeInTheSystem = 16.0f;
        float expectedServerOccupancyRate = 95.56f;
        int expectedIdleTime = 2;

        assertEquals(expectedAverageWaitTime, QueueSimulator.averageWaitTime(), 0.01f);
        assertEquals(expectedAverageTimeInTheSystem, QueueSimulator.averageTimeInTheSystem(), 0.01f);
        assertEquals(expectedServerOccupancyRate, QueueSimulator.serverOccupancyRate().floatValue(),0.01f);
        assertEquals(expectedIdleTime, QueueSimulator.getIdleTime());
    }

    @Test
    public void testWithIdleTimeEqualToZero() {

        Person p1 = new Person("Joao", 1, 0, 19);
        Person p2 = new Person("Amanda", 2, 9, 18);
        Person p3 = new Person("Yan", 3, 5, 9);
        Person p4 = new Person("Maria", 4, 10, 6);

        QueueSimulator.addSpecificClients(p1,p2,p3,p4);

        while (!QueueSimulator.getServiceQueue().isEmpty()){
            QueueSimulator.processService();
        }

        System.out.println("PEOPLE SERVED: "+QueueSimulator.getPeopleServed());
        System.out.println("Average Wait Time: "+QueueSimulator.averageWaitTime());
        System.out.println("Average Time in the System: "+QueueSimulator.averageTimeInTheSystem());
        System.out.println("Server Occupancy Rate: "+QueueSimulator.serverOccupancyRate()+"%");
        System.out.println("Idle Time: "+QueueSimulator.getIdleTime());

        float expectedAverageWaitTime = 13.75f;
        float expectedAverageTimeInTheSystem = 26.75f;
        float expectedServerOccupancyRate = 100;
        int expectedIdleTime = 0;

        assertEquals(expectedAverageWaitTime, QueueSimulator.averageWaitTime(), 0.01f);
        assertEquals(expectedAverageTimeInTheSystem, QueueSimulator.averageTimeInTheSystem(), 0.01f);
        assertEquals(expectedServerOccupancyRate, QueueSimulator.serverOccupancyRate().floatValue(),0.01f);
        assertEquals(expectedIdleTime, QueueSimulator.getIdleTime());
    }


    @Test
    public void testWithIncreasingIdleTime() {

        Person p1 = new Person("Joao", 1, 0, 7);
        Person p2 = new Person("Amanda", 2, 8, 5);
        Person p3 = new Person("Yan", 3, 7, 6);
        Person p4 = new Person("Maria", 4, 10, 7);

        QueueSimulator.addSpecificClients(p1,p2,p3,p4);

        while (!QueueSimulator.getServiceQueue().isEmpty()){
            QueueSimulator.processService();
        }

        System.out.println("PEOPLE SERVED: "+QueueSimulator.getPeopleServed());
        System.out.println("Average Wait Time: "+QueueSimulator.averageWaitTime());
        System.out.println("Average Time in the System: "+QueueSimulator.averageTimeInTheSystem());
        System.out.println("Server Occupancy Rate: "+QueueSimulator.serverOccupancyRate()+"%");
        System.out.println("Idle Time: "+QueueSimulator.getIdleTime());

        float expectedAverageWaitTime = 0;
        float expectedAverageTimeInTheSystem = 6.25f;
        float expectedServerOccupancyRate = 78.13f;
        int expectedIdleTime = 7;

        assertEquals(expectedAverageWaitTime, QueueSimulator.averageWaitTime(), 0.01f);
        assertEquals(expectedAverageTimeInTheSystem, QueueSimulator.averageTimeInTheSystem(), 0.01f);
        assertEquals(expectedServerOccupancyRate, QueueSimulator.serverOccupancyRate().floatValue(),0.01f);
        assertEquals(expectedIdleTime, QueueSimulator.getIdleTime());
    }



}
