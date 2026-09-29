package com.spacecombat.entities;
import com.spacecombat.interfaces.SpecialAbility;
import com.spacecombat.rules.RuleManage;
import com.spacecombat.weapons.Missile;
import com.spacecombat.exceptions.DestroyedShipException;
import com.spacecombat.exceptions.InvalidTargetException;
import com.spacecombat.exceptions.NotEnoughEnergyException;
public class Cruiser extends SpaceShip implements SpecialAbility {
    private static final int SHIELD_RECHARGE = 40;

    public Cruiser(String name) {
        super(name, 160, 80, 120, 60, new Missile());
    }

    @Override
    public void attack(SpaceShip target) throws DestroyedShipException,
            NotEnoughEnergyException,
            InvalidTargetException {
        if (!isAlive()) {
            throw new DestroyedShipException(
                    getName() + " is destroyed and cannot attack."
            );

        }
        if (target == null) {

            throw new InvalidTargetException(
                    "The target is invalid."
            );

        }
        if (getEnergy() < getWeapon().getEnergyCost()) {
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
    public void useSpecialAbility (SpaceShip target) throws
        DestroyedShipException, NotEnoughEnergyException{
        if (!isAlive()) {
            throw new DestroyedShipException(
                    getName() + " is destroyed and cannot use its special ability."
            );
        }
        if (getEnergy() < 20) {
            throw new NotEnoughEnergyException(
                    getName() + " does not have enough energy."
            );

        }
        restoreShield(SHIELD_RECHARGE);
        consumeEnergy(20);

        System.out.println(getName() + "restored" + SHIELD_RECHARGE + "shield points.");
    }
    @Override
    public void chooseAction (SpaceShip target) throws DestroyedShipException,
                NotEnoughEnergyException,
                InvalidTargetException{
        if (!isAlive()) {
            throw new DestroyedShipException(getName()+" is destroyed and cannot act");
        }
        if (getShield() < 30 && getEnergy() >= 20) {
            System.out.println(getName() + " decided to restore its shield.");
            useSpecialAbility(target);
        } else if (getEnergy() >= getWeapon().getEnergyCost()) {
            System.out.println(getName() + " decided to attack");
            attack(target);

        } else {
            System.out.println(getName() + " skips the turn.");
            }

        }
    }
