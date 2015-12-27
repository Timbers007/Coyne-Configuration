package net.coyne.api;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigReader {
	
	YamlConfiguration config;
	File file;
	
	public ConfigReader(File file) {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		if (!(config.getBoolean("coyne-readable") == false)) {
			this.file = file;
			this.config = config;
		}
	}
	
	@Deprecated
	public ConfigReader(YamlConfiguration config) {
		YamlConfiguration yconfig = YamlConfiguration.loadConfiguration(file);
		if (!(config.getBoolean("coyne-readable") == false)) {
			this.config = yconfig;
		}
	}
	
	/**
	 * Save the config file to the file from the instant.
	 */
	
	public void saveToFile() {
		if (file != null) {
			try {
				config.save(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Read the field specified.
	 * @param str
	 * @return Field Value
	 */
	
	public Object read(String str) {
		return config.get(str);
	}
	
	/**
	 * Set the field to the value specified.
	 * @param field
	 * @param var
	 */
	
	public void set(String field, Object var) {
		config.set(field, var);
	}
}