package com.spacecombat.obstacle;
import com.spacecombat.entities.SpaceShip;
import java.util.ArrayList;
public abstract class Obstacle {
    private String name;
    public Obstacle(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public abstract void apply(ArrayList<SpaceShip> ships);
}
