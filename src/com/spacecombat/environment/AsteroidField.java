package com.spacecombat.environment;
import com.spacecombat.entities.SpaceShip;
import java.util.ArrayList;
public class AsteroidField extends EnvironmentalEvent{
    private static final int DAMAGE=30;
    public AsteroidField(){
        super("Asteroid Field");
    }
    @Override
    public void apply(ArrayList<SpaceShip> ships){
        System.out.println();
        System.out.println("====================================");
        System.out.println("ENVIRONMENTAL EVENT: " + getName());
        System.out.println("Every ship is hit by asteroids!");
        System.out.println("Each living ship takes " + DAMAGE + " damage.");
        System.out.println("====================================");
        System.out.println();
        for (SpaceShip ship:ships){
            if (ship.isAlive()) {
                ship.takeDamage(DAMAGE);
                System.out.println(ship.getName() + " was hit by an asteroid!");

                System.out.println("----------------------------------");
                System.out.println(ship.getName() + "'s Status");
                System.out.println("Shield : " + ship.getShield());
                System.out.println("Health : "
                        + ship.getHealth()
                        + "/"
                        + ship.getMaxHealth());
                System.out.println("----------------------------------");

            }
        }
    }
}
