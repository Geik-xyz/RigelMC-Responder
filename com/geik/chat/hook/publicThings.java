package com.geik.chat.hook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import com.geik.chat.Main;

import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class publicThings {

	static TitleManagerAPI api = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
	public static HashMap<String, Integer> rehberMap = new HashMap<String, Integer>();
	
	
	public static void rehberJoin(Player player)
	{
		Random newRandom = new Random();
		int n = newRandom.nextInt(4);
		if (n == 2) {
			rehberRigelMCHook.rigelSaystoRehber(player, "&5&lASISTAN &aMerhaba &b" + player.getName() + " &aho� geldin! Asistan�n olarak hizmetindeyim.",
					"&5&lASISTAN &aSana hizmet etmek i�in can at�yorum :)))",
					"&5&lASISTAN &eNas�ls�n bu arada? Nas�l gidiyor?", 2);
		} else if (n == 3) {
			rehberRigelMCHook.rigelSaystoRehber(player, "&5&lASISTAN &aTekrar selam &b" + player.getName() + " &aSeni g�rmek ne ho�!",
					"&5&lASISTAN &aSenin yeteneklerini g�rmek beni �ok mutlu edecek =))",
					"&5&lASISTAN &d�imdiden Kolay gelsin ve bir kalbini al�r�m bu arada ;)", 3);
		} else {
			rehberRigelMCHook.rigelSaystoRehber(player, "&5&lASISTAN &aUuu patron gelmi�! &b" + player.getName() + " &aSelam olsun!",
					"&5&lASISTAN &aBu sunucu yapt�klar�ndan dolay� sana minnettar! :)",
					"&5&lASISTAN &cBu arada laf a��lm��ken beni seviyor musun? :3", 4);
		}
	}
	
	
	
	
	/*
	 * TAGGED
	 * @author Geik
	 * 
	 */
	public static void tagged(Player player, Player p){
		String katilacaksin = (Main.color("&b@" + player.getName() + "&7 Senden bahsetti!"));
		String savas = (Main.color("&9&lBILDIRIM!"));
		api.sendTitle(p, savas, 8, 15, 8);
    	api.sendSubtitle(p, katilacaksin);
		}
	
	
	/*
	 * MESSAGE REPLACER FIRST
	 * @author Geik
	 * 
	 */
	public static void messageReplacer(AsyncPlayerChatEvent e, String willReplace, String replace) {
		String mesaj = e.getMessage();
		if (mesaj.equalsIgnoreCase(willReplace)) {
			String newMessage = mesaj.replace(willReplace, replace); e.setMessage(newMessage);}
	}
	
	
	/*
	 * MESSAGE REPLACER FINAL
	 * @author Geik
	 * 
	 */
	public static void allMessageReplacers(AsyncPlayerChatEvent e) {
		publicThings.messageReplacer(e, "sa", "Selam�n aleyk�m");
		publicThings.messageReplacer(e, "as", "Aleyk�m selam");
		publicThings.messageReplacer(e, "hg", "Ho� geldin");
		publicThings.messageReplacer(e, "hb", "Ho� bulduk");
		publicThings.messageReplacer(e, "kg", "Kolay gelsin");
		publicThings.messageReplacer(e, "eyw", "Eyvallah");
		publicThings.messageReplacer(e, "eyv", "Eyvallah");
		publicThings.messageReplacer(e, "�d", "�nemli de�il");
		publicThings.messageReplacer(e, "as hg", "Aleyk�m selam ho� geldin");
	}
	
	
	/*
	 * ESYA VIEWER
	 * @author Geik
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static void esyaViewer(AsyncPlayerChatEvent e, Player player) {
		if (e.getMessage().equalsIgnoreCase("[esya]")) {
			e.setCancelled(true);
			String prefix = Main.chat.getPlayerPrefix(player);
			ItemStack eldeki = e.getPlayer().getInventory().getItemInMainHand();
			if (eldeki.getType() != null && eldeki.getType() != Material.AIR) {
			  if (eldeki.getItemMeta().hasDisplayName()) {
				TextComponent mainComponent = new TextComponent((prefix +player.getName() + " &6>> ").replace("&", "�"));
				TextComponent subComponent = new TextComponent((eldeki.getItemMeta().getDisplayName()).replace("&", "�"));
				List<String> newLore = new ArrayList<String>();
				newLore.add((eldeki.getItemMeta().getDisplayName()).replace("&", ""));	
				if (eldeki.getEnchantments() != null) {
					Map<Enchantment, Integer> ench = eldeki.getEnchantments();
					for (Enchantment enh : ench.keySet()) {
						newLore.add(("&7" + enh.getName() + " " + eldeki.getEnchantmentLevel(enh)).replace("&", "�"));
					}
				}
				if (eldeki.getItemMeta().hasLore()) {
					List<String> lore = eldeki.getItemMeta().getLore();
					for (String s : lore) {
						newLore.add((s).replace("&", ""));}}
				
				String joined = String.join("\n", newLore);
				BaseComponent[] text = TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', joined));
				subComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, text));
				subComponent.setBold( true );
				mainComponent.setBold( true );
				mainComponent.addExtra( subComponent );

				Bukkit.broadcast(mainComponent);
			  }
			  else {
				  TextComponent mainComponent = new TextComponent((prefix +player.getName() + " &6>> ").replace("&", "�"));
					TextComponent subComponent = new TextComponent((eldeki.getType().name()).replace("&", "�"));
					List<String> newLore = new ArrayList<String>();
					newLore.add((eldeki.getItemMeta().getDisplayName()).replace("&", "�"));
					if (eldeki.getEnchantments() != null) {
						Map<Enchantment, Integer> ench = eldeki.getEnchantments();
						for (Enchantment enh : ench.keySet()) {
							newLore.add(("&7" + enh.getName() + " " + eldeki.getEnchantmentLevel(enh)).replace("&", "�"));
						}
					}
					if (eldeki.getItemMeta().hasLore()) {
						List<String> lore = eldeki.getItemMeta().getLore();
						for (String s : lore) {
							newLore.add((s).replace("&", "�"));
						}
					}
					
					String joined = String.join("\n", newLore);
					BaseComponent[] text = TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', joined));
					subComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, text));
					subComponent.setBold( false );
					mainComponent.setBold( false );
					mainComponent.addExtra( subComponent );

					Bukkit.broadcast(mainComponent);}}}}
	
	
	
	

}
