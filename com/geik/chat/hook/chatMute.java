package com.geik.chat.hook;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.geik.chat.Main;

public class chatMute {
	
	public static void muteChat(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("sustur")) {
		  if (sender instanceof Player) {
			  Player player = (Player) sender;
			if(player.hasPermission("sohbet.sustur")) {
				  if(Main.globalmute == false) {
					  Bukkit.broadcastMessage(Main.color("&2&lREHBER &r&2RigelMC: &cSohbet yetkili &b" + player.getName() + " &ctaraf�ndan kapat�lm��t�r."));
					  Main.globalmute = true;}
				  else {
					  if(Main.globalmute == true) {
					  Bukkit.broadcastMessage(Main.color("&2&lREHBER &r&2RigelMC: &aSohbet yetkili &b" + player.getName() + " &ataraf�ndan a��lm��t�r."));
					  Main.globalmute = false;}}} else player.sendMessage(Main.color("&2&lRehber &2Bot: &cBunun i�in yetkin olmad���ndan dolay� talebin red edildi."));
		  } else {
			  if(Main.globalmute == false) {
				  Bukkit.broadcastMessage(Main.color("&2&lREHBER &r&2RigelMC: &cSohbet yetkili &bCONSOLE &ctaraf�ndan kapat�lm��t�r."));
				  Main.globalmute = true;}
			  else {
				  if(Main.globalmute == true) {
				  Bukkit.broadcastMessage(Main.color("&2&lREHBER &r&2RigelMC: &aSohbet &bCONSOLE &ataraf�ndan a��lm��t�r."));
				  Main.globalmute = false;}}
		  }
		}
	}

}
