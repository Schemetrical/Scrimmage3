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
import io.github.ocnscrim.scrimmage.map.MapAuthor;
import io.github.ocnscrim.scrimmage.map.MapAuthor.MapAuthorType;
import io.github.ocnscrim.scrimmage.map.MapProtocol;
import io.github.ocnscrim.scrimmage.match.Match;
import io.github.ocnscrim.scrimmage.utils.XMLUtils;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Difficulty;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class with methods to return essential information about the map.
 *
 * @author Maxim Salikhov
 * @see Module
 * @see Map
 */
public class MapInfoModule extends Module {

	MapProtocol mproto;
	String mn;
	String mv;
	String mo;
	List<MapAuthor> ma;
    Difficulty dif;
    int mh;

	/**
	 * The basic constructor for MapInfoModule, has no function except to allow
	 * extending Module class.
	 *
	 * @param mat
	 * @param map
	 * @see Module
	 */
	public MapInfoModule(Match mat, Map map) {
		super(mat, map);
		mproto = new MapProtocol(x.getDoc().getDocumentElement()
			.getAttribute("proto"));
		Node n_name = XMLUtils.getFirstNodeByName(x.getDoc(), "name");
		if (n_name != null) {
			if (n_name.getNodeType() == Node.ELEMENT_NODE) {
				Element e_name = (Element) n_name;
				mn = e_name.getTextContent();
			}

		}
		Node n_ver = XMLUtils.getFirstNodeByName(x.getDoc(), "version");
		if (n_ver != null) {
			if (n_ver.getNodeType() == Node.ELEMENT_NODE) {
				Element e_ver = (Element) n_ver;
				mv = e_ver.getTextContent();
			}

		}
		Node n_obj = XMLUtils.getFirstNodeByName(x.getDoc(), "objective");
        if (n_obj != null) {
            if (n_obj.getNodeType() == Node.ELEMENT_NODE) {
                Element e_obj = (Element) n_obj;
                mo = e_obj.getTextContent();
            }

        }
        Node n_dif = XMLUtils.getFirstNodeByName(x.getDoc(), "difficulty");
        if (n_dif != null) {
            if (n_dif.getNodeType() == Node.ELEMENT_NODE) {
                Element e_dif = (Element) n_obj;
                dif = Difficulty.getByValue(Integer.parseInt(e_dif.getTextContent()));
            }
        }
        Node n_max = XMLUtils.getFirstNodeByName(x.getDoc(), "maxbuildheight");
        if (n_max != null) {
            if (n_max.getNodeType() == Node.ELEMENT_NODE) {
                Element e_max = (Element) n_obj;
                mh = Integer.parseInt(e_max.getTextContent());
            }
        }
		ma = new ArrayList<MapAuthor>();
		Node n_aut = XMLUtils.getFirstNodeByName(x.getDoc(), "authors");
		Node n_con = XMLUtils.getFirstNodeByName(x.getDoc(), "contributors");
		if (n_aut != null) {
			if (n_aut.getNodeType() == Node.ELEMENT_NODE) {
				Element e_aut = (Element) n_aut;
				NodeList ns_aut_child = e_aut.getChildNodes();
				for (int c_aut = 0; c_aut < ns_aut_child.getLength(); c_aut++) {
					Node n_aut_child = ns_aut_child.item(c_aut);
					if (n_aut_child.getNodeType() == Node.ELEMENT_NODE) {
						Element e_aut_child = (Element) n_aut_child;
						String authname = e_aut_child.getTextContent();
						String authcontrib = e_aut_child.getAttribute("contribution");
						ma.add(new MapAuthor(MapAuthorType.AUTHOR, authname, authcontrib));
					}
				}
			}
		}
		if (n_con != null) {
			if (n_con.getNodeType() == Node.ELEMENT_NODE) {
				Element e_con = (Element) n_con;
				NodeList ns_con_child = e_con.getChildNodes();
				for (int c_con = 0; c_con < ns_con_child.getLength(); c_con++) {
					Node n_con_child = ns_con_child.item(c_con);
					if (n_con_child.getNodeType() == Node.ELEMENT_NODE) {
						Element e_con_child = (Element) n_con_child;
						String authname = e_con_child.getTextContent();
						String authcontrib = e_con_child.getAttribute("contribution");
						ma.add(new MapAuthor(MapAuthorType.CONTRIBUTOR, authname, authcontrib));
					}
				}
			}
		}
	}

	/**
	 * Returns the MapProtocol object containing the map protocol from the XML.
	 *
	 * @return MapProtocol object according to XML
	 * @see MapProtocol
	 */
	public MapProtocol getMapProto() {
		return mproto;
	}

	/**
	 * Returns the map name specific in the XML as a string. Returns null if
	 * there is no such node or if the node is not an element.
	 *
	 * @return map name string according to XML
	 */
	public String getMapName() {
		return mn;
	}

	/**
	 * Returns the map version specified in the XML. Returns null if there is no
	 * such node or if the node is not an element.
	 *
	 * @return map version string according to XML
	 */
	public String getMapVersion() {
		return mv;
	}

	/**
	 * Returns the map objective specified in the XML. Returns null if there is
	 * no such node or if the node is not an element.
	 *
	 * @return map objective string according to XML
	 */
	public String getMapObjective() {
		return mo;
	}

	/**
	 * Returns the authors and contributors of the map in the form of the
	 * MapAuthor object. Returns empty list if there are no authors or
	 * contributors specified in the XML.
	 *
	 * @return list of map authors and contributors according to XML
	 * @see MapAuthor
	 */
	public List<MapAuthor> getMapAuthors() {
		return ma;
	}

    /**
     * Returns max build height of a map
     *
     * @return int max height
     */
    public int getMaxBuildHeight() {
        return mh;
    }

    /**
     * Returns Minecraft difficulty of the map's world
     *
     * @return Difficulty
     */
    public Difficulty getDifficulty() {
        return dif;
    }

}
