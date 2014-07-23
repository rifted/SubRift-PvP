package com.gravirift.rifted.subrift.kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.gravirift.rifted.subrift.PlayerManager;

public class KitManager {
	
	static HashMap<String, Kit> kitClasses = new HashMap<String, Kit>();
	public static ArrayList<String> kits = new ArrayList<String>();
	
	public static void registerKit(String n, Kit k){
		kitClasses.put(n, k);
		kits.add(n);
	}
	
	public static boolean playerHasKit(Player p, Kit k){
		if(PlayerManager.kits.containsKey(p)){
			if(PlayerManager.kits.get(p) == k){
				return true;
			}
		}
		return false;
	}
	public static boolean playerHasKit(Player p, String s){
		if(!isKit(s)){
			return false;
		}
		Kit k = getKit(s);
		if(PlayerManager.kits.containsKey(p)){
			if(PlayerManager.kits.get(p) == k){
				return true;
			}
		}
		return false;
	}
	
	public static void setKit(Player p, Kit k){
		k.kitItems();
		p.getInventory().clear();
		for(ItemStack i : k.kitItems()){
			p.getInventory().addItem(i);
		}
		p.getInventory().setArmorContents(k.kitArmour());
		for(PotionEffect pe : k.kitEffects()){
			p.addPotionEffect(pe);
		}
		
		if(PlayerManager.kits.containsKey(p)){
			PlayerManager.kits.replace(p, k);
		}else{
			PlayerManager.kits.put(p, k);
		}
	}
	
	public static ArrayList<String> availableKits(){
		return kits;
	}
	
	public static boolean isKit(String n){
		n = n.toLowerCase();
		for(String s : availableKits()){
			if(s.equals(n)) return true;
		}
		return false;
	}
	
	public static Kit getKit(String name){
		name = name.toLowerCase();
		
		if(isKit(name)){
			return kitClasses.get(name);
		}
		
		return null;
	}
}
