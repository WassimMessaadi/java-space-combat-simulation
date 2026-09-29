package com.spacecombat.bonuses;
import com.spacecombat.entities.SpaceShip;
public abstract class Bonus {
    private String name;
    public Bonus( String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public abstract void apply(SpaceShip ship);
}
