package com.geik.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.geik.chat.hook.chatClear;
import com.geik.chat.hook.chatMute;

public class Commands implements CommandExecutor {
	
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Commands(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		chatClear.clearChat(sender, cmd, label, args);
		chatMute.muteChat(sender, cmd, label, args);
		return false;
	}

	
	
}
