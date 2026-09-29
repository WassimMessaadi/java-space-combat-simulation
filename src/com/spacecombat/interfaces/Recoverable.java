package com.spacecombat.interfaces;

public interface Recoverable {
        void recoverEnergy(int amount);
        void recoverEnergy(int amount, String source);

        void recoverShield(int amount);

        void recoverHealth(int amount);

}
