/*
 * @(#)FormatLinePattern.java	1.2 31.01.2003
 *
 * Copyright (C) 2001-2004 Gaudenz Alder
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */
package org.interpss.editor.coreframework.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.interpss.editor.coreframework.IpssAbstractGraphAction;
import org.interpss.editor.resources.Translator;
import org.interpss.editor.util.Utilities;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.GraphConstants;


public class FormatLinePattern extends IpssAbstractGraphAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (getCurrentGraph().getSelectionCount() > 0) {
			try {
				String s =
					JOptionPane.showInputDialog(
						Translator.getString("PatternDialog"));
				float[] f = Utilities.parsePattern(s);
				if (f != null) {
					AttributeMap map = new AttributeMap();
					GraphConstants.setDashPattern(map, f);
					setSelectionAttributes(map);
				}
			} catch (NullPointerException npe) {
				// ignore
			} catch (Exception ex) {
				graphpad.error(ex.toString());
			}
		}

	}

}
