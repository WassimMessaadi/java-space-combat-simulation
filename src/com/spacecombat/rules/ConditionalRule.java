package com.spacecombat.rules;
import com.spacecombat.entities.SpaceShip;
public class ConditionalRule extends Rule {

    public ConditionalRule(){
        super("Conditional Rule");
    }
    @Override
    public void apply(){
        System.out.println();
        System.out.println("====================================");
        System.out.println("RULE ACTIVE: " + getName());
        System.out.println("Ships with low health deal more damage.");
        System.out.println("====================================");

    }
    @Override
    public int modifyDamage(SpaceShip attacker, int damage) {

        if (attacker.getHealth() < attacker.getMaxHealth() / 2) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("CONDITIONAL RULE ACTIVATED");
            System.out.println(attacker.getName()
                    + " has low health and gains +20 damage!");
            System.out.println("====================================");

            damage += 20;

        }

        return damage;

    }
}
