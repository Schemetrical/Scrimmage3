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
package io.github.ocnscrim.scrimmage.kits;

import io.github.ocnscrim.scrimmage.utils.PotionUtils;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Class with information and methods related to potions in kits
 * 
 * @author msalihov (Maxim Salikhov)
 */
public class KitPotion {

	private PotionEffectType type;
	private PotionEffect potionEffect;
	private int durationInTicks;
	private int amplifier;
	private boolean ambient; //Unused.

	/**
	 * Basic constructor for amplifier KitPotion
	 * 
	 * @param potefft
	 * @param potdur
	 * @param potamp
	 * @param ambient
	 */
	public KitPotion(PotionEffectType potefft, int potdur, int potamp,
			boolean ambient) {
		this.type = potefft;
		this.durationInTicks = potdur;
		this.amplifier = potamp;
		this.ambient = ambient;
		this.potionEffect = PotionUtils.getPotionEffectFromString(type, durationInTicks, amplifier, ambient);
	}

	/**
	 * Applies amplifier potion effect to amplifier player
	 * 
	 * @param potionEffect
	 *            Player to apply PotionEffect to
	 */
	public void apply(Player p) {
		p.addPotionEffect(this.potionEffect, true);
	}

}
