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

package io.github.ocnscrim.scrimmage.listeners;

import io.github.ocnscrim.scrimmage.Scrimmage;
import io.github.ocnscrim.scrimmage.map.MapTeam;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Class for listening to player logins
 * 
 * @author augustt198
 */
public class LoginListener implements Listener {

	final Scrimmage _i;
	
	/**
	 * Constructor for the listener
	 * 
	 * @param scrimmage instance
	 */
	public LoginListener(Scrimmage _i){
		this._i = _i;
	}
	
	/**
	 * Handles login event
	 * 
	 */
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event){
		MapTeam jointhis = _i.getTeamHandler().getTeamByName("Observer");
		if(jointhis != null){
			jointhis.addPlayer(event.getPlayer().getName());
		}
	}
	
}
