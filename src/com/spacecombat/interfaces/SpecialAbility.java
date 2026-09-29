package com.spacecombat.interfaces;
import com.spacecombat.entities.SpaceShip;
import com.spacecombat.exceptions.DestroyedShipException;
import com.spacecombat.exceptions.InvalidTargetException;
import com.spacecombat.exceptions.NotEnoughEnergyException;
public interface SpecialAbility {
    void useSpecialAbility(SpaceShip target) throws NotEnoughEnergyException,
            DestroyedShipException,InvalidTargetException;
}
