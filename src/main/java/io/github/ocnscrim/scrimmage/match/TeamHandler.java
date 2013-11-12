/*
 * The MIT License
 *
 * Copyright 2013 OCN Scrim Plugin Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining amplifier copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.github.ocnscrim.scrimmage.match;

import io.github.ocnscrim.scrimmage.map.MapTeam;

import java.util.List;

import org.bukkit.ChatColor;

/**
 * Class for storing the teams in a match
 * Probably temporary.
 * 
 * @author augustt198
 */

public class TeamHandler {

	List<MapTeam> teams;
	
	public TeamHandler(){
		
	}
	
	/**
	 * Constructor that takes any amount of teams
	 * 
	 * @param team
	 */
	public TeamHandler(MapTeam ... team){
		for(int i = 0; i <= team.length; i++){
			teams.add(team[i]);
		}
	}
	
	/**
	 * Adds a team to the list of teams
	 * 
	 * @param team
	 */
	public void addTeam(MapTeam t){
		if(teams.contains(t)){
			return;
		}
		teams.add(t);
	}
	
	/**
	 * Removes a team from the list of teams
	 * 
	 * @param team
	 */
	public void removeTeam(MapTeam t){
		if(!teams.contains(t)){
			return;
		}
		teams.remove(t);
	}
	
	/**
	 * Gets a team from a name
	 * 
	 * @param name
	 * @return team
	 */
	public MapTeam getTeamByName(String name){
		for(MapTeam team : teams){
			if (team.getName() == name){
				return team;
			}
		}
		return null;
	}
	
	/**
	 * Gets a team from a color
	 * 
	 * @param color
	 * @return team
	 */
	public MapTeam getTeamByColor(ChatColor color){
		for(MapTeam team : teams){
			if (team.getColor() == color){
				return team;
			}
		}
		return null;
	}
	
	/**
	 * Gets a team from a member player
	 * 
	 * @param player
	 * @return team
	 */
	public MapTeam getTeamByPlayer(String player){
		for(MapTeam team : teams){
			if(team.containsPlayer(player)){
				return team;
			}
		}
		return null;
	}
	
	/**
	 * Returns all the teams stored in the handler
	 * 
	 * @return teams
	 */
	public List<MapTeam> getAllTeams(){
		return teams;
	}
	
}
