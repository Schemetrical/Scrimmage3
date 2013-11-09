package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import org.bukkit.Material;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to control removal of items on item spawn
 *
 * @author Jake0oo0
 */
public class ItemRemoveModule extends Module {

    List<Material> items = new ArrayList<Material>();
    /**
     * Default constructor using superclass Module constructor
     *
     * @param mat
     * @param map
     */
    public ItemRemoveModule(Match mat, Map map) {
        super(mat, map);
        items = new ArrayList<Material>();
        Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "itemremove");
        if (n != null) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                NodeList ns = n.getChildNodes();
                for (int c = 0; c < ns.getLength(); c++) {
                    Node nc = ns.item(c);
                    if (nc.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nc;
                        String matString = e.getTextContent();
                        Material material = StringUtils.getMaterialFromString(matString);
                        items.add(material);
                    }
                }
            }
        }
    }

    /**
     * @return List of materials to remove on spawn
     */
    public List<Material> getItems() {
        return items;
    }

}
