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
 * 3DSam world. Owns the physics constraints (gravity, stiffness, friction) and the current model). 
 *
 */
package editor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.OutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

import model.Dot;
import model.Home;
import model.Model;
import editor.Editor.Colors;

public class World implements Serializable {
    /**
	 * non modified class serialization ID
	 */
	private static final long serialVersionUID = 6672046529928045230L;

	// this defines the fields we want to serialize
    private static final ObjectStreamField[] serialPersistentFields = {
    	new ObjectStreamField("gravity", double.class),
    	new ObjectStreamField("friction", double.class),
    	new ObjectStreamField("stiffness", double.class),
    	new ObjectStreamField("impulsion", double.class),
    	new ObjectStreamField("home", Home.class),
    	new ObjectStreamField("model", Model.class)
    };

	// mix, max, default parameters for gravity, stiffness, friction, impulsion
    public final static int  	MIN_GRAVITY = -50,
								MAX_GRAVITY = 50,
								DEFAULT_GRAVITY = 0,
								GRAVITY_MINOR_INCREMENT = 1,
								GRAVITY_MAJOR_INCREMENT = 5,
								MIN_FRICTION = 0,
								MAX_FRICTION = 100,
								DEFAULT_FRICTION = 90,
								FRICTION_MINOR_INCREMENT = 1,
								FRICTION_MAJOR_INCREMENT = 10,
								MIN_STIFFNESS = 0,
								MAX_STIFFNESS = 100,
								DEFAULT_STIFFNESS = 10,
								STIFFNESS_MINOR_INCREMENT = 1,
								STIFFNESS_MAJOR_INCREMENT = 5,
								MIN_IMPULSION = -200,
								MAX_IMPULSION = 200,
								DEFAULT_IMPULSION = 0,
								IMPULSION_MINOR_INCREMENT = 5,
								IMPULSION_MAJOR_INCREMENT = 10,
								ANIMATE_DELAY = 20,
								IMPULSION_STEP = 100,
								GROUND_ALTITUDE = 150,
								GROUND_MAX_ALTITUDE = 600,
								GROUND_MIN = -1000,
								GROUND_MAX = 1000,
								GROUND_STEP = 20, 
								MAX_MODEL_DISTANCE = (GROUND_MAX - GROUND_MIN) / 2; 
    
    public final static double  SPRING_INITIAL_AMPLITUDE = 0.0,
    							ENERGY_LOSS_FACTOR = 0.3,
    							BAR_FRICTION = 0.09;

    // current model
    private Model		model;
    private Home		home;			// the model home

    // has the model been modified since it was last saved
    boolean				dirty;
    
    // current world settings
	double		gravity = (double)DEFAULT_GRAVITY / (double)(MAX_GRAVITY - MIN_GRAVITY), 			
				friction = (double)DEFAULT_FRICTION / (double)(MAX_FRICTION - MIN_FRICTION),		
				stiffness = (double)DEFAULT_STIFFNESS / (double)(MAX_STIFFNESS - MIN_STIFFNESS),	
				impulsion = (double)DEFAULT_IMPULSION / (double)(MAX_IMPULSION - MIN_IMPULSION);  	
	
	public World() {
		model = new Model(Editor.getEditor().getColor(Colors.MODEL_COLOR));
	}

	public Home getHome() {
    	if (home == null)
    		home = new Home(Editor.getEditor().getColor(Colors.HOME_COLOR));

    	return home;
    }

    public Model getModel() {
		if (model == null) {
			model = new Model(Editor.getEditor().getColor(Colors.MODEL_COLOR));
		}
		
		return model;
    }

    public void setModel(Model value) {
    	model = value;
		dirty = true;
    }
    
	public double getGravity() {
		return gravity;
	}
	
	public double getFriction() {
		return friction;
	}

	public double getStiffness() {
		return stiffness;
	}

	public double getImpulsion() {
		return impulsion;
	}

	public void setGravity(double value) {
		gravity = value;
		dirty = true;
	}
	
	public void setFriction(double value) {
		friction = value;
		dirty = true;
	}

	public void setStiffness(double value) {
		stiffness = value;
		dirty = true;
	}

	public void setImpulsion(double value) {
		impulsion = value;
		dirty = true;
	}
	
	public boolean isDirty() {
		return dirty;
	}
	
	public void setDirty(boolean _dirty) {
		dirty = _dirty;
	}
  
	/**
	 * Get the model back home if gone too far
	 */
    public void keepModelAtHome() {
    	// get model center
    	Dot modelCenter = model.getCenter();
    	double distance = Model.distance(0, 0, 0,
    									 (int)modelCenter.getX(), 0, (int)modelCenter.getZ());
    	if (distance >= MAX_MODEL_DISTANCE) 
    		bringModelBackHome();
    }

