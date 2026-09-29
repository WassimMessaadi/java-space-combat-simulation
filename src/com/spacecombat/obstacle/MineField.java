package com.spacecombat.obstacle;
import com.spacecombat.entities.SpaceShip;
import java.util.ArrayList;
public class MineField extends Obstacle{
    private static final int DAMAGE=20;
    public MineField(){
        super("Mine Field");
    }
    @Override
    public void apply(ArrayList<SpaceShip> ships){
        System.out.println();
        System.out.println("====================================");
        System.out.println("OBSTACLE: " + getName());
        System.out.println("Ships crossed a dangerous mine field!");
        System.out.println("====================================");

        for (SpaceShip ship:ships){
            if (ship.isAlive()){
                System.out.println(ship.getName()+" hit a mine!");
                ship.takeDamage(DAMAGE, getName());
            }
        }
    }
}
