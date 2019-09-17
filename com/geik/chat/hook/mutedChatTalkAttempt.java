package com.geik.chat.hook;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.geik.chat.Main;

public class mutedChatTalkAttempt {
	
	public static void chatEventMuted(AsyncPlayerChatEvent e) {
		if (Main.globalmute == true) {
			Player player = (Player) e.getPlayer();
			if(!(player.hasPermission("sohbet.sustur"))) {
				e.setCancelled(true);
				player.sendMessage(Main.color("&2&lREHBER &r&2RigelMC: &cSohbet kapalý olduðundan konuþamazsýn dostum."));
			}
		}
	}

}
