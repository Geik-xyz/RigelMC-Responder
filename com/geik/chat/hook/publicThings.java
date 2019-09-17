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
			rehberRigelMCHook.rigelSaystoRehber(player, "&5&lASISTAN &aMerhaba &b" + player.getName() + " &ahoþ geldin! Asistanýn olarak hizmetindeyim.",
					"&5&lASISTAN &aSana hizmet etmek için can atýyorum :)))",
					"&5&lASISTAN &eNasýlsýn bu arada? Nasýl gidiyor?", 2);
		} else if (n == 3) {
			rehberRigelMCHook.rigelSaystoRehber(player, "&5&lASISTAN &aTekrar selam &b" + player.getName() + " &aSeni görmek ne hoþ!",
					"&5&lASISTAN &aSenin yeteneklerini görmek beni çok mutlu edecek =))",
					"&5&lASISTAN &dÞimdiden Kolay gelsin ve bir kalbini alýrým bu arada ;)", 3);
		} else {
			rehberRigelMCHook.rigelSaystoRehber(player, "&5&lASISTAN &aUuu patron gelmiþ! &b" + player.getName() + " &aSelam olsun!",
					"&5&lASISTAN &aBu sunucu yaptýklarýndan dolayý sana minnettar! :)",
					"&5&lASISTAN &cBu arada laf açýlmýþken beni seviyor musun? :3", 4);
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
		publicThings.messageReplacer(e, "sa", "Selamýn aleyküm");
		publicThings.messageReplacer(e, "as", "Aleyküm selam");
		publicThings.messageReplacer(e, "hg", "Hoþ geldin");
		publicThings.messageReplacer(e, "hb", "Hoþ bulduk");
		publicThings.messageReplacer(e, "kg", "Kolay gelsin");
		publicThings.messageReplacer(e, "eyw", "Eyvallah");
		publicThings.messageReplacer(e, "eyv", "Eyvallah");
		publicThings.messageReplacer(e, "öd", "Önemli deðil");
		publicThings.messageReplacer(e, "as hg", "Aleyküm selam hoþ geldin");
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
				TextComponent mainComponent = new TextComponent((prefix +player.getName() + " &6>> ").replace("&", "§"));
				TextComponent subComponent = new TextComponent((eldeki.getItemMeta().getDisplayName()).replace("&", "§"));
				List<String> newLore = new ArrayList<String>();
				newLore.add((eldeki.getItemMeta().getDisplayName()).replace("&", ""));	
				if (eldeki.getEnchantments() != null) {
					Map<Enchantment, Integer> ench = eldeki.getEnchantments();
					for (Enchantment enh : ench.keySet()) {
						newLore.add(("&7" + enh.getName() + " " + eldeki.getEnchantmentLevel(enh)).replace("&", "§"));
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
				  TextComponent mainComponent = new TextComponent((prefix +player.getName() + " &6>> ").replace("&", "§"));
					TextComponent subComponent = new TextComponent((eldeki.getType().name()).replace("&", "§"));
					List<String> newLore = new ArrayList<String>();
					newLore.add((eldeki.getItemMeta().getDisplayName()).replace("&", "§"));
					if (eldeki.getEnchantments() != null) {
						Map<Enchantment, Integer> ench = eldeki.getEnchantments();
						for (Enchantment enh : ench.keySet()) {
							newLore.add(("&7" + enh.getName() + " " + eldeki.getEnchantmentLevel(enh)).replace("&", "§"));
						}
					}
					if (eldeki.getItemMeta().hasLore()) {
						List<String> lore = eldeki.getItemMeta().getLore();
						for (String s : lore) {
							newLore.add((s).replace("&", "§"));
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
