package com.spacecombat.entities;
import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<SpaceShip> ships;
    public Team(String name){
        this.name=name;
        ships=new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public ArrayList<SpaceShip> getShips(){
        return ships;
    }

    public void addShip(SpaceShip ship){
        ships.add(ship);
    }
    public void removeShip(SpaceShip ship){
        ships.remove(ship);
    }

    public boolean hasAliveShips(){
        for(SpaceShip ship:ships){
            if (ship.isAlive()){
                return true;
            }
        }
        return false;
    }
    public void printTeam(){
        System.out.println("==========");

        System.out.println("Team : " + name);

        System.out.println();

        for (SpaceShip ship:ships){
            ship.printStatus();

            System.out.println();
        }
    }
    public ArrayList<SpaceShip> getAliveShips(){
        ArrayList<SpaceShip> aliveShips= new ArrayList<>();
        for (SpaceShip ship: ships){
            if (ship.isAlive()){
                aliveShips.add(ship);

            }
        }
        return aliveShips;
    }
    public SpaceShip getFirstAliveShip() {

        for (SpaceShip ship : ships) {

            if (ship.isAlive()) {

                return ship;

            }

        }

        return null;

    }

}
