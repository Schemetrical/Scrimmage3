package io.github.ocnscrim.scrimmage.listeners;

import io.github.ocnscrim.scrimmage.Scrimmage;
import io.github.ocnscrim.scrimmage.map.MapTeam;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginListener implements Listener {

	final Scrimmage _i;
	
	public LoginListener(Scrimmage _i){
		this._i = _i;
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event){
		MapTeam jointhis = _i.getTeamHandler().getTeamByName("Observer");
		if(jointhis != null){
			jointhis.addPlayer(event.getPlayer().getName());
		}
	}
	
}
