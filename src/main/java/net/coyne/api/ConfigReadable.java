package net.coyne.api;

import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Helper class for readable config files.
 * @author Tim
 *
 */

public class ConfigReadable {
	
	/**
	 * Set the configuration file readable or unreadable by Coyne's Config Handler.
	 * @param readable - True/False should coyne be able to read this config file?
	 * @param config - The configuration file to be readable / not readable.
	 */
	
 	public static void setReadable(boolean readable, YamlConfiguration config) {
		config.set("coyne-readable", readable);
	}
	
	/**
	 * Is the specified YamlConfiguration file readable?
	 * @param config - Config file to be checked
	 * @return True/False - Is readable by config handler.
	 */
	
	public static boolean getReadable(YamlConfiguration config) {
		if (config.getBoolean( "coyne-readable" ) == false) {
			return false;
		}
		return true;
	}
}