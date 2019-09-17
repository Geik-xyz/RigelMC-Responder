package com.geik.chat.hook;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.geik.chat.Main;
import com.geik.chat.keywords.keywordMessage;

public class chatClear {
	
	
	public static void clearChat(CommandSender sender, Command cmd, String label, String[] args) {
	if (label.equalsIgnoreCase("temizle")) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				if (player.hasPermission("chat.clear.admin")) {
					player.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &cYanlýþ yetkili kullanýmý! /temizle <herkes/ben>"));
				} else {
					for (int i = 0 ; i < 100 ; i++) {player.sendMessage("");}
					player.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &aSohbetin baþarýyla temizlendi!"));
				}
			}
			else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("ben")) {
					for (int i = 0 ; i < 100 ; i++) {player.sendMessage("");}
					player.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &aSohbetin baþarýyla temizlendi!"));
					player.sendMessage(keywordMessage.botDefault.toString());
				}
				else if (args[0].equalsIgnoreCase("herkes")) {
					if (player.hasPermission("chat.clear.admin")) {
						for(Player p : Bukkit.getOnlinePlayers()){
							if (!(p.hasPermission("chat.clear.admin"))) {
								for (int i = 0 ; i < 100; i++) {
									p.sendMessage("");
								}
								p.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &aSohbetin &b" + player.getName() + " &atarafýndan temizlendi."));
							}
							else {p.sendMessage(Main.color("&5&lASISTAN &aSohbet &b" + player.getName() + " &atarafýndan temizlendi. [Korunuyorsun]"));}
						}
						Bukkit.getServer().getConsoleSender().sendMessage(Main.color("&5&lASISTAN &aSohbet &b" + player.getName() + " &atarafýndan temizlendi!"));
					} else player.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &cBu komut için yetkin yok!"));
				}
				else {
					player.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &cHatalý komut lütfen &f/temizle &cyaz."));
				}
			}
			else {
				player.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &cHatalý komut lütfen &f/temizle &cyaz."));
			}
		}
		else {
			if (args.length == 0) {
				for(Player p : Bukkit.getOnlinePlayers()){
					if (!(p.hasPermission("chat.clear.admin"))) {
						for (int i = 0 ; i < 100; i++) {
							p.sendMessage("");
						}
						p.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &aSohbetin &bCONSOLE &atarafýndan temizlendi."));
					}
					else {p.sendMessage(Main.color("&5&lASISTAN &aSohbet &bCONSOLE &atarafýndan temizlendi. [Temizlemeden korunuyorsun.]"));}}
			}
			else {
				sender.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &cHatalý komut doðrusu: &f/temizle"));
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
