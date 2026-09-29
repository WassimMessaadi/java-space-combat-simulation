package com.spacecombat.environment;
import com.spacecombat.entities.SpaceShip;
import java.util.ArrayList;
import java.util.Random;
public class Nebula extends EnvironmentalEvent {
    private static final int SPEED_REDUCTION = 20;

    public Nebula() {
        super("Nebula");
    }

    @Override
    public void apply(ArrayList<SpaceShip> ships) {

        System.out.println();
        System.out.println("====================================");
        System.out.println("ENVIRONMENTAL EVENT: " + getName());
        System.out.println("A dense nebula slows down all ships!");
        System.out.println("Each living ship loses a random amount of speed due to the dense nebula.");
        System.out.println("====================================");
        System.out.println();
        Random random = new Random();

        for (SpaceShip ship : ships) {

            if (ship.isAlive()) {


                int reduction = random.nextInt(21) + 10;

                int newSpeed = ship.getBaseSpeed() - reduction;

                if (newSpeed < 0) {
                    newSpeed = 0;
                }

                ship.setSpeed(newSpeed);

                System.out.println(
                        ship.getName()+" speed "
                                + ": "
                                + ship.getBaseSpeed()
                                + " -> "
                                + ship.getSpeed()
                                + " (-"
                                + reduction
                                + ")"
                );
            }

        }

    }
}
