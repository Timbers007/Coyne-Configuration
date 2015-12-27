package net.coyne.config;

import java.io.File;

import net.coyne.command.CommandHelper;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for CoyneConfig.
 * @author Tim
 *
 */

public class ConfigHandler extends JavaPlugin {

	public static ConfigHandler handler;
	
	public void onEnable()
	{
		
		File file = new File(this.getDataFolder() + File.separator + "config.yml");
				
		if (!file.exists()) {
			
			this.getLogger().info( "No config file detected! First time loading plugin?" );
			this.getLogger().info( "Generating config..." );
			
			this.getConfig().set( "coyneconfig-no-permission", "&cNo Permission." );
			this.getConfig().set( "coyne-readable", true );
			this.getConfig().options().copyDefaults();
			this.saveConfig();
			
			this.getLogger().info( "Config generated!" );
			
		}
		
		if (file.exists()) {
			
			this.getLogger().info( "Loading config..." );
			
			this.saveConfig();
			this.reloadConfig();
			this.saveConfig();
			
			this.getLogger().info( "Config loaded!" );
			
		}
		
		//Handler declaration
		handler = this;
		
		//Register Commands
		CommandHelper.registerCommands();
	}
	
	public void onDisable() {}
	
	/**
	 * Return the instance of the ConfigHandler main class. (this)
	 * @return Handler
	 */
	
	public static ConfigHandler getHandler() {
		return handler;
	}	
}