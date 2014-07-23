package com.gravirift.rifted.subrift.kits.hulk;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.gravirift.rifted.subrift.kits.Kit;

public class Hulk extends Kit{
	@Override
	public ItemStack[] kitItems(){
		ItemStack[] items = {
			new ItemStack(Material.WOOD_SWORD)
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
		lamhelm.setColor(Color.GREEN); helmet.setItemMeta(lamhelm);
		
		LeatherArmorMeta lamchest = (LeatherArmorMeta)chestplate.getItemMeta();
		lamchest.setColor(Color.GREEN); chestplate.setItemMeta(lamchest);
		
		LeatherArmorMeta lamleg = (LeatherArmorMeta)leggings.getItemMeta();
		lamleg.setColor(Color.GREEN); leggings.setItemMeta(lamleg);
		
		LeatherArmorMeta lamboot = (LeatherArmorMeta)boots.getItemMeta();
		lamboot.setColor(Color.GREEN); boots.setItemMeta(lamboot);

		ItemStack[] items = {boots, leggings, chestplate, helmet};
		return items;
	}
	
	@Override
	public PotionEffect[] kitEffects(){
		PotionEffect[] effects = {
			new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1),
			new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1)
		};
		return effects;
	}
}
