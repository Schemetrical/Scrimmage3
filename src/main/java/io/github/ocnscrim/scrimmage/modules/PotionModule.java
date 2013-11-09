package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import org.bukkit.potion.PotionEffect;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to control potion effects a player spawns with
 *
 * @author Jake0oo0
 */
public class PotionModule extends Module {

    List<PotionEffect> potions;

    /**
     * Default constructor using superclass Module constructor
     *
     * @param mat
     * @param map
     */
    public PotionModule(Match mat, Map map) {
        super(mat, map);
        potions = new ArrayList<PotionEffect>();
        Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "potions");
        if (n != null) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                NodeList ns = n.getChildNodes();
                for (int c = 0; c < ns.getLength(); c++) {
                    Node nc = ns.item(c);
                    if (nc.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nc;
                        String potionString = e.getTextContent();
                        // A potionString would look like 'NIGHT_VISION,30,1'
                        String[] array = potionString.split(",");
                        String type = array[0];
                        int duration = Integer.parseInt(array[1]);
                        int level = Integer.parseInt(array[2]);
                        potions.add(StringUtils.getPotionEffectFromString(type, duration, level));
                    }
                }
            }
        }
    }

    public List<PotionEffect> getPotions() {
        return potions;
    }
}
