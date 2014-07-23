package com.gravirift.rifted.subrift.kits.spiderman;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.gravirift.rifted.subrift.MethodManager;
import com.gravirift.rifted.subrift.kits.KitManager;

public class SpidermanListener implements Listener{
	@EventHandler
	public void playerInteract(PlayerInteractEvent event){
		if(KitManager.playerHasKit(event.getPlayer(), "spiderman")){
			if(event.getAction() == Action.LEFT_CLICK_AIR){
				if(event.getPlayer().getItemInHand().getType() == Material.STRING){
					
					Location loc = event.getPlayer().getLocation();
					Vector vec = event.getPlayer().getLocation().getDirection().multiply(1.5);
					
					loc.setY(loc.getY()+2);
					@SuppressWarnings("deprecation")
					FallingBlock fb = loc.getWorld().spawnFallingBlock(loc, Material.WEB, (byte) 0);
					fb.setVelocity(vec);
					event.getPlayer().setItemInHand( MethodManager.reduceItemStack( event.getPlayer().getItemInHand(), event.getPlayer() ) );
				}
			}
			if(event.getAction() == Action.RIGHT_CLICK_AIR){
				if(event.getPlayer().getItemInHand().getType() != Material.AIR){
					if(event.getPlayer().getItemInHand().hasItemMeta()){
						if(event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RESET+"Summon Spider")){
							event.getPlayer().setItemInHand( MethodManager.reduceItemStack( event.getPlayer().getItemInHand(), event.getPlayer() ) );
							Player pl = event.getPlayer();
							Spider s = (Spider) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.SPIDER);
							s.setPassenger((Entity) pl);
							List<Entity> ents = pl.getNearbyEntities(10, 20, 10);
							double dist = 999;
							Player closest = null;
							for(Entity e : ents){
								if(!(e instanceof Player)) break;
								if((Player) e == pl) break;
								double eloc = e.getLocation().distanceSquared(pl.getLocation());
								if(eloc < dist){
									closest = (Player) e;
									dist = eloc;
								}
							}
							if(dist != 999){
								s.setTarget(closest);
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void playerAttack(EntityDamageByEntityEvent event){
		if(event.getDamager() instanceof Player){
			if(KitManager.playerHasKit((Player) event.getDamager(), "spiderman")){
				if(event.getEntity() instanceof LivingEntity){
					Player pl = (Player) event.getDamager();
					if(MethodManager.randInt(0, 6) == 3){
						LivingEntity ent = (LivingEntity) event.getEntity();
						ent.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40, 0));
						pl.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 1));
					}
					if(pl.getVehicle() != null){
						if(pl.getVehicle() instanceof Spider){
							Spider sp = (Spider) pl.getVehicle();
							sp.setTarget((LivingEntity) event.getEntity());
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void projectile(ProjectileHitEvent evt){
		if(evt.getEntityType() == EntityType.SNOWBALL){
			//if()
			Location loc = evt.getEntity().getLocation();
			loc.getWorld().getBlockAt(loc).setType(Material.WEB);
		}
	}
}
