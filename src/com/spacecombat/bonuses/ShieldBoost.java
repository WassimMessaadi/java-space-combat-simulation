package com.spacecombat.bonuses;
import com.spacecombat.entities.SpaceShip;
public class ShieldBoost extends Bonus {
    public static final int SHIELD_AMOUNT=40;

    public ShieldBoost(){
        super("Shield Boost");
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
        ship.recoverShield(SHIELD_AMOUNT);

    }
}
