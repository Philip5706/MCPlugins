package de.philip.Lobby.Scoreboard;

import org.bukkit.entity.Player;

import de.philip.Main.Main;
import net.md_5.bungee.api.ChatColor;

public class Scoreboard extends ScoreboardBuilder {
	
	private Main plugin;

	public Scoreboard(Player player) {
		super(player, ChatColor.GREEN.toString() + "        Testserver        ");
	}
	
	@Override
	public void createScoreboard() {
		
		setScore(ChatColor.DARK_GRAY.toString(), 13);
		setScore(ChatColor.BLUE + player.getName(), 12);
		setScore(ChatColor.DARK_PURPLE.toString(), 11);
		setScore(ChatColor.AQUA + "Rank:", 10);
		
		if (player.isOp()) {
			setScore(ChatColor.DARK_AQUA + "Operator", 9);
		}else
			setScore(ChatColor.GRAY + "Spieler", 9);

		setScore(ChatColor.DARK_GREEN.toString(), 8);
		setScore(ChatColor.BLACK + "Spielzeit:", 7);
		
		String spielzeit = plugin.getConfig().getInt("OnlineTime." + player.getName() + ".hours") + ":" + plugin.getConfig().getInt("OnlineTime." + player.getName() + ".minutes");

		setScore(ChatColor.WHITE + spielzeit, 6);


	}
	
	@Override
	public void update() {
		
	}
}
