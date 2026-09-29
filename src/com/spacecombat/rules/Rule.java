package com.spacecombat.rules;
import com.spacecombat.entities.SpaceShip;
import com.spacecombat.entities.Team;


public abstract class Rule {
    private String name;

    public Rule(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public abstract void apply();

    public int modifyDamage(SpaceShip attacker, int damage) {
        return damage;
    }
    public SpaceShip chooseTarget(Team enemyTeam) {
        return null;
    }

    public void applyTeamBonus(Team team) {
    }
}
