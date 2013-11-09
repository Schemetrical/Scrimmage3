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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
		s = s.replaceAll(" ", "_");
		return ChatColor.getByChar(s);
	}

    /**
     * Returns the DamageCause based on the string that has been put in
     *
     * @param s
     * @return DamageCause resulting from string
     */
    public static EntityDamageEvent.DamageCause getDamageCauseFromString(String s){
        for(EntityDamageEvent.DamageCause cause : EntityDamageEvent.DamageCause.values()) {
            if (cause.name().equalsIgnoreCase(s)) return cause;
        }
        return null;
    }

    /**
     * Returns the PotionEffectType based on the string that has been put in
     *
     * @param s
     * @return PotionEffectType resulting from string
     */
    public static PotionEffectType getPotionEffectTypeFromString(String s){
        for(PotionEffectType effect : PotionEffectType.values()) {
            if (effect.getName().equalsIgnoreCase(s)) return effect;
        }
        return null;
    }

    /**
     * Returns a PotionEffect based on the arguments given
     *
     * @param effect
     * @param duration In seconds
     * @param level
     * @return PotionEffect
     */
    public static PotionEffect getPotionEffectFromString(String effect, int duration, int level) {
        if (getPotionEffectTypeFromString(effect) != null) {
            PotionEffectType type = getPotionEffectTypeFromString(effect);
            PotionEffect finalEffect = type.createEffect(duration * 20, level);
            return finalEffect;
        }
        return null;
    }
}
