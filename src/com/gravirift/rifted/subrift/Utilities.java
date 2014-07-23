package com.gravirift.rifted.subrift;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Utilities {
	
	private static Random rand = new Random();
	
	public static ItemStack reduceItemStack(ItemStack item) {
		if (item.getAmount() > 1) {
			item.setAmount(item.getAmount() - 1);
			return item;
		}
		return new ItemStack(Material.AIR);
	}

	public static ItemStack reduceItemStack(ItemStack item, Player pl) {
		if (pl.getGameMode() == GameMode.CREATIVE) {
			return item;
		}
		return reduceItemStack(item);
	}
	
	public static ItemStack colourStack(ItemStack is, Color c){ //woot go UK English
		LeatherArmorMeta lm = (LeatherArmorMeta) is.getItemMeta(); //don't even call this function if you aren't sure it's leather armour!
		lm.setColor(c);
		is.setItemMeta(lm);
		return is;
	}

	public static int randInt(int min, int max) {

		return rand.nextInt((max - min) + 1) + min;
	}
}
