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