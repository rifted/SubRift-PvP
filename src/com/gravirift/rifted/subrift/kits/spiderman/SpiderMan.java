package com.gravirift.rifted.subrift.kits.spiderman;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.gravirift.rifted.subrift.kits.Kit;

public class SpiderMan extends Kit{
	
	@Override
	public ItemStack[] kitItems(){
		
		ItemStack summonSpider = new ItemStack(Material.SPIDER_EYE, 1);
		ItemMeta ssMeta = summonSpider.getItemMeta();
		ssMeta.setDisplayName(ChatColor.RESET+"Summon Spider");
		summonSpider.setItemMeta(ssMeta);
		
		ItemStack[] items = {
			new ItemStack(Material.STRING, 16),
			summonSpider
		};
		return items;
	}
	
	@Override
	public ItemStack[] kitArmour(){
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		
		LeatherArmorMeta lamhelm = (LeatherArmorMeta)helmet.getItemMeta();
		lamhelm.setColor(Color.RED); helmet.setItemMeta(lamhelm);
		
		LeatherArmorMeta lamchest = (LeatherArmorMeta)chestplate.getItemMeta();
		lamchest.setColor(Color.BLACK); chestplate.setItemMeta(lamchest);
		
		LeatherArmorMeta lamleg = (LeatherArmorMeta)leggings.getItemMeta();
		lamleg.setColor(Color.BLACK); leggings.setItemMeta(lamleg);
		
		LeatherArmorMeta lamboot = (LeatherArmorMeta)boots.getItemMeta();
		lamboot.setColor(Color.BLACK); boots.setItemMeta(lamboot);

		ItemStack[] items = {boots, leggings, chestplate, helmet};
		return items;
	}
	
	@Override
	public PotionEffect[] kitEffects(){
		PotionEffect[] effects = {
			new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0),
			new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 0)
		};
		
		return effects;
	}
	
	@Override
	public Sound kitSound(){
		return Sound.SPIDER_IDLE;
	}
}
