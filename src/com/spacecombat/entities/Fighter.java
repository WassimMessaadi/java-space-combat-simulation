package com.spacecombat.entities;
import com.spacecombat.interfaces.SpecialAbility;
import com.spacecombat.weapons.Laser;
import com.spacecombat.exceptions.DestroyedShipException;
import com.spacecombat.exceptions.InvalidTargetException;
import com.spacecombat.exceptions.NotEnoughEnergyException;
import com.spacecombat.rules.RuleManage;
public class Fighter extends SpaceShip  {
    private static final int RAPID_FIRE_MULTIPLIER = 2;
    public Fighter(String name) {
        super(name, 100, 40, 100, 90, new Laser());
    }
    @Override
    public void attack(SpaceShip target) throws DestroyedShipException,NotEnoughEnergyException,InvalidTargetException{
        if (!isAlive()){
            throw new DestroyedShipException(getName()+" is destroyed and cannot act");
        }
        if (target == null) {

            throw new InvalidTargetException(
                    "The target is invalid."
            );

        }
        if (getEnergy()<getWeapon().getEnergyCost()){
            throw new NotEnoughEnergyException(getName()+" does not have enough energy");

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
    //special ability :Rapid fire
    @Override
    public void useSpecialAbility(SpaceShip target) throws DestroyedShipException,NotEnoughEnergyException,InvalidTargetException{
        if (!isAlive()){
            throw new DestroyedShipException(
                    getName() + " is destroyed and cannot use its special ability."
            );
        }
        if (target == null) {

            throw new InvalidTargetException(
                    "The target is invalid."
            );

        }
        if (getEnergy()<getWeapon().getEnergyCost()){
            throw new NotEnoughEnergyException(
                    getName() + " does not have enough energy to use Rapid Fire."
            );
        }
        System.out.println(getName()+" use Rapid Fire");
        int damage = RuleManage.modifyDamage(
                this,
                getWeapon().calculateDamage() * RAPID_FIRE_MULTIPLIER
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

        System.out.println(getName() + " dealt " +" "+ damage +" "+ " damage to "
                + target.getName() + ".");


    }
    @Override
    public void chooseAction(SpaceShip target) throws DestroyedShipException,
            NotEnoughEnergyException,
            InvalidTargetException {
        if (!isAlive()){
            throw new DestroyedShipException(getName()+" is destroyed and cannot act");
        }
        if (getEnergy()>=60){
            System.out.println(getName()+" decided to use Rapid Fire (special ability).");
            useSpecialAbility(target);
        }
        else if (getEnergy() >= getWeapon().getEnergyCost()) {

            System.out.println(getName() + " decided to perform a normal attack.");
            attack(target);

        }

        else {

            System.out.println(getName() + "  does not have enough energy and skips the turn.");

        }


    }
}
