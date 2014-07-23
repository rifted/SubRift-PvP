package com.gravirift.rifted.subrift.kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Kit {
	public ItemStack[] kitItems() {
		ItemStack[] i = { new ItemStack(Material.AIR) };
		return i;
	}

	public ItemStack[] kitArmour() {
		ItemStack[] i = { new ItemStack(Material.AIR),
				new ItemStack(Material.AIR), new ItemStack(Material.AIR),
				new ItemStack(Material.AIR) };
		return i;
	}

	public PotionEffect[] kitEffects() {
		PotionEffect[] effects = new PotionEffect[0];
		return effects;
	}

	public Sound kitSound() {
		return null;
	}
}
