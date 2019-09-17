package com.geik.chat.hook;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.geik.chat.Main;

public class rehberRigelMCHook {
	
	public static void chatEventWithRehber(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		if (publicThings.rehberMap.containsKey(player.getName())) {
			int getValue = publicThings.rehberMap.get(player.getName());
			String msg = e.getMessage();
			if (getValue == 2) {
				publicThings.rehberMap.remove(player.getName());
				if (msg.equalsIgnoreCase("iyi") || msg.equalsIgnoreCase("iyi sen") || msg.equalsIgnoreCase("ii") || msg.equalsIgnoreCase("iyiyim teşekkürler sen")
						|| msg.equalsIgnoreCase("ii teşekkürler") || msg.equalsIgnoreCase("ii tşk") || msg.equalsIgnoreCase("ii sn") || msg.equalsIgnoreCase("ii tşk sn")) {
					e.setCancelled(true);
					if (msg.contains("sn") || msg.contains("sen")) {
						player.sendMessage(Main.color("&5&lASISTAN &aİyi olmana bayıldımm!! &aBu arada ben de iyiyim sorduğun için sağ ol!"));
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
							player.sendMessage(Main.color("&5&lASISTAN &aNeyse neyse beynim biraz gelişince konuşuruz :) sen işine bak!"));}},540);}
					
					else {
					player.sendMessage(Main.color("&5&lASISTAN &aİyi olmana çok sevindim! &cAma benim nasıl olduğumu niye merak etmedin :(("));
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
						player.sendMessage(Main.color("&5&lASISTAN &cZaten kimsenin umrunda değilim..."));}},250);}
					
					
				
				} else if (msg.equalsIgnoreCase("kötü") || msg.equalsIgnoreCase("kötü sen") || msg.equalsIgnoreCase("kotu") || msg.equalsIgnoreCase("kotuyum sen")
						|| msg.equalsIgnoreCase("kotu teşekkürler") || msg.equalsIgnoreCase("kotuyum") || msg.equalsIgnoreCase("kotu sn") || msg.equalsIgnoreCase("kotuyum sn")
						|| msg.equalsIgnoreCase("kötüyüm") || msg.equalsIgnoreCase("kötüyüm sen") || msg.equalsIgnoreCase("kötüyüm sn")){
					e.setCancelled(true);
					if (msg.contains("sn") || msg.contains("sen")) {
						player.sendMessage(Main.color("&5&lASISTAN &cKötü olman beni çok üzdü... Moralini bozma diye fazladan yardım edicem."));
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
							player.sendMessage(Main.color("&5&lASISTAN &cBu arada sorduğun için sağol ama sen kötüysen ben de kötüyüm.."));}},160);}
					
					else {
						player.sendMessage(Main.color("&5&lASISTAN &cKötü olman beni üzdü :( Dinlemek istedim fakat o kadar zeki değilim..."));
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
							player.sendMessage(Main.color("&5&lASISTAN &cBu arada sen sormadın ama kötü hissettiğin için ben de kötüyüm."));}},340);}}
				
			}
			else if (getValue == 3) {
				publicThings.rehberMap.remove(player.getName());
				if (msg.equalsIgnoreCase("♥") || msg.equalsIgnoreCase("<3")){
					e.setCancelled(true);
					player.sendMessage(Main.color("&5&lASISTAN &aYerim seni &4♥&a, hadi seni tutmayayım kolay gelsin &6:3&a!"));}
			}
			else {
				publicThings.rehberMap.remove(player.getName());
				if (msg.equalsIgnoreCase("evet") || msg.equalsIgnoreCase("evt") || msg.equalsIgnoreCase("eet") || msg.equalsIgnoreCase("seviyorum")
						|| msg.equalsIgnoreCase("svyrm") || msg.equalsIgnoreCase("eveet") || msg.equalsIgnoreCase("evet seviyorum") || msg.equalsIgnoreCase("eet seviyorum")) {
					e.setCancelled(true);
					player.sendMessage(Main.color("&5&lASISTAN &aCanımsın benim :*, ben de seni seviyorum &4♥"));
					
					
				}
				else if (msg.equalsIgnoreCase("hayır") || msg.equalsIgnoreCase("hayir") || msg.equalsIgnoreCase("hyr") || msg.equalsIgnoreCase("hyr sevmiyorum")
						|| msg.equalsIgnoreCase("hayır sevmiyorum") || msg.equalsIgnoreCase("hayir sevmiyorum") || msg.equalsIgnoreCase("hyr svmyrm") || msg.equalsIgnoreCase("hayir svmyrm")
						|| msg.equalsIgnoreCase("hayır svmyrm") || msg.equalsIgnoreCase("hayır sevmyrm") || msg.equalsIgnoreCase("sevmiyorum") || msg.equalsIgnoreCase("svmyrm")) {
					e.setCancelled(true);
					player.sendMessage(Main.color("&5&lASISTAN &cOlsun bee... Ben seni hep sevmeye devam edeceğim :/"));
				}
				
			}
		}
		
		
		
	}
	public static void rigelSaystoRehber(Player player, String message1, String message2, String message3, int messageNumber) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
			player.sendMessage(Main.color(message1));}},80);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
			player.sendMessage(Main.color(message2));}},110);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
			player.sendMessage(Main.color(message3));
			publicThings.rehberMap.put(player.getName(), messageNumber);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
				if (publicThings.rehberMap.containsKey(player.getName())) {publicThings.rehberMap.remove(player.getName());}}}, 300);}},140);
	}
}
