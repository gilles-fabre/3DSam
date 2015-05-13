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
 * 3DSam actions
 */
package editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Box;
import model.Cone;
import model.ConnectionSet;
import model.Dot;
import model.Mass;
import model.Model;
import model.ModelPart;
import model.Pyramid;
import model.RigidBox;
import model.Sphere;
import model.Spring;
import model.Tetrahedron;
import model.Torus;
import model.Wheel;

public class EditorActions {
	// paste modes
    static enum PasteModes {NONE_MODE, COPY_MODE, CUT_MODE};
    PasteModes 	pasteMode = PasteModes.NONE_MODE;
    
    static double COPY_OFFSET = 10.0;
    
    public class ModelColorAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			World world = editor.getWorld();
			Model model = world.getModel();
			
			Color color = new ARGBColorPicker(editor.getMainWindow(), model.getColor(), false).getColor();
			if (color != null)
				model.setColor(color);

			world.setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

    private void setEditorColor(Editor.Colors colorIndex) {
		Editor editor = Editor.getEditor();
		
		Color color = new ARGBColorPicker(editor.getMainWindow(), editor.colors[colorIndex.ordinal()], false).getColor();
    	
		if (color != null)
			editor.colors[colorIndex.ordinal()] = color;

		editor.getEditorGUI().update();
    }

