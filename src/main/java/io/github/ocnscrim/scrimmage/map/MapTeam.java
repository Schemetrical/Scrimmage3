/*
 * The MIT License
 *
 * Copyright 2013 Maxim Salikhov.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
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
package io.github.ocnscrim.scrimmage.map;

import org.bukkit.ChatColor;

/**
 * Class serving to store information regarding a team, such as player count,
 * color and name.
 * 
 * @author Maxim Salikhov
 */
public class MapTeam {

	String n;
	ChatColor c;
	Integer m;
	Integer o;

	/**
	 * Basic constructor for a MapTeam, getting all parameters from constructor.
	 * 
	 * @param name
	 * @param color
	 * @param max
	 * @param overfill
	 */
	public MapTeam(String name, ChatColor color, Integer max, Integer overfill) {
		n = name;
		c = color;
		m = max;
		o = overfill;
	}

	/**
	 * Constructor that does not require maximum overfill, and sets it to 25%
	 * over maximum integer.
	 * 
	 * @param name
	 * @param color
	 * @param max
	 */
	public MapTeam(String name, ChatColor color, Integer max) {
		n = name;
		c = color;
		m = max;
		o = (Integer) Math.round((float) ((0.25 * max) * 100)) + max;
	}

	/**
	 * Returns the name of the team as specified in the constructor.
	 * 
	 * @return string with team name
	 */
	public String getName() {
		return n;
	}

	/**
	 * Returns the ChatColor of the team as specified in the constructor.
	 * 
	 * @return ChatColor of the team
	 */
	public ChatColor getColor() {
		return c;
	}

	/**
	 * Returns the maximum amount of players that can join the team.
	 * 
	 * @return integer with max players on team
	 */
	public Integer getMax() {
		return m;
	}

	/**
	 * Returns the overfill amount of players that can join the team. This is
	 * the absolute limit for joining a team.
	 * 
	 * @return integer with overfill players on team
	 */
	public Integer getOverfill() {
		return o;
	}

}
