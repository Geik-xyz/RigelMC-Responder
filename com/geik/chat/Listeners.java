package com.geik.chat;


import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.geik.chat.hook.mutedChatTalkAttempt;
import com.geik.chat.hook.publicThings;
import com.geik.chat.hook.rehberRigelMCHook;
import com.geik.chat.keywords.keywordMessage;


public class Listeners implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Listeners(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if (player.hasPermission("essentials.mute")) {
			publicThings.rehberJoin(player);}
		if (keywordMessage.botDefault.contains(player.getName())) {
			keywordMessage.botDefault.removeIf( name -> name.contains(player.getName()));
			player.sendMessage(keywordMessage.botDefault.toString());}
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if (keywordMessage.botDefault.contains(player.getName())) {
			keywordMessage.botDefault.removeIf( s -> s.equals(player.getName()));}
	}
	
	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		
		/*
		 * ETIKETLEME
		 * @author Geik
		 * 
		 */
		String suffix = Main.chat.getPlayerSuffix(player);
		String mesaj = e.getMessage().toLowerCase();
		for (Player p : Bukkit.getOnlinePlayers()) {
		  if (!(p.hasPermission("etiket.bypass"))) {
			if (mesaj.contains(p.getName().toLowerCase())) {
				String newMessage = mesaj.replace(p.getName().toLowerCase(), "§b@" + p.getName() + Main.color(suffix));
				e.setMessage(newMessage);
				publicThings.tagged(player, p);
				p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0F, 0.9F);}
			}
		  }
		
		/*
		 * WORD REPLACER
		 * @author Geik
		 * 
		 */
		publicThings.allMessageReplacers(e);
		
		/*
		 * ESYA VIEWER
		 * @author Geik
		 * 
		 */
		publicThings.esyaViewer(e, player);
		
		/*
		 * CHAT MUTE
		 * @author Geik
		 * 
		 */
		mutedChatTalkAttempt.chatEventMuted(e);
		
		/*
		 * CHATTING WITH REHBER
		 * @author Geik
		 * 
		 */
		rehberRigelMCHook.chatEventWithRehber(e);
		
		
		/*
		 * SMART ANSWERER
		 * @author Geik
		 * 
		 */
		keywordMessage.wholeKeyWords(player, e);
		
		
	}
	
	

}
