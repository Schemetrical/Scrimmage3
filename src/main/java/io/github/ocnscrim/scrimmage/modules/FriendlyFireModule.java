/*
 * The MIT License
 *
 * Copyright 2013 Jake0oo0.
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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class to control friendly fire
 *
 * @author Jake0oo0
 */
public class FriendlyFireModule extends Module {
    boolean friendlyFire;
    boolean refund;
    /**
     * Default constructor using superclass Module constructor
     *
     * @param mat
     * @param map
     */
    public FriendlyFireModule(Match mat, Map map) {
        super(mat, map);
        friendlyFire = false;
        refund = true;
        Node n = XMLUtils.getFirstNodeByName(document.getDoc(), "friendlyfire");
        if (n != null) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                NodeList ns = n.getChildNodes();
                for (int c = 0; c < ns.getLength(); c++) {
                    Node nc = ns.item(c);
                    if (nc.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nc;
                        friendlyFire = StringUtils.parseBoolean(e.getTextContent());
                    }
                }
            }
        }

        Node nF = XMLUtils.getFirstNodeByName(document.getDoc(), "friendlyfirerefund");
        if (nF != null) {
            if (nF.getNodeType() == Node.ELEMENT_NODE) {
                NodeList ns = nF.getChildNodes();
                for (int c = 0; c < ns.getLength(); c++) {
                    Node nc = ns.item(c);
                    if (nc.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nc;
                        refund = StringUtils.parseBoolean(e.getTextContent());
                    }
                }
            }
        }
    }

    public boolean isFriendlyFire() {
        return friendlyFire;
    }

    public boolean isRefund() {
        return refund;
    }
}
