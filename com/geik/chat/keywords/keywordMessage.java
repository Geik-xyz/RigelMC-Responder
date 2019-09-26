package com.geik.chat.keywords;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.geik.chat.Main;

public class keywordMessage {
	
	public static List<String> botDefault = new ArrayList<>();
	
	public static void rigelSaysEveryone(Player player, String message1, String message2, String message3, String message4) {
		if (!player.hasPermission("essentials.mute")) {
			defaultSchedulerMessage(20, player, message1);
			if (message2 != null) {
				defaultSchedulerMessage(90, player, message2);}
			if (message3 != null) {
				defaultSchedulerMessage(140, player, message3);}
			if (message4 != null) {
				defaultSchedulerMessage(180, player, message4);}
		}
		
	}
	public static void defaultSchedulerMessage(int time, Player player, String msj) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
			player.sendMessage(Main.color("&2&lREHBER &2RigelMC: " + msj));}},time);
	}
	
	public static void hallOfTheMountainKing(AsyncPlayerChatEvent e, Player player, String listenWord, String message1, String message2, String message3, String message4)
	{
		defaultKeywords event = new defaultKeywords(listenWord, e.getMessage());
		if (e.getMessage().contains(event.detected())) {
			if (!botDefault.contains(player.getName())) {
				keywordMessage.rigelSaysEveryone(player, message1, message2, message3, message4);
				botDefault.add(player.getName() + "." + listenWord);
			}
		}
	}
	
	public static void wholeKeyWords(Player player, AsyncPlayerChatEvent e) {
		
		
		hallOfTheMountainKing(e, player, "event", 
				"&aSelam &b" + player.getName() + " &aEventlerin listesi:", 
				"&aHer Gün &e18:00 &ave &e20:00 &ada &cBOSS&a ve her &6Pazar &e18:50&a'de &4FETIH Savaþý", 
				"&aSüreli etkinlikler için:&b&n http://bit.ly/2lRcJd6", 
				"&aAyrýca rastgele zamanlarda &4&lGM&a'ler event yapabiliyor. Öneri için &f/dc");
		
		hallOfTheMountainKing(e, player, "viktor", 
				"&aSelam &b" + player.getName() + " &aViktor bir bosstur:",
				"&aHer gün saat &e20:00 &ada çýkar ve ölürksen 10 blok yakýnýndaki herkese ödül verir.", 
				"&aAyrýca görevleri yaparak viktoru parþomen olarak da alabilirsin.", 
				"&aDaha basittir ve arkadaþlarýnla kesip ödülü paylaþabilirsin.&b&n http://bit.ly/2lY3Wpv");
		
		hallOfTheMountainKing(e, player, "demonia", 
				"&aSelam &b" + player.getName() + " &3Demonia&a bir bosstur:",
				"&aHer gün saat &e18:00 &ada çýkar ve ölürksen 10 blok yakýnýndaki herkese ödül verir.", 
				"&aAyrýca görevleri yaparak &3Demoniayý&a parþomen olarak da alabilirsin.", 
				"&aParþomen daha basittir ve arkadaþlarýnla kesebilirsin.&b&n http://bit.ly/2lY3Wpv");
		
		hallOfTheMountainKing(e, player, "görev", 
				"&aSelam &b" + player.getName() + " &aGörevler 2 ye ayrýlýr:",
				"&dAda görevleri&a, adaný büyütür ve ünvan verir. &f/c", 
				"&dSpawn Görevleri&a, günlük parþomen almaný saðlar.&b&n http://bit.ly/2mdf2XV", 
				null);
		
		if (player.hasPermission("sinif.elyon") || player.hasPermission("sinif.xiviel")) {
			
			String perm;
			if (player.hasPermission("sinif.xiviel")) {perm = "&cXiviel";} else perm = "&bElyon";
			
			hallOfTheMountainKing(e, player, "fetih",
					"&aSelam &b" + player.getName() + " &aFetih bir savaþtýr.",
					"&aHer &6Pazar &e18:50 &ade &akayýtlarý açýlýr. Bir " + perm + " &aolarak savaþtan kaçma!", 
					"&aKazanan tarafýn en çok kill alanýna 1 haftalýk &b&lVIP &aolan &c&lSK &averilir.", 
					"&aVe ayrýca katýlan, kazanan/kaybeden herkes ödül alýr. Fakat miktarlarý deðiþir.&b&n http://bit.ly/2kNSNaO");}
		else {
			hallOfTheMountainKing(e, player, "fetih",
					"&aSelam &b" + player.getName() + " &aFetih bir savaþtýr.",
					"&aHer &6Pazar &e18:50 &ade &akayýtlarý açýlýr. &4&lNOT: &cHenüz sýnýf seçmemiþsin &f/sinif &cyaz!",
					"&aKazanan tarafýn en çok kill alanýna 1 haftalýk &b&lVIP &aolan &c&lSK &averilir.", 
					"&aVe ayrýca katýlan, kazanan/kaybeden herkes ödül alýr. Fakat miktarlarý deðiþir.&b&n http://bit.ly/2kNSNaO");}
		
		
		hallOfTheMountainKing(e, player, "boss", 
				"&aSelam &b" + player.getName() + " &aBosslarýn listesi:", 
				"&aHer Gün &e18:00&a da &a&lVIKTOR &ave &e20:00 &ada &3&lDEMONIA &açýkar.", 
				"&aDünya bosslarý kendi warpýnda, parþomen bosslarý adada doðar.", 
				"&aAyrýca detay istiyorsan bana sorabilirsin &c:) &b&nhttp://bit.ly/2lY3Wpv");
		
		hallOfTheMountainKing(e, player, "parþomen", 
				"&aSelam &b" + player.getName() + " &aParþomen bosslarý:", 
				"&a&lVIKTOR &ave &3&lDEMONIA &anýn illüzyonlarýdýr ve daha güçsüzüdür.", 
				"&aSpawndaki görevleri yaparak parþomenleri elde edebilirsin.", 
				"&aAyrýca detay istiyorsan bana sorabilirsin :) &b&nhttp://bit.ly/2lY3Wpv");
		
		
		

	}

}
