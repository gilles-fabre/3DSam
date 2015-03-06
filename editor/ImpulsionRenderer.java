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

/**
 * This is the springs impulsion curve renderer. This is also the panel where springs' impulsion time and 
 * amplitude can be modified.
 * 
 */
package editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import javax.swing.JPanel;

import model.ConnectionSet;
import model.Spring;

public class ImpulsionRenderer extends JPanel  implements MouseListener, MouseMotionListener, KeyListener {
	static float DASH_PATTERN[] = {5.0f};
	
	// the sine table used to draw the impulsion curve
	static final int sinTable[]= {
	          +0,   +3,   +6,   +9,  +12,  +15,  +18,  +21,  +25,  +28,  +31,  +34,  +37,  +40,  +43,  +46,  +49,  +53,  +56,  +59,
	         +62,  +65,  +68,  +71,  +74,  +77,  +80,  +83,  +86,  +89,  +92,  +95,  +97, +100, +103, +106, +109, +112, +115, +117,
	        +120, +123, +126, +128, +131, +134, +136, +139, +142, +144, +147, +149, +152, +155, +157, +159, +162, +164, +167, +169,
	        +171, +174, +176, +178, +181, +183, +185, +187, +189, +191, +193, +195, +197, +199, +201, +203, +205, +207, +209, +211,
	        +212, +214, +216, +217, +219, +221, +222, +224, +225, +227, +228, +230, +231, +232, +234, +235, +236, +237, +238, +239,
	        +241, +242, +243, +244, +244, +245, +246, +247, +248, +249, +249, +250, +251, +251, +252, +252, +253, +253, +254, +254,
	        +254, +255, +255, +255, +255, +255, +255, +255, +256, +255, +255, +255, +255, +255, +255, +255, +254, +254, +254, +253,
	        +253, +252, +252, +251, +251, +250, +249, +249, +248, +247, +246, +245, +244, +244, +243, +242, +241, +239, +238, +237,
	        +236, +235, +234, +232, +231, +230, +228, +227, +225, +224, +222, +221, +219, +217, +216, +214, +212, +211, +209, +207,
	        +205, +203, +201, +199, +197, +195, +193, +191, +189, +187, +185, +183, +181, +178, +176, +174, +171, +169, +167, +164,
	        +162, +159, +157, +155, +152, +149, +147, +144, +142, +139, +136, +134, +131, +128, +126, +123, +120, +117, +115, +112,
	        +109, +106, +103, +100,  +97,  +95,  +92,  +89,  +86,  +83,  +80,  +77,  +74,  +71,  +68,  +65,  +62,  +59,  +56,  +53,
	         +49,  +46,  +43,  +40,  +37,  +34,  +31,  +28,  +25,  +21,  +18,  +15,  +12,   +9,   +6,   +3,   +0,   -3,   -6,   -9,
	         -12,  -15,  -18,  -21,  -25,  -28,  -31,  -34,  -37,  -40,  -43,  -46,  -49,  -53,  -56,  -59,  -62,  -65,  -68,  -71,
	         -74,  -77,  -80,  -83,  -86,  -89,  -92,  -95,  -97, -100, -103, -106, -109, -112, -115, -117, -120, -123, -126, -128,
	        -131, -134, -136, -139, -142, -144, -147, -149, -152, -155, -157, -159, -162, -164, -167, -169, -171, -174, -176, -178,
		    -181, -183, -185, -187, -189, -191, -193, -195, -197, -199, -201, -203, -205, -207, -209, -211, -212, -214, -216, -217,
	        -219, -221, -222, -224, -225, -227, -228, -230, -231, -232, -234, -235, -236, -237, -238, -239, -241, -242, -243, -244,
	        -244, -245, -246, -247, -248, -249, -249, -250, -251, -251, -252, -252, -253, -253, -254, -254, -254, -255, -255, -255,
	        -255, -255, -255, -255, -256, -255, -255, -255, -255, -255, -255, -255, -254, -254, -254, -253, -253, -252, -252, -251,
	        -251, -250, -249, -249, -248, -247, -246, -245, -244, -244, -243, -242, -241, -239, -238, -237, -236, -235, -234, -232,
	        -231, -230, -228, -227, -225, -224, -222, -221, -219, -217, -216, -214, -212, -211, -209, -207, -205, -203, -201, -199,
	        -197, -195, -193, -191, -189, -187, -185, -183, -181, -178, -176, -174, -171, -169, -167, -164, -162, -159, -157, -155,
	        -152, -149, -147, -144, -142, -139, -136, -134, -131, -128, -126, -123, -120, -117, -115, -112, -109, -106, -103, -100,
	         -97,  -95,  -92,  -89,  -86,  -83,  -80,  -77,  -74,  -71,  -68,  -65,  -62,  -59,  -56,  -53,  -49,  -46,  -43,  -40,
	         -37,  -34,  -31,  -28,  -25,  -21,  -18,  -15,  -12,   -9,   -6,   -3 };
	
