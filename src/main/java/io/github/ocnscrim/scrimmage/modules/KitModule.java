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
package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.kits.Kit;
import io.github.ocnscrim.scrimmage.kits.KitArmor;
import io.github.ocnscrim.scrimmage.kits.KitArmorType;
import io.github.ocnscrim.scrimmage.kits.KitItem;
import io.github.ocnscrim.scrimmage.kits.KitPotion;
import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.PotionUtils;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.TimeUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffectType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class to control potion effects a player spawns with
 *
 * @author Maxim Salikhov
 */
public class KitModule extends Module {

	java.util.Map<String, Kit> kits;

	/**
	 * Default constructor using superclass Module constructor
	 *
	 * @param mat
	 * @param map
	 */
	public KitModule(Match mat, Map map) {
		super(mat, map);
		kits = new HashMap<>();
		Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "kits");
		if (n != null) {
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				NodeList ns = n.getChildNodes();
				for (int c = 0; c < ns.getLength(); c++) {
					Node nc = ns.item(c);
					if (nc.getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) nc;
						if ("kit".equals(e.getTagName())) {
							String name = e.getAttribute("name");
							List<KitItem> ki = new ArrayList<>();
							List<KitArmor> ka = new ArrayList<>();
							List<KitPotion> kp = new ArrayList<>();
							if (e.hasAttribute("parents")) {
								Kit parent = kits.get(e.getAttribute("parents"));
								NodeList nsc = e.getChildNodes();
								for (int cc = 0; cc < nsc.getLength(); cc++) {
									Node ncs = nsc.item(cc);
									if (ncs.getNodeType() == Node.ELEMENT_NODE) {
										Element ec = (Element) ncs;
										int slot;
										Material material;
										String ench;
										String lore;
										String iname;
										int damage;
										String color;
										PotionEffectType poteff;
										int potiondur;
										int potionamp;
										boolean ambient;
										switch (ec.getTagName()) {
											case "item":
												slot = Integer.parseInt(ec.getAttribute("slot"));
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												ki.add(new KitItem(slot, material, ench, lore, iname, damage));
												break;
											case "helmet":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.HELMET, material, ench, lore, iname, damage, color));
												break;
											case "chestplate":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.CHESTPLATE, material, ench, lore, iname, damage, color));
												break;
											case "leggings":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.LEGGINGS, material, ench, lore, iname, damage, color));
												break;
											case "boots":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.BOOTS, material, ench, lore, iname, damage, color));
												break;
											case "potion":
												poteff = PotionUtils.getPotionEffectTypeFromString(ec.getTextContent());
												if (ec.hasAttribute("duration")) {
													potiondur = TimeUtils.parseTimeStringIntoSecs(ec.getAttribute("duration"));
												} else {
													potiondur = 10;
												}
												if (ec.hasAttribute("ambient")) {
													if (ec.getAttribute("ambient").equals("true")) {
														ambient = true;
													} else {
														ambient = false;
													}
												} else {
													ambient = false;
												}
												potionamp = Integer.parseInt(ec.getAttribute("amplifier"));
												kp.add(new KitPotion(poteff, potiondur, potionamp, ambient));
												break;
										}
									}
								}
								kits.put(name, new Kit(name, parent, ki, ka, kp));
							} else {
								NodeList nsc = e.getChildNodes();
								for (int cc = 0; cc < nsc.getLength(); cc++) {
									Node ncs = nsc.item(cc);
									if (ncs.getNodeType() == Node.ELEMENT_NODE) {
										Element ec = (Element) ncs;
										int slot;
										Material material;
										String ench;
										String lore;
										String iname;
										int damage;
										String color;
										PotionEffectType poteff;
										int potiondur;
										int potionamp;
										boolean ambient;
										switch (ec.getTagName()) {
											case "item":
												slot = Integer.parseInt(ec.getAttribute("slot"));
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												ki.add(new KitItem(slot, material, ench, lore, iname, damage));
												break;
											case "helmet":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.HELMET, material, ench, lore, iname, damage, color));
												break;
											case "chestplate":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.CHESTPLATE, material, ench, lore, iname, damage, color));
												break;
											case "leggings":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.LEGGINGS, material, ench, lore, iname, damage, color));
												break;
											case "boots":
												material = StringUtils.getMaterialFromString(ec.getTextContent());
												ench = ec.getAttribute("enchantment");
												lore = ec.getAttribute("lore");
												iname = ec.getAttribute("name");
												damage = Integer.parseInt(ec.getAttribute("damage"));
												color = ec.getAttribute("color");
												ka.add(new KitArmor(KitArmorType.BOOTS, material, ench, lore, iname, damage, color));
												break;
											case "potion":
												poteff = PotionUtils.getPotionEffectTypeFromString(ec.getTextContent());
												if (ec.hasAttribute("duration")) {
													potiondur = TimeUtils.parseTimeStringIntoSecs(ec.getAttribute("duration"));
												} else {
													potiondur = 10;
												}
												if (ec.hasAttribute("ambient")) {
													if (ec.getAttribute("ambient").equals("true")) {
														ambient = true;
													} else {
														ambient = false;
													}
												} else {
                                                ambient = false;
                                            }
												potionamp = Integer.parseInt(ec.getAttribute("amplifier"));
												kp.add(new KitPotion(poteff, potiondur, potionamp, ambient));
												break;
										}
									}
								}
								kits.put(name, new Kit(name, ki, ka, kp));
							}
						}
					}
				}
			}
		}
	}
}
