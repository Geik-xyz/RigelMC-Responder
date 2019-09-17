package com.geik.chat.keywords;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.geik.chat.Main;

public class keywordMessage {
	
	public static List<String> botDefault = new ArrayList<String>();
	
	public static void rigelSaysEveryone(Player player, String message1, String message2, String message3, String message4) {
	//	if (!player.hasPermission("essentials.mute")) {
			defaultSchedulerMessage(20, player, message1);
			if (message2 != null) {
				defaultSchedulerMessage(90, player, message2);}
			if (message3 != null) {
				defaultSchedulerMessage(140, player, message3);}
			if (message4 != null) {
				defaultSchedulerMessage(180, player, message4);}
	//	}
		
	}
	public static void defaultSchedulerMessage(int time, Player player, String msj) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run(){
			player.sendMessage(Main.color("&2&lREHBER &2RigelMC: " + msj));}},time);
	}
	
	public static void hallOfTheMountainKing(AsyncPlayerChatEvent e, Player player, String listenWord, String message1, String message2, String message3, String message4)
	{
		defaultKeywords event = new defaultKeywords(listenWord, e.getMessage());
		if (e.getMessage().contains(event.detected())) {
			if (!botDefault.contains(player.getName() + "." + listenWord)) {
				keywordMessage.rigelSaysEveryone(player, message1, message2, message3, message4);
			botDefault.add(player.getName() + "." + listenWord);
			}
		}
	}
	
	public static void wholeKeyWords(Player player, AsyncPlayerChatEvent e) {
		
		
		hallOfTheMountainKing(e, player, "event", 
				"&aSelam &b" + player.getName() + " &aEventlerin listesi:", 
				"&aHer G�n &e18:00 &ave &e20:00 &ada &cBOSS&a ve her &6Pazar &e18:50&a'de &4FETIH Sava��", 
				"&aS�reli etkinlikler i�in:&b&n http://bit.ly/2lRcJd6", 
				"&aAyr�ca rastgele zamanlarda &4&lGM&a'ler event yapabiliyor. �neri i�in &f/dc");
		
		hallOfTheMountainKing(e, player, "viktor", 
				"&aSelam &b" + player.getName() + " &aViktor bir bosstur:",
				"&aHer g�n saat &e20:00 &ada ��kar ve �l�rksen 10 blok yak�n�ndaki herkese �d�l verir.", 
				"&aAyr�ca g�revleri yaparak viktoru par�omen olarak da alabilirsin.", 
				"&aDaha basittir ve arkada�lar�nla kesip �d�l� payla�abilirsin.&b&n http://bit.ly/2lY3Wpv");
		
		hallOfTheMountainKing(e, player, "demonia", 
				"&aSelam &b" + player.getName() + " &3Demonia&a bir bosstur:",
				"&aHer g�n saat &e18:00 &ada ��kar ve �l�rksen 10 blok yak�n�ndaki herkese �d�l verir.", 
				"&aAyr�ca g�revleri yaparak &3Demoniay�&a par�omen olarak da alabilirsin.", 
				"&aPar�omen daha basittir ve arkada�lar�nla kesebilirsin.&b&n http://bit.ly/2lY3Wpv");
		
		hallOfTheMountainKing(e, player, "g�rev", 
				"&aSelam &b" + player.getName() + " &aG�revler 2 ye ayr�l�r:",
				"&dAda g�revleri&a, adan� b�y�t�r ve �nvan verir. &f/c", 
				"&dSpawn G�revleri&a, g�nl�k par�omen alman� sa�lar.&b&n http://bit.ly/2mdf2XV", 
				null);
		
		if (player.hasPermission("sinif.elyon") || player.hasPermission("sinif.xiviel")) {
			
			String perm;
			if (player.hasPermission("sinif.xiviel")) {perm = "&cXiviel";} else perm = "&bElyon";
			
			hallOfTheMountainKing(e, player, "fetih",
					"&aSelam &b" + player.getName() + " &aFetih bir sava�t�r.",
					"&aHer &6Pazar &e18:50 &ade &akay�tlar� a��l�r. Bir " + perm + " &aolarak sava�tan ka�ma!", 
					"&aKazanan taraf�n en �ok kill alan�na 1 haftal�k &b&lVIP &aolan &c&lSK &averilir.", 
					"&aVe ayr�ca kat�lan, kazanan/kaybeden herkes �d�l al�r. Fakat miktarlar� de�i�ir.&b&n http://bit.ly/2kNSNaO");}
		else {
			hallOfTheMountainKing(e, player, "fetih",
					"&aSelam &b" + player.getName() + " &aFetih bir sava�t�r.",
					"&aHer &6Pazar &e18:50 &ade &akay�tlar� a��l�r. &4&lNOT: &cHen�z s�n�f se�memi�sin &f/sinif &cyaz!",
					"&aKazanan taraf�n en �ok kill alan�na 1 haftal�k &b&lVIP &aolan &c&lSK &averilir.", 
					"&aVe ayr�ca kat�lan, kazanan/kaybeden herkes �d�l al�r. Fakat miktarlar� de�i�ir.&b&n http://bit.ly/2kNSNaO");}
		
		
		hallOfTheMountainKing(e, player, "boss", 
				"&aSelam &b" + player.getName() + " &aBosslar�n listesi:", 
				"&aHer G�n &e18:00&a da &a&lVIKTOR &ave &e20:00 &ada &3&lDEMONIA &a��kar.", 
				"&aD�nya bosslar� kendi warp�nda, par�omen bosslar� adada do�ar.", 
				"&aAyr�ca detay istiyorsan bana sorabilirsin &c:) &b&nhttp://bit.ly/2lY3Wpv");
		
		hallOfTheMountainKing(e, player, "par�omen", 
				"&aSelam &b" + player.getName() + " &aPar�omen bosslar�:", 
				"&a&lVIKTOR &ave &3&lDEMONIA &an�n ill�zyonlar�d�r ve daha g��s�z�d�r.", 
				"&aSpawndaki g�revleri yaparak par�omenleri elde edebilirsin.", 
				"&aAyr�ca detay istiyorsan bana sorabilirsin :) &b&nhttp://bit.ly/2lY3Wpv");
		
		
		

	}

}
