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