	int phase = 0;  // the impulsion curve phase, this is the parameter we use to accelerate or slow down the impulsions, as well as to 
					// reverse the impulsions  
	
	BasicStroke 				dashedStroke = new BasicStroke(1, 
															   BasicStroke.CAP_SQUARE, 
															   BasicStroke.CAP_BUTT, 
															   10.0f, 
															   DASH_PATTERN, 
															   0.0f);
	BasicStroke 				solidStroke = new BasicStroke(1);

	double sin(int angle) {
		return (double)sinTable[angle % sinTable.length] / (double)sinTable.length;
	}
	
	public ImpulsionRenderer() {
		super();
		setBackground(Editor.getEditor().getColor(Editor.Colors.IMPULSION_BACKGROUND_COLOR));
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7622131556869563611L;

	public void mouseClicked(MouseEvent arg0) {
		dispatchMouseEvent(arg0);		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void dispatchMouseEvent(MouseEvent arg0) {
		// check all sliders
		Iterator<ConnectionSet> c = Editor.getEditor().getWorld().getModel().getConnections().iterator();
		while (c.hasNext()) {
			Iterator<Spring> s = ((ConnectionSet)c.next()).getSprings().iterator();
			while (s.hasNext()) {
				Spring spring = (Spring)s.next();
				switch (arg0.getID()) {
					case MouseEvent.MOUSE_CLICKED: 
						if (spring.getSlider().handleMouseClicked(arg0))
							return;
						break;
	
					case MouseEvent.MOUSE_PRESSED: 
						if (spring.getSlider().handleMouseDown(arg0))
							return;
						break;
					case MouseEvent.MOUSE_DRAGGED: 
						if (spring.getSlider().handleMouseDrag(arg0)) {
							Editor editor = Editor.getEditor();
							editor.getWorld().setDirty(true);
							editor.addHistoryState();
							editor.getEditorGUI().update();
							return;
						}
						break;

					case MouseEvent.MOUSE_RELEASED: 
						if (spring.getSlider().handleMouseRelease(arg0)) {
							Editor editor = Editor.getEditor();
							editor.getWorld().setDirty(true);
							editor.addHistoryState();
							editor.getEditorGUI().update();
							return;
						}
						break;
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent arg0) {
		requestFocusInWindow(true);
		dispatchMouseEvent(arg0);
	}

	public void mouseReleased(MouseEvent arg0) {
		dispatchMouseEvent(arg0);
	}

	public void mouseDragged(MouseEvent arg0) {
		dispatchMouseEvent(arg0);
	}

	public void mouseMoved(MouseEvent arg0) {
		// nop
	}

	public void update(Graphics g) {
		int width = getSize().width;
		int height = getSize().height;
		
		Graphics2D g2 = (Graphics2D)g;

		// draw curve and sliders
		g2.setStroke(solidStroke);
		drawImpulsionCurve(g);
		drawSliders(g);

		// draw border
		g.setColor(Editor.getEditor().getColor(Editor.Colors.IMPULSION_BORDER_COLOR));
		g.drawRect(0, 0, width - 1, height - 1);

		// draw grid
		g2.setStroke(dashedStroke);
		g.setColor(Editor.getEditor().getColor(Editor.Colors.IMPULSION_GRID_COLOR));
	    g2.drawLine(width / 4, 0, width / 4, height); 
	    g2.drawLine(width / 2, 0, width / 2, height); 
	    g2.drawLine(width * 3 / 4, 0, width * 3 / 4, height); 
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		update(g);
	}
	
	/**
	 * ImpulsionStep increments or decrements the phase 
	 * 
	 * @param value is the increment or decrement to be applied to the phase.
	 *
	 * invariant: 0 <= phase < sinTable.length  
	 */
	void ImpulsionStep(int value) {
		phase += value;
		if (value < 0) {
			// going backward
			if (phase < 0)
				phase = sinTable.length;
		} else {
			// going forward
			if (phase >= sinTable.length)
				phase = 0;
		}
		
		// go through sliders and apply the amplitude.
		int 	angle;
		Point 	sliderPos;
		double  height = (double)getHeight();
		final double lastValidHeight = height > 0.0 ? height : 1.0;
		double 	deltaAngle = (double)((double)sinTable.length / lastValidHeight); // yuk. when the panel is closed, its width *and* height are set to 0!
		
		Iterator<ConnectionSet> i = Editor.getEditor().getWorld().getModel().getConnections().iterator();
		while (i.hasNext())	{
			ConnectionSet c = i.next();
			Iterator<Spring> j = c.getSprings().iterator();

			while (j.hasNext()) {
				Spring spring = j.next();
				
				Slider slider = spring.getSlider();
				sliderPos = slider.getPosition();
				if (sliderPos.y > 0) {
					angle = (int)(deltaAngle * sliderPos.y);
					spring.impulse(sin(angle + phase));
				}
			}
		}
	}
	
	/**
	 * DrawSliders draws the springs' sliders
	 * 
	 * @param g is the graphical context where we draw
	 */
	void drawSliders(Graphics g) {
        // draw all non selected sliders
		@SuppressWarnings("unused")
		Rectangle impulsionArea = new Rectangle(0, 0, getSize().width, getSize().height);
		Iterator<ConnectionSet> c = Editor.getEditor().getWorld().getModel().getConnections().iterator();
		while (c.hasNext()) {
			Iterator<Spring> s = ((ConnectionSet)c.next()).getSprings().iterator();
			while (s.hasNext()) {
				Spring spring = (Spring)s.next();

				Color impulsionColor = Editor.getEditor().getColor(Editor.Colors.SLIDER_COLOR);
		        if (Editor.getEditor().isSelected(spring))
		        	continue;
		        	
		        spring.getSlider().draw(g, impulsionColor);
			}
		}

		// draw all selected sliders
		Iterator<ConnectionSet> c2 = Editor.getEditor().getWorld().getModel().getConnections().iterator();
		while (c2.hasNext()) {
			Iterator<Spring> s = ((ConnectionSet)c2.next()).getSprings().iterator();
			while (s.hasNext()) {
				Spring spring = (Spring)s.next();

		        if (Editor.getEditor().isSelected(spring)) {
			        Color impulsionColor = Editor.getEditor().getColor(Editor.Colors.SELECTION_COLOR);
		        	spring.getSlider().draw(g, impulsionColor);
		        }
			}
		}
	}

	/**
	 * DrawImpulsionCurve draws the impulsion curve
	 * 
	 * @param g is the graphical context where we draw
	 */
	void drawImpulsionCurve(Graphics g)
	{
        Graphics2D  g2 = (Graphics2D) g;
        Color 		impulsionColor = Editor.getEditor().getColor(Editor.Colors.IMPULSION_CURVE_COLOR);
        
        // NOTE: this makes drawing slower  
        // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int 	xPoints[],
				yPoints[];
		 int 	i = 0, 
				y = 0, 
				height = getSize().height, 
				width = getSize().width - 1,
				xAxis = width / 2;
		double 	iRatio = (double)sinTable.length / (double)height,
				xDelta;
		
		xPoints = new int[height];
		yPoints = new int[height];
		do {
			i = (int)((double)y * iRatio);
			i += phase;
			if (i < 0) {
				i = i + sinTable.length;
			}
			xDelta = width * sin(i);
			xPoints[y] = xAxis + (int)xDelta;
			yPoints[y] = y;
			++y;
		} while (y < height);
		
		g2.setColor(impulsionColor);
		g2.drawPolyline(xPoints, yPoints, height);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode != KeyEvent.VK_UP &&
			keyCode != KeyEvent.VK_DOWN &&
			keyCode != KeyEvent.VK_LEFT &&
			keyCode != KeyEvent.VK_RIGHT)
			return;
							
		boolean change = false;
		
		// move all selected sliders
		Iterator<ConnectionSet> c = Editor.getEditor().getWorld().getModel().getConnections().iterator();
		while (c.hasNext()) {
			Iterator<Spring> s = ((ConnectionSet)c.next()).getSprings().iterator();
			while (s.hasNext()) {
				switch (keyCode) {
					case KeyEvent.VK_UP:
						change |= s.next().getSlider().handleKeyUp();
						break;
		
					case KeyEvent.VK_DOWN:
						change |= s.next().getSlider().handleKeyDown();
						break;
		
					case KeyEvent.VK_LEFT:
						change |= s.next().getSlider().handleKeyLeft();
						break;
						
					case KeyEvent.VK_RIGHT:
						change |= s.next().getSlider().handleKeyRight();
						break;
				}
			}
		}
		
		if (change)	{
			Editor editor = Editor.getEditor();
			editor.getWorld().setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
}
