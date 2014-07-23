package com.gravirift.rifted.subrift;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.gravirift.rifted.subrift.kits.KitManager;
import com.gravirift.rifted.subrift.kits.hulk.Hulk;
import com.gravirift.rifted.subrift.kits.hulk.HulkListener;
import com.gravirift.rifted.subrift.kits.spiderman.SpiderMan;
import com.gravirift.rifted.subrift.kits.spiderman.SpidermanListener;

public class Main extends JavaPlugin{
	
	PluginDescriptionFile pdf = this.getDescription();
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new MainListener(), this);
		getServer().getPluginManager().registerEvents(new SpidermanListener(), this);
		getServer().getPluginManager().registerEvents(new HulkListener(), this);
		
		KitManager.registerKit("spiderman", new SpiderMan());
		KitManager.registerKit("hulk", new Hulk());
	}
	
	@Override
	public void onDisable(){
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kit")){
			if(!(sender instanceof Player)){
				sender.sendMessage(ChatColor.RED+"Sorry console; you can't choose a kit!");
			}else{
				Player p = (Player) sender;
				if(args.length >= 1){
					String kit = args[0];
					if(KitManager.isKit(kit)){
						p.setHealth(0.0);
						KitManager.setKit(p, KitManager.getKit(kit));
						p.sendMessage(ChatColor.GREEN+"Good Luck!");
					}else{
						p.sendMessage(ChatColor.RED+"The kit '"+kit+"' does not exist!");
					}
					return true;
				}else{
					p.sendMessage(ChatColor.YELLOW+"There are "+KitManager.availableKits().size()+" kits:");
					String kits = StringUtils.join(KitManager.availableKits(),", ");
					p.sendMessage(ChatColor.YELLOW+kits);
					return true;
				}
			}
		}
		return false; 
	}
}
