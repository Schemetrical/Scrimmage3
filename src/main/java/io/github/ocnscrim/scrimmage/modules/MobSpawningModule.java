package io.github.ocnscrim.scrimmage.modules;

import java.util.ArrayList;
import java.util.List;

import io.github.ocnscrim.scrimmage.map.Map;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.StringUtils;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;

import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("deprecation")
public class MobSpawningModule extends Module{

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
						switch(e.getTagName()) {
							case "mob":
								allowedMobs = new ArrayList<CreatureType>();
								allowedMobs.add(StringUtils.getCreatureTypeFromString(e.getTextContent()));
								break;
							case "entity":
								allowedEntities = new ArrayList<EntityType>();
								allowedEntities.add(StringUtils.getEntityTypeFromString(e.getTextContent()));
								break;
							case "spawn":	
								allowedSpawns = new ArrayList<String>();
								if(StringUtils.validSpawnReason(e.getTextContent())){
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
    public List<CreatureType> getAllowedMobs(){
        return allowedMobs;
    }
    
    /**
     * @return All the allowed entities
     */
    public List<EntityType> getAllowedEntities(){
    	return allowedEntities;
    }
    
    /**
     * @return All the allowed spawn reasons
     */
    public List<String> getAllowedSpawns(){
    	return allowedSpawns;
    }
}
