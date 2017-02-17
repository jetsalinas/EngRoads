import Map.RoadQueue;
import Map.Vehicle;

import java.util.Random;

/**
 * Created by Jose Salinas on 2/17/2017.
 */
public class Simulator {

    //Global triggers
    boolean simulationDone = false;

    //Declaration of simulation values
    boolean isOuterTwoWay = false;
    int maxVehicleCount = 7000;
    int maxROneCount = 10;
    int maxRTwoCount = 10;
    int maxRThreeCount = 10;
    int maxRFourCount = 40;
    int maxRFiveCount = 40;

    @Deprecated
    int lengthROne;
    int lengthRTwo;
    int lengthRThree;
    int lengthRFour;
    int lengthRFive;

    //Declaration of probabilities
    final double probROne = 1;
    final double probRTwo = 1;
    final double probRThree = 1;
    final double probRFour = 1;
    final double probRFive = 1;
    final double probRPickup = 0.64;

    //Global counters
    int totalExitVehicles = 0;
    int delayCounterPickup = 0;
    long totalLoop = 0;

    //Declaration of road stacks
    RoadQueue entrance = new RoadQueue(maxVehicleCount);
    RoadQueue roadOne = new RoadQueue(maxROneCount);     //entrance to pickup point
    RoadQueue roadTwo = new RoadQueue(maxRTwoCount);     //pickup point to exit
    RoadQueue roadThree = new RoadQueue(maxRThreeCount);   //clockwise inner entrance to exit
    RoadQueue roadFour = new RoadQueue(maxRFourCount);    //counter-clockwise outer entrance to exit
    RoadQueue roadFive = new RoadQueue(maxRFiveCount);    //clockwise outer exit to entrance
    RoadQueue finished = new RoadQueue(maxVehicleCount);    //final car count

    public void simulate() {

        for(int i = 0; i < maxVehicleCount; i++) {
            entrance.add(new Vehicle());
            System.out.println(entrance.peek());
        }

        Random random = new Random();
        float randValue = 0;

        while(!simulationDone) {

            totalLoop++;

            //check entrance queue
            if (!entrance.isEmpty() && entrance.element() != null) {
                if(!roadOne.isFull()) {
                    transfer(entrance, roadOne);
                } else if (!roadFour.isFull()) {
                    ((Vehicle)roadOne.peek()).loopVehicle();
                    transfer(entrance, roadFour);
                }
            }

            //check road one queue
            if(!roadOne.isEmpty() && roadOne.peek() != null) {
                if(!(((Vehicle) roadOne.peek()).hasPassenger())) {
                    //if(random.nextDouble() <= probRPickup) {
                        ((Vehicle) roadOne.peek()).setHasPassenger(true);
                    //}
                }
                if(!roadTwo.isFull()) {
                    transfer(roadOne, roadTwo);
                }
            }

            //check road two queue
            if(!roadTwo.isEmpty() && roadTwo.peek() != null) {
                if(((Vehicle)roadTwo.peek()).hasPassenger()) {

                    System.out.println("Exited vehicle: " + roadTwo.peek());

                    transfer(roadTwo, finished);
                    ++totalExitVehicles;
                } else if (!roadThree.isFull()) {
                    ((Vehicle)roadTwo.peek()).loopVehicle();
                    transfer(roadTwo, roadThree);
                } else if (!roadFive.isFull() && isOuterTwoWay) {
                    ((Vehicle)roadTwo.peek()).loopVehicle();
                    transfer(roadTwo, roadFive);
                }
            }

            //check road three queue
            if(!roadThree.isEmpty() && roadThree.peek() != null) {
                if(!(roadOne.isFull())) {
                    transfer(roadThree, roadOne);
                } else if(!(roadFour).isFull()) {
                    ((Vehicle)roadThree.peek()).loopVehicle();
                    transfer(roadThree, roadFour);
                }
            }

            //check road four queue
            if(!roadFour.isEmpty() && roadFour.peek() != null) {
                if(!(roadThree.isFull())) {
                    ((Vehicle)roadFour.peek()).loopVehicle();
                    transfer(roadFour, roadThree);
                }
            }

            //check road five queue
            if(!roadFive.isEmpty() && isOuterTwoWay && roadFive.peek() != null) {
                if(!(roadOne.isFull())) {
                    transfer(roadFive, roadOne);
                }
            }

            //update isSimulationDone
            if(totalExitVehicles == maxVehicleCount) {
                simulationDone = true;
                System.out.println(totalLoop);
            }
        }
    }

    public void transfer(RoadQueue from, RoadQueue to) {
        to.add(from.poll());
    }
}
