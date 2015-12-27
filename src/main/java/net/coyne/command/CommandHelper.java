package net.coyne.command;

import net.coyne.config.ConfigHandler;

public class CommandHelper {

	/**
	 * Register commands
	 */
	
	public static void registerCommands() {
		ConfigHandler.getHandler().getCommand("coyneconfig").setExecutor(new CommandCoyneConfig());
	}
}