package com.spacecombat.entities;
import com.spacecombat.exceptions.DestroyedShipException;
import com.spacecombat.exceptions.InvalidTargetException;
import com.spacecombat.exceptions.NotEnoughEnergyException;
import com.spacecombat.interfaces.SpecialAbility;
import com.spacecombat.weapons.Weapon;
import com.spacecombat.interfaces.Recoverable;
public abstract class SpaceShip implements Recoverable, SpecialAbility {
    private String name;
    private int health;
    private int maxHealth;
    private int shield;
    private int maxShield;
    private int energy;
    private int maxEnergy;
    private int speed;
    private final int baseSpeed;
    private Weapon weapon;
    private boolean destroyed;
    public SpaceShip(String name,int maxHealth , int maxShield , int maxEnergy,int speed,Weapon weapon){
        this.name=name;
        this.maxHealth=maxHealth;
        this.health=maxHealth;
        this.maxShield=maxShield;
        this.shield=maxShield;
        this.maxEnergy=maxEnergy;
        this.energy=maxEnergy;
        this.speed=speed;
        this.baseSpeed=speed;
        this.weapon=weapon;
        this.destroyed=false;
    }
    public String getName() {
        return name;
    }
    public int getHealth(){
    return health;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getSpeed(){
        return speed;
    }
    public int getShield(){
        return shield;
    }
    public int getMaxShield(){
        return maxShield;
    }
    public int getEnergy(){
        return energy;
    }
    public int getMaxEnergy() {
        return maxEnergy;
    }

    public Weapon getWeapon(){
        return weapon;
    }
    public boolean isDestroyed(){
        return destroyed;
    }


    public void setWeapon(Weapon weapon){
        this.weapon=weapon;
    }
    public void consumeEnergy(int amount) {
        energy -= amount;
        if (energy < 0)
            energy = 0;
    }
    public void  restoreEnergy(int amount){
        energy+=amount;
        if (energy>maxEnergy)
            energy=maxEnergy;
    }
    public void  restoreShield(int amount){
        shield+=amount;
        if (shield>maxShield)
            shield=maxShield;
    }
    public void takeDamage(int damage){
        if (shield>=damage){
            shield-=damage;
        }else{
            int remainingDamage=damage-shield;
            shield=0;
            health-=remainingDamage;
            if (health<=0){
                health=0;
                destroyed=true;
                System.out.println();
                System.out.println("====================================");
                System.out.println(getName() + " has been destroyed!");
                System.out.println("====================================");
                System.out.println();
            }
        }
    }
    public void takeDamage(int damage, String source){
        System.out.println(getName() + " received " + damage
                + " damage from " + source + ".");

        takeDamage(damage);
    }
    public boolean isAlive(){
        return !destroyed;
    }
    public void printStatus() {

        System.out.println("==========");

        System.out.println("Ship : " + name);

        System.out.println("Health : " + health + "/" + maxHealth);

        System.out.println("Shield : " + shield + "/" + maxShield);

        System.out.println("Energy : " + energy + "/" + maxEnergy);

        System.out.println("Speed : " + speed);

        System.out.println("Destroyed : " + destroyed);

        System.out.println("==========");
    }

    public abstract void attack(SpaceShip target) throws DestroyedShipException, NotEnoughEnergyException, InvalidTargetException;


    public abstract void chooseAction(SpaceShip target)throws DestroyedShipException,
            NotEnoughEnergyException,
            InvalidTargetException;
    @Override
    public void recoverEnergy(int amount) {

        energy = Math.min(energy + amount, maxEnergy);
        System.out.println(getName()
                + " recovered "
                + amount
                + " energy. ("
                + energy
                + "/"
                + maxEnergy
                + ")");

    }
    public void recoverEnergy(int amount, String source) {

        System.out.println(getName()
                + " recovered "
                + amount
                + " energy from "
                + source + ".");

        recoverEnergy(amount);
    }
    public void setSpeed(int speed){
        this.speed =speed;
    }
    public int getBaseSpeed(){
        return baseSpeed;
    }
    @Override
    public void recoverShield(int amount) {

        shield = Math.min(shield + amount, maxShield);

        System.out.println(getName()
                + " recovered "
                + amount
                + " shield. ("
                + shield
                + "/"
                + maxShield
                + ")");
    }
    @Override
    public void recoverHealth(int amount) {

        health = Math.min(health + amount, maxHealth);

        System.out.println(getName()
                + " recovered "
                + amount
                + " health. ("
                + health
                + "/"
                + maxHealth
                + ")");
    }
    public void setEnergy(int energy) {

        if (energy < 0) {
            this.energy = 0;
        }
        else if (energy > maxEnergy) {
            this.energy = maxEnergy;
        }
        else {
            this.energy = energy;
        }

    }


}
