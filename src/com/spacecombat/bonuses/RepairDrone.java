package com.spacecombat.bonuses;
import com.spacecombat.entities.SpaceShip;

public class RepairDrone extends Bonus {
    private static final int HEALTH_AMOUNT=50;
    public RepairDrone(){
        super("Repair Drone");
    }
    @Override
    public void apply(SpaceShip ship){
        if (!ship.isAlive()){
            return;
        }
        System.out.println();
        System.out.println("====================================");
        System.out.println("BONUS EVENT: " + getName());
        System.out.println("====================================");
        System.out.println();

        System.out.println(ship.getName() + " collected the " + getName() + "!");
        ship.recoverHealth(HEALTH_AMOUNT);
    }


}
