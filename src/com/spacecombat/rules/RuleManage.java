package com.spacecombat.rules;
import java.util.ArrayList;
import com.spacecombat.entities.SpaceShip;
import com.spacecombat.entities.Team;
public class RuleManage {

    private static ArrayList<Rule> activeRules = new ArrayList<>();
    private static int currentTurn;

    public static void addRule(Rule rule) {

        activeRules.add(rule);

    }

    public static void removeRule(Class<? extends Rule> ruleType) {

        activeRules.removeIf(rule -> rule.getClass() == ruleType);

    }

    public static ArrayList<Rule> getActiveRules() {

        return activeRules;

    }

    public static void setCurrentTurn(int turn) {

        currentTurn = turn;

    }

    public static int getCurrentTurn() {

        return currentTurn;

    }

    public static int modifyDamage(SpaceShip attacker, int damage) {

        int finalDamage = damage;

        for (Rule rule : activeRules) {

            finalDamage = rule.modifyDamage(attacker, finalDamage);

        }

        return finalDamage;

    }

    public static SpaceShip chooseTarget(Team enemyTeam) {

        for (Rule rule : activeRules) {

            SpaceShip target = rule.chooseTarget(enemyTeam);

            if (target != null) {
                return target;
            }
        }

        return enemyTeam.getFirstAliveShip();
    }

    public static void checkEventTriggeredRules(Team team) {

        if (team.getAliveShips().size()
                <= team.getShips().size() / 2) {

            for (Rule rule : activeRules) {
                rule.applyTeamBonus(team);
            }
        }
    }
}