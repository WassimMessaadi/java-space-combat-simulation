package com.spacecombat.weapons;
import com.spacecombat.entities.SpaceShip;
public class Laser extends Weapon{
    public Laser() {
        super("Laser",20,10,50,0.30,"Burn");
    }
    @Override

    public int calculateDamage(){
        return getDamage();
    }
    @Override
    public void applySpecialEffects(SpaceShip target){

        System.out.println(target.getName()+" is burning!!");
    }
}
