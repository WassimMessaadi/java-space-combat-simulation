package com.spacecombat.bonuses;

import com.spacecombat.entities.SpaceShip;

public class EnergyCapsule extends Bonus{
    private static final int ENERGY_AMOUNT=30;
    public EnergyCapsule(){
        super("Energy Capsule");

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

        ship.recoverEnergy(ENERGY_AMOUNT, getName());

    }
}
