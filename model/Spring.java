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
 * A Spring is a connection between two masses, controlling the forces between those masses.
 * 
 */
package model;

import java.io.ObjectStreamField;
import java.io.Serializable;

import editor.Editor;
import editor.Slider;
import editor.World;

public class Spring implements Serializable {
	/**
	 * non modified class serialization ID
	 */
	private static final long serialVersionUID = 3079051473380321400L;
	
	protected static double MAX_REACTION = 0.1;
	protected static double MAX_AXIS_REACTION = 0.3;
	
	private Slider 			slider;
	private double			amplitude = World.SPRING_INITIAL_AMPLITUDE;		// spring amplitude
	protected Mass			destination,	// connected masses
							origin;			
	private ConnectionSet	connection;		// the connection set this belongs to
	private double			currentSize;	// segment sizes.
	protected double		initialSize;

	// this defines the fields we want to serialize
    private static final ObjectStreamField[] serialPersistentFields = {
    	new ObjectStreamField("origin", Mass.class),
    	new ObjectStreamField("destination", Mass.class),
    	new ObjectStreamField("currentSize", double.class),
    	new ObjectStreamField("initialSize", double.class),
    	new ObjectStreamField("slider", Slider.class),
    	new ObjectStreamField("amplitude", double.class),
    	new ObjectStreamField("connection", ConnectionSet.class)
    };
    
	Spring(ConnectionSet _connection, Mass _origin, Mass _destination) {
		origin = _origin;
		destination = _destination; 
		connection = _connection;
		resetSizeAndVelocity(true);
		slider = new Slider(this);
	}
	
	// can the stiffness/amplitude change?
	public boolean isRigid() {
		return false;
	}
	
	/**
	 * resets the initial (if setInitialize) and current size of the spring. Shall be called every
	 * time a spring is manipulated by the user. The forces DO NOT affect initialSize, which must be
	 * preserved to handle the spring amplitude.
	 * 
	 * @param setInitialSize true if initial size is to be set
	 */
	public void resetSizeAndVelocity(boolean setInitialSize)
	{
		if (destination == null) {
			currentSize = initialSize = 0;
			return;
		}
			
		if (setInitialSize)
			initialSize = destination.distance(origin);

		currentSize = destination.distance(origin);
		origin.getVelocity().zero();
		destination.getVelocity().zero();
	}

	public double getSize() {
		return currentSize;
	}
	
	void setSlider(Slider value) {
		slider = value;
	}
	
	public Slider getSlider() {
		return slider;
	}
	
	public Mass getOrigin() {
		return origin;
	}

	public Mass getDestination() {
		return destination;
	}
	
	public ConnectionSet getConnectionSet() {
		return connection;
	}
	
	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double value) {
		amplitude = value;
	}
	
	// #### quickfix to properly reload misserialized models.
	public void setConnection(ConnectionSet set) {
		connection = set;
	}
	
	// ===============================   Springs and Masses physics  ===========================================
	
	/*
	 * applyReaction to the connection set's masses. The reactions have been computed by computeReaction and the 
	 * resulting forces set in the masses' velocities. We now just have to apply the gravity and the reactions to
	 * each mass and to check ground collision. Once the reaction have been applied, we reduce the mass velocities
	 * by an ENERGY_LOSS constant.
	 */
	protected void applyReaction(Mass mass, Velocity gravity, Dot ground) {
		if (mass.isFixed()) 
			return;
		
		Editor editor = Editor.getEditor();
	
		// apply gravity when in RUN_MODE only.
		if (editor.getMode() == Editor.Modes.RUN_MODE)
			mass.add(gravity);

		// apply reaction
		mass.add(mass.getVelocity());

		// do not go below the ground
		if (mass.getY() > ground.getY()) {
			mass.setY(ground.getY());

			// energy loss, y velocity is set to 0, others reduces by friction
			double friction = 1.0 - editor.getWorld().getFriction();
			Velocity groundHitEffect = new Velocity(friction, 0, friction);
			mass.getVelocity().mul(groundHitEffect);
		}

		// energy loss
		mass.getVelocity().mul(1.0 - World.ENERGY_LOSS_FACTOR);
	}
	
	public void applyReaction() {
		Dot    	ground = new Dot(0, World.GROUND_ALTITUDE, 0);

		// compute gravity direction vector
		Velocity 	gravity = new Velocity(0, 1, 0);
										   
		// apply gravity force
		gravity.mul(Editor.getEditor().getWorld().getGravity());

		// apply gravity and velocity to the non fixed masses
		applyReaction(origin, gravity, ground);
		applyReaction(destination, gravity, ground);
	}

	public void computeReaction() {
		// no need to compute anything if both masses are fixed
		if (origin.isFixed() && destination.isFixed())
			return;
		
		Editor editor = Editor.getEditor();
		World  world = editor.getWorld();
		
		double 		size = destination.distance(origin);
		Velocity 	reaction = new Velocity();
		
		// compute spring reaction due to change in distance between masses
		reaction.add(destination);
		reaction.sub(origin);
		
		// normalize reaction (ratio to initial size).
		double invSize = initialSize == 0 ? 0.0 : 1.0 / initialSize;
		reaction.mul(invSize);
		
		// difference to the resting length
	 	if (editor.getMode() == Editor.Modes.PAUSE_MODE)
			size -= initialSize;
		else
			size -= currentSize;
		
		// compute attraction/repulsion force based on displacement
	 	size *= world.getStiffness();

		// Velocity change to apply to masses due to the attraction amplitude and direction
		reaction.mul(size);
		
		// friction slows reaction down
		reaction.mul(1.0 - world.getFriction());
		
		// half of the force applied on each side
		reaction.mul(0.5);
		
		// #### try to prevent the model from getting into resonance
		Velocity noReaction = new Velocity(0, 0, 0);
		if (reaction.distance(noReaction) > MAX_REACTION) {
			double x = reaction.getX(), 
				   y = reaction.getY(), 
				   z = reaction.getZ();
			
			if (x < -MAX_AXIS_REACTION || x > MAX_AXIS_REACTION)
				x *= MAX_AXIS_REACTION;
			if (y < -MAX_AXIS_REACTION || y > MAX_AXIS_REACTION)
				y *= MAX_AXIS_REACTION;
			if (z < -MAX_AXIS_REACTION || z > MAX_AXIS_REACTION)
				z *= MAX_AXIS_REACTION;

			reaction = new Velocity(x, y, z);
		}
		
		// apply reaction to masses' velocity
		if (!origin.isFixed()) {
			if (destination.isFixed())
				reaction.mul(2.0); // reaction is twice more important
			origin.getVelocity().add(reaction);
		}
		
		if (!destination.isFixed()) { 
			if (origin.isFixed())
				reaction.mul(2.0); // reaction is twice more important
			destination.getVelocity().sub(reaction);
		}
	}
	
	public void impulse(double step) {
		step *= amplitude;	// multiply by own amplitude
		currentSize = initialSize * (1.0 + step);
	}
}
