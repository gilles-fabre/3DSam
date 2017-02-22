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
 * The 3DSam main module: main and all the GUI stuff is here
 *
 */
package editor;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class EditorGUI {

	static final int TOP_PAD = 5, 
					 LEFT_PAD = 5, 
					 BOTTOM_PAD = 5, 
					 RIGHT_PAD = 5;
	
	Window			mainWindow;  
	WorldRenderer	worldRenderer;
	JPanel			worldControlPane;
	JPanel			springsControlPane;
	JSlider			gravitySlider;
	JSlider			frictionSlider;
	JSlider			stiffnessSlider;
	JSlider			impulsionSlider;
	JToolBar		toolbar;
	JSplitPane		hSplitPane;
	JSplitPane		vSplitPane;
	JMenuBar		menuBar;
	JMenu			worldMenu;
	JMenu			colorMenu;
	JMenuItem		modelColorMenuItem;
	JMenuItem		groundColorMenuItem;
	JMenuItem		textColorMenuItem;
	JMenuItem		selectionColorMenuItem;
	JMenuItem		overflewColorMenuItem;
	JMenuItem		modelBoxColorMenuItem;
	JMenuItem		newMenuItem;
	JMenuItem		newBoxMenuItem;
	JMenuItem		newRigidBoxMenuItem;
	JMenuItem		newSphereMenuItem;
	JMenuItem		newConeMenuItem;
	JMenuItem		newTetrahedronMenuItem;
	JMenuItem		newPyramidMenuItem;
	JMenuItem		newTorusMenuItem;
	JMenuItem		newWheelMenuItem;
	JMenuItem		loadMenuItem;
	JMenuItem		saveMenuItem;
	JMenuItem		saveAsMenuItem;
	JMenuItem		exitMenuItem;
	JMenu			editMenu;
	JMenu			partsMenu;
	JMenu			renderingMenu;
	JMenuItem		undoMenuItem;
	JMenuItem		redoMenuItem;
	JMenuItem		cutMenuItem;
	JMenuItem		copyMenuItem;
	JMenuItem		pasteMenuItem;
	JMenuItem		weldMenuItem;
	JMenuItem		selectAllMenuItem;
	JMenuItem		deselectAllMenuItem;
	JMenuItem		newModelPartMenuItem;
	JMenuItem		manageModelPartsMenuItem;
	JMenuItem		deleteMenuItem;
	JMenu			optionsMenu;
	JToggleButton	constructButton;
	JCheckBoxMenuItem	isoRenderingButton;
	JCheckBoxMenuItem	centeredRenderingButton;

	ImpulsionRenderer impulsionRenderer;
	
	public class Window extends JFrame {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * default constructor enables events processing.
		 * Resize events will be used to dynamically adjust the Editor's panes layout
		 */
		public Window() {
	        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

			Editor.getEditor().loadPreferences();
			addWindowListener(new CloseWindowListener());		
	        
	        enableEvents(ComponentEvent.COMPONENT_RESIZED);
		}

		class CloseWindowListener extends WindowAdapter {
            public void windowClosing(java.awt.event.WindowEvent evt){
            	Editor editor = Editor.getEditor();
            	if (editor.canExit()) {
            		editor.savePreferences();
                	System.exit(0);
                }
            }
		}

		/**
		 * process COMPONENT_RESIZED event to set the split panes positions.
		 */
		protected void processComponentEvent(ComponentEvent e) {
			super.processComponentEvent(e);
			if (e.getID() == ComponentEvent.COMPONENT_RESIZED) {
				if (vSplitPane != null) 
					vSplitPane.setDividerLocation(2 * (getHeight() / 3));
				if (hSplitPane != null) 
					hSplitPane.setDividerLocation(getWidth() / 4);
			}
		}
		
		public void updateAll(JComponent source) {
			// #### call any embedded swing component's updateUI method
			super.repaint();
		}
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println(Messages.getString("EditorGUI.0") + path); //$NON-NLS-1$
            return null;
        }
    }

	/** getMainWindow
	 * This method initializes mainWindow	
	 * 	
	 * @return javax.swing.Window	
	 */
	public Window getMainWindow() {
		if (mainWindow == null) {
			mainWindow = new Window();
			mainWindow.setTitle(Messages.getString("EditorGUI.1")); //$NON-NLS-1$
			mainWindow.setLocation(new java.awt.Point(0,0));
			mainWindow.setJMenuBar(getMenuBar());
			mainWindow.setSize(new java.awt.Dimension(800,600));
			
			vSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, getWorldRenderer(), getWorldControlPane());
			vSplitPane.setDividerLocation(2 * (mainWindow.getHeight() / 3));
			vSplitPane.setOneTouchExpandable(true);

			hSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, getSpringsControlPane(), vSplitPane);
			hSplitPane.setDividerLocation(mainWindow.getWidth() / 4);
			hSplitPane.setOneTouchExpandable(true);
	        mainWindow.add(getToolBar(), BorderLayout.PAGE_START);
			mainWindow.add(hSplitPane, BorderLayout.CENTER);
		}
		
		return mainWindow;
	}
	
	private JPanel getWorldControlPane() {
		if (worldControlPane == null) {
			worldControlPane = new JPanel();
			
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.weightx = 0.0D;
			gridBagConstraints.weighty = 1.0D;
			gridBagConstraints.anchor = GridBagConstraints.CENTER;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.insets = new Insets(TOP_PAD, LEFT_PAD, BOTTOM_PAD, RIGHT_PAD);
			worldControlPane.setLayout(new GridBagLayout());

			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			worldControlPane.add(new JLabel(Messages.getString("EditorGUI.2")), gridBagConstraints); //$NON-NLS-1$
			gridBagConstraints.gridy = 1;
			worldControlPane.add(new JLabel(Messages.getString("EditorGUI.3")), gridBagConstraints); //$NON-NLS-1$
			gridBagConstraints.gridy = 2;
			worldControlPane.add(new JLabel(Messages.getString("EditorGUI.4")), gridBagConstraints); //$NON-NLS-1$
			
			gridBagConstraints.weightx = 1.0D;
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			worldControlPane.add(getGravitySlider(), gridBagConstraints);
			gridBagConstraints.gridy = 1;
			worldControlPane.add(getFrictionSlider(), gridBagConstraints);
			gridBagConstraints.gridy = 2;
			worldControlPane.add(getStiffnessSlider(), gridBagConstraints);
		}
		
		return worldControlPane;
	}

	private JSlider getGravitySlider() {
		if (gravitySlider == null) {
			gravitySlider = new JSlider(World.MIN_GRAVITY, World.MAX_GRAVITY, World.DEFAULT_GRAVITY);
			
//			Hashtable labels = gravitySlider.createStandardLabels(SLIDER_MAJOR_TICKS_SPACING, MIN_SLIDER_VALUE);
			gravitySlider.setToolTipText(Messages.getString("EditorGUI.5")); //$NON-NLS-1$
			gravitySlider.setMajorTickSpacing(World.GRAVITY_MAJOR_INCREMENT);
			gravitySlider.setMinorTickSpacing(World.GRAVITY_MINOR_INCREMENT);
//			gravitySlider.setSnapToTicks(true);
			gravitySlider.setPaintTicks(true);
//			gravitySlider.setPaintLabels(true);
//			gravitySlider.setLabelTable(labels);
			gravitySlider.addChangeListener(Editor.getEditor().getEditorActions().new GravityChangeListener());
		}
		
		return gravitySlider;
	}
	
	private JSlider getFrictionSlider() {
		if (frictionSlider == null) {
			frictionSlider = new JSlider(World.MIN_FRICTION, World.MAX_FRICTION, World.DEFAULT_FRICTION);

//			Hashtable labels = frictionSlider.createStandardLabels(SLIDER_MAJOR_TICKS_SPACING, MIN_SLIDER_VALUE);
			frictionSlider.setToolTipText(Messages.getString("EditorGUI.6")); //$NON-NLS-1$
			frictionSlider.setMajorTickSpacing(World.FRICTION_MAJOR_INCREMENT);
			frictionSlider.setMinorTickSpacing(World.FRICTION_MINOR_INCREMENT);
//			frictionSlider.setSnapToTicks(true);
			frictionSlider.setPaintTicks(true);
//			frictionSlider.setPaintLabels(true);
//			frictionSlider.setLabelTable(labels);
			frictionSlider.addChangeListener(Editor.getEditor().getEditorActions().new FrictionChangeListener());
		}
		
		return frictionSlider;
	}

	private JSlider getStiffnessSlider() {
		if (stiffnessSlider == null) {
			stiffnessSlider = new JSlider(World.MIN_STIFFNESS, World.MAX_STIFFNESS, World.DEFAULT_STIFFNESS);

//			Hashtable labels = stiffnessSlider.createStandardLabels(SLIDER_MAJOR_TICKS_SPACING, MIN_SLIDER_VALUE);
			stiffnessSlider.setToolTipText(Messages.getString("EditorGUI.7")); //$NON-NLS-1$
			stiffnessSlider.setMajorTickSpacing(World.STIFFNESS_MAJOR_INCREMENT);
			stiffnessSlider.setMinorTickSpacing(World.STIFFNESS_MINOR_INCREMENT);
//			stiffnessSlider.setSnapToTicks(true);
			stiffnessSlider.setPaintTicks(true);
//			stiffnessSlider.setPaintLabels(true);
//			stiffnessSlider.setLabelTable(labels);
			stiffnessSlider.addChangeListener(Editor.getEditor().getEditorActions().new StiffnessChangeListener());
		}
		
		return stiffnessSlider;
	}

	private JSlider getImpulsionSlider() {
		if (impulsionSlider == null) {
			impulsionSlider = new JSlider(World.MIN_IMPULSION, World.MAX_IMPULSION, World.DEFAULT_IMPULSION);
			impulsionSlider.setOrientation(JSlider.VERTICAL);
			
//			Hashtable labels = impulsionSlider.createStandardLabels(SLIDER_MAJOR_TICKS_SPACING, MIN_SLIDER_VALUE);
			impulsionSlider.setToolTipText(Messages.getString("EditorGUI.100")); //$NON-NLS-1$
			impulsionSlider.setMajorTickSpacing(World.IMPULSION_MAJOR_INCREMENT);
			impulsionSlider.setMinorTickSpacing(World.IMPULSION_MINOR_INCREMENT);
//			impulsionSlider.setSnapToTicks(true);
			impulsionSlider.setPaintTicks(true);
//			impulsionSlider.setPaintLabels(true);
//			impulsionSlider.setLabelTable(labels);
			impulsionSlider.addChangeListener(Editor.getEditor().getEditorActions().new ImpulsionChangeListener());
		}
		
		return impulsionSlider;
	}

	private JPanel getSpringsControlPane() {
		if (springsControlPane == null) {
			springsControlPane = new JPanel();
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.weightx = 1.0D;
			gridBagConstraints.weighty = 0.0D;
			gridBagConstraints.insets = new Insets(TOP_PAD, LEFT_PAD, BOTTOM_PAD, RIGHT_PAD);
			springsControlPane.setLayout(new GridBagLayout());

			gridBagConstraints.anchor = GridBagConstraints.NORTH;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			springsControlPane.add(new JLabel(Messages.getString("EditorGUI.9")), gridBagConstraints); //$NON-NLS-1$
			
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weightx = 1.0D;
			gridBagConstraints.weighty = 1.0D;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 1;
			springsControlPane.add(getImpulsionRenderer(), gridBagConstraints);

			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.weightx = 0.0D;
			gridBagConstraints.weighty = 1.0D;
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 1;
			springsControlPane.add(getImpulsionSlider(), gridBagConstraints);
		}
		
		return springsControlPane;
	}
	
	public JCheckBoxMenuItem getIsoRenderingButton() {
		if (isoRenderingButton == null) 
			isoRenderingButton = new JCheckBoxMenuItem();
			
		return isoRenderingButton;
	}
	
	public JCheckBoxMenuItem getCenteredRenderingButton() {
		if (centeredRenderingButton == null) 
			centeredRenderingButton = new JCheckBoxMenuItem();
		
		return centeredRenderingButton;
	}

	public JToggleButton getConstructButton() {
		if (constructButton == null)
			constructButton = new JToggleButton();
		
		return constructButton;
	}
	
	private JToolBar getToolBar() {
		Editor 			editor = Editor.getEditor();
		EditorActions	actions = editor.getEditorActions();
		
		if (toolbar == null) {
			toolbar = new JToolBar();
			
			ButtonGroup group = new ButtonGroup();
			
			JToggleButton button = getConstructButton();
			//button.setText("Construct");
			button.setToolTipText(Messages.getString("EditorGUI.10")); //$NON-NLS-1$
			ImageIcon icon = createImageIcon("/resources/construct_40x40.jpeg");
			button.setIcon(icon);
			group.add(button);
			toolbar.add(button);
			button.setSelected(true);
			button.addActionListener(actions.new ConstructActionListener());
			
			button = new JToggleButton();
			//button.setText("Select");
			button.setToolTipText(Messages.getString("EditorGUI.12")); //$NON-NLS-1$
			icon = createImageIcon("/resources/select_40x40.jpeg");
			button.setIcon(icon);
			group.add(button);
			toolbar.add(button);
			button.addActionListener(actions.new SelectActionListener());

			button = new JToggleButton();
			//button.setText("Manipulate");
			button.setToolTipText(Messages.getString("EditorGUI.14")); //$NON-NLS-1$
			icon = createImageIcon("/resources/manipulate_40x40.jpeg");
			button.setIcon(icon);
			group.add(button);
			toolbar.add(button);
			button.addActionListener(actions.new ManipulateActionListener());

			button = new JToggleButton();
			//button.setText("Run");
			button.setToolTipText(Messages.getString("EditorGUI.16")); //$NON-NLS-1$
			button.setIcon(createImageIcon("/resources/run_40x40.jpeg"));
			button.addActionListener(actions.new RunActionListener());
			group.add(button);
			toolbar.add(button);
		
			button = new JToggleButton();
			//button.setText("Pause");
			button.setToolTipText(Messages.getString("EditorGUI.18")); //$NON-NLS-1$
			button.setIcon(createImageIcon("/resources/pause_40x40.jpeg"));
			button.addActionListener(actions.new PauseActionListener());
			group.add(button);
			toolbar.add(button);
			
			button = new JToggleButton();
			//button.setText("Rotate/Zoom");
			button.setToolTipText(Messages.getString("EditorGUI.20")); //$NON-NLS-1$
			icon = createImageIcon("/resources/rotate_40x40.jpeg");
			button.setIcon(icon);
			group.add(button);
			toolbar.add(button);
			button.addActionListener(actions.new RotateActionListener());

			toolbar.add(new JSeparator());
			
			JButton actionbutton = new JButton();
			//actionbutton.setText("X Rotate");
			actionbutton.setToolTipText(Messages.getString("EditorGUI.22")); //$NON-NLS-1$
			icon = createImageIcon("/resources/rotateX_40x40.jpeg");
			actionbutton.setIcon(icon);
			toolbar.add(actionbutton);
			actionbutton.addActionListener(actions.new RotateXActionListener());

			actionbutton = new JButton();
			//actionbutton.setText("Y Rotate");
			actionbutton.setToolTipText(Messages.getString("EditorGUI.24")); //$NON-NLS-1$
			icon = createImageIcon("/resources/rotateY_40x40.jpeg");
			actionbutton.setIcon(icon);
			toolbar.add(actionbutton);
			actionbutton.addActionListener(actions.new RotateYActionListener());
		
			actionbutton = new JButton();
			//actionbutton.setText("Z Rotate");
			actionbutton.setToolTipText(Messages.getString("EditorGUI.26")); //$NON-NLS-1$
			icon = createImageIcon("/resources/rotateZ_40x40.jpeg");
			actionbutton.setIcon(icon);
			toolbar.add(actionbutton);
			actionbutton.addActionListener(actions.new RotateZActionListener());
		}
		
		return toolbar;
	}

	/**
	 * This method initializes menuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getWorldMenu());
			menuBar.add(getEditMenu());
			menuBar.add(getPartsMenu());
			menuBar.add(getRenderingMenu());
			menuBar.add(getColorsMenu());
		}

		return menuBar;
	}

	/**
	 * This method initializes worldMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getWorldMenu() {
		if (worldMenu == null) {
			worldMenu = new JMenu();
			worldMenu.setText(Messages.getString("EditorGUI.28")); //$NON-NLS-1$
			//worldMenu.setMnemonic(KeyEvent.VK_W);
			worldMenu.add(getNewMenuItem());
			worldMenu.add(getLoadMenuItem());
			worldMenu.add(getSaveMenuItem());
			worldMenu.add(getSaveAsMenuItem());
			worldMenu.add(new JSeparator());
			worldMenu.add(getExitMenuItem());
		}
		return worldMenu;
	}

	/**
	 * This method initializes colorsMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getColorsMenu() {
		if (colorMenu == null) {
			colorMenu = new JMenu();
			colorMenu.setText(Messages.getString("EditorGUI.29")); //$NON-NLS-1$
			//colorMenu.setMnemonic(KeyEvent.VK_C);
			colorMenu.add(getModelColorMenuItem());
			colorMenu.add(getGroundColorMenuItem());
			colorMenu.add(getTextColorMenuItem());
			colorMenu.add(getOverflewColorMenuItem());
			colorMenu.add(getSelectionColorMenuItem());
			colorMenu.add(getModelBoxColorMenuItem());
		}
		return colorMenu;
	}

	/**
	 * This method initializes modelColorMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getModelColorMenuItem() {
		if (modelColorMenuItem == null) {
			modelColorMenuItem = new JMenuItem();
			modelColorMenuItem.setText(Messages.getString("EditorGUI.30")); //$NON-NLS-1$
			//modelColorMenuItem.setMnemonic(KeyEvent.VK_M);
			modelColorMenuItem.setToolTipText(Messages.getString("EditorGUI.31")); //$NON-NLS-1$
			modelColorMenuItem.addActionListener(Editor.getEditor().getEditorActions().new ModelColorAction());
		}
		return modelColorMenuItem;
	}

	/**
	 * This method initializes groundColorMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getGroundColorMenuItem() {
		if (groundColorMenuItem == null) {
			groundColorMenuItem = new JMenuItem();
			groundColorMenuItem.setText(Messages.getString("EditorGUI.32")); //$NON-NLS-1$
			//groundColorMenuItem.setMnemonic(KeyEvent.VK_G);
			groundColorMenuItem.setToolTipText(Messages.getString("EditorGUI.33")); //$NON-NLS-1$
			groundColorMenuItem.addActionListener(Editor.getEditor().getEditorActions().new GroundColorAction());
		}
		return groundColorMenuItem;
	}

	/**
	 * This method initializes textColorMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTextColorMenuItem() {
		if (textColorMenuItem == null) {
			textColorMenuItem = new JMenuItem();
			textColorMenuItem.setText(Messages.getString("EditorGUI.34")); //$NON-NLS-1$
			//textColorMenuItem.setMnemonic(KeyEvent.VK_T);
			textColorMenuItem.setToolTipText(Messages.getString("EditorGUI.35")); //$NON-NLS-1$
			textColorMenuItem.addActionListener(Editor.getEditor().getEditorActions().new TextColorAction());
		}
		return textColorMenuItem;
	}

	/**
	 * This method initializes overflewColorMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getOverflewColorMenuItem() {
		if (overflewColorMenuItem == null) {
			overflewColorMenuItem = new JMenuItem();
			overflewColorMenuItem.setText(Messages.getString("EditorGUI.36")); //$NON-NLS-1$
			//overflewColorMenuItem.setMnemonic(KeyEvent.VK_O);
			overflewColorMenuItem.setToolTipText(Messages.getString("EditorGUI.37")); //$NON-NLS-1$
			overflewColorMenuItem.addActionListener(Editor.getEditor().getEditorActions().new OverflewColorAction());
		}
		return overflewColorMenuItem;
	}

	/**
	 * This method initializes selectionColorMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSelectionColorMenuItem() {
		if (selectionColorMenuItem == null) {
			selectionColorMenuItem = new JMenuItem();
			selectionColorMenuItem.setText(Messages.getString("EditorGUI.38")); //$NON-NLS-1$
			//selectionColorMenuItem.setMnemonic(KeyEvent.VK_S);
			selectionColorMenuItem.setToolTipText(Messages.getString("EditorGUI.39")); //$NON-NLS-1$
			selectionColorMenuItem.addActionListener(Editor.getEditor().getEditorActions().new SelectionColorAction());
		}
		return selectionColorMenuItem;
	}
	
	/**
	 * This method initializes modelBoxColorMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getModelBoxColorMenuItem() {
		if (modelBoxColorMenuItem == null) {
			modelBoxColorMenuItem = new JMenuItem();
			modelBoxColorMenuItem.setText(Messages.getString("EditorGUI.40")); //$NON-NLS-1$
			//modelBoxColorMenuItem.setMnemonic(KeyEvent.VK_B);
			modelBoxColorMenuItem.setToolTipText(Messages.getString("EditorGUI.41")); //$NON-NLS-1$
			modelBoxColorMenuItem.addActionListener(Editor.getEditor().getEditorActions().new ModelBoxColorAction());
		}
		return modelBoxColorMenuItem;
	}
	
	/**
	 * This method initializes loadMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getLoadMenuItem() {
		if (loadMenuItem == null) {
			loadMenuItem = new JMenuItem();
			loadMenuItem.setText(Messages.getString("EditorGUI.42")); //$NON-NLS-1$
			//loadMenuItem.setMnemonic(KeyEvent.VK_L);
			loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.CTRL_MASK));
			loadMenuItem.setToolTipText(Messages.getString("EditorGUI.43")); //$NON-NLS-1$
			loadMenuItem.addActionListener(Editor.getEditor().getEditorActions().new LoadAction());
		}
		return loadMenuItem;
	}

	/**
	 * This method initializes saveAsMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveAsMenuItem() {
		if (saveAsMenuItem == null) {
			saveAsMenuItem = new JMenuItem();
			saveAsMenuItem.setText(Messages.getString("EditorGUI.44")); //$NON-NLS-1$
			//saveAsMenuItem.setMnemonic(KeyEvent.VK_A);
			saveAsMenuItem.setToolTipText(Messages.getString("EditorGUI.45")); //$NON-NLS-1$
			saveAsMenuItem.addActionListener(Editor.getEditor().getEditorActions().new SaveAsAction());
		}
		return saveAsMenuItem;
	}

	/**
	 * This method initializes saveMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText(Messages.getString("EditorGUI.46")); //$NON-NLS-1$
			//saveMenuItem.setMnemonic(KeyEvent.VK_S);
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
			saveMenuItem.setToolTipText(Messages.getString("EditorGUI.47")); //$NON-NLS-1$
			saveMenuItem.addActionListener(Editor.getEditor().getEditorActions().new SaveAction());
		}
		return saveMenuItem;
	}

	/**
	 * This method initializes exitMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText(Messages.getString("EditorGUI.48")); //$NON-NLS-1$
			//exitMenuItem.setMnemonic(KeyEvent.VK_X);
			exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));
			exitMenuItem.setToolTipText(Messages.getString("EditorGUI.49")); //$NON-NLS-1$
			exitMenuItem.addActionListener(Editor.getEditor().getEditorActions().new ExitAction());
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes newMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewMenuItem() {
		if (newMenuItem == null) {
			newMenuItem = new JMenuItem();
			newMenuItem.setText(Messages.getString("EditorGUI.50")); //$NON-NLS-1$
			//newMenuItem.setMnemonic(KeyEvent.VK_N);
			newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
			newMenuItem.setToolTipText(Messages.getString("EditorGUI.51")); //$NON-NLS-1$
			newMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewAction());
		}
		return newMenuItem;
	}

	/**
	 * This method initializes newBoxMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewBoxMenuItem() {
		if (newBoxMenuItem == null) {
			newBoxMenuItem = new JMenuItem();
			newBoxMenuItem.setText(Messages.getString("EditorGUI.52")); //$NON-NLS-1$
			newBoxMenuItem.setToolTipText(Messages.getString("EditorGUI.53")); //$NON-NLS-1$
			newBoxMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewBoxAction());
		}
		return newBoxMenuItem;
	}

	/**
	 * This method initializes newSphereItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	@SuppressWarnings("unused")
	private JMenuItem getNewSphereMenuItem() {
		if (newSphereMenuItem == null) {
			newSphereMenuItem = new JMenuItem();
			newSphereMenuItem.setText(Messages.getString("EditorGUI.54")); //$NON-NLS-1$
			newSphereMenuItem.setToolTipText(Messages.getString("EditorGUI.55")); //$NON-NLS-1$
			newSphereMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewSphereAction());
		}
		return newSphereMenuItem;
	}

	/**
	 * This method initializes newConeMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewConeMenuItem() {
		if (newConeMenuItem == null) {
			newConeMenuItem = new JMenuItem();
			newConeMenuItem.setText(Messages.getString("EditorGUI.56")); //$NON-NLS-1$
			newConeMenuItem.setToolTipText(Messages.getString("EditorGUI.57")); //$NON-NLS-1$
			newConeMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewConeAction());
		}
		return newConeMenuItem;
	}

	/**
	 * This method initializes newTetrahedronMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewTetrahedronMenuItem() {
		if (newTetrahedronMenuItem == null) {
			newTetrahedronMenuItem = new JMenuItem();
			newTetrahedronMenuItem.setText(Messages.getString("EditorGUI.58")); //$NON-NLS-1$
			newTetrahedronMenuItem.setToolTipText(Messages.getString("EditorGUI.59")); //$NON-NLS-1$
			newTetrahedronMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewTetrahedronAction());
		}
		return newTetrahedronMenuItem;
	}

	/**
	 * This method initializes newPyramidMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewPyramidMenuItem() {
		if (newPyramidMenuItem == null) {
			newPyramidMenuItem = new JMenuItem();
			newPyramidMenuItem.setText(Messages.getString("EditorGUI.60")); //$NON-NLS-1$
			newPyramidMenuItem.setToolTipText(Messages.getString("EditorGUI.61")); //$NON-NLS-1$
			newPyramidMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewPyramidAction());
		}
		return newPyramidMenuItem;
	}

	/**
	 * This method initializes newTorusMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	@SuppressWarnings("unused")
	private JMenuItem getNewTorusMenuItem() {
		if (newTorusMenuItem == null) {
			newTorusMenuItem = new JMenuItem();
			newTorusMenuItem.setText(Messages.getString("EditorGUI.62")); //$NON-NLS-1$
			newTorusMenuItem.setToolTipText(Messages.getString("EditorGUI.63")); //$NON-NLS-1$
			newTorusMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewTorusAction());
		}
		return newTorusMenuItem;
	}
	/**
	 * This method initializes newModelPartMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewModelPartMenuItem() {
		if (newModelPartMenuItem == null) {
			newModelPartMenuItem = new JMenuItem();
			newModelPartMenuItem.setText(Messages.getString("EditorGUI.64")); //$NON-NLS-1$
			newModelPartMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
			newModelPartMenuItem.setToolTipText(Messages.getString("EditorGUI.65")); //$NON-NLS-1$
			newModelPartMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewModelPartAction());
		}
		return newModelPartMenuItem;
	}

	/**
	 * This method initializes newRigidBoxMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewRigidBoxMenuItem() {
		if (newRigidBoxMenuItem == null) {
			newRigidBoxMenuItem = new JMenuItem();
			newRigidBoxMenuItem.setText(Messages.getString("EditorGUI.66")); //$NON-NLS-1$
			newRigidBoxMenuItem.setToolTipText(Messages.getString("EditorGUI.67")); //$NON-NLS-1$
			newRigidBoxMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewRigidBoxAction());
		}
		return newRigidBoxMenuItem;
	}

	/**
	 * This method initializes newWheelMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	@SuppressWarnings("unused")
	private JMenuItem getNewWheelMenuItem() {
		if (newWheelMenuItem == null) {
			newWheelMenuItem = new JMenuItem();
			newWheelMenuItem.setText(Messages.getString("EditorGUI.68")); //$NON-NLS-1$
			newWheelMenuItem.setToolTipText(Messages.getString("EditorGUI.69")); //$NON-NLS-1$
			newWheelMenuItem.addActionListener(Editor.getEditor().getEditorActions().new NewWheelAction());
		}
		return newWheelMenuItem;
	}

	/**
	 * This method initializes editMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText(Messages.getString("EditorGUI.70")); //$NON-NLS-1$
			//editMenu.setMnemonic(KeyEvent.VK_E);
			editMenu.add(getUndoMenuItem());
			editMenu.add(getRedoMenuItem());
			editMenu.add(new JSeparator());
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
			editMenu.add(new JSeparator());
			editMenu.add(getDeleteMenuItem());
			editMenu.add(new JSeparator());
			editMenu.add(getSelectAllMenuItem());
			editMenu.add(getDeselectAllMenuItem());
			editMenu.add(new JSeparator());
			editMenu.add(getWeldMenuItem());
		}
		return editMenu;
	}

	/**
	 * This method initializes partsMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getPartsMenu() {
		if (partsMenu == null) {
			partsMenu = new JMenu();
			partsMenu.setText(Messages.getString("EditorGUI.71")); //$NON-NLS-1$
			//partsMenu.setMnemonic(KeyEvent.VK_P);
			partsMenu.add(getNewBoxMenuItem());
			partsMenu.add(getNewRigidBoxMenuItem());
			//partsMenu.add(getNewWheelMenuItem());
			//partsMenu.add(getNewSphereMenuItem());
			partsMenu.add(getNewConeMenuItem());
			partsMenu.add(getNewTetrahedronMenuItem());
			partsMenu.add(getNewPyramidMenuItem());
			//partsMenu.add(getNewTorusMenuItem());
			partsMenu.add(new JSeparator());
			partsMenu.add(getNewModelPartMenuItem());
			partsMenu.add(getManageModelPartsMenuItem());
		}
		return partsMenu;
	}

	/**
	 * This method initializes renderingMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getRenderingMenu() {
		if (renderingMenu == null) {
			renderingMenu = new JMenu();
			renderingMenu.setText(Messages.getString("EditorGUI.72")); //$NON-NLS-1$
			//renderingMenu.setMnemonic(KeyEvent.VK_R);
			
			// add an 'ISO checkbox'.
			JCheckBoxMenuItem isoButton = getIsoRenderingButton();
			isoButton.setSelected(Editor.getEditor().isIsoRendering());
			isoButton.setText(Messages.getString("EditorGUI.73")); //$NON-NLS-1$
			//isoButton.setMnemonic(KeyEvent.VK_I);
			isoButton.setToolTipText(Messages.getString("EditorGUI.74")); //$NON-NLS-1$
			isoButton.addActionListener(Editor.getEditor().getEditorActions().new IsoRenderingAction());
			renderingMenu.add(isoButton);

			// add a 'keep model centered' checkbox.
			JCheckBoxMenuItem centeredButton = getCenteredRenderingButton();
			centeredButton.setSelected(Editor.getEditor().isCenteredRendering());
			centeredButton.setText(Messages.getString("EditorGUI.75")); //$NON-NLS-1$
			//centeredButton.setMnemonic(KeyEvent.VK_C);
			centeredButton.setToolTipText(Messages.getString("EditorGUI.76")); //$NON-NLS-1$
			centeredButton.addActionListener(Editor.getEditor().getEditorActions().new CenteredRenderingAction());
			renderingMenu.add(centeredButton);
		}
		return renderingMenu;
	}

	/**
	 * This method initializes modelPartsMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getManageModelPartsMenuItem() {
		if (manageModelPartsMenuItem == null) {
			manageModelPartsMenuItem = new JMenuItem();
			manageModelPartsMenuItem.setText(Messages.getString("EditorGUI.77")); //$NON-NLS-1$
			manageModelPartsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
			manageModelPartsMenuItem.setToolTipText(Messages.getString("EditorGUI.78")); //$NON-NLS-1$
			manageModelPartsMenuItem.addActionListener(Editor.getEditor().getEditorActions().new ManageModelPartsAction());
		}
		return manageModelPartsMenuItem;
	}

	/**
	 * This method initializes copyMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText(Messages.getString("EditorGUI.79")); //$NON-NLS-1$
			//copyMenuItem.setMnemonic(KeyEvent.VK_C);
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
			copyMenuItem.setToolTipText(Messages.getString("EditorGUI.80")); //$NON-NLS-1$
			copyMenuItem.addActionListener(Editor.getEditor().getEditorActions().new CopySelectedAction());
		}
		return copyMenuItem;
	}

	/**
	 * This method initializes cutMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText(Messages.getString("EditorGUI.81")); //$NON-NLS-1$
			//cutMenuItem.setMnemonic(KeyEvent.VK_T);
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
			cutMenuItem.setToolTipText(Messages.getString("EditorGUI.82")); //$NON-NLS-1$
			cutMenuItem.addActionListener(Editor.getEditor().getEditorActions().new CutSelectedAction());
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes undoMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getUndoMenuItem() {
		if (undoMenuItem == null) {
			undoMenuItem = new JMenuItem();
			undoMenuItem.setText(Messages.getString("EditorGUI.83")); //$NON-NLS-1$
			//undoMenuItem.setMnemonic(KeyEvent.VK_U);
			undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
			undoMenuItem.setToolTipText(Messages.getString("EditorGUI.84")); //$NON-NLS-1$
			undoMenuItem.addActionListener(Editor.getEditor().getEditorActions().new UndoAction());
		}
		return undoMenuItem;
	}

	/**
	 * This method initializes redoMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getRedoMenuItem() {
		if (redoMenuItem == null) {
			redoMenuItem = new JMenuItem();
			redoMenuItem.setText(Messages.getString("EditorGUI.85")); //$NON-NLS-1$
			//redoMenuItem.setMnemonic(KeyEvent.VK_R);
			redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,InputEvent.CTRL_MASK));
			redoMenuItem.setToolTipText(Messages.getString("EditorGUI.86")); //$NON-NLS-1$
			redoMenuItem.addActionListener(Editor.getEditor().getEditorActions().new RedoAction());
		}
		return redoMenuItem;
	}

	/**
	 * This method initializes pasteMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText(Messages.getString("EditorGUI.87")); //$NON-NLS-1$
			//pasteMenuItem.setMnemonic(KeyEvent.VK_P);
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
			pasteMenuItem.setToolTipText(Messages.getString("EditorGUI.88")); //$NON-NLS-1$
			pasteMenuItem.addActionListener(Editor.getEditor().getEditorActions().new PasteSelectedAction());
		}
		return pasteMenuItem;
	}

	/**
	 * This method initializes weldMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getWeldMenuItem() {
		if (weldMenuItem == null) {
			weldMenuItem = new JMenuItem();
			weldMenuItem.setText(Messages.getString("EditorGUI.89")); //$NON-NLS-1$
			//weldMenuItem.setMnemonic(KeyEvent.VK_W);
			weldMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.CTRL_MASK));
			weldMenuItem.setToolTipText(Messages.getString("EditorGUI.90")); //$NON-NLS-1$
			weldMenuItem.addActionListener(Editor.getEditor().getEditorActions().new WeldSelectedAction());
		}
		return weldMenuItem;
	}

	/**
	 * This method initializes deleteMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDeleteMenuItem() {
		if (deleteMenuItem == null) {
			deleteMenuItem = new JMenuItem();
			deleteMenuItem.setText(Messages.getString("EditorGUI.91")); //$NON-NLS-1$
			//deleteMenuItem.setMnemonic(KeyEvent.VK_D);
			deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,InputEvent.CTRL_MASK));
			deleteMenuItem.setToolTipText(Messages.getString("EditorGUI.92")); //$NON-NLS-1$
			deleteMenuItem.addActionListener(Editor.getEditor().getEditorActions().new DeleteSelectedAction());
		}
		return deleteMenuItem;
	}

	/**
	 * This method initializes selectAllMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSelectAllMenuItem() {
		if (selectAllMenuItem == null) {
			selectAllMenuItem = new JMenuItem();
			selectAllMenuItem.setText(Messages.getString("EditorGUI.93")); //$NON-NLS-1$
			selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
			selectAllMenuItem.setToolTipText(Messages.getString("EditorGUI.94")); //$NON-NLS-1$
			selectAllMenuItem.addActionListener(Editor.getEditor().getEditorActions().new SelectAllAction());
		}
		return selectAllMenuItem;
	}

	/**
	 * This method initializes DeselectAllMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDeselectAllMenuItem() {
		if (deselectAllMenuItem == null) {
			deselectAllMenuItem = new JMenuItem();
			deselectAllMenuItem.setText(Messages.getString("EditorGUI.95")); //$NON-NLS-1$
			deselectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
			deselectAllMenuItem.setToolTipText(Messages.getString("EditorGUI.96")); //$NON-NLS-1$
			deselectAllMenuItem.addActionListener(Editor.getEditor().getEditorActions().new DeselectAllAction());
		}
		return deselectAllMenuItem;
	}
	
	public ImpulsionRenderer getImpulsionRenderer() {
		if (impulsionRenderer == null)
			impulsionRenderer = new ImpulsionRenderer();
		
		return impulsionRenderer;
	}
	
	public WorldRenderer getWorldRenderer() {
		if (worldRenderer == null) {
			worldRenderer = new WorldRenderer();
		}
		
		return worldRenderer;
	}
	
	/**
	 * Shall be called to update the whole editor UI
	 *
	 */
	public void update() {
		Editor 			editor = Editor.getEditor();
		World			world = editor.getWorld();
		Editor.Modes 	mode = editor.getMode();
		
		// update edit menu items
		boolean canPaste = !editor.getClipboard().isEmpty();
		boolean canCutCopyDelete = !editor.getSelectedMasses().isEmpty();
		
		// edit menu is not accessible when running or moving the model. 
		getEditMenu().setEnabled(true);
		if (mode == Editor.Modes.RUN_MODE ||
			mode == Editor.Modes.PAUSE_MODE) {
			getEditMenu().setEnabled(false);
		}
		
		// edit sub menus
		getUndoMenuItem().setEnabled(editor.canUndo());
		getRedoMenuItem().setEnabled(editor.canRedo());
		getCutMenuItem().setEnabled(canCutCopyDelete);
		getCopyMenuItem().setEnabled(canCutCopyDelete);
		getPasteMenuItem().setEnabled(canPaste);
		getDeleteMenuItem().setEnabled(canCutCopyDelete);

		// update sliders
		getImpulsionSlider().setValue((int)(world.getImpulsion() * (double)(World.MAX_IMPULSION - World.MIN_IMPULSION)));
		getGravitySlider().setValue((int)(world.getGravity() * (double)(World.MAX_GRAVITY - World.MIN_GRAVITY)));
		getStiffnessSlider().setValue((int)(world.getStiffness() * (double)(World.MAX_STIFFNESS - World.MIN_STIFFNESS)));
		getFrictionSlider().setValue((int)(world.getFriction() * (double)(World.MAX_FRICTION - World.MIN_FRICTION)));
		
		// update world renderer
		getWorldRenderer().invalidate();
		getWorldRenderer().repaint();
		
		// update title
		getMainWindow().setTitle(Messages.getString("EditorGUI.97") + world.getModel().getName() + (world.isDirty() ? " * " : Messages.getString("EditorGUI.99"))); //$NON-NLS-1$ //$NON-NLS-3$
	}
}
