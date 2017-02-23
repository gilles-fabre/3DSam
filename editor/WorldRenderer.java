/*
                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library.  A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.

Initial version by gilles fabre (gilles.fabre.perso@free.fr), March 2015
*/

/** The rendering/edit view for 3DSam.
 * 
 * Modes: 	
 * 		SELECT: selects/deselects masses/springs
 * 		CONSTRUCT: left click creates mobile mass, right click creates fixed mass, drag creates or moves mass/spring/mass
 * 		RUN: plays the model (can move it around, but can't edit it)
 * 		PAUSE: pauses the model (can move it around, but can't edit it)
 * 		CAMERA: zooms in/out or moves the view point (camera position), left drag moves around x/y, right drag moves around y/z	
 * 
 * Modifiers:
 * 
 * CAMERA mode:
 * 		CTRL + drag: zooms in/out 
 * 
 * MANIPULATE mode:
 * 		CTRL + drag: rotates the selection
 *
 * CONSTRUCT mode:
 * 		CTRL + drag: move mass/spring 
 *
 */

package editor;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;

import model.Box;
import model.ConnectionSet;
import model.Dot;
import model.Home;
import model.Mass;
import model.Model;
import model.Spring;
import model.Velocity;

@SuppressWarnings("serial")
public class WorldRenderer extends JPanel implements MouseListener, MouseMotionListener {
	static float 				DASH_PATTERN[] = {5.0f}, SELECTION_PATTERN[] = {10.0f};
	static final int			STRING_X = 15, STRING_Y = 15; 
	static final int			MASS_SIZE = 6; 
	static final int			SPRING_WIDTH = MASS_SIZE / 4;
	
	public int					xEyeDistance = 700, 
								yEyeDistance = -400, 
								zEyeDistance = 2000;
	
	static final int			MAX_EYE_X = World.GROUND_MAX * 2;
	static final int			MIN_EYE_X = World.GROUND_MIN * 2;
	
	static final int			MIN_EYE_Y = -World.GROUND_ALTITUDE * 10;
	static final int			MAX_EYE_Y = World.GROUND_ALTITUDE;
	
	static final int			MAX_EYE_Z = World.GROUND_MAX * 2;
	static final int			MIN_EYE_Z = World.GROUND_MAX;

	private int					xAnchor, yAnchor, button;

	// selection in screen coords.
	private int					xSelAnchor, ySelAnchor;
	private Rectangle			selRect; 
	
	// currently under the mouse...
	private Mass				overflewMass;
	private Spring				overflewSpring;
	
	private int					xOffset, zOffset;
	private	boolean				ctrlDown = false;
	private	boolean				shiftDown = false;
	private Mass 				src, dst;
	private Spring				spr;
	private Vector<Dot> 		ground;
	
	BasicStroke 				selectionStroke = new BasicStroke(SPRING_WIDTH, 
																   BasicStroke.CAP_SQUARE, 
																   BasicStroke.CAP_BUTT, 
																   10.0f, 
																   SELECTION_PATTERN, 
																   0.0f);
	BasicStroke 				dashedStroke = new BasicStroke(SPRING_WIDTH, 
															   BasicStroke.CAP_SQUARE, 
															   BasicStroke.CAP_BUTT, 
															   10.0f, 
															   DASH_PATTERN, 
															   0.0f);
	BasicStroke 				solidStroke = new BasicStroke(SPRING_WIDTH);

	class SelectionRectangle {
		  public void paint(Graphics g) {
			    Graphics2D g2 = (Graphics2D) g;
			    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    					RenderingHints.VALUE_ANTIALIAS_ON);
			
			    g2.setPaint(Editor.getEditor().getColor(Editor.Colors.SELECTION_COLOR));
			
