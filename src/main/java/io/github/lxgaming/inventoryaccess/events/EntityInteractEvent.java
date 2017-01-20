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

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractEvent implements Listener {
	
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent PI) {

		if (!PI.getRightClicked().getType().equals(EntityType.PLAYER)) {
			return;
		}
		
		Player player = PI.getPlayer();
		Player targetPlayer = (Player) PI.getRightClicked();
		
		if (player.hasPermission("InventoryAccess.Player." + player.getGameMode())) {
			player.openInventory(targetPlayer.getInventory());
		}
		return;
	}
}
