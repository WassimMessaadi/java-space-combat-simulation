package com.spacecombat.weapons;

import com.spacecombat.entities.SpaceShip;

public class Missile extends Weapon{
    public Missile(){
        super("Missile",35,20,120,0.15,"Stun");
    }
    @Override
    public int calculateDamage(){
        return getDamage()+10;
    }
    @Override
    public void applySpecialEffects(SpaceShip target){
        System.out.println(target.getName()+" has been stunned!!");
    }
}
