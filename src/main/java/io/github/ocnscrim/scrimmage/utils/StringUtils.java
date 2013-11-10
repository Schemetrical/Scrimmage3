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
package io.github.ocnscrim.scrimmage.utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Class with some string utilities
 * 
 * @author Maxim Salikhov
 */
public class StringUtils {

	/**
	 * Returns the ChatColor based on the string that has been put in
	 * 
	 * @param s
	 * @return ChatColor resulting from string
	 */
	public static ChatColor getChatColorFromString(String s) {
		s = s.replaceAll(" ", "_").toUpperCase();
		return ChatColor.getByChar(s);
	}

	/**
	 * Converts a hexadecimal color string into a Bukkit Color
	 * 
	 * @param s
	 * @return Bukkit Color
	 */
	public static Color getColorFromString(String s) {
		return Color.fromRGB(java.awt.Color.decode(s).getRGB());
	}

	/**
	 * Returns enchantment from based on the input string
	 * 
	 * @param s
	 * @return Enchantment based on string
	 */
	public static Enchantment getEnchantmentFromString(String s) {
		s = s.replaceAll(" ", "_").toUpperCase();
		return Enchantment.getByName(s);
	}

	/**
	 * Adds ChatColor to a string
	 * 
	 * @param s
	 * @return String with ChatColor added
	 */
	public static String addChatColorToString(String s) {
		s = ChatColor.translateAlternateColorCodes('`', s);
		s = ChatColor.translateAlternateColorCodes('§', s);
		return s;
	}

	/**
	 * Returns the Material based on the string put in
	 * 
	 * @param s
	 * @return Material resulting from string
	 */
	public static Material getMaterialFromString(String s) {
		s = s.replaceAll(" ", "_").toUpperCase();
		return Material.getMaterial(s);
	}

	/**
	 * Returns the DamageCause based on the string that has been put in
	 * 
	 * @param s
	 * @return DamageCause resulting from string
	 */
	public static EntityDamageEvent.DamageCause getDamageCauseFromString(String s) {
		for (EntityDamageEvent.DamageCause cause : EntityDamageEvent.DamageCause.values()) {
			if (cause.name().equalsIgnoreCase(s)) {
				return cause;
			}
		}
		return null;
	}

	/**
	 * @param s
	 * @return Boolean crreated from on/off
	 */
	public static boolean parseBoolean(String s) {
		switch (s) {
			case "on" :
				return true;
			case "off" :
				return false;
		}

		return false;
	}

    public static EntityType getEntityTypeFromString(String s) {
        String mod = s.replaceAll("", "_").toUpperCase();
        for (EntityType type : EntityType.values()) {
            if (type.name().equalsIgnoreCase(mod)) {
                return type;
            }
        }
    }


}
