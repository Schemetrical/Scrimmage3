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
package io.github.ocnscrim.scrimmage;

import io.github.ocnscrim.scrimmage.utils.Log;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author msalihov (Maxim Salikhov)
 */
public class XMLDocument {

	private File fileLocation;
	private Document document;

	public XMLDocument(File file) {
		try {
			fileLocation = file;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			document = db.parse(fileLocation);
			document.getDocumentElement().normalize();
		} catch (SAXException ex) {
			Log.log(Level.SEVERE,
					"[XML-Parse-Error] Scrimmage generated a SAXException while parsing "
							+ file.getName());
			Log.log(ex);
		} catch (IOException ex) {
			Log.log(Level.SEVERE,
					"[XML-Parse-Error] Scrimmage generated a IOException while parsing "
							+ file.getName());
			Log.log(ex);
		} catch (ParserConfigurationException ex) {
			Log.log(Level.SEVERE,
					"[XML-Parse-Error] Scrimmage generated a ParserConfigurationException while parsing "
							+ file.getName());
			Log.log(ex);
		}
	}

	public Document getDoc() {
		return document;
	}

}
