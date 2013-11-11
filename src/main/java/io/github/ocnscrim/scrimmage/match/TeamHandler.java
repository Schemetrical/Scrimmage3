package io.github.ocnscrim.scrimmage.match;

import io.github.ocnscrim.scrimmage.map.MapTeam;

import java.util.List;

import org.bukkit.ChatColor;

public class TeamHandler {

	List<MapTeam> teams;
	
	public TeamHandler(){
		
	}
	
	public TeamHandler(MapTeam ... team){
		for(int i = 0; i <= team.length; i++){
			teams.add(team[i]);
		}
	}
	
	public void addTeam(MapTeam t){
		if(teams.contains(t)){
			return;
		}
		teams.add(t);
	}
	
	public void removeTeam(MapTeam t){
		if(!teams.contains(t)){
			return;
		}
		teams.remove(t);
	}
	
	public MapTeam getTeamByName(String name){
		for(MapTeam team : teams){
			if (team.getName() == name){
				return team;
			}
		}
		return null;
	}
	
	public MapTeam getTeamByColor(ChatColor color){
		for(MapTeam team : teams){
			if (team.getColor() == color){
				return team;
			}
		}
		return null;
	}
	
	public MapTeam getTeamByPlayer(String player){
		for(MapTeam team : teams){
			if(team.containsPlayer(player)){
				return team;
			}
		}
		return null;
	}
	
}
