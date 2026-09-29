package com.spacecombat.weapons;

import com.spacecombat.entities.SpaceShip;

public abstract class Weapon {
    private String name;
    private int damage;
    private int energyCost;
    private int range;
    private double criticalChance;
    private String specialEffect;
    public Weapon(String name ,int damage,int energyCost,int range,double criticalChance,String specialEffect){
        this.name=name;
        this.damage=damage;
        this.energyCost=energyCost;
        this.range=range;
        this.criticalChance=criticalChance;
        this.specialEffect=specialEffect;
    }
    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public int getEnergyCost(){
        return energyCost;
    }
    public int getRange(){
        return range;
    }
    public double getCriticalChance(){
        return criticalChance;

    }
    public String getSpecialEffect(){
        return specialEffect;
    }

    public void printWeapon(){
        System.out.println("Weapon : " + name);
        System.out.println("Damage : " + damage);

        System.out.println("Energy Cost : " + energyCost);

        System.out.println("Range : " + range);

        System.out.println("Critical Chance : " + criticalChance);

        System.out.println("Special Effect : " + specialEffect);

    }
    public abstract int calculateDamage();

    public abstract void applySpecialEffects(SpaceShip target);




}