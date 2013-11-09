package io.github.ocnscrim.scrimmage.modules;


import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import org.w3c.dom.Node;

public class TimeLockModule extends Module {
    boolean enabled;

    public TimeLockModule(Match mat, Map map) {
        super(mat, map);
        Node n = XMLUtils.getFirstNodeByName(x.getDoc(), "timelock");
        if (n != null) {
            enabled = StringUtils.parseBoolean(n.getTextContent());
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

}
