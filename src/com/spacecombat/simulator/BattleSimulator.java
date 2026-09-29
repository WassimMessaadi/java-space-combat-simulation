package com.spacecombat.simulator;
import com.spacecombat.entities.SpaceShip;
import com.spacecombat.entities.Team;
import java.util.ArrayList;
import com.spacecombat.environment.AsteroidField;
import com.spacecombat.environment.EnvironmentalEvent;
import com.spacecombat.environment.Nebula;
import com.spacecombat.exceptions.DestroyedShipException;
import com.spacecombat.exceptions.InvalidTargetException;
import com.spacecombat.exceptions.NotEnoughEnergyException;
import com.spacecombat.environment.SolarStorm;
import com.spacecombat.bonuses.Bonus;
import com.spacecombat.bonuses.EnergyCapsule;
import com.spacecombat.bonuses.ShieldBoost;
import com.spacecombat.bonuses.RepairDrone;
import com.spacecombat.obstacle.BlackHole;
import com.spacecombat.obstacle.MineField;
import com.spacecombat.obstacle.Obstacle;
import com.spacecombat.obstacle.RadiationZone;
import com.spacecombat.rules.RuleManage;
import com.spacecombat.rules.ConditionalRule;
import com.spacecombat.rules.BehaviourRule;
import com.spacecombat.rules.AdaptiveRule;
import com.spacecombat.rules.EventTriggeredRule;
import java.util.Random;

public class BattleSimulator {

    private Team team1;
    private Team team2;
    private int turn;
    private EnvironmentalEvent currentEvent;
    private Random random = new Random();
    private Bonus currentBonus;
    private Obstacle currentObstacle;

    public BattleSimulator(Team team1, Team team2) {

        this.team1 = team1;
        this.team2 = team2;
        this.turn = 1;
        currentEvent = new Nebula();
        RuleManage.addRule(new ConditionalRule());
        RuleManage.addRule(new BehaviourRule());
        RuleManage.addRule(new AdaptiveRule());
        RuleManage.addRule(new EventTriggeredRule());

    }

    private ArrayList<SpaceShip> createTurnOrder() {

        ArrayList<SpaceShip> turnOrder = new ArrayList<>();

        turnOrder.addAll(team1.getAliveShips());
        turnOrder.addAll(team2.getAliveShips());



        for (int i = 0; i < turnOrder.size() - 1; i++) {

            for (int j = 0; j < turnOrder.size() - i - 1; j++) {

                if (turnOrder.get(j).getSpeed() < turnOrder.get(j + 1).getSpeed()) {

                    SpaceShip temp = turnOrder.get(j);

                    turnOrder.set(j, turnOrder.get(j + 1));

                    turnOrder.set(j + 1, temp);

                }

            }

        }

        return turnOrder;

    }

    public void printTurnOrder() {

        ArrayList<SpaceShip> turnOrder = createTurnOrder();

        System.out.println("========== TURN ORDER ==========");

        for (SpaceShip ship : turnOrder) {

            System.out.println(
                    ship.getName()
                            + " | Speed: " + ship.getSpeed()
                            + " | Health: " + ship.getHealth() + "/" + ship.getMaxHealth()
                            + " | Shield: " + ship.getShield() + "/" + ship.getMaxShield()
                            + " | Energy: " + ship.getEnergy() + "/" + ship.getMaxEnergy()
            );

        }

        System.out.println("===============================");

    }
    public int getTurn() {
        return turn;
    }

    public void startBattle() {

        System.out.println("========== SPACE COMBAT SIMULATION ==========");

        while (team1.hasAliveShips() && team2.hasAliveShips()) {

            System.out.println("\n=================================");
            System.out.println("TURN " + turn);
            System.out.println("=================================");

            RuleManage.setCurrentTurn(turn);


            if (turn % 3 == 0) {

                switch (random.nextInt(3)) {

                    case 0:
                        currentEvent = new SolarStorm();
                        break;

                    case 1:
                        currentEvent = new AsteroidField();
                        break;

                    case 2:
                        currentEvent = new Nebula();
                        break;
                }

                ArrayList<SpaceShip> allShips = createTurnOrder();

                currentEvent.apply(allShips);
            }


            if (turn % 4 == 0) {

                switch (random.nextInt(3)) {

                    case 0:
                        currentObstacle = new BlackHole();
                        break;

                    case 1:
                        currentObstacle = new MineField();
                        break;

                    case 2:
                        currentObstacle = new RadiationZone();
                        break;
                }

                ArrayList<SpaceShip> allShips = createTurnOrder();

                currentObstacle.apply(allShips);
            }


            if (turn % 2 == 0) {

                switch (random.nextInt(3)) {

                    case 0:
                        currentBonus = new EnergyCapsule();
                        break;

                    case 1:
                        currentBonus = new ShieldBoost();
                        break;

                    case 2:
                        currentBonus = new RepairDrone();
                        break;
                }

                SpaceShip luckyShip = getRandomLivingShip();

                if (luckyShip != null) {

                    currentBonus.apply(luckyShip);

                }
            }

            ArrayList<SpaceShip> turnOrder = createTurnOrder();
            for (SpaceShip ship : turnOrder) {

                if (!ship.isAlive()) {
                    continue;
                }

                SpaceShip target;

                if (team1.getShips().contains(ship)) {

                    target = RuleManage.chooseTarget(team2);

                } else {

                    target = RuleManage.chooseTarget(team1);

                }

                if (target != null) {

                    try {

                        ship.chooseAction(target);

                    } catch (DestroyedShipException |
                             NotEnoughEnergyException |
                             InvalidTargetException e) {

                        System.out.println("ERROR: " + e.getMessage());

                    }
                }
            }

            RuleManage.checkEventTriggeredRules(team1);
            RuleManage.checkEventTriggeredRules(team2);

            for (SpaceShip ship : turnOrder) {

                if (ship.isAlive()) {

                    ship.recoverEnergy(10);

                }
            }

            for (SpaceShip ship : turnOrder) {

                ship.setSpeed(ship.getBaseSpeed());

            }

            turn++;

        }

        announceWinner();

    }
    private void announceWinner(){
        System.out.println("\n========== BATTLE FINISHED ==========");
        if (team1.hasAliveShips()){
            System.out.println("Winner: " + team1.getName());
        }else{
            System.out.println("Winner: "+team2.getName());
        }
    }

    private SpaceShip getRandomLivingShip() {

        ArrayList<SpaceShip> livingShips = new ArrayList<>();

        for (SpaceShip ship : createTurnOrder()) {

            if (ship.isAlive()) {
                livingShips.add(ship);
            }

        }

        if (livingShips.isEmpty()) {
            return null;
        }

        return livingShips.get(random.nextInt(livingShips.size()));
    }

}