    public class GroundColorAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			setEditorColor(Editor.Colors.WORLD_GROUND_COLOR);
		}
	}

    public class TextColorAction implements ActionListener {
 		public void actionPerformed(ActionEvent arg0) {
 			setEditorColor(Editor.Colors.TEXT_TIP_COLOR);
 		}
 	}

    public class OverflewColorAction implements ActionListener {
 		public void actionPerformed(ActionEvent arg0) {
 			setEditorColor(Editor.Colors.OVERFLEW_COLOR);
 		}
 	}

    public class SelectionColorAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			setEditorColor(Editor.Colors.SELECTION_COLOR);
		}
	}

    public class ModelBoxColorAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			setEditorColor(Editor.Colors.MODEL_BOX_COLOR);
		}
	}

    public class IsoRenderingAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			boolean iso = editor.getEditorGUI().isoRenderingButton.isSelected();
			editor.setIsoRendering(iso);
			editor.getEditorGUI().update();
		}
	}

    public class CenteredRenderingAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			boolean centered = editor.getEditorGUI().centeredRenderingButton.isSelected();
			editor.setCenteredRendering(centered);
			editor.getEditorGUI().update();
		}
	}

    public class SaveAsAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			World world = editor.getWorld();
			
			boolean wasDirty = world.isDirty();
			world.setDirty(false);
			try {
				world.saveAs();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(editor.getMainWindow(), Messages.getString("EditorActions.0"), Messages.getString("EditorActions.1"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				world.setDirty(wasDirty);
			}
			editor.getEditorGUI().update();
		}
	}

	public class SaveAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			World world = editor.getWorld();
			
			boolean wasDirty = world.isDirty();
			world.setDirty(false);
			try {
				world.save(new String(world.getModel().getName()), false);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(editor.getMainWindow(), Messages.getString("EditorActions.2"), Messages.getString("EditorActions.3"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				world.setDirty(wasDirty);
			}
			editor.getEditorGUI().update();
		}
	}

	public class LoadAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			World world = editor.getWorld();
			
			// display an alert
    		if (world.isDirty() &&
    			JOptionPane.showConfirmDialog(editor.getMainWindow(), 
    										  Editor.LOAD_WITHOUT_SAVING, 
    										  Messages.getString("EditorActions.4"),  //$NON-NLS-1$
    										  JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
    			return;

			String newWorldName = editor.getWorld().load();
			if (newWorldName == null)
				return;
			
			// the model's name is the last saved filename... we need to fix it
			// in case the file was manually moved, else, Save will try to save it
			// to the last (potentially invalid) location.
			world.getModel().setName(newWorldName);
			// editor.getWorld().fixSprings();
			
			editor.clearHistory();
			world.setDirty(false);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}
	
	public class NewAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			World	world = editor.getWorld();

			// display an alert
    		if (world.isDirty() &&
    			JOptionPane.showConfirmDialog(editor.getMainWindow(), 
    										  Editor.NEW_WITHOUT_SAVING, 
    										  Messages.getString("EditorActions.5"),  //$NON-NLS-1$
    										  JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
    			return;

    		// pass editor into construct mode and creates a brand new model
			editor.getEditorGUI().getConstructButton().doClick();
			world.setModel(new Model(editor.getColor(Editor.Colors.MODEL_COLOR)));

			editor.clearHistory();
			editor.getWorld().setDirty(false);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewBoxAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {			
			Editor editor = Editor.getEditor();
			World  world = editor.getWorld();
			
			Box box = new Box();
			world.getModel().mergeConnections(box, false);
			editor.clearSelection();
			editor.select(box);
			
			world.setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewRigidBoxAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			World  world = editor.getWorld();

			RigidBox box = new RigidBox();
			
			world.getModel().mergeConnections(box, false);
			editor.clearSelection();
			editor.select(box);
			
			world.setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewWheelAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			Wheel 	wheel = new Wheel();
			
			editor.getWorld().getModel().mergeConnections(wheel, true);
			editor.clearSelection();
			editor.select(wheel);
			
			editor.getWorld().setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewSphereAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			Sphere sphere = new Sphere();
			
			editor.getWorld().getModel().mergeConnections(sphere, true);
			editor.clearSelection();
			editor.select(sphere);
			
			editor.getWorld().setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewConeAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			Cone cone = new Cone();
			
			editor.getWorld().getModel().mergeConnections(cone, true);
			editor.clearSelection();
			editor.select(cone);
			
			editor.getWorld().setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewTetrahedronAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			Tetrahedron tetrahedron = new Tetrahedron();
			
			editor.getWorld().getModel().mergeConnections(tetrahedron, true);
			editor.clearSelection();
			editor.select(tetrahedron);
			
			editor.getWorld().setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewPyramidAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			Pyramid pyramid = new Pyramid();
			
			editor.getWorld().getModel().mergeConnections(pyramid, true);
			editor.clearSelection();
			editor.select(pyramid);
			
			editor.getWorld().setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewTorusAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			Torus torus = new Torus();
			
			editor.getWorld().getModel().mergeConnections(torus, true);
			editor.clearSelection();
			editor.select(torus);
			
			editor.getWorld().setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class NewModelPartAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			if (editor.getSelectedMasses().isEmpty()) {
	    		JOptionPane.showMessageDialog(editor.getMainWindow(),
	    									  Editor.EMPTY_SELECTION_ERROR, 
	    									  Messages.getString("EditorActions.6"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
	    		return;
			}
			
			// pops up a dialog prompting the user for a model part name
			// then create a new named model part with the current selection
	        String name;
	        name = JOptionPane.showInputDialog(null, Messages.getString("EditorActions.7")); //$NON-NLS-1$
	        if (name != null) {
	        	editor.getWorld().getModel().addPart(new ModelPart(name));
				editor.getWorld().setDirty(true);
				editor.addHistoryState();
				editor.getEditorGUI().update();
			}
			editor.clearSelection();
		}
	}
	
	public class ManageModelPartsAction implements ActionListener {
		ModelPartsGUI	partsDialog;
		JList<String>	parts;	

		private void populateParts() {
			Vector<String> partNames = new Vector<String>(); 
			Iterator<ModelPart> i = Editor.getEditor().getWorld().getModel().getParts().iterator();
			while (i.hasNext()) 
				partNames.add(i.next().getName());
			parts.setListData(partNames);
		}
		
		private ModelPart getSelectedPart() {
			String partName = (String)parts.getSelectedValue();
			if (partName == null)
				return null;
			
			Iterator<ModelPart> i = Editor.getEditor().getWorld().getModel().getParts().iterator();
			while (i.hasNext()) {
				ModelPart part = i.next(); 
				if (part.getName().equals(partName))
					return part;
			}
			
			return null;
		}
		
		public class ClosePartsDialogAction implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				partsDialog.setVisible(false);
				partsDialog = null;

				// the user can now reopen the dialog
				Editor.getEditor().getEditorGUI().partsMenu.setEnabled(true);
			}
		}
		
		public class SelectPartAction implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				Editor editor = Editor.getEditor();

				ModelPart part = getSelectedPart();
				if (part != null) {
					Iterator<Mass> i = part.getMasses().iterator();
					while (i.hasNext())
						editor.select(i.next());

					editor.getEditorGUI().update();
				}
			}
		}

		public class DeselectPartAction implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				Editor editor = Editor.getEditor();

				ModelPart part = getSelectedPart();
				if (part != null) {
					Iterator<Mass> i = part.getMasses().iterator();
					while (i.hasNext())
						editor.deselect(i.next());

					editor.getEditorGUI().update();
				}
			}
		}

		public class DeletePartAction implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				ModelPart part = getSelectedPart();
				if (part != null) {
					Editor.getEditor().getWorld().getModel().removePart(part);
					populateParts();
				}
			}
		}

		public void actionPerformed(ActionEvent arg0) {
			// prevent the user from reopening the dialog
			Editor.getEditor().getEditorGUI().partsMenu.setEnabled(false);
			
			// pops up a dialog enabling the user to delete/select a model part in a list
			partsDialog = new ModelPartsGUI();
			parts = partsDialog.getModelPartsList();	
			
			// populate the list with the existing model parts
			populateParts();
			
			// set the button actions
			JButton	button = partsDialog.getDoneButton();
			button.addActionListener(new ClosePartsDialogAction());
			
			button = partsDialog.getSelectButton();
			button.addActionListener(new SelectPartAction());

			button = partsDialog.getDeselectButton();
			button.addActionListener(new DeselectPartAction());

			button = partsDialog.getDeleteButton();
			button.addActionListener(new DeletePartAction());

			partsDialog.setVisible(true);
		}
	}

	/**
	 * 
	 * Welds the masses in the selection, which distance is < WELD_DISTANCE
	 *
	 */
	public class WeldSelectedAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			Model  model = editor.getWorld().getModel();
			
			Iterator<Mass> srci = editor.getSelectedMasses().iterator();
			while (srci.hasNext()) {
				Mass 		 src = srci.next();
				Dot  		 srcd = new Dot(src.getX(), src.getY(), src.getZ());
				Vector<Mass> dsts = new Vector<Mass>();
				
				// find all masses close enough to src
				Iterator<Mass> dsti = editor.getSelectedMasses().iterator();
				while (dsti.hasNext()) {
					Mass dst = dsti.next();
					
					// is dst (different from src and) close enough?
					if (!dst.equals(src) && dst.distance(srcd) < Editor.WELD_DISTANCE) 
						dsts.add(dst);
				}
				
				// weld all weld candidates to src (replace them by src)
				Iterator<Mass> i = dsts.iterator();
				while (i.hasNext())
					model.replaceMass(i.next(), src);
			}
		}
	}
	
	public class ExitAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (Editor.getEditor().canExit())
				System.exit(0);
		}
	}

	public class UndoAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.undo();
			editor.getEditorGUI().update();
		}
	}
	
	public class RedoAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.redo();
			editor.getEditorGUI().update();
		}
	}
	
	public class CutSelectedAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.getClipboard().addAll(editor.getSelectedMasses());
			
			// remove cut masses from selection
			Iterator<Mass> i = editor.getClipboard().iterator();
			while (i.hasNext()) 
				editor.deselect((Mass)i.next());
			
			editor.getEditorGUI().update();
			pasteMode = PasteModes.CUT_MODE;
		}
	}

	public class CopySelectedAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.getClipboard().addAll(editor.getSelectedMasses());

			// remove copied masses from selection
			Iterator<Mass> i = editor.getClipboard().iterator();
			while (i.hasNext()) 
				editor.deselect((Mass)i.next());
			
			editor.getEditorGUI().update();
			pasteMode = PasteModes.COPY_MODE;
		}
	}

	public class PasteSelectedAction implements ActionListener {
		Mass copyMassesAux(Mass from, Vector<Mass> copiedMasses, ConnectionSet connections) {
			Editor editor = Editor.getEditor();

			Mass fromCopy = null;
			Mass toCopy = null;
			
			// if origin not in copied masses yet, copy it,
			// else retrieve existing copy
			if (!copiedMasses.contains(from)) {
				copiedMasses.add(from);
				fromCopy = new Mass(from);
				editor.select(fromCopy); // pasted masses are selected
				
				// move the copy to make it visible
				fromCopy.setX(fromCopy.getX() + COPY_OFFSET);
				fromCopy.setY(fromCopy.getY() + COPY_OFFSET);
				fromCopy.setZ(fromCopy.getZ() + COPY_OFFSET);
				
				copiedMasses.add(fromCopy);
			} else
				fromCopy = copiedMasses.get(copiedMasses.indexOf(from) + 1);
			
			// find the mass as origin or destination in the connection sets
			// then process its connections
			Iterator<ConnectionSet> i = editor.getWorld().getModel().getConnections().iterator();
			while (i.hasNext()) {
				ConnectionSet c = (ConnectionSet)i.next();
				Iterator<Spring> j = c.getSprings().iterator();
				while (j.hasNext()) {
					Mass 	to;
					Spring 	s = j.next();

					// we're following a connection from the origin
					if (from == s.getOrigin()) {
						to = s.getDestination();
					
						// if the connected mass is to be copied, recursively copy its peers
						if (editor.getClipboard().contains(to)) {

							// was this mass processed already (as an origin)?
							// if yes, just connect it (possibly twice)
							// else connect a copy returned by the recursive call
							if (copiedMasses.contains(to))
								toCopy = copiedMasses.get(copiedMasses.indexOf(to) + 1);
							else
								toCopy = copyMassesAux(to, copiedMasses, connections);

							connections.addConnection(fromCopy, toCopy, s.isRigid());
						}
					}
					
					// we're following a connection from the destination
					if (from == s.getDestination()) {
						to = s.getOrigin();
					
						// if the connected mass is to be copied, recursively copy its peers
						if (editor.getClipboard().contains(to)) {
							// was this mass processed already (as an origin)?
							// if yes, just connect it (possibly twice)
							// else connect a copy returned by the recursive call
							if (copiedMasses.contains(to))
								toCopy = copiedMasses.get(copiedMasses.indexOf(to) + 1);
							else
								toCopy = copyMassesAux(to, copiedMasses, connections);

							connections.addConnection(fromCopy, toCopy, s.isRigid());
						}
					}
				}
			}
			
			// return copy of origin
			return fromCopy;
		}
		
		void copyMasses() {
			Editor 	editor = Editor.getEditor();
			World   world = editor.getWorld();
			Model	model = world.getModel();

			Vector<Mass> 	copiedMasses = new Vector<Mass>();
			ConnectionSet	connections = new ConnectionSet(new Model());
			
			// any connected mass must have a new peer mass unless already created
			// recursively create connections
			Iterator<Mass> m = editor.getClipboard().iterator();
			while (m.hasNext()) 
				copyMassesAux((Mass)m.next(), copiedMasses, connections);
			
			Mass []connection = new Mass[2];
			Iterator<Spring> c = connections.getSprings().iterator();
			while (c.hasNext()) {
				Spring s = c.next();
				connection[0] = s.getOrigin();
				connection[1] = s.getDestination();
				model.addConnections(connection, s.isRigid()); 
			}
		}
		
		public void actionPerformed(ActionEvent arg0) {
			Editor 	editor = Editor.getEditor();
			World	world = editor.getWorld();
			Model	model = world.getModel();
			copyMasses();
	
			// now delete cut masses if a cut was requested
			if (pasteMode == PasteModes.CUT_MODE) {
				Iterator<Mass> m = editor.getClipboard().iterator();
				while (m.hasNext()) {
					model.removeMass((Mass)m.next());
					m.remove();
				}

				editor.getClipboard().clear();
			}
	
			world.setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
			pasteMode = PasteModes.NONE_MODE;
		}
	}

	public class DeleteSelectedAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			World  world = editor.getWorld();
			Model  model = world.getModel();

			Iterator<Mass> m = editor.getSelectedMasses().iterator();
			while (m.hasNext()) {
				model.removeMass((Mass)m.next());
				m.remove();
			}

			editor.getClipboard().clear();
			world.setDirty(true);
			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class SelectAllAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			// find the mass as origin in the connection sets
			// then process its connections
			Iterator<ConnectionSet> i = editor.getWorld().getModel().getConnections().iterator();
			while (i.hasNext()) {
				ConnectionSet c = (ConnectionSet)i.next();
				Iterator<Spring> j = c.getSprings().iterator();
				while (j.hasNext()) {
					Spring 	s = j.next();
					editor.select(s.getDestination());
					editor.select(s.getOrigin());
				}
			}
			editor.getEditorGUI().update();
		}
	}

	public class DeselectAllAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.clearSelection();

			editor.getEditorGUI().update();
		}
	}

	public class GravityChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			double value = ((JSlider)arg0.getSource()).getValue(); 
			Editor.getEditor().getWorld().setGravity(value / (new Double(World.MAX_GRAVITY) - new Double(World.MIN_GRAVITY)));
		}
	}

	public class FrictionChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			double value = ((JSlider)arg0.getSource()).getValue(); 
			Editor.getEditor().getWorld().setFriction(value / (new Double(World.MAX_FRICTION) - new Double(World.MIN_FRICTION)));
		}
	}

	public class StiffnessChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			double value = ((JSlider)arg0.getSource()).getValue(); 
			Editor.getEditor().getWorld().setStiffness(value / (new Double(World.MAX_STIFFNESS) - new Double(World.MIN_STIFFNESS)));
		}
	}

	public class ImpulsionChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			double value = ((JSlider)arg0.getSource()).getValue(); 
			Editor.getEditor().getWorld().setImpulsion(value / (new Double(World.MAX_IMPULSION) - new Double(World.MIN_IMPULSION)));
		}
	}

	public class RunActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.setMode(Editor.Modes.RUN_MODE);
			editor.getEditorGUI().update();
		}
	}

	public class PauseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.setMode(Editor.Modes.PAUSE_MODE);
			editor.getEditorGUI().update();
		}
	}
	
	public class ConstructActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.setMode(Editor.Modes.CONSTRUCT_MODE);
			editor.getEditorGUI().update();
		}
	}

	public class SelectActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.setMode(Editor.Modes.SELECT_MODE);
			editor.getEditorGUI().update();
		}
	}

	public class RotateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.setMode(Editor.Modes.ROTATE_MODE);
			editor.getEditorGUI().update();
		}
	}

	public class RotateXActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			
			editor.rotateSelection(45, 0, 0);

			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class RotateYActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			
			editor.rotateSelection(0, 45, 0);

			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class RotateZActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();
			
			editor.rotateSelection(0, 0, 45);

			editor.addHistoryState();
			editor.getEditorGUI().update();
		}
	}

	public class ManipulateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Editor editor = Editor.getEditor();

			editor.setMode(Editor.Modes.MANIPULATE_MODE);
			editor.getEditorGUI().update();
		}
	}
}
