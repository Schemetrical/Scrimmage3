/*
 * The MIT License
 *
 * Copyright 2013 OCN Scrim Plugin Team.
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
package io.github.ocnscrim.scrimmage.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to store MapProtocol information
 *
 * @author msalihov (Maxim Salikhov)
 */
public class MapProtocol {

	private String protocolString;
	private List<Integer> subversions;

	public MapProtocol(String str) {
		protocolString = str;
		subversions = new ArrayList<Integer>();
		String[] strs = protocolString.split(".");
		for (String s : strs) {
			subversions.add(Integer.parseInt(s));
		}
	}

	public String getString() {
		return protocolString;
	}

	public Integer getInt(int index) {
		if (index > subversions.size() - 1) {
			return null;
		} else {
			return subversions.get(index);
		}
	}

	public List<Integer> getAllSubversions() {
		return subversions;
	}

	public boolean isEqual(MapProtocol mp) {
		int validcount = 0;
		int totalcount = 0;
		for (Integer ti : subversions) {
			for (Integer si : mp.getAllSubversions()) {
				if (ti == si) {
					validcount++;
					totalcount++;
				} else {
					totalcount++;
				}
			}
		}
		return totalcount == validcount;
	}

}
