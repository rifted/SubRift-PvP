package com.gravirift.rifted.subrift;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gravirift.rifted.subrift.kits.Kit;

public class MainListener implements Listener {

	@EventHandler
	public void playerInteract(PlayerInteractEvent event) {
		if (PlayerManager.kits.containsKey(event.getPlayer())) {
			Player p = event.getPlayer();
			Kit k = PlayerManager.kits.get(p);

			if (event.getAction() == Action.RIGHT_CLICK_AIR) {
				p.getWorld().playSound(p.getLocation(), k.kitSound(), 1F, 1F);
			}
		}
	}
}
