package com.spacecombat.controller;

import com.spacecombat.entities.*;
import com.spacecombat.interfaces.Recoverable;
import com.spacecombat.interfaces.SpecialAbility;
import com.spacecombat.simulator.BattleSimulator;

import java.util.Scanner;

public class GameController {

    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========== SPACE COMBAT SIMULATION ==========");
        System.out.println("Choose a battle scenario:");
        System.out.println("1. fighter and Battleship Battle");
        System.out.println("2. Fighter and Cruiser Battle");
        System.out.println("3. Battleship and Cruiser Battle");
        System.out.print("Enter your choice: ");

        Battleship destroyer = new Battleship("Destroyer");
        SpaceShip ship = destroyer;
        SpecialAbility ability = destroyer;
        Recoverable recoverable = destroyer;

        int choice = scanner.nextInt();

        Team alpha = new Team("Alpha");
        Team beta = new Team("Beta");

        switch (choice) {

            case 1:

                alpha.addShip(new Fighter("Falcon"));
                alpha.addShip(new Battleship("Destroyer"));

                beta.addShip(new Fighter("Shadow"));
                beta.addShip(new Battleship("Annihilator"));
                break;

            case 2:

                alpha.addShip(new Fighter("Falcon"));
                alpha.addShip(new Cruiser("Titan"));

                beta.addShip(new Fighter("Shadow"));
                beta.addShip(new Cruiser("Hunter"));
                break;

            case 3:

                alpha.addShip(new Battleship("Destroyer"));
                alpha.addShip(new Cruiser("Titan"));

                beta.addShip(new Battleship("Annihilator"));
                beta.addShip(new Cruiser("Hunter"));
                break;

            default:
                System.out.println("Invalid choice. Standard Battle selected:Fighter,Cruiser and Battleship.");

                alpha.addShip(new Fighter("Falcon"));
                alpha.addShip(new Cruiser("Tian"));
                alpha.addShip(new Battleship("Destroyer"));

                beta.addShip(new Fighter("Shadow"));
                beta.addShip(new Cruiser("Hunter"));
                beta.addShip(new Battleship("Annihilator"));
        }

        BattleSimulator simulator =
                new BattleSimulator(alpha, beta);

        simulator.printTurnOrder();

        simulator.startBattle();
    }
}
