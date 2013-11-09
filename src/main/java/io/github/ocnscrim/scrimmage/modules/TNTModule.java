package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class to control the attributes of TNT
 *
 * @author Jake0oo0
 */
public class TNTModule extends Module {
     boolean insta;
     boolean blockDamage;
     int yield;

    /**
     * Default constructor using superclass Module constructor
     *
     * @param mat
     * @param map
     */
    public TNTModule(Match mat, Map map) {
        super(mat, map);
        Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "tnt");
        if (n != null) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                NodeList ns = n.getChildNodes();
                for (int c = 0; c < ns.getLength(); c++) {
                    Node nc = ns.item(c);
                    if (nc.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nc;
                        switch(e.getTagName()) {
                            case "yield":
                                yield = Integer.parseInt(e.getTextContent());
                                break;
                            case "instantignite":
                                insta = Boolean.parseBoolean(e.getTextContent());
                                break;
                            case "blockdamaage":
                                blockDamage = Boolean.parseBoolean(e.getTextContent());
                                break;
                        }
                    }
                }
            }
        }
    }

    /**
     * @return Whether or not TNT is instantly ignited
     */
    public boolean isInstantIgnite() {
        return insta;
    }

    /**
     * @return Whether or not TNT does block damage
     */
    public boolean isBlockDamage() {
        return blockDamage;
    }

    /**
     * @return Yield of TNT explosions
     */
    public int getYield() {
        return yield;
    }
 }
