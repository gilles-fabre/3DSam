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
 * 3DSam: A 3D physics model editor. Sam stands for "Springs And Masses".
 */
package editor;

import java.awt.Color;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import editor.World.Animator;
import model.Dot;
import model.Mass;
import model.Model;
import model.Spring;


public class Editor implements Serializable {
    /**
	 * non modified class serialization ID
	 */
	private static final long serialVersionUID = -7959555113688471009L;
	
	public static double 	WELD_DISTANCE = 10;
    public static String 	SAVE_BEFORE_EXITING_1 = Messages.getString("Editor.0"); //$NON-NLS-1$
	public static String 	SAVE_BEFORE_EXITING_2 = Messages.getString("Editor.1"); //$NON-NLS-1$
	public static String 	NEW_WITHOUT_SAVING = Messages.getString("Editor.2"); //$NON-NLS-1$
	public static String 	LOAD_WITHOUT_SAVING = Messages.getString("Editor.3"); //$NON-NLS-1$
	public static String 	EMPTY_SELECTION_ERROR = Messages.getString("Editor.4"); //$NON-NLS-1$
		
	
	static  Editor 			editor;			// the singleton editor
    private EditorGUI 		editorGUI;		// the whole GUI
    private EditorActions	editorActions;	// all the actions
    private Animator		animator;		// the world and renderers animator
    private Modes			mode;			// the edition mode
	private Vector<Mass>	selectedMasses;
	private Vector<Mass>	clipboard;
	private World			world;
	private String 			lastFilePath = new String(System.getProperty("user.dir")); 
	private boolean 		isoRendering;
	private boolean         centeredRendering;
	
	// this defines the fields we want to serialize
    private static final ObjectStreamField[] serialPersistentFields = {
    	new ObjectStreamField("world", World.class),
    	new ObjectStreamField("colors", Color[].class),
    	new ObjectStreamField("isoRendering", boolean.class),
    	new ObjectStreamField("centeredRendering", boolean.class)
    };

    // edition modes
    public static enum Modes {RUN_MODE, PAUSE_MODE, CONSTRUCT_MODE, SELECT_MODE, ROTATE_MODE, MANIPULATE_MODE};
    
    // editor colors
    public static enum Colors {IMPULSION_CURVE_COLOR,
    						   IMPULSION_BACKGROUND_COLOR,
    						   IMPULSION_BORDER_COLOR,
    						   IMPULSION_GRID_COLOR,
    						   WORLD_BACKGROUND_COLOR,
    						   WORLD_GROUND_COLOR,
    						   MODEL_COLOR,
    						   MODEL_BOX_COLOR,
    						   MODEL_CENTER_COLOR,
    						   SLIDER_COLOR,
    						   SELECTION_COLOR,
    						   OVERFLEW_COLOR,
    						   TEXT_TIP_COLOR,
    						   HOME_COLOR,
    						   MAX_COLOR};
    public Color	colors[] = {Color.BLUE,			// impulsion curve
    							Color.WHITE,		// impulsion curve background
    							Color.BLUE,			// impulsion curve border color
    							Color.LIGHT_GRAY,	// impulsion grid color
							    Color.WHITE,		// world background
								Color.LIGHT_GRAY,	// world ground
								Color.BLUE,			// model color 
								Color.CYAN,			// model box 
								Color.BLUE,			// model center
								Color.BLACK,		// slider
								Color.RED,			// selection
								Color.ORANGE,		// overflew object
								Color.BLUE,			// text tip
								Color.RED};			// home
    
    public static String		SAM_EXTENSION = ".3DSW";
    public static String		SAM_HISTORY_PREFIX = ".3DSAM_";
    private static String		PREFERENCES_FILE = ".3DSam.conf";
    
  	private static Vector<String>	history = new Vector<String>();
  	private	static int				historyIndex = -1;

    public Editor() {
		mode = Modes.CONSTRUCT_MODE;
	}
	
