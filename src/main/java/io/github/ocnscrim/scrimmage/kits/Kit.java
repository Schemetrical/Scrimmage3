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
package io.github.ocnscrim.scrimmage.kits;

import java.util.List;

import io.github.ocnscrim.scrimmage.modules.HungerModule;
import org.bukkit.entity.Player;

/**
 * Class containing KitItem, KitArmor, KitPotion lists according to the XML
 *
 * @author Maxim Salikhov
 */
public class Kit {

	String n;
	List<KitItem> ki;
	List<KitArmor> ka;
	List<KitPotion> kp;
    KitHunger kh;
    KitHealth ke;

	/**
	 * Basic constructor for a kit, without a parent
	 *
	 * @param name
	 * @param kiti List with the KitItem classes
	 * @param kita List with the KitArmor classes
	 * @param kitp List with the KitPotion class
	 */
	public Kit(String name, List<KitItem> kiti, List<KitArmor> kita, List<KitPotion> kitp) {
		n = name;
		ki = kiti;
		ka = kita;
		kp = kitp;
        kh = new KitHunger(20, 5.0F);
        ke = new KitHealth(20, 20);
	}

	/**
	 * Constructor for a kit with a parent kits. Adds the parent kit to the
	 * itself.
	 *
	 * @param name
	 * @param parent
	 * @param kiti List with the KitItem classes
	 * @param kita List with the KitArmor classes
	 * @param kitp List with the KitPotion class
	 */
	public Kit(String name, Kit parent, List<KitItem> kiti, List<KitArmor> kita, List<KitPotion> kitp) {
		n = name;
		ki = kiti;
		ka = kita;
		kp = kitp;
        kh = new KitHunger(20, 5.0F);
        ke = new KitHealth(20, 20);
		for (KitItem it : parent.getItems()) {
			ki.add(it);
		}
		for (KitArmor ar : parent.getArmor()) {
			ka.add(ar);
		}
		for (KitPotion po : parent.getPotions()) {
			kp.add(po);
		}
	}

	/**
	 * Returns a list of the items in the kit
	 *
	 * @return List with KitItem objects
	 */
	public List<KitItem> getItems() {
		return ki;
	}

	/**
	 * Returns a list with the armor in the kit
	 *
	 * @return List with KitArmor objects
	 */
	public List<KitArmor> getArmor() {
		return ka;
	}

	/**
	 * Return a list with the potions in the kit
	 *
	 * @return List with KitPotion objects
	 */
	public List<KitPotion> getPotions() {
		return kp;
	}

	/**
	 * Applies the kit to a specified player
	 *
	 * @param p Player to apply the kit to
	 */
	public void applyKit(Player p) {

	}

}
