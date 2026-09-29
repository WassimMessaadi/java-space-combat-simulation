package com.spacecombat.rules;
import com.spacecombat.entities.SpaceShip;
public class AdaptiveRule extends Rule {
    public AdaptiveRule() {
        super("Adaptive Rule");
    }
    @Override
    public void apply() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("RULE ACTIVE: " + getName());
        System.out.println("Damage increases as the battle progresses.");
        System.out.println("Turns 5-7  : +10 damage");
        System.out.println("Turns 8-10 : +20 damage");
        System.out.println("Turn 11+   : +30 damage");
        System.out.println("====================================");

    }
    @Override
    public int modifyDamage(SpaceShip attacker, int damage) {
        int currentTurn = RuleManage.getCurrentTurn();
        int bonusDamage = 0;
        if (currentTurn >= 11) {
            bonusDamage = 30;
        }
        else if (currentTurn >= 8) {
            bonusDamage = 20;
        }
        else if (currentTurn >= 3) {
            bonusDamage = 10;
        }
        if (bonusDamage > 0) {
            System.out.println();
            System.out.println("====================================");
            System.out.println("ADAPTIVE RULE ACTIVATED");
            System.out.println(attacker.getName()
                    + " is empowered by the Adaptive Rule!");
            System.out.println("Battle Turn: " + currentTurn);
            System.out.println("Damage increased by " + bonusDamage + ".");
            System.out.println("====================================");
        }
        return damage + bonusDamage;
    }
}