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

package io.github.lxgaming.inventoryaccess.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InventoryAccessCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("inventoryaccess")) {
			sender.sendMessage(ChatColor.GOLD + "===== " + ChatColor.GREEN + "InventoryAccess" + ChatColor.GOLD + " ===== ");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "Version 0.1.1");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "Author - LX_Gaming");
			sender.sendMessage(ChatColor.GOLD + "===== " + ChatColor.GREEN + "Permissions" + ChatColor.GOLD + " ===== ");
			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.AQUA + "Author - LX_Gaming");
			return true;
		}
		return false;
	}
}
