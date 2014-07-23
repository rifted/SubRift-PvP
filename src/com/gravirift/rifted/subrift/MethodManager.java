package com.gravirift.rifted.subrift;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MethodManager {
	public static ItemStack reduceItemStack(ItemStack item){
		if(item.getAmount() > 1){
			item.setAmount(item.getAmount()-1);
			return item;
		}
		return new ItemStack(Material.AIR);
	}
	public static ItemStack reduceItemStack(ItemStack item, Player pl){
		if(pl.getGameMode() == GameMode.CREATIVE){
			return item;
		}
		if(item.getAmount() > 1){
			item.setAmount(item.getAmount()-1);
			return item;
		}
		return new ItemStack(Material.AIR);
	}
	public static int randInt(int min, int max) {

	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
