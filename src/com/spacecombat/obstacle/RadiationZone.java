package com.spacecombat.obstacle;
import com.spacecombat.entities.SpaceShip;
import java.util.ArrayList;
public class RadiationZone extends Obstacle {

    private static final int DAMAGE =10;
    private static final int ENERGY_LOSS=10;

    public RadiationZone(){
        super("Radiation Zone");
    }
    @Override
    public void apply(ArrayList<SpaceShip> ships){
        System.out.println();
        System.out.println("====================================");
        System.out.println("OBSTACLE: " + getName());
        System.out.println("A radioactive zone weakens every ship!");
        System.out.println("====================================");

        for (SpaceShip ship: ships){
            System.out.println(ship.getName()
                    + " was exposed to radiation!");

            ship.takeDamage(DAMAGE, getName());

            ship.setEnergy(ship.getEnergy()-ENERGY_LOSS);
        }
    }
}
