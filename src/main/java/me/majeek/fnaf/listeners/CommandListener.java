package me.majeek.fnaf.listeners;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length > 0){
                if(args[0].equalsIgnoreCase("help") && player.hasPermission("fnaf.help"))
                    help(player);
                else if(args[0].equalsIgnoreCase("start") && player.hasPermission("fnaf.start"))
                    start(player);
                else if(args[0].equalsIgnoreCase("stop") && player.hasPermission("fnaf.stop"))
                    stop(player);
                else if(args[0].equalsIgnoreCase("reload") && player.hasPermission("fnaf.reload"))
                    reload(player);
                else
                    player.sendMessage("Unknown command. Type \"/help\" for help.");
            } else{
                if(player.hasPermission("fnaf.help"))
                    help(player);
                else
                    player.sendMessage("Unknown command. Type \"/help\" for help.");
            }
        }

        return false;
    }

    private void help(Player sender){
        sender.sendMessage(ChatColor.GRAY + "--------------" + " [ " + ChatColor.RESET + ChatColor.GREEN + "Fnaf" + ChatColor.GRAY + " ] " + "-------------------");
        sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/fnaf help" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Displays this.");
        sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/fnaf start" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Starts the game with the current players in the world.");
        sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/fnaf stop" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Stops the game.");
        sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/fnaf reload" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Reloads the config.");
    }

    private void start(Player sender){
        if(Fnaf.getInstance().getGame().inProgress()){
            sender.sendMessage(ChatColor.RED + "Game already in progress.");
            return;
        }

        Fnaf.getInstance().getGame().initialize(sender);

        if(!Fnaf.getInstance().getGame().isInitialized()){
            sender.sendMessage(ChatColor.RED + "Failed to initialize.");
            return;
        } else{
            Bukkit.broadcastMessage(ChatColor.GREEN + "Fnaf game now starting.");
            Fnaf.getInstance().getGame().start();
        }
    }

    private void stop(Player sender){
        if(Fnaf.getInstance().getGame().inProgress()) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "Stopping current game.");
            Fnaf.getInstance().getGame().stop();
        } else{
            sender.sendMessage(ChatColor.RED + "No game is currently in progress.");
        }
    }

    private void reload(Player sender){
        FnafConfig.reload();
        sender.sendMessage(ChatColor.GREEN + "Reload complete.");
    }
}
