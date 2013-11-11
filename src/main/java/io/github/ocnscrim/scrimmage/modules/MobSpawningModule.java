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
package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("deprecation")
public class MobSpawningModule extends Module {

	List<CreatureType> allowedMobs;
	List<EntityType> allowedEntities;
	List<String> allowedSpawns;

	/**
	 * Default constructor using superclass Module constructor
	 *
	 * @param mat
	 * @param map
	 */
	public MobSpawningModule(Match mat, Map map) {
		super(mat, map);

		Node n = XMLUtils.getFirstNodeByName(document.getDoc(), "mobs");
		if (n != null) {
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				NodeList ns = n.getChildNodes();
				for (int c = 0; c < ns.getLength(); c++) {
					Node nc = ns.item(c);
					if (nc.getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) nc;
						switch (e.getTagName()) {
							case "mob":
								allowedMobs = new ArrayList<>();
								allowedMobs.add(StringUtils.getCreatureTypeFromString(e.getTextContent()));
								break;
							case "entity":
								allowedEntities = new ArrayList<>();
								allowedEntities.add(StringUtils.getEntityTypeFromString(e.getTextContent()));
								break;
							case "spawn":
								allowedSpawns = new ArrayList<>();
								if (StringUtils.validSpawnReason(e.getTextContent())) {
									allowedSpawns.add(e.getTextContent());
								}
								break;
						}
					}
				}
			}
		}
	}

	/**
	 * @return All the allowed mobs
	 */
	public List<CreatureType> getAllowedMobs() {
		return allowedMobs;
	}

	/**
	 * @return All the allowed entities
	 */
	public List<EntityType> getAllowedEntities() {
		return allowedEntities;
	}

	/**
	 * @return All the allowed spawn reasons
	 */
	public List<String> getAllowedSpawns() {
		return allowedSpawns;
	}
}
