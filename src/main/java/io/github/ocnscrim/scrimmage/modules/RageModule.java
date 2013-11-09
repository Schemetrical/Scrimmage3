package io.github.ocnscrim.scrimmage.modules;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import org.w3c.dom.Node;

/**
 * Class to enable or disable the rage module
 *
 * @author Jake0oo0
 */
public class RageModule extends Module {
    boolean enabled;

    /**
     * Default constructor using superclass Module constructor
     *
     * @param mat
     * @param map
     */
    public RageModule(Match mat, Map map) {
        super(mat, map);
        enabled = false;
        Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "rage");
        if (n != null) {
            enabled = true;
        } else {
            enabled = false;
        }
    }

}