	/**
	 * 
	 * returns true if the application can be closed.
	 */
	public boolean canExit() {
		Editor 	editor = Editor.getEditor();
		World	world = editor.getWorld();
	
		if (!world.isDirty())
			return true;
		
		switch (JOptionPane.showConfirmDialog(editor.getMainWindow(),
											  SAVE_BEFORE_EXITING_1 + Editor.getEditor().getWorld().getModel().getName() + SAVE_BEFORE_EXITING_2,
											  Messages.getString("Editor.13"),  //$NON-NLS-1$
											  JOptionPane.YES_NO_CANCEL_OPTION)) {
			case JOptionPane.YES_OPTION:
				// user wants to save the model and exit.
				boolean wasDirty = world.isDirty();
				world.setDirty(false);
				try {
					world.saveAs();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(editor.getMainWindow(), Messages.getString("Editor.14"), Messages.getString("Editor.15"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
					world.setDirty(wasDirty);
					return false;
				}
				return true;
			
			case JOptionPane.NO_OPTION:
				return true;
			
			case JOptionPane.CANCEL_OPTION:
			case JOptionPane.CLOSED_OPTION:
			default:
				// User doesn't want to exit after all.
				return false;
		}
	}

    public String getLastFilePath() {
		return lastFilePath;
	}

	public boolean isIsoRendering() {
		return isoRendering;
	}
	
	public void setIsoRendering(boolean set) {
		isoRendering = set;
	}
	
	public boolean isCenteredRendering() {
		return centeredRendering;
	}

	public void setCenteredRendering(boolean set) {
		centeredRendering = set;
	}
	
	public void setLastFilePath(String path) {
		lastFilePath = new String(path);
	}

	public World getWorld() {
		if (world == null) 
			world = new World();
	
		return world;
	}
	
	public void setWorld(World _world) {
		world = _world;
	}

	static public Editor getEditor() {
    	if (editor == null) 
    		editor = new Editor();
    	
    	return editor;
    }
    	
    public Animator getAnimator() {
    	if (animator == null) 
    		animator = getWorld().new Animator();

    	return animator;
    }
    
	public EditorGUI getEditorGUI() {
		if (editorGUI == null) {
			editorGUI = new EditorGUI();

			try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (Exception e) {
			    // If Nimbus is not available, you can set the GUI to another look and feel.
			}

			editorGUI.update();
		}
		
		return editorGUI;
	}
	
	public JFrame getMainWindow() {
		return getEditorGUI().getMainWindow();
	}
	
	public EditorActions getEditorActions() {
		if (editorActions == null)
			editorActions = new EditorActions();
		
		return editorActions;
	}
	
	public void setMode(Modes value) {
		mode = value;
	}

	public Modes getMode() {
		return mode;
	}

	public Vector<Mass>	getSelectedMasses() {
		if (selectedMasses == null)
			selectedMasses = new Vector<Mass>();
		
		return selectedMasses;
	}
	
	public Vector<Mass>	getClipboard() {
		if (clipboard == null)
			clipboard = new Vector<Mass>();
		
		return clipboard;
	}
	
	void loadPreferences() {
		// does the prefs file exist?
		File f = new File(PREFERENCES_FILE);
		if (!f.exists())
			return;
		
		// load file
		FileInputStream fIn;
		try {
			fIn = new FileInputStream(PREFERENCES_FILE);

			ObjectInputStream objIn = new ObjectInputStream(fIn);
			Editor prefs = (Editor)objIn.readObject();
			colors = prefs.colors;
			world = prefs.world; 
			isoRendering = prefs.isoRendering;
			centeredRendering = prefs.centeredRendering;
			fIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void savePreferences() {
		// save file
		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(PREFERENCES_FILE);

			ObjectOutputStream objOut = new ObjectOutputStream(fOut);
			objOut.writeObject(this);
			fOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void run() {
		Window wnd = getMainWindow();
		addHistoryState();
		getAnimator().start();
		wnd.setVisible(true);
	}
	
    Color getColor(Colors color) {
    	if (color.ordinal() > Colors.MAX_COLOR.ordinal())
    		return Color.BLACK;
    	
    	return colors[color.ordinal()];
    }

    public boolean isSelection() {
    	boolean isSelection = !getSelectedMasses().isEmpty();

    	Iterator<JComponent> i = getEditorGUI().getSelectionButtons().iterator();
    	while (i.hasNext()) 
    		i.next().setEnabled(isSelection);
    
    	return isSelection;
    }

    public boolean isSelected(Mass mass) {
    	return getSelectedMasses().contains(mass); 
    }
    
    public boolean isSelected(Spring spring) {
    	return getSelectedMasses().contains(spring.getOrigin()) &&
    		   getSelectedMasses().contains(spring.getDestination()); 
    }

    public void select(Spring s) {
    	if (!isSelected(s)) {
    		select(s.getOrigin());
    		select(s.getDestination());
    	}
    }
    
    public void deselect(Spring s) {
    	if (isSelected(s)) {
    		deselect(s.getOrigin());
    		deselect(s.getDestination());
    	}
    }

    public void select(Mass m) {
    	if (!isSelected(m))
    		getSelectedMasses().add(m); 
    }

    public void deselect(Mass m) {
    	if (isSelected(m))
    		getSelectedMasses().remove(m); 
    }

    public void clearSelection() {
		getSelectedMasses().clear();
    }
    
    public void select(Model m) {
    	getSelectedMasses().addAll(m.getMasses());
    }
    
    
    public void undo() {
    	if (historyIndex > 0)  {
    		try {
				getWorld().load(history.elementAt(--historyIndex));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public void redo() {
    	if (historyIndex < history.size() - 1) {
    		try {
				getWorld().load(history.elementAt(++historyIndex));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

    public boolean canUndo() {
    	return (historyIndex > 0);
    }
    
    public boolean canRedo() {
    	return (historyIndex < history.size() - 1); 
    }

    public void addHistoryState() {
		File hFile;
		try {
			hFile = File.createTempFile(SAM_HISTORY_PREFIX, SAM_EXTENSION);
			hFile.deleteOnExit();
			String hFilename = hFile.getCanonicalPath();
	    	getWorld().save(hFilename, false);
	    	history.insertElementAt(hFilename, ++historyIndex);
	    	
	    	// remove potentially inconsistent trailing history
	    	if (historyIndex < history.size() - 1)
	    		clearTrailingHistory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void clearTrailingHistory() {
    	Iterator<String> i = history.listIterator(historyIndex + 1);
    	while (i.hasNext()) {
    		File file = new File(i.next());
    		file.delete();
    	}

    	history.setSize(historyIndex + 1);
    }
    
    public void clearHistory() {
    	historyIndex = 0;
    	clearTrailingHistory();
    	historyIndex = -1;
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	getEditor().run();
            }
        });
	}
	
	/**
	 * Get the selection bounding box
	 */
	public void getSelectionBoundingBox(Dot frontUpperLeft, Dot backBottomRight) {
		Vector<Mass> masses = Editor.getEditor().getSelectedMasses();
		if (masses.isEmpty())
			return;

		Mass mass = masses.get(0);
		
		frontUpperLeft.setX(mass.getX());
		frontUpperLeft.setY(mass.getY());
		frontUpperLeft.setZ(mass.getZ());
		backBottomRight.setX(mass.getX());
		backBottomRight.setY(mass.getY());
		backBottomRight.setZ(mass.getZ());
		
		Iterator<Mass> i = masses.iterator();
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
	 * Get the Selection center point.
	 */
	private Dot getSelectionCenter() {
		Dot frontUpperLeft = new Dot();
		Dot backBottomRight = new Dot();
		getSelectionBoundingBox(frontUpperLeft, backBottomRight);
		Dot center = new Dot((backBottomRight.getX() + frontUpperLeft.getX()) / 2,
					   		 (frontUpperLeft.getY() + backBottomRight.getY()) / 2,
					   		 (backBottomRight.getZ() + frontUpperLeft.getZ()) / 2);
		return center;
	}
	
	/**
	 * Align the selection.
	 */
	public void alignSelectionOnX() {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Dot selectionCenter = getSelectionCenter();
			
		Iterator<Mass> i = getSelectedMasses().iterator();
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.setX(selectionCenter.getX());
		}

		model.changeHome(modelCenter);
	}
	
	public void alignSelectionOnY() {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Dot selectionCenter = getSelectionCenter();
			
		Iterator<Mass> i = getSelectedMasses().iterator();
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.setY(selectionCenter.getY());
		}

		model.changeHome(modelCenter);
	}

	public void alignSelectionOnZ() {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Dot selectionCenter = getSelectionCenter();
			
		Iterator<Mass> i = getSelectedMasses().iterator();
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.setZ(selectionCenter.getZ());
		}

		model.changeHome(modelCenter);
	}

	/**
	 * Rotate the selection.
	 */
	public void rotateSelection(int xAngle, int yAngle, int zAngle) {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Iterator<Mass> i = getSelectedMasses().iterator();
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.rotate(xAngle, yAngle, zAngle);
		}
		
		model.changeHome(modelCenter);
	}
	
	/**
	 * Translate the selection.
	 */
	public void translateSelection(int xOffset, int yOffset, int zOffset) {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());

		Iterator<Mass> i = getSelectedMasses().iterator();
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.translate(xOffset, yOffset, zOffset);
		}
		
		model.changeHome(modelCenter);
	}

	/**
	 * Scale the selection.
	 */
	public void scaleSelection(double xRatio, double yRatio, double zRatio) {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Iterator<Mass> i = getSelectedMasses().iterator();
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.scale(xRatio, yRatio, zRatio);
		}
		
		model.changeHome(modelCenter);
	}

	/**
	 * Distribute the selection.
	 */
	public void distributeSelectionOnX() {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Dot ful = new Dot();
		Dot bbr = new Dot();
		getSelectionBoundingBox(ful, bbr);
		double width = bbr.getX() - ful.getX();		

		getSelectedMasses().sort(Dot.CompareOnX);
		
		Iterator<Mass> i = getSelectedMasses().iterator();
		double delta = width / (getSelectedMasses().size() - 1);
		double offset = ful.getX(); 
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.setX(offset);
			offset += delta;
		}

		model.changeHome(modelCenter);
	}

	public void distributeSelectionOnY() {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Dot ful = new Dot();
		Dot bbr = new Dot();
		getSelectionBoundingBox(ful, bbr);
		double height = bbr.getY() - ful.getY();		

		getSelectedMasses().sort(Dot.CompareOnY);

		Iterator<Mass> i = getSelectedMasses().iterator();
		double delta = height / (getSelectedMasses().size() - 1);
		double offset = ful.getY(); 
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.setY(offset);
			offset += delta;
		}

		model.changeHome(modelCenter);
	}

	public void distributeSelectionOnZ() {
		Model model = world.getModel();
		
		// actions on the selection are relative to the selection center
		Dot modelCenter = model.getHome();
		model.changeHome(getSelectionCenter());
			
		Dot ful = new Dot();
		Dot bbr = new Dot();
		getSelectionBoundingBox(ful, bbr);
		double depth = bbr.getZ() - ful.getZ();		

		getSelectedMasses().sort(Dot.CompareOnZ);

		Iterator<Mass> i = getSelectedMasses().iterator();
		double delta = depth / (getSelectedMasses().size() - 1);
		double offset = ful.getZ(); 
		while (i.hasNext()) {
			Mass m = (Mass)i.next();
			m.setZ(offset);
			offset += delta;
		}

		model.changeHome(modelCenter);
	}
}

