package com.spacecombat.rules;
import com.spacecombat.entities.SpaceShip;
import com.spacecombat.entities.Team;
public class EventTriggeredRule extends Rule{
    private static final int BONUS_ENERGY=20;
    private boolean activated = false;

    public EventTriggeredRule(){
        super("Event Triggered Rule");
    }
    @Override
    public void apply() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("RULE ACTIVE: " + getName());
        System.out.println("If a team loses half of its ships,");
        System.out.println("the remaining ships gain extra energy.");
        System.out.println("====================================");
    }
    @Override
    public void applyTeamBonus(Team team){
        if (activated) {
            return;
        }
        System.out.println();
        System.out.println("====================================");
        System.out.println(team.getName()
                + " has lost half of its fleet!");
        System.out.println("Remaining ships receive "
                + BONUS_ENERGY
                + " bonus energy.");
        System.out.println("====================================");

        activated = true;
        for (SpaceShip ship: team.getShips()){
            if (ship.isAlive()){
                ship.recoverEnergy(BONUS_ENERGY);
            }
        }
    }

}
