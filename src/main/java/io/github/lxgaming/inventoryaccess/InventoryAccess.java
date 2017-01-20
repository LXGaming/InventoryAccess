/*
 * Copyright 2017 Alex Thomson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
