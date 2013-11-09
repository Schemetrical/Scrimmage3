package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import org.bukkit.event.entity.EntityDamageEvent;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DisableDamageModule extends Module {

    List<EntityDamageEvent.DamageCause> damages;

    public DisableDamageModule(Match mat, Map map) {
        super(mat, map);
        damages = new ArrayList<EntityDamageEvent.DamageCause>();
        Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "disabledamage");
        if (n != null) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                NodeList ns = n.getChildNodes();
                for (int c = 0; c < ns.getLength(); c++) {
                    Node nc = ns.item(c);
                    if (nc.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nc;
                        String damage = e.getTextContent();
                        damages.add(StringUtils.getDamageCauseFromString(damage));
                    }
                }
            }
        }
    }
}
