package io.github.lxgaming.inventoryaccess;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.lxgaming.inventoryaccess.commands.InventoryAccessCommand;
import io.github.lxgaming.inventoryaccess.events.ChestInteractEvent;
import io.github.lxgaming.inventoryaccess.events.EntityInteractEvent;

public class InventoryAccess extends JavaPlugin {
	
	public static InventoryAccess instance;
	
	@Override
	public void onEnable() {
		this.getCommand("inventoryaccess").setExecutor(new InventoryAccessCommand());
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ChestInteractEvent(), this);
		pm.registerEvents(new EntityInteractEvent(), this);
		getLogger().info("InventoryAccess has Started!");
	}
	
	@Override
	public void onDisable() {
		instance = null;
		getLogger().info("InventoryAccess has Stopped!");
	}
}