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

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.map.MapTeam;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import java.util.List;
import org.bukkit.ChatColor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class that is used for controlling teams based on XML
 *
 * @author Maxim Salikhov
 */
public class TeamModule extends Module {

	List<MapTeam> t;

	/**
	 * Basic constructor for TeamModule, utilizing the the inherited constructor
	 * from Module.
	 *
	 * @param mat
	 * @param map
	 */
	public TeamModule(Match mat, Map map) {
		super(mat, map);
		Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "teams");
		if (n != null) {
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) n;
				NodeList ns = e.getChildNodes();
				for (int c = 0; c < ns.getLength(); c++) {
					Node n_chi = ns.item(c);
					if (n_chi.getNodeType() == Node.ELEMENT_NODE) {
						Element ec = (Element) n_chi;
						String name = ec.getTextContent();
						ChatColor cl = StringUtils.getChatColorFromString(ec.getAttribute("color"));
						Integer max = Integer.parseInt(ec.getAttribute("max"));
						if (ec.getAttribute("max-overfill") != null) {
							t.add(new MapTeam(name, cl, max, Integer.parseInt(ec.getAttribute("max-overfill"))));
						} else {
							t.add(new MapTeam(name, cl, max));
						}
					}
				}
			}
		}
	}

}
