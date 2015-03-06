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
 * A 3D model. Knows how to scale/rotate and project itself. Can be saved and
 * Loaded. Holds a color to be drawn with.
 * 
 * The model holds a vector of connection sets (connected masses sets). The model
 * can compute its reactions, apply them, or reset the springs' sizes.
 * 
 */
package model;

import java.awt.Color;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import matrix.Matrix;
import utilities.SimpleStringTokenizer;

public class Model implements Serializable {
	/**
	 * modified class serialization ID
	 */
	private static final long serialVersionUID = 8581657786161356194L;

	static final int INITIAL_OBJECT_SIZE = 100;

	private ArrayList<ModelPart> parts = new ArrayList<ModelPart>();

	// this defines the fields we want to serialize
    private static final ObjectStreamField[] serialPersistentFields = {
    	new ObjectStreamField("parts", ArrayList.class),
    	new ObjectStreamField("connections", Vector.class),
    	new ObjectStreamField("home", Dot.class),
    	new ObjectStreamField("color", Color.class),
    	new ObjectStreamField("name", String.class)
    };

	static final int 		SEL_MARGIN = 4;

	Vector<ConnectionSet>	connections = new Vector<ConnectionSet>();
	Dot						home = new Dot(0, 0, 0);	// home for this model
	Color					color;						// model color
	String					name = new SimpleStringTokenizer(getClass().getName()).lastToken() + "_" + new Integer((int)(System.currentTimeMillis() % 999999)).toString(); // model name
	Vector<Mass>			masses;						// a list of the masses 
	
    public Model() {
    	color = Color.GREEN;
  }

    public Model(Color _color) {
    	color = _color;
    }
    
    /**
     * Get a list of unique masses from the model (no duplicates)
     */
 	public synchronized Vector<Mass> getMasses() {

    	// if an up to date list of masses exist, just return it
    	if (masses != null)
    		return masses;
    	
    	// populate the list of masses
    	masses = new Vector<Mass>();
    	Iterator<ConnectionSet> i = getConnections().iterator();
    	while (i.hasNext()) {
    		Iterator<Spring> j = i.next().getSprings().iterator();
        	while (j.hasNext()) {
        		Spring s = (Spring)j.next(); 
        		if (!masses.contains(s.getOrigin()))
        			masses.add(s.getOrigin());
        		if (!masses.contains(s.getDestination()))
        			masses.add(s.getDestination());
        	}
    	}
    	
    	return masses;
    }

    /**
    * 
    * @return the list of connections for this.
    */
    public Vector<ConnectionSet> getConnections() {return connections;}
	
	/**
	 * Transform this by matrix m
	 * @param The m transformation matrix
	 */
	public void transform(Matrix m) {
    	Iterator<Mass> i = getMasses().iterator();
    	while (i.hasNext()) 
    		i.next().mul(m); 
	}

	/**
	 * Rotate this by...
	 * @param Rx the angle around the X axis
	 * @param Ry the angle around the Y axis
	 * @param Rz the angle around the Z axis
	 */
    public void rotate(int Rx, int Ry, int Rz) {
		Matrix r = new Matrix(Dot.noTransformMatrix);
		r.rotate(Rx, Ry, Rz);
		transform(r);
	}

	/**
	 * Translate this by...
	 * @param Dx the delta along the X axis
	 * @param Dy the delta along the Y axis
	 * @param Dz the delta along the Z axis
	 */
	public void	translate(int Dx, int Dy, int Dz) {
		home.translate(Dx, Dy, Dz);
	}
	
	/**
	 * Scale this by...
	 * @param Dx the factor along the X axis
	 * @param Dy the factor along the Y axis
	 * @param Dz the factor along the Z axis
	 */
	public void scale(double Sx, double Sy, double Sz) {
		Matrix s = new Matrix(Dot.noTransformMatrix);
		s.scale(Sx, Sy, Sz);
		transform(s);
	}
	
	/**
	 * Project this using the specified position of the observation point
	 * @param Xo is the distance between the 'eye' and the screen along the X axis
	 * @param Yo is the distance between the 'eye' and the screen along the Y axis
	 * @param Zo is the distance between the 'eye' and the screen along the Z axis
	 */
	public void		project(double Xo, double Yo, double Zo) {
    	Iterator<Mass> i = getMasses().iterator();
    	while (i.hasNext()) 
    		i.next().project(Xo, Yo, Zo);
	}

