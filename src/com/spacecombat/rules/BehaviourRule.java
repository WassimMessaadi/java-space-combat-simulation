package com.spacecombat.rules;
import com.spacecombat.entities.SpaceShip;
import com.spacecombat.entities.Team;
public class BehaviourRule extends Rule {

    public BehaviourRule(){
        super("Behaviour Rule");
    }
    @Override
    public void apply(){
        System.out.println();
        System.out.println("====================================");
        System.out.println("RULE ACTIVE: " + getName());
        System.out.println("Ships will prioritize the weakest enemy.");
        System.out.println("====================================");
    }
    @Override
    public SpaceShip chooseTarget(Team enemyTeam){
        SpaceShip weakest =null;
        for (SpaceShip ship : enemyTeam.getShips()){
            if(!ship.isAlive()){
                continue;
            }
            if (weakest == null || ship.getHealth() < weakest.getHealth()){
                weakest=ship;
            }
        }
        if (weakest != null) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("BEHAVIOURAL RULE ACTIVATED");
            System.out.println("Target selected: " + weakest.getName());
            System.out.println("Reason: Lowest Health");
            System.out.println("====================================");

        }

        return weakest;
    }
}
