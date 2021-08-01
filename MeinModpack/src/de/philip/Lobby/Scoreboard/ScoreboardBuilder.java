package de.philip.Lobby.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public abstract class ScoreboardBuilder {

	protected final Scoreboard scoreboard_seite;
	protected final Objective objective_seite;
	
	protected final Player player;
	
	public ScoreboardBuilder(Player player, String displayName) {
		this.player = player;
		
		if (player.getScoreboard().equals(Bukkit.getScoreboardManager().getMainScoreboard())) {
			player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		}
		
		this.scoreboard_seite = player.getScoreboard();
		
		if (this.scoreboard_seite.getObjective("display") != null) {
			this.scoreboard_seite.getObjective("display").unregister();
		}
				
		this.objective_seite = this.scoreboard_seite.registerNewObjective("display", "dummy", displayName);
		this.objective_seite.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		createScoreboard();
	}
	
	public abstract void createScoreboard();
	
	public abstract void update();
	
	public void setDisplayName(String displayName) {
		this.objective_seite.setDisplayName(displayName);
	}
	
	public void setScore(String content, int score) {
		this.objective_seite.getScore(content).setScore(score);
	}
	
	public void removeScore(String content) {
		this.scoreboard_seite.resetScores(content);
	}
	
}