	/**
	 * Iso Project this using the specified position of the observation point (on the Z axis) 
	 * @param Zo is the distance between the 'eye' and the screen along the Z axis
	 */
	public void		isoProject(double Zo) {
    	Iterator<Mass> i = getMasses().iterator();
    	while (i.hasNext()) 
    		i.next().isoProject(Zo);
	}
	
	/**
	 * 
	 * @return this' color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 
	 * @param _color is the color to set to this
	 */
	public void setColor(Color _color) {
		color = _color;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public String getName() {
		return name;
	}
	
	public Dot	getHome() {
		return home;
	}

	public void		setHome(Dot _home) {
		home = new Dot(_home);
	}

	public void changeHome(Dot newHome) {
    	Iterator<Mass> i = getMasses().iterator();
    	Dot delta = new Dot(newHome);
    	delta.sub(home);
    	while (i.hasNext()) 
			i.next().sub(delta);
    	home = newHome;
    }
   
    public void removeConnections(Mass []connections) {
		// remove the connections from the model.
    	Iterator<ConnectionSet> ci = getConnections().iterator();
    	while (ci.hasNext()) {
			int i = 0; 
			do {
		    		ConnectionSet c = (ConnectionSet)ci.next();
		    		c.removeConnection(connections[i], connections[++i]);
		    		if (c.getSprings().isEmpty())
		    			ci.remove();
			} while (i < connections.length - 1);
	    }
    	
    	// the list of masses must be re-populated
    	masses = null;
	}

	public void addConnections(Mass []connections, boolean rigid) {
		// add the connections to the model.
		int i = 0; 
		do 
			ConnectionSet.factory(this, connections[i], connections[++i], rigid);
		while (i < connections.length - 1);

		// the list of masses must be re-populated
    	masses = null;
	}

	public void removeMass(Mass mass) {
		// remove the connections to/from this mass from the model.
		Spring s = ConnectionSet.getSpring(this, mass);
    	while (s != null) {
    		ConnectionSet cs = s.getConnectionSet();
    		if (cs == null) 
    			break; // ouch... broken model :/
    		cs.removeConnection(s.getOrigin(), s.getDestination());
    		s = ConnectionSet.getSpring(this, mass);
    	}

    	// the list of masses must be re-populated
    	masses = null;
	}

	public void replaceMass(Mass m1, Mass m2) {
		// replace the connections to/from m1 by connection to/from m2 in the model.
		Spring s = ConnectionSet.getSpring(this, m1);
    	while (s != null) {
    		ConnectionSet cs = s.getConnectionSet();
    		if (cs == null) 
    			break; // ouch... broken model :/
    		
			Mass src = m2;
			Mass dst = m2;
    		if (s.getOrigin() == m1)
    			dst = s.getDestination();
    		else 
    			src = s.getOrigin();

			cs.removeConnection(s.getOrigin(), s.getDestination());
			cs.addConnection(src, dst, s.isRigid());
    		
    		s = ConnectionSet.getSpring(this, m1);
    	}

    	// the list of masses must be re-populated
    	masses = null;
	}

	public void dump() {
		System.out.println("model	: " + name);
		System.out.println("home	: " + home.getX() + ", " + home.getY() + ", " + home.getZ());
        Iterator<ConnectionSet> i = getConnections().iterator();
		while (i.hasNext()) {
        	Iterator<Spring> j = i.next().getSprings().iterator(); 
    		while (j.hasNext()) {
    			Spring s = (Spring)j.next();
            	Mass origin = s.getOrigin();
            	Mass destination = s.getDestination();
           		System.out.println("connection: " + origin.getX() + ", " + origin.getY() + ", " + origin.getZ() + "<->" + destination.getX() + ", " + destination.getY() + ", " + destination.getZ());
           		System.out.println("size: " + s.getSize());
    		}
        }
		System.out.println("model end -----------");
	}
	
	/**
	 * findMassAt returns the front most mass at x, y if any, else
	 * 	returns null
	 * 
	 * @param x coordinate to look for
	 * @param y coordinate to look for
	 * @param ignorePoint ignore this mass if non null
	 * @return front most mass at x, y if found, else null
	 */
	public Mass findMassAt(int x, int y, Mass ignorePoint) {
		int 	frontMost = new Integer(Integer.MIN_VALUE).intValue();
		Mass 	found = null;
		
    	Iterator<ConnectionSet> ci = getConnections().iterator();
    	while (ci.hasNext()) {
    		Iterator<Spring> j = ci.next().getSprings().iterator(); 
    		while (j.hasNext()) {
    			Spring s = (Spring)j.next();
            	Mass o = s.getOrigin();
            	Mass d = s.getDestination();

            	if (o != ignorePoint &&
	        		o.getZX() >= x - SEL_MARGIN &&
	    			o.getZX() <= x + SEL_MARGIN &&
	    			o.getZY() >= y - SEL_MARGIN &&
	    			o.getZY() <= y + SEL_MARGIN && 
	    			(int)o.getZ() >= frontMost) {
	    			frontMost = (int)o.getZ();
	    			found = o;
	    		}

            	if (d != ignorePoint &&
	        		d.getZX() >= x - SEL_MARGIN &&
	    			d.getZX() <= x + SEL_MARGIN &&
	    			d.getZY() >= y - SEL_MARGIN &&
	    			d.getZY() <= y + SEL_MARGIN && 
	    			(int)d.getZ() >= frontMost) {
	    			frontMost = (int)d.getZ();
	    			found = d;
	    		}
			}
		}
    		
    	return found;
	}

	/**
	 * findSpringAt returns the front most spring at x, y if any, else
	 * 	returns null
	 * 
	 * @param x coordinate to look for
	 * @param y coordinate to look for
	 * @return front most spring at x, y if found, else null
	 */
	static public int projectedDistance(int x0, int y0, int x1, int y1) {
		double s1, s2;
		
		s1 = y0 - y1;
		s1 *= s1;
		s2 = x0 - x1;
		s2 *= s2;
		return (int)Math.sqrt(s1 + s2);
	}
	
	static public int distance(int x0, int y0, int z0, int x1, int y1, int z1) {
		double s1, s2, s3;
		
		s1 = y0 - y1;
		s1 *= s1;
		s2 = x0 - x1;
		s2 *= s2;
		s3 = z0 - z1;
		s3 *= s3;
		return (int)Math.sqrt(s1 + s2 + s3);
	}

	public Spring findSpringAt(int x, int y) {
		int		MIN_INT = new Integer(Integer.MIN_VALUE).intValue();
		int 	frontMost = MIN_INT;
		
		Spring found = null;
		
		// iterate on all connection sets
		Iterator<ConnectionSet> ci = getConnections().iterator();
	
		while (ci.hasNext()) {
			ConnectionSet c = (ConnectionSet)ci.next();
			
			// iterate on all springs
			Iterator<Spring>si = c.getSprings().iterator();
			while (si.hasNext()) {
				Spring 	s = (Spring)si.next();
				Mass	origin = s.getOrigin(),
						destination = s.getDestination();
					
				int sl = (int)origin.projectedDistance(s.getDestination());
				int od = projectedDistance(x, y, (int)origin.getZX(), (int)origin.getZY());
				int dd = projectedDistance(x, y, (int)destination.getZX(), (int)destination.getZY());
				int d3 = distance(x, y, MIN_INT, x, y, (int)origin.getZ()) +
						 distance(x, y, MIN_INT, x, y, (int)destination.getZ());
				
				//   sl - margin <= od + dd <= sl + margin 
				if (od + dd <= sl + 1 &&	// click is on the spring
					od + dd >= sl - 1 &&
					d3 >= frontMost) {		// spring is the front most we found so far
					found = s;
					frontMost = d3;
				}
			}
		}

		return found;
	}
	
	/**
	 * Reset size and velocity for all springs
	 *
	 */
	public void resetSizeAndVelocity(boolean setInitialSize) {
		Iterator<ConnectionSet> i = getConnections().iterator();
		while (i.hasNext())	{
			Iterator<Spring> j = i.next().getSprings().iterator();

			while (j.hasNext()) 
				j.next().resetSizeAndVelocity(setInitialSize);
		}
	}

	/**
	 * Compute reactions for all springs (and thus impacted masses)
	 *
	 */
	public void computeReactions() {
		Iterator<ConnectionSet> i = getConnections().iterator();
		while (i.hasNext())	{
			Iterator<Spring> j = i.next().getSprings().iterator();

			while (j.hasNext()) 
				j.next().computeReaction();
		}
	}

	/**
	 * Apply reactions for all springs (and thus impacted masses)
	 *
	 */
	public void applyReactions() {
		Iterator<ConnectionSet> i = getConnections().iterator();
		while (i.hasNext())	{
			Iterator<Spring> j = i.next().getSprings().iterator();

			while (j.hasNext()) 
				j.next().applyReaction();
		}
	}
	
	public void mergeConnections(Model model, boolean rigid) {
		Iterator<ConnectionSet> cs = model.getConnections().iterator();
		while (cs.hasNext()) {
			Iterator<Spring> i = cs.next().getSprings().iterator();
			while (i.hasNext()) {
				Spring s = i.next();
				Mass[] masses = {s.getOrigin(), s.getDestination()};
				addConnections(masses, rigid);
			}
		}
	}

	/**
	 * Get the model center
	 */
	public Dot getCenter() {
		Dot frontUpperLeft = new Dot();
		Dot backBottomRight = new Dot();
		getBoundingBox(frontUpperLeft, backBottomRight);
		Dot center = new Dot((backBottomRight.getX() + frontUpperLeft.getX()) / 2,
					   		 (frontUpperLeft.getY() + backBottomRight.getY()) / 2,
					   		 (backBottomRight.getZ() + frontUpperLeft.getZ()) / 2);
		return center;
	}

	/**
	 * Get the model bounding box
	 */
	public void getBoundingBox(Dot frontUpperLeft, Dot backBottomRight) {
		if (getMasses().isEmpty())
			return;

		Mass mass = getMasses().get(0);
		
		frontUpperLeft.setX(mass.getX());
		frontUpperLeft.setY(mass.getY());
		frontUpperLeft.setZ(mass.getZ());
		backBottomRight.setX(mass.getX());
		backBottomRight.setY(mass.getY());
		backBottomRight.setZ(mass.getZ());
		
		Iterator<Mass> i = getMasses().iterator();
		while (i.hasNext()) {
			Mass m = i.next();
			if (frontUpperLeft.getX() > m.getX())
				frontUpperLeft.setX(m.getX());
			if (frontUpperLeft.getY() < m.getY())
				frontUpperLeft.setY(m.getY());
			if (frontUpperLeft.getZ() > m.getZ())
				frontUpperLeft.setZ(m.getZ());

			if (backBottomRight.getX() < m.getX())
				backBottomRight.setX(m.getX());
			if (backBottomRight.getY() > m.getY())
				backBottomRight.setY(m.getY());
			if (backBottomRight.getZ() < m.getZ())
				backBottomRight.setZ(m.getZ());
		}
	}
	
	/**
	 * 
	 * @return the list of parts for the model if any
	 */
	public ArrayList<ModelPart> getParts() {
		return parts;
	}
	
	/**
	 * 
	 * @param part is the part of the model to remove from the parts list
	 */
	public void removePart(ModelPart part) {
		parts.remove(part);
	}

	/**
	 * 
	 * @param part is the model part to be added to the model parts list
	 */
	public void addPart(ModelPart part) {
		parts.add(part);
	}
	
	/**
	 * move the model (center) to X, Y, Z 
	 * @param X coord for the model center
	 * @param Y coord for the model center
	 * @param Z coord for the model center
	 */
	public void moveTo(int X, int Y, int Z) {
		Dot center = getCenter();
		int Dx = X - (int)center.getX(), 
			Dy = Y - (int)center.getY(), 
			Dz = Z - (int)center.getZ();
		
		Iterator<Mass> i = getMasses().iterator();
		while (i.hasNext()) {
			i.next().translate(Dx, Dy, Dz);
		}
	}
}
