package com.spacecombat.environment;
import com.spacecombat.entities.SpaceShip;
import java.util.ArrayList;

public abstract class EnvironmentalEvent {

    private String name;

    public EnvironmentalEvent(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }


    public abstract void apply (ArrayList<SpaceShip> ships);
}
