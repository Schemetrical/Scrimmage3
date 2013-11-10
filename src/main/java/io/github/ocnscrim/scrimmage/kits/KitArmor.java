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

import io.github.ocnscrim.scrimmage.utils.Log;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Class for storing a piece of information about a piece of armor per XML
 *
 * @author Maxim Salikhov
 */
public class KitArmor {

	KitArmorType t;
	Material m;
	List<Enchantment> e;
	List<Integer> el;
	String l;
	String n;
	int d;
	String c;
	ItemStack is;

	/**
	 * Constructor requesting all info about an item. It is possible for some
	 * values to be null.
	 *
	 * @param type
	 * @param mat
	 * @param enchantment
	 * @param lore
	 * @param name
	 * @param damage
	 * @param color
	 */
	public KitArmor(KitArmorType type, Material mat, String enchantment,
		String lore, String name, int damage, String color) {
		e = new ArrayList<>();
		el = new ArrayList<>();
		t = type;
		m = mat;
		l = lore;
		n = name;
		d = damage;
		c = color;
		if (enchantment != null) {
			String[] enchs = enchantment.split(";");
			for (String str : enchs) {
				String[] enchi = str.split(":");
				Enchantment ench = StringUtils.getEnchantmentFromString(enchi[0]);
				try {
					Integer lvl = Integer.parseInt(enchi[1]);
					e.add(ench);
					el.add(lvl);
				} catch (NumberFormatException ex) {
					Log.log(Level.SEVERE, "[XML-Parse-Error] Could not parse integer from string!");
				}
			}
		}
		is = new ItemStack(m);
		if (d != 0) {
			is.setDurability((short) d);
		}
		if (l != null) {
			ItemMeta im = is.getItemMeta();
			String[] lorelist = l.split("|");
			List<String> ll = new ArrayList<>();
			for (String s : lorelist) {
				ll.add(StringUtils.addChatColorToString(s));
			}
			im.setLore(ll);
		}
		if (n != null) {
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(StringUtils.addChatColorToString(n));
		}
		if (c != null) {
			if (mat == Material.LEATHER_BOOTS || mat == Material.LEATHER_LEGGINGS || mat == Material.LEATHER_CHESTPLATE || mat == Material.LEATHER_HELMET) {
				LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
				im.setColor(StringUtils.getColorFromString(c));

			}
		}
		if (e != null && el != null) {
			int count = 0;
			for (Enchantment ec : e) {
				Integer lev = el.get(count);
				is.addEnchantment(ec, lev);
			}
		}
	}

	/**
	 * Applies the specific piece of armor to the player's according slot
	 *
	 * @param p Player to apply armor to
	 */
	public void apply(Player p) {
		switch (t) {
			case HELMET:
				p.getInventory().setHelmet(is);
				break;
			case CHESTPLATE:
				p.getInventory().setChestplate(is);
				break;
			case LEGGINGS:
				p.getInventory().setLeggings(is);
				break;
			case BOOTS:
				p.getInventory().setBoots(is);
				break;
		}
	}

}
