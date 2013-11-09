package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HungerModule extends Module {
    boolean depletes;

    public HungerModule(Match mat, Map map) {
        super(mat, map);
        Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "hunger");
        if (n != null) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                NodeList ns = n.getChildNodes();
                for (int c = 0; c < ns.getLength(); c++) {
                    Node nc = ns.item(c);
                    if (nc.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nc;
                        depletes = StringUtils.parseBoolean(e.getTextContent());
                    }
                }
            }
        }
    }

    public boolean isDepleting() {
        return depletes;
    }
}
