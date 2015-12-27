package net.coyne.command;

import net.coyne.config.ConfigHandler;

import org.bukkit.ChatColor;

public class ConfigHelper {

	/**
	 * Returns the no permission message from coyne config.
	 * @return No permission message
	 */
	
	public static String getNoPermissionMessage() {
		return ChatColor.translateAlternateColorCodes('&', ConfigHandler.getHandler().getConfig().getString("coyneconfig-no-permission"));
	}
}