			    g2.setStroke(selectionStroke);
			    g2.draw(new RoundRectangle2D.Double((double)selRect.x, 
	    				   							(double)selRect.y, 
	    				   							(double)selRect.width, 
	    				   							(double)selRect.height, 1.0, 1.0));
		}
	}
	SelectionRectangle selectionRectangle = new WorldRenderer.SelectionRectangle();
	
	public WorldRenderer() {
		super();
		
		// create the ground
		ground = new Vector<Dot>();
		for (int x = World.GROUND_MIN; x < World.GROUND_MAX; x += World.GROUND_STEP)
			for (int z = World.GROUND_MIN; z < World.GROUND_MAX; z += World.GROUND_STEP)
				ground.add(new Dot(x, World.GROUND_ALTITUDE, z));
		
		setBackground(Editor.getEditor().getColor(Editor.Colors.WORLD_BACKGROUND_COLOR));
        addMouseMotionListener(this);
        addMouseListener(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		// nop
	}

	public void mouseEntered(MouseEvent arg0) {
		// nop
	}

	public void mouseExited(MouseEvent arg0) {
		// nop
	}

	public void mousePressed(MouseEvent arg0) {
		Editor	editor = Editor.getEditor();
		World   world = editor.getWorld();
		Model 	model = world.getModel();
		int		halfScreenHeight = getHeight() >> 1;
		int		halfScreenWidth = getWidth() >> 1;

		// keep track of the button initially pressed, along with
		// the coordinates (anchor)
		xSelAnchor = xAnchor = arg0.getX();
		ySelAnchor = yAnchor = arg0.getY();
		selRect = new Rectangle(xAnchor, yAnchor, 0, 0);
		button = arg0.getButton();
		
		ctrlDown = arg0.isControlDown();
		shiftDown = arg0.isShiftDown();
		
		switch (editor.getMode()) {
			case RUN_MODE:
			case PAUSE_MODE:
				// select a mass or spring to move
				src = model.findMassAt(xAnchor - halfScreenWidth, yAnchor  - halfScreenHeight, null);
				if (src == null)
					spr = model.findSpringAt(xAnchor - halfScreenWidth, yAnchor  - halfScreenHeight);
				break;
				
			case CONSTRUCT_MODE:
				switch (button) {
					case MouseEvent.BUTTON1:
						// create a mobile mass
						// when CTRL down, we're moving springs and masses
						// try to find selected mass xor spring
						// when creating pair of masses, a source mass can also be used 
						src = model.findMassAt(xAnchor - halfScreenWidth, yAnchor  - halfScreenHeight, null);
						if (src == null)
							spr = model.findSpringAt(xAnchor - halfScreenWidth, yAnchor  - halfScreenHeight);
						
						// CTRL -> moving things around
						if (ctrlDown)
							break;
						
						// create the source (if necessary) and dest masses
						if (src == null)
							src = new Mass((double)(xAnchor - halfScreenWidth), (double)(yAnchor - halfScreenHeight), 0.0);
						dst = new Mass((double)(xAnchor - halfScreenWidth), (double)(yAnchor - halfScreenHeight), 0.0);
						break;
						
					case MouseEvent.BUTTON3:
						// create a fixed mass
						// when CTRL down, we're moving springs and masses
						// try to find selected mass xor spring
						// when creating pair of masses, a source mass can also be used 
						src = model.findMassAt(xAnchor - halfScreenWidth, yAnchor  - halfScreenHeight, null);
						if (src == null)
							spr = model.findSpringAt(xAnchor - halfScreenWidth, yAnchor  - halfScreenHeight);
						
						// CTRL -> moving things around
						if (ctrlDown)
							break;

						// create the source (if necessary) and dest masses
						if (src == null)
							src = new Mass((double)(xAnchor - halfScreenWidth), (double)(yAnchor - halfScreenHeight), 0.0);
						dst = new Mass((double)(xAnchor - halfScreenWidth), (double)(yAnchor - halfScreenHeight), 0.0);
						src.setFixed(true);
						dst.setFixed(true);
						break;
				}
				
				if (!ctrlDown) {
					// create a new connection if not just moving things around
					Mass []connection = {src, dst};
					model.addConnections(connection, shiftDown);
//					currentModel.dump();
				}
				break;

			default:
				break;
		}
		invalidate();
		repaint();
	}

	public void mouseReleased(MouseEvent arg0) {
		Mass 	foundMass;
		Spring	foundSpring;
		int 	modelX = arg0.getX() - (getWidth() >> 1),
				modelY = arg0.getY() - (getHeight() >> 1);
		Editor  editor = Editor.getEditor();
		World	world = editor.getWorld();
		Model 	model = world.getModel();
	
		foundMass = model.findMassAt(modelX, modelY, dst);
		foundSpring = overflewSpring;
		
		ctrlDown = arg0.isControlDown();
		shiftDown = arg0.isShiftDown();
		
		switch (editor.getMode()) {
			case SELECT_MODE:
				// first check for a selected mass (user will select springs
				// more likely by clicking in the middle of them)
				if (foundMass != null) {
					if (editor.isSelected(foundMass)) 
						editor.deselect(foundMass);
					else
						editor.select(foundMass);
				} else if (foundSpring != null) {
					// if masses not selected,  select them.
					if (editor.isSelected(foundSpring))
						Editor.getEditor().deselect(foundSpring);
					else
						editor.select(foundSpring);
				}
				// udate edit menu items
				editor.getEditorGUI().update();
				break;
				
			case CONSTRUCT_MODE:
				if (!ctrlDown && foundMass != null) {
					// the mouse was released in an existing mass
					// reuse the latter 
					Mass []connection = {src, dst};
					model.removeConnections(connection);
					connection = new Mass[]{src, foundMass};
					model.addConnections(connection, shiftDown);

					// the world has been modified
					world.setDirty(true);
					editor.addHistoryState();
					editor.getEditorGUI().update();
				}

				// if anything modified, keep track of change
				if (src != null || dst != null || spr != null) {
					world.setDirty(true);
					editor.addHistoryState();
					editor.getEditorGUI().update();
				}
				break;
				
			case ROTATE_MODE:
			case MANIPULATE_MODE:
				world.setDirty(true);
				editor.addHistoryState();
				editor.getEditorGUI().update();
				break;

			default:
				break;
				
		}
		
		spr = null;
		src = null;
		dst = null;
		selRect = null;
	}

	public void mouseDragged(MouseEvent arg0) {
		int 			x = arg0.getX(),
						y = arg0.getY();
		Editor 			editor = Editor.getEditor();
		World			world = editor.getWorld();
		Model 			model = world.getModel();
		Iterator<Mass> 	i;
	
		int modelX = x - (getWidth() >> 1);
		int modelY = y - (getHeight() >> 1);
		overflewMass = model.findMassAt(modelX, 
										modelY, 
										overflewMass);

		overflewSpring = model.findSpringAt(modelX, 
											modelY);

		// actions on the model are relative to the model center
		Dot modelHome = model.getHome();
		model.changeHome(model.getCenter());
			
		ctrlDown = arg0.isControlDown();
		shiftDown = arg0.isShiftDown();
		
		switch (editor.getMode()) {
			case SELECT_MODE:
				selRect.x = xSelAnchor < x ? xSelAnchor : x;
				selRect.y = ySelAnchor < y ? ySelAnchor : y;
				selRect.width = Math.abs(x - xSelAnchor);
				selRect.height = Math.abs(y - ySelAnchor);

				// clear the current selection.
				Vector<Mass> selection = editor.getSelectedMasses();
				if (!ctrlDown)
					selection.clear();
				
				// add masses inside the selection rect.
				i = editor.getWorld().getModel().getMasses().iterator();
				int widthOffset = getWidth() >> 1;
				int heightOffset = getHeight() >> 1;
				
				while (i.hasNext()) {
					Mass m = i.next();
					if (selRect.contains(new Point((int)m.getZX() + widthOffset, (int)m.getZY() + heightOffset)) &&
						!selection.contains(m)) 
						selection.add(m);
				}
				break;
	
			case RUN_MODE:
			case PAUSE_MODE:
				if (shiftDown) {
					switch (button) {
					// SHIFT changes eye position
					case MouseEvent.BUTTON1:
						// left controls x, y
						xEyeDistance -= x - xAnchor;
						if (xEyeDistance < MIN_EYE_X)
							xEyeDistance = MIN_EYE_X;
						else if (xEyeDistance > MAX_EYE_X)
							xEyeDistance = MAX_EYE_X;
						
						yEyeDistance -= y - yAnchor;
						if (yEyeDistance < MIN_EYE_Y)
							yEyeDistance = MIN_EYE_Y;
						if (yEyeDistance > MAX_EYE_Y)
							yEyeDistance = MAX_EYE_Y;
						break;
						
					case MouseEvent.BUTTON3:
						// right controls z
						zEyeDistance -= y - yAnchor;
						if (zEyeDistance <= MIN_EYE_Z)
							zEyeDistance = MIN_EYE_Z;
						else if (zEyeDistance > MAX_EYE_Z)
							zEyeDistance = MAX_EYE_Z;
						break;
					}
				} else {
					// move selected mass or spring 
					if (src != null) { 
						Velocity mouseMove = new Velocity(x - xAnchor, y - yAnchor, 0);
						src.getVelocity().add(mouseMove);
					} else 
						if (spr != null) {
						Velocity mouseMove = new Velocity(x - xAnchor, y - yAnchor, 0);
						Mass o = spr.getOrigin(),
							 d = spr.getDestination();
						o.getVelocity().add(mouseMove);
						d.getVelocity().add(mouseMove);
					}
				}
				break;
				
			case MANIPULATE_MODE:
				// actions on the selection are relative to the selection center
				switch (button) {
					case MouseEvent.BUTTON1:
						// CTRL left scales selection
						if (ctrlDown)  
							editor.scaleSelection(1 - ((xAnchor - x) * 0.1), 
												  1 - ((xAnchor - x) * 0.1),
												  1 - ((xAnchor - x) * 0.1));
						// left drags selection
						else
							editor.translateSelection(x - xAnchor, y - yAnchor, 0);

						// object shouldn't wooble while manipulating it...
						model.resetSizeAndVelocity(true);
						break;
							
						case MouseEvent.BUTTON3:
							// CTRL right rotates around y,z
							if (ctrlDown) {
								editor.rotateSelection(0,
											           xAnchor - x < 0 ? 360 + xAnchor - x : xAnchor - x,
												       yAnchor - y < 0 ? 360 + yAnchor - y : yAnchor - y);
								editor.rotateSelection(0,
												       xAnchor - x < 0 ? 360 + xAnchor - x : xAnchor - x,
													   yAnchor - y < 0 ? 360 + yAnchor - y : yAnchor - y);
							// CTRL right rotates around x,y
							} else {
								editor.rotateSelection(y - yAnchor < 0 ? 360 + y - yAnchor : y - yAnchor,
							 						   xAnchor - x < 0 ? 360 + xAnchor - x : xAnchor - x,
							 						   0);
								editor.rotateSelection(y - yAnchor < 0 ? 360 + y - yAnchor : y - yAnchor,
													   xAnchor - x < 0 ? 360 + xAnchor - x : xAnchor - x,
													   0);
							}
							break;
					}
				break;
				
			case ROTATE_MODE:
				if (ctrlDown) { 
					// CTRL zooms
					model.scale(1 - ((xAnchor - x) * 0.1), 
							    1 - ((xAnchor - x) * 0.1),
							    1 - ((xAnchor - x) * 0.1));
					model.resetSizeAndVelocity(true);
				} else {
					switch (button) {
						// left rotates around x,y
						case MouseEvent.BUTTON1:
							model.rotate(y - yAnchor < 0 ? 360 + y - yAnchor : y - yAnchor,
									     xAnchor - x < 0 ? 360 + xAnchor - x : xAnchor - x,
									     0);
							break;
							
						// right rotates around y,z
						case MouseEvent.BUTTON3:
							model.rotate(0,
								         xAnchor - x < 0 ? 360 + xAnchor - x : xAnchor - x,
									     yAnchor - y < 0 ? 360 + yAnchor - y : yAnchor - y);
							break;
					}
				}
				break;

			case CONSTRUCT_MODE:
				// in this mode, CTRL moves stuff around
				if (ctrlDown) { 
					if (src != null) 
						src.translate(x - xAnchor, y - yAnchor, 0);
					else if (spr != null) {
						Mass o = spr.getOrigin(),
							 d = spr.getDestination();
						o.translate(x - xAnchor, y - yAnchor, 0);
						d.translate(x - xAnchor, y - yAnchor, 0);
					}
				} else if (dst != null) 
					dst.translate(x - xAnchor, y - yAnchor, 0);
				
				// object shouldn't wooble while manipulating it...
				model.resetSizeAndVelocity(true);
				break;
	
			default:
				break;
		}
		
		xAnchor = x;			
		yAnchor = y;			

		// actions on the model were relative to the model center
		model.changeHome(modelHome);
	}

	public void mouseMoved(MouseEvent arg0) {
		int 	modelX = arg0.getX() - (getWidth() >> 1),
				modelY = arg0.getY() - (getHeight() >> 1);
		Editor  editor = Editor.getEditor();
		World	world = editor.getWorld();
		Model 	model = world.getModel();
	
		overflewMass = model.findMassAt(modelX, modelY, null);
		overflewSpring = model.findSpringAt(modelX, modelY);
	}
	

	/**
	 *  Draw the ground (it follows the model gravity center)
	 */
	public void drawGround(Graphics g, Model model, int xModelOffset, int zModelOffset) {
		Editor editor = Editor.getEditor();
		Graphics2D g2 = (Graphics2D)g;
		
		// get the view size, and place the home at the center of the view...
		Dimension dim = getSize();
		int offX = dim.width >> 1;
		int offY = dim.height >> 1;
							
		g2.setStroke(solidStroke);
		g.setColor(editor.getColor(Editor.Colors.WORLD_GROUND_COLOR));
		int iStartDot = 0, iRow = 0, iCol = 0;
		int lineLen = (World.GROUND_MAX - World.GROUND_MIN) / World.GROUND_STEP;
		int iEndDot = lineLen + 1;
		while (iEndDot < ground.size()) {

			// change row?
			if (++iCol == lineLen) {
				iCol = 0;
				iRow++;
			}
			
			// draw only odd tiles (and prevent from drawing a misformed diagonal tile
			// at the end of the row).
			if ((iCol + iRow) % 2 != 0 &&
				iEndDot % lineLen != 0) {
				Dot d1 = new Dot(ground.elementAt(iStartDot)), 
				d2 = new Dot(ground.elementAt(iStartDot + 1)), 
				d3 = new Dot(ground.elementAt(iEndDot - 1)),
				d4 = new Dot(ground.elementAt(iEndDot));

				if (editor.isCenteredRendering()) {
					// add the model offset to the ground
					d1.setX(d1.getX() - xModelOffset);
					d1.setZ(d1.getZ() - zModelOffset);
					d2.setX(d2.getX() - xModelOffset);
					d2.setZ(d2.getZ() - zModelOffset);
					d3.setX(d3.getX() - xModelOffset);
					d3.setZ(d3.getZ() - zModelOffset);
					d4.setX(d4.getX() - xModelOffset);
					d4.setZ(d4.getZ() - zModelOffset);
				}
				
				if (editor.isIsoRendering()) {
					d1.isoProject(zEyeDistance);
					d2.isoProject(zEyeDistance);
					d3.isoProject(zEyeDistance);
					d4.isoProject(zEyeDistance);
				}
				else {
					d1.project(xEyeDistance, yEyeDistance, zEyeDistance);
					d2.project(xEyeDistance, yEyeDistance, zEyeDistance);
					d3.project(xEyeDistance, yEyeDistance, zEyeDistance);
					d4.project(xEyeDistance, yEyeDistance, zEyeDistance);
				}
				Polygon tile = new Polygon();
				tile.addPoint((int)(d1.getZX() + offX), (int)(d1.getZY() + offY));
				tile.addPoint((int)(d2.getZX() + offX), (int)(d2.getZY() + offY));
				tile.addPoint((int)(d4.getZX() + offX), (int)(d4.getZY() + offY));
				tile.addPoint((int)(d3.getZX() + offX), (int)(d3.getZY() + offY));
	
				g.fillPolygon(tile);
			}
			
			iStartDot++;
			iEndDot++;
		}
	}
	
	void drawModel(Graphics g, Model model, boolean drawMasses) {
		Editor editor = Editor.getEditor();
        Graphics2D g2 = (Graphics2D)g;

        // NOTE: this makes drawing slower
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// get the view size, and place the home at the center of the view...
		Dimension dim = getSize();
		int offX = dim.width >> 1;
		int offY = dim.height >> 1;
		
		// draw the model.
		Dot home = model.getHome();
		if (editor.isIsoRendering()) {
			home.isoProject(zEyeDistance);
			model.isoProject(zEyeDistance);
		} else {
			home.project(xEyeDistance, yEyeDistance, zEyeDistance);
			model.project(xEyeDistance, yEyeDistance, zEyeDistance);
		}
		Iterator<ConnectionSet> i = model.getConnections().iterator();
        while (i.hasNext()) {
        	ConnectionSet c = (ConnectionSet)i.next();
    		Iterator<Spring> j = c.getSprings().iterator(); 

    		while (j.hasNext()) {
    			Boolean originSelected = false, 
    					destinationSelected = false;
    			
    			Spring spring = (Spring)j.next();
            	Mass origin = spring.getOrigin(),
            		 destination = spring.getDestination();
            	
        		int sx = (int)((origin.getZX() + home.getZX()) + offX),
        			sy = (int)((origin.getZY() + home.getZY()) + offY),
            		dx = (int)((destination.getZX() + home.getZX()) + offX),
        			dy = (int)((destination.getZY() + home.getZY()) + offY);
            		
    			// masses and spring colors depend on the selection
    			destinationSelected = editor.isSelected(destination);
    			originSelected = editor.isSelected(origin);        			
        		
        		// draw the spring
        		
    			// under the mouse?
    			if (spring.equals(overflewSpring))
            		g.setColor(editor.getColor(Editor.Colors.OVERFLEW_COLOR));
    			else {
    				// selected?
	        		if (originSelected && destinationSelected)
	            		g.setColor(editor.getColor(Editor.Colors.SELECTION_COLOR));
	        		else
	        			g.setColor(model.getColor());
    			}
    			
        		// draw a bar or spring
        		if (spring.isRigid())
    			    g2.setStroke(solidStroke);
        		else
        			g2.setStroke(dashedStroke);
        		
    			g.drawLine(sx, sy, dx, dy);

    			if (drawMasses) {
            		// draw the masses

        			// under the mouse?
        			if (origin.equals(overflewMass))
                		g.setColor(editor.getColor(Editor.Colors.OVERFLEW_COLOR));
        			else {
        				// selected?
	        			if (originSelected)
	                		g.setColor(editor.getColor(Editor.Colors.SELECTION_COLOR));
	        			else
	                		g.setColor(model.getColor());
        			}
        			
        			if (origin.isFixed())
        				g.fillRect(sx - (MASS_SIZE >> 1), sy - (MASS_SIZE >> 1), MASS_SIZE, MASS_SIZE);
        			else
        				g.fillArc(sx - (MASS_SIZE >> 1), sy - (MASS_SIZE >> 1), MASS_SIZE, MASS_SIZE, 0, 360);

        			// under the mouse?
        			if (destination.equals(overflewMass))
                		g.setColor(editor.getColor(Editor.Colors.OVERFLEW_COLOR));
        			else {
        				// selected?
	        			if (destinationSelected) 
	                		g.setColor(editor.getColor(Editor.Colors.SELECTION_COLOR));
	        			else
	                		g.setColor(model.getColor());
        			}
        			
        			if (destination.isFixed())
        				g.fillRect(dx - (MASS_SIZE >> 1), dy - (MASS_SIZE >> 1), MASS_SIZE, MASS_SIZE);
           			else
            			g.fillArc(dx - (MASS_SIZE >> 1), dy - (MASS_SIZE >> 1), MASS_SIZE, MASS_SIZE, 0, 360);
        		}
        	}
        }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		update(g);
	}
	
	public void update(Graphics g) {
		Editor 	editor = Editor.getEditor();
		World	world = editor.getWorld();
		Model 	model = world.getModel();

		if (model == null)
			return;

		// if in 'free movement mode', and model gone too far bring it back home
		if (!editor.isCenteredRendering())
			world.keepModelAtHome();
		
		// get model distance from home
		int x = 0, z = 0;
		if (editor.isCenteredRendering()) {
			Dot modelCenter = model.getCenter();
			x = (int)modelCenter.getX();
			z = (int)modelCenter.getZ();
			
			// bring model back home
			world.bringModelBackHome();
		}
		
		// draw ground
		xOffset += x;
		zOffset += z;
		if ((xOffset % World.GROUND_STEP) == 0)
			xOffset = 0;
		if ((zOffset % World.GROUND_STEP) == 0)
			zOffset = 0;
		drawGround(g, model, xOffset, zOffset);
		
		// draw world reference 
		drawModel(g, world.getHome(), false);
		
		// draw model bounding box
		Dot frontUpperLeft = new Dot();
		Dot backBottomRight = new Dot();
		if (editor.isSelection())
			editor.getSelectionBoundingBox(frontUpperLeft, backBottomRight);
		else
			model.getBoundingBox(frontUpperLeft, backBottomRight);
		Box bbox = new Box(frontUpperLeft, backBottomRight);
		bbox.setHome(model.getHome());
		bbox.setColor(editor.getColor(Editor.Colors.MODEL_BOX_COLOR));
		drawModel(g, bbox, false);
		
		// draw model center 
		Dot modelCenter = model.getCenter();
		Home modelHome = new Home(modelCenter.getX(),
								  modelCenter.getY(),
								  modelCenter.getZ(),
								  editor.getColor(Editor.Colors.MODEL_CENTER_COLOR));
		drawModel(g, modelHome, false);

		// draw model
		drawModel(g, model, true);
		
		// display model name
		if (model.getName() != null) {
			g.setColor(editor.getColor(Editor.Colors.TEXT_TIP_COLOR));
			g.drawString(model.getName(), STRING_X, STRING_Y);
		}
		
		// draw selection box
		if (editor.getMode() == Editor.Modes.SELECT_MODE &&
			selRect != null) 
    		selectionRectangle.paint(g);
			
		// display world properties
		String 	text = Messages.getString("WorldRenderer.0") + new Double(world.getGravity()).toString(); //$NON-NLS-1$
		text += Messages.getString("WorldRenderer.1") + new Double(world.getFriction()).toString(); //$NON-NLS-1$
		text += Messages.getString("WorldRenderer.2") + new Double(world.getStiffness()).toString(); //$NON-NLS-1$
		text += Messages.getString("WorldRenderer.3") + new Double(world.getImpulsion()).toString(); //$NON-NLS-1$
		text += Messages.getString("WorldRenderer.4") + new Double(xEyeDistance).toString() + ", " //$NON-NLS-1$
								   + new Double(yEyeDistance).toString() + ", "
								   + new Double(zEyeDistance).toString();
		g.setColor(editor.getColor(Editor.Colors.TEXT_TIP_COLOR));
		g.drawString(text, STRING_X, STRING_Y << 1);

		// get the view size, draw a tip at the bottom left
		String usageTip = new String();	// help on mouse/keys usage in view depending on the mode
		switch (editor.getMode()) {
			case MANIPULATE_MODE:
				usageTip = Messages.getString("WorldRenderer.7"); //$NON-NLS-1$
				break;

			case ROTATE_MODE:
				usageTip = Messages.getString("WorldRenderer.8"); //$NON-NLS-1$
				break;
	
			case CONSTRUCT_MODE:
				usageTip = Messages.getString("WorldRenderer.9"); //$NON-NLS-1$
				break;

			case RUN_MODE:
			case PAUSE_MODE:
				usageTip = Messages.getString("WorldRenderer.10"); //$NON-NLS-1$
				if (!editor.isIsoRendering())
					usageTip += Messages.getString("WorldRenderer.11"); //$NON-NLS-1$
				break;

			case SELECT_MODE:
				usageTip = Messages.getString("WorldRenderer.12"); //$NON-NLS-1$
				break;
		}
		Dimension d = getSize();
		int offX = STRING_X;
		int offY = d.height - STRING_Y;
		g.drawString(usageTip, offX, offY);
	}
}
