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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

public class ModelPartsGUI extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel  		jContentPane = null;
	private JLabel  		jLabel = null;
	private JList<String> 	modelPartsList = null;
	private JPanel  		jPanel = null;
	private JButton 		deleteButton = null;
	private JButton 		selectButton = null;
	private JButton 		doneButton = null;
	private JButton 		deselectButton = null;

	/**
	 * This is the default constructor
	 */
	public ModelPartsGUI() {
		super(Editor.getEditor().getMainWindow());
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		setSize(348, 392);
		setResizable(false);
		setContentPane(getJContentPane());
		setTitle(Messages.getString("ModelPartsGUI.0")); //$NON-NLS-1$
	    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setText(Messages.getString("ModelPartsGUI.1")); //$NON-NLS-1$
			jLabel.setBackground(Color.white);
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(jLabel, BorderLayout.NORTH);
			jContentPane.add(getModelPartsList(), BorderLayout.CENTER);
			jContentPane.add(getJPanel(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes ModelPartsList	
	 * 	
	 * @return javax.swing.JList	
	 */
	public JList<String> getModelPartsList() {
		if (modelPartsList == null) {
			modelPartsList = new JList<String>();
			modelPartsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return modelPartsList;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.ipadx = 5;
			gridBagConstraints2.ipady = 5;
			gridBagConstraints2.gridy = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 3;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.weightx = 1.0D;
			gridBagConstraints11.ipadx = 5;
			gridBagConstraints11.ipady = 5;
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.ipadx = 5;
			gridBagConstraints1.ipady = 5;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.weightx = 1.0D;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.ipadx = 5;
			gridBagConstraints.ipady = 5;
			gridBagConstraints.gridy = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			jPanel.add(getDeleteButton(), gridBagConstraints);
			jPanel.add(getSelectButton(), gridBagConstraints1);
			jPanel.add(getDoneButton(), gridBagConstraints11);
			jPanel.add(getDeselectButton(), gridBagConstraints2);
		}
		return jPanel;
	}

	/**
	 * This method initializes DeleteButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getDeleteButton() {
		if (deleteButton == null) {
			deleteButton = new JButton();
			deleteButton.setText(Messages.getString("ModelPartsGUI.2")); //$NON-NLS-1$
			deleteButton.setToolTipText(Messages.getString("ModelPartsGUI.3")); //$NON-NLS-1$
		}
		return deleteButton;
	}

	/**
	 * This method initializes SelectButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getSelectButton() {
		if (selectButton == null) {
			selectButton = new JButton();
			selectButton.setText(Messages.getString("ModelPartsGUI.4")); //$NON-NLS-1$
			selectButton.setToolTipText(Messages.getString("ModelPartsGUI.5")); //$NON-NLS-1$
		}
		return selectButton;
	}

	/**
	 * This method initializes DoneButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getDoneButton() {
		if (doneButton == null) {
			doneButton = new JButton();
			doneButton.setText(Messages.getString("ModelPartsGUI.6")); //$NON-NLS-1$
			doneButton.setToolTipText(Messages.getString("ModelPartsGUI.7")); //$NON-NLS-1$
		}
		return doneButton;
	}

	/**
	 * This method initializes DeselectSelectButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getDeselectButton() {
		if (deselectButton == null) {
			deselectButton = new JButton();
			deselectButton.setText(Messages.getString("ModelPartsGUI.8")); //$NON-NLS-1$
			deselectButton.setToolTipText(Messages.getString("ModelPartsGUI.9")); //$NON-NLS-1$
		}
		return deselectButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
