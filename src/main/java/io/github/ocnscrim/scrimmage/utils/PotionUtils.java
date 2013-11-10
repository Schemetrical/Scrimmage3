/*
 * The MIT License
 *
 * Copyright 2013 OCN Scrim Plugin Team.
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

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Class with utilities regarding potions
 * 
 * @author msalihov (Maxim Salikhov)
 * @author Jake0oo0
 */
public class PotionUtils {

	/**
	 * Returns a PotionEffect based on the arguments given
	 * 
	 * @param type
	 * @param dur
	 *            in seconds
	 * @param amp
	 * @param ambient
	 * @return PotionEffect
	 */
	public static PotionEffect getPotionEffectFromString(PotionEffectType type,
			int dur, int amp, boolean ambient) {
		return new PotionEffect(type, dur, amp, ambient);
	}

	/**
	 * Returns the PotionEffectType based on the input string
	 * 
	 * @param s
	 * @return PotionEffectType based on string
	 */
	public static PotionEffectType getPotionEffectTypeFromString(String s) {
		s = s.replaceAll(" ", "_").toUpperCase();
		return PotionEffectType.getByName(s);
	}

}
