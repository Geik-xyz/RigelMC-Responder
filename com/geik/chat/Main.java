package com.geik.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;

public class Main extends JavaPlugin {
	
	private Listeners listeners;
	public static Main instance;
	public static Chat chat = null;
	public static boolean globalmute;
	
	public void onEnable() {
		getCommand("temizle").setExecutor(new Commands(this));
		getCommand("sustur").setExecutor(new Commands(this));
		instance = this;
		this.listeners = new Listeners(this);
		Bukkit.getPluginManager().registerEvents(this.listeners, this);
		setupChat();
	}
	
	public static String color(String yazirengi){return ChatColor.translateAlternateColorCodes('&', yazirengi);}

	
	private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
}
