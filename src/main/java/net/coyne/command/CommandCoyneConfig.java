package net.coyne.command;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class CommandCoyneConfig implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("coyneconfig.cmd")) {
			try {
				String toDo = args[0];
				String fileName = args[1];
				String field = args[2];
				File file = new File(fileName);
				YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
				if (!(config.getBoolean( "coyne-readable" ) == false)) {
					if (toDo.equalsIgnoreCase("get")) {
						sender.sendMessage( ChatColor.BLUE + "Config> " + ChatColor.GOLD + "Value of " + field + " is: " + ChatColor.RESET + "" + config.get(field) );
					}
					if (toDo.equalsIgnoreCase("set")) {
						Object obj = "";
						for (int i = 3; i < args.length; i++) {
							obj = obj + " " + args[i];
						}
						config.set(field, obj);
						sender.sendMessage( ChatColor.BLUE + "Config> " + ChatColor.GOLD + "Set " + field + " to: " + ChatColor.RESET + "" + obj );
						config.save(file);
					}
					if (toDo.equalsIgnoreCase("save")) {
						config.save(file);
					}
				}
				if (config.getBoolean( "coyne-readable" ) == false) {
					sender.sendMessage( ChatColor.BLUE + "Config> " + ChatColor.GOLD + "That configuration file has disabled reading from this plugin." );
				}
			}catch(Exception e) {
				sender.sendMessage( ChatColor.RED + "Invalid Command Handling! Usage: /coyneconfig <Action> <File Path> <Object1> <Object2> Make sure the file path exists!" );
			}
		}
		if (!sender.hasPermission("coyneconfig.cmd")) {
			sender.sendMessage( ConfigHelper.getNoPermissionMessage() );
		}
		return false;
	}
}