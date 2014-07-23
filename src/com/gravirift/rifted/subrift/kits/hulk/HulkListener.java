package com.gravirift.rifted.subrift.kits.hulk;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.gravirift.rifted.subrift.kits.KitManager;

public class HulkListener implements Listener{
	@EventHandler
	public void interactEvent(PlayerInteractEntityEvent event){
		if(KitManager.playerHasKit(event.getPlayer(), "hulk")){
			Location l = event.getPlayer().getEyeLocation();
			l.setPitch(-25);
			Vector v = l.getDirection().multiply(2);
			event.getRightClicked().setVelocity(v);
			((LivingEntity) event.getRightClicked()).addPotionEffect(new PotionEffect(PotionEffectType.HARM, 5, 0));
			event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 2));
		}
	}
}
