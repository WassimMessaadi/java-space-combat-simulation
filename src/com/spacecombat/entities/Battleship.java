package com.spacecombat.entities;
import com.spacecombat.rules.RuleManage;
import com.spacecombat.weapons.PlasmaCannon;
import com.spacecombat.exceptions.DestroyedShipException;

import com.spacecombat.interfaces.SpecialAbility;
import com.spacecombat.exceptions.InvalidTargetException;
import com.spacecombat.exceptions.NotEnoughEnergyException;
public class Battleship extends SpaceShip implements SpecialAbility {
    private static final int HEAVY_BLAST_MULTIPLIER=3;
    public Battleship(String name){
        super(name,250,120,150,30,new PlasmaCannon());
    }
    @Override
    public void attack(SpaceShip target) throws DestroyedShipException,
            NotEnoughEnergyException,
            InvalidTargetException{
        if (!isAlive()){
            throw new DestroyedShipException(
                    getName() + " is destroyed and cannot attack."
            );
        }
        if (target == null) {

            throw new InvalidTargetException(
                    "The target is invalid."
            );

        }
        if (getEnergy()<getWeapon().getEnergyCost()){
            throw new NotEnoughEnergyException(
                    getName() + " does not have enough energy."
            );
        }
        int damage = RuleManage.modifyDamage(
                this,
                getWeapon().calculateDamage()
        );
        target.takeDamage(damage);
        System.out.println("----------------------------------");
        System.out.println(target.getName() + "'s Status");
        System.out.println("Shield : " + target.getShield());
        System.out.println("Health : "
                + target.getHealth()
                + "/"
                + target.getMaxHealth());
        System.out.println("----------------------------------");

        consumeEnergy(getWeapon().getEnergyCost());

        getWeapon().applySpecialEffects(target);

        System.out.println("----------------------------------");
        System.out.println(getName() + " attacked " + target.getName());
        System.out.println("Weapon: " + getWeapon().getName());
        System.out.println("Damage: " + damage);
        System.out.println("----------------------------------");
    }
    @Override
    public void useSpecialAbility(SpaceShip target)throws DestroyedShipException,
            NotEnoughEnergyException,
            InvalidTargetException{
        if (!isAlive()){
            throw new DestroyedShipException(
                    getName() + " is destroyed and cannot use Heavy Blast."
            );
        }
        if (target == null) {

            throw new InvalidTargetException(
                    "The target is invalid."
            );

        }
        if(getEnergy()<getWeapon().getEnergyCost()){
            throw new NotEnoughEnergyException(
                    getName() + " does not have enough energy to use Heavy Blast."
            );
        }
        System.out.println(getName()+" used Heavy Blast");


        int damage = RuleManage.modifyDamage(
                this,
                getWeapon().calculateDamage()*HEAVY_BLAST_MULTIPLIER
        );

        target.takeDamage(damage);
        System.out.println("----------------------------------");
        System.out.println(target.getName() + "'s Status");
        System.out.println("Shield : " + target.getShield());
        System.out.println("Health : "
                + target.getHealth()
                + "/"
                + target.getMaxHealth());
        System.out.println("----------------------------------");

        consumeEnergy(getWeapon().getEnergyCost());

        getWeapon().applySpecialEffects(target);

        System.out.println(getName()+" "+"dealt"+" "+damage+" "+"damage to"+" "+target.getName()+" . ");
    }
    @Override
    public void chooseAction(SpaceShip target) throws DestroyedShipException,
            NotEnoughEnergyException,
            InvalidTargetException{
        if (!isAlive()){
            System.out.println(getName()
                    + " is destroyed and cannot act.");

            return;
        }
        if (getEnergy()>=100){
            System.out.println(getName()+" "+" decided to use Heavy BLast");
            useSpecialAbility(target);
        }
        else if (getEnergy()>=getWeapon().getEnergyCost()){
            System.out.println(getName()+" "+" decided to perform a normal attack.");
            attack(target);

        }
        else{
            System.out.println(getName()+" "+" skips the turn.");
        }

    }
}
