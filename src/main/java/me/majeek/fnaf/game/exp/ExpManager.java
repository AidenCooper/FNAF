package me.majeek.fnaf.game.exp;

import org.bukkit.entity.Player;

public class ExpManager {
    public int getTotalExperience(Player player) {
        int exp = Math.round(getExpAtLevel(player) * player.getExp());
        int currentLevel = player.getLevel();

        while (currentLevel > 0) {
            currentLevel--;
            exp += getExpAtLevel(currentLevel);
        }
        if (exp < 0) {
            exp = Integer.MAX_VALUE;
        }
        return exp;
    }

    public void setTotalExperience(Player player, int xp) {
        player.setExp(0);
        player.setLevel(0);
        player.setTotalExperience(0);

        //This following code is technically redundant now, as bukkit now calulcates levels more or less correctly
        //At larger numbers however... player.getExp(3000), only seems to give 2999, putting the below calculations off.
        int amount = xp;
        while (amount > 0) {
            final int expToLevel = getExpAtLevel(player);

            amount -= expToLevel;
            if (amount >= 0) {
                // give until next level
                player.giveExp(expToLevel);
            } else {
                // give the rest
                amount += expToLevel;
                player.giveExp(amount);
                amount = 0;
            }
        }
    }

    private int getExpAtLevel(final Player player) {
        return getExpAtLevel(player.getLevel());
    }

    public int getExpAtLevel(final int level) {
        if (level <= 15) {
            return (2 * level) + 7;
        }
        if ((level >= 16) && (level <= 30)) {
            return (5 * level) - 38;
        }
        return (9 * level) - 158;
    }

    public int getTotalExpAtLevel(final int level){
        int amount = 0;

        for(int i = 0; i < level; i++){
            amount += getExpAtLevel(i);
        }

        return amount;
    }
}
