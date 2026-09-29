package com.spacecombat.obstacle;
import com.spacecombat.entities.SpaceShip;


import java.util.ArrayList;
import java.util.Random;

public class BlackHole extends Obstacle{
    private static final int DAMAGE=40;
    private static final int ENERGY_LOSS=20;

    public BlackHole(){
        super("Black Hole");
    }
    @Override
    public void apply(ArrayList<SpaceShip> ships){
        ArrayList<SpaceShip> aliveShips= new ArrayList<>();
        for (SpaceShip ship:ships){
            if (ship.isAlive()){
                aliveShips.add(ship);
            }
        }
        if (aliveShips.isEmpty()){
            return;
        }
        Random random =new Random();

        SpaceShip target=aliveShips.get(random.nextInt(aliveShips.size()));

        System.out.println();
        System.out.println("====================================");
        System.out.println("OBSTACLE: " + getName());
        System.out.println(target.getName() + " was pulled into a Black Hole!");
        System.out.println("====================================");

        target.takeDamage(DAMAGE, getName());

        target.setEnergy(target.getEnergy() - ENERGY_LOSS);

        System.out.println(target.getName()
                + " lost "
                + ENERGY_LOSS
                + " energy.");

    }
}
