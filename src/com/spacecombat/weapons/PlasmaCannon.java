package com.spacecombat.weapons;

import com.spacecombat.entities.SpaceShip;
public class PlasmaCannon extends Weapon {
    public PlasmaCannon(){
        super("Plasma Cannon",50,35,30,0.10,"Shield Break");
    }
    @Override
    public int calculateDamage(){
        return getDamage()*2;
    }
    @Override
    public void applySpecialEffects(SpaceShip target){
        System.out.println(target.getName()
                + "'s shield has been weakened!");
    }


}
