/*
 * The MIT License
 *
 * Copyright 2013 OCN Scrim Plugin Team.
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
package io.github.ocnscrim.scrimmage.utils;

import java.util.logging.Level;

/**
 * 
 * @author msalihov (Maxim Salikhov)
 */
public class TimeUtils {

	/**
	 * Returns time based on the input string containing modifiers
	 * 
	 * @param s
	 * @return int time in seconds
	 */
	public static int parseTimeStringIntoSecs(String s) {
		if (s.contains("s")) {
			s = s.replaceAll("[^\\d.]", "");
			int i = Integer.parseInt(s);
			return i;
		} else if (s.contains("m")) {
			s = s.replaceAll("[^\\d.]", "");
			try {
				int i = Integer.parseInt(s) * 60;
				return i;
			} catch (NumberFormatException ex) {
				Log.log(Level.SEVERE,
						"[XML-Parse-Error] Could not parse integer from string!");
			}
		} else if (s.contains("h")) {
			s = s.replaceAll("[^\\d.]", "");
			try {
				int i = Integer.parseInt(s) * 3600;
				return i;
			} catch (NumberFormatException ex) {
				Log.log(Level.SEVERE,
						"[XML-Parse-Error] Could not parse integer from string!");
			}
		} else if (s.contains("d")) {
			s = s.replaceAll("[^\\d.]", "");
			try {
				int i = Integer.parseInt(s) * 86400;
				return i;
			} catch (NumberFormatException ex) {
				Log.log(Level.SEVERE,
						"[XML-Parse-Error] Could not parse integer from string!");
			}
		} else if (s.contains("mo")) {
			s = s.replaceAll("[^\\d.]", "");
			try {
				int i = Integer.parseInt(s) * 2592000;
				return i;
			} catch (NumberFormatException ex) {
				Log.log(Level.SEVERE,
						"[XML-Parse-Error] Could not parse integer from string!");
			}
		} else if (s.contains("y")) {
			s = s.replaceAll("[^\\d.]", "");
			try {
				int i = Integer.parseInt(s) * 31104000;
				return i;
			} catch (NumberFormatException ex) {
				Log.log(Level.SEVERE,
						"[XML-Parse-Error] Could not parse integer from string!");
			}
		} else {
			try {
				Integer.parseInt(s);
			} catch (NumberFormatException ex) {
				Log.log(Level.SEVERE,
						"[XML-Parse-Error] Could not parse integer from string!");
			}
		}
		return 0;
	}

}
