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

package io.github.lxgaming.inventoryaccess.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestInteractEvent implements Listener {
	
	@EventHandler
	public void onChestInteract(PlayerInteractEvent PI) {
		Block block = PI.getClickedBlock();
		Player player = PI.getPlayer();
		
		if (block == null) {
			return;
		}
		
		if ((block.getType().equals(Material.CHEST)) && (PI.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && (!player.isSneaking())) {
			Chest chest = (Chest) block.getState();
			if (player.hasPermission("InventoryAccess.Chest." + player.getGameMode())) {
				player.openInventory(chest.getInventory());
			}
		}
		return;
	}
}
