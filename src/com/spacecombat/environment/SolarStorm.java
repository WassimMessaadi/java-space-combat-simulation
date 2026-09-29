package com.spacecombat.environment;
import com.spacecombat.entities.SpaceShip;
import java.util.ArrayList;
public class SolarStorm extends EnvironmentalEvent{
    public static final int ENERGY_LOSS=20;
    public SolarStorm(){
        super("Solar Storm");
    }
    @Override
    public void apply (ArrayList<SpaceShip> ships){
        System.out.println();
        System.out.println("====================================");
        System.out.println("ENVIRONMENTAL EVENT: " + getName());
        System.out.println("Every ship loses " + ENERGY_LOSS + " energy!");
        System.out.println("====================================");
        System.out.println();
        for (SpaceShip ship : ships){
            if (ship.isAlive()){
                ship.consumeEnergy(20);

                System.out.println(
                        ship.getName()
                                + " lost "
                                + ENERGY_LOSS
                                + " energy. ("
                                + ship.getEnergy()
                                + "/"
                                + ship.getMaxEnergy()
                                + ")"
                );
            }
        }

    }
}