	/**
	 * Bring the model back home wherever it is
	 */
    public void bringModelBackHome() {
		// get model center
    	Dot modelCenter = model.getCenter();
		model.moveTo((int)getHome().getHome().getX(), (int)modelCenter.getY(), (int)getHome().getHome().getZ());
    }

    // --------------------------  load and save  -----------------------------------
	public void save(OutputStream out) throws IOException {
	    ObjectOutputStream objOut = new ObjectOutputStream(out);

	    // saves the object
		objOut.writeObject(Editor.getEditor().getWorld());
	}

    public void save(String filename, boolean setName) throws IOException {
    	if (!filename.endsWith(Editor.SAM_EXTENSION))
    		filename += Editor.SAM_EXTENSION;
    		    		
	    FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(filename);

			if (setName)
				// sets the name of the model to the file name
				Editor.getEditor().getWorld().getModel().setName(filename);
			
			// serialize
			save(fOut);
			
			try {
				fOut.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(Editor.getEditor().getMainWindow(), Messages.getString("World.6"), Messages.getString("World.7"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(Editor.getEditor().getMainWindow(), Messages.getString("World.8"), Messages.getString("World.9"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
    }
    
	public void saveAs() throws IOException {
		FilePicker picker = new FilePicker(Editor.getEditor().getMainWindow(), 
				   Messages.getString("World.10"),  //$NON-NLS-1$
				   Editor.getEditor().getLastFilePath(), 
				   true);

		if (picker.getPathname() == null) 
			return;

		Editor.getEditor().setLastFilePath(picker.getPathname());

		save(picker.getFilename(), true);
	}
    
	
	// #### quickfix to properly reload misserialized models.
	/*
	public void fixSprings() {
		Model model = getModel();
		Vector<ConnectionSet> sets = model.getConnections();
		if (sets == null)
			return;
			
		Iterator<ConnectionSet> i = sets.iterator();
		while (i.hasNext()) {
			ConnectionSet c = i.next();
			Vector<Spring> springs = c.getSprings();
			if (springs == null)
				continue;
			Iterator<Spring> j = springs.iterator();
			while (j.hasNext())
				j.next().setConnection(c);
		}
	}
	*/
	
	public void load(String filename) throws IOException, ClassNotFoundException {
		// load file
		FileInputStream fIn;
		fIn = new FileInputStream(filename);

		ObjectInputStream objIn = new ObjectInputStream(fIn);

		Editor editor = Editor.getEditor();
		editor.getEditorGUI().getConstructButton().doClick();
		editor.setWorld((World)objIn.readObject());
		editor.getWorld().getModel().setName(filename);
		
		fIn.close();
	}

	public String load() {
		FilePicker picker = new FilePicker(Editor.getEditor().getMainWindow(), 
				   Messages.getString("World.11"),  //$NON-NLS-1$
				   Editor.getEditor().getLastFilePath(), 
				   false);

		String filename = picker.getFilename();
		if (filename == null) 
			return null;
		
		try {
			load(filename);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(Editor.getEditor().getMainWindow(), Messages.getString("World.12"), Messages.getString("World.13"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(Editor.getEditor().getMainWindow(), Messages.getString("World.14"), Messages.getString("World.15"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			e.printStackTrace();
		}
		
		Editor.getEditor().setLastFilePath(filename);
		
		return filename;
    }
	
	// =================================  animator  ===================================
	/**
	 * The world animator: pulses and refresh the renderers
	 * 
	 * @author gilles fabre
	 *
	 */
    public class Animator extends Thread {
        public void run() {
        	Editor 		editor = Editor.getEditor();
        	EditorGUI	gui = editor.getEditorGUI();
        	
         	while (true) {
	        	World world = editor.getWorld();

        		// animate the world
        		try {
					sleep(ANIMATE_DELAY);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				switch (Editor.getEditor().getMode()) {
	        		case RUN_MODE:
	        			// animate the world
	        			gui.getImpulsionRenderer().ImpulsionStep((int)(IMPULSION_STEP * Editor.getEditor().getWorld().getImpulsion()));
		        		// fall through

	        		case PAUSE_MODE:
	        			world.getModel().computeReactions();
	        			world.getModel().applyReactions();
		        		// fall through
		        		
	        		default:
	        			gui.getImpulsionRenderer().invalidate();
	        			gui.getImpulsionRenderer().repaint();
	        			gui.getWorldRenderer().invalidate();
	        			gui.getWorldRenderer().repaint();
		        		break;
        		}
        	}
        }
    }
}

