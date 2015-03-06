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

package editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import editor.ARGBColorPicker.ARGBColorPickerPanel;


public class ColorCircle extends JPanel implements MouseListener, MouseMotionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final int        POINTER_RADIUS = 3;
    private boolean         draggingWheel = false;
    private Rectangle       wheelRect;
    private Graphics        wheelGraphics;
    private BufferedImage   wheelImage;
    private int             wheelCenterX;
    private int             wheelCenterY;
 
    ColorModel           model = new ColorModel();

    public ColorCircle() {
        super();
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    /**
    ColorModel - stores the current selected colour
    */

    class ColorModel {
        private float brightness = (float)1.0;
        private float hue = (float)0.0;
        private float saturation = (float)0.0;
        private Color color;

        public void setBrightness(float b) {
            if (b < 0.0) b = 0f;
            if (b >= 1.0) b = 1f;

            brightness = b;
            color = Color.getHSBColor(hue, saturation, brightness);
        }

        public void setHue(float h) {
            if (h < 0.0) h= 0f;
            if (h >= 1.0) h= 0.999f;

            hue = h;
            color = Color.getHSBColor(hue, saturation, brightness);
        }

        public void setSaturation(float s) {
            if (s < 0.0) s = 0f;
            if (s >= 1.0) s = 1f;

            saturation = s;
            color = Color.getHSBColor(hue, saturation, brightness);
        }

        public void setRGB(int r, int g, int b) {
            if (r < 0) r = 0;
            if (r > 255) r = 255;
            if (g < 0) g = 0;
            if (g > 255) g = 255;
            if (b < 0) b = 0;
            if (b > 255) b = 255;

            float[] vals = new float[3];
            Color.RGBtoHSB(r , g, b, vals);
            hue = vals[0];
            saturation = vals[1];
            brightness = vals[2];
            color = new Color(r, g, b);
        }

        public void setColor(Color c) {
        	if (c != null)
        		setRGB(c.getRed(), c.getGreen(), c.getBlue());
        }

        public Color getColor() {
            return color;
        }

        public float getHue() {
            return hue;
        }

        public float getSaturation() {
            return saturation;
        }

        public float getBrightness() {
            return brightness;
        }
    }


    private void computeSize() {
        Dimension d = getSize();
        int       min = d.width < d.height ? d.width : d.height;

        wheelRect = new Rectangle((d.width - min) >> 1,
                                 (d.height - min) >> 1,
                                 min,
                                 min);

        wheelCenterX = wheelRect.x + wheelRect.width >> 1;
        wheelCenterY = wheelRect.y + wheelRect.height >> 1;
    }

    public void setBackground(Color color) {
        if (model != null) 
            model.setColor(color);
        super.setBackground(color);
    }

    public void paint(Graphics g) {
        super.paint(g);

        computeSize();

        // draw wheel
        if (wheelImage == null) {
            wheelImage = new BufferedImage(wheelRect.width, wheelRect.height, BufferedImage.TYPE_INT_ARGB);
            wheelGraphics = wheelImage.getGraphics();
            Color background = getParent().getBackground();
            wheelGraphics.setColor(background);
            wheelGraphics.fillRect(0, 0, wheelRect.width, wheelRect.height);
            int saturation_step = 1;
            int hue_step = 1;
            for (int s = 100; s >= 0; s -= saturation_step) {
                int arcw = wheelRect.width * s / 100;
                int arch = wheelRect.height * s / 100;
                float sat = s / 100F;
                for (int h = 0; h <= 360; h += hue_step) {
                    float hue = h / 360F;
                    if (hue >= 1F)
                        hue = 0F;

                    Color c = Color.getHSBColor(hue, sat, 1F);
                    wheelGraphics.setColor(c);
                    wheelGraphics.fillArc(wheelCenterX - (arcw >> 1), wheelCenterY - (arch >> 1), arcw, arch, h, hue_step);
                }
            }
        }

        // draw image
        g.drawImage(wheelImage, wheelRect.x, wheelRect.y, null);
        
        // draw circle around the current colour
        g.setXORMode(Color.white);
        int arcw = (int)(wheelRect.width * model.getSaturation()) >> 1;
        int arch = (int) (wheelRect.height * model.getSaturation()) >> 1;
        double th = model.getHue() * 2.0 * Math.PI;
        g.drawOval((int)(wheelCenterX + arcw * Math.cos(th) - POINTER_RADIUS),
                   (int)(wheelCenterY - arch * Math.sin(th) - POINTER_RADIUS),
                   POINTER_RADIUS << 1,
                   POINTER_RADIUS << 1);
    }


    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int dX = x - wheelCenterX;
        int dY = y - wheelCenterY;

        if (draggingWheel) {
            double s;
            s = Math.sqrt((double)((dX * dX) + (dY * dY))) / ((double)(wheelRect.height) / 2.0);
            if (s <= 1) {
                int color = wheelImage.getRGB(x, y);
                int  red = (color & 0x00ff0000) >> 16;
                int  green = (color & 0x0000ff00) >> 8;
                int  blue = color & 0x000000ff;

                setBackground(new Color(red, green, blue));
                ((ARGBColorPickerPanel)getParent()).update();
                repaint();
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        draggingWheel = false;

        int x = e.getX();
        int y = e.getY();

        int dX = x - wheelCenterX;
        int dY = y - wheelCenterY;
        double s;
        s = Math.sqrt((double)((dX * dX) + (dY * dY))) / ((double)(wheelRect.height) / 2.0);
        if (s <= 1) {
            draggingWheel = true;

            int color = wheelImage.getRGB(x, y);
            int  red = (color & 0x00ff0000) >> 16;
            int  green = (color & 0x0000ff00) >> 8;
            int  blue = color & 0x000000ff;

            setBackground(new Color(red, green, blue));
            ((ARGBColorPickerPanel)getParent()).update();
            repaint();
        }
    }

	public void mouseMoved(MouseEvent arg0) {
		// nop
	}

	public void mouseEntered(MouseEvent arg0) {
		// nop
	}

	public void mouseReleased(MouseEvent arg0) {
		// nop
	}

	public void mouseExited(MouseEvent arg0) {
		// nop
	}

    public void mouseClicked(MouseEvent arg0) {
		// nop
	}
}
