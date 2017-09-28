/*
 * Copyright (C) 2017 - Benjamin Dickson, Andrew Odintsov, Zilvinas Ceikauskas,
 * Bijan Ghasemi Afshar
 *
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package Controller;

import Model.HubFile;
import Model.StudyPlanner;
import View.UIManager;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bendickson on 5/4/17.
 */
public class MainController {
	public static UIManager ui = new UIManager();

	private static StudyPlannerController SPC;

	// Used for serialization:
	private static SecretKey key64 = new SecretKeySpec(
			new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 }, "Blowfish");
	private static File plannerFile = null;

	/**
	 * Returns a StudyPlannerController.
	 *
	 * @return StudyPlannerController.
	 */
	public static StudyPlannerController getSPC() {
		return SPC;
	}

	/**
	 * Sets StudyPlannerController SPC.
	 */
	public static void setSPC(StudyPlannerController s) {
		SPC = s;
	}

	/**
	 * Initializes the Study Planner by either registering a new account or importing an existing
	 * Study Planner file.
	 */
	public static void initialise() {

		try {
			ui.showStartup();
			// If a file is present:
			if (plannerFile.exists()) {
				Cipher cipher = Cipher.getInstance("Blowfish");
				cipher.init(Cipher.DECRYPT_MODE, key64);
				CipherInputStream cipherInputStream = new CipherInputStream(
						new BufferedInputStream(new FileInputStream(plannerFile)), cipher);
				ObjectInputStream inputStream = new ObjectInputStream(cipherInputStream);
				SealedObject sealedObject = (SealedObject) inputStream.readObject();
				SPC = new StudyPlannerController((StudyPlanner) sealedObject.getObject(cipher));

				// Sample note
				if (SPC.getPlanner().getCurrentStudyProfile() != null && SPC.getPlanner()
						.getCurrentStudyProfile().getName().equals("First year Gryffindor")) {
					UIManager.reportSuccess("Note: This is a pre-loaded sample StudyPlanner,"
							+ " as used by Harry Potter. To make your own StudyPlanner,"
							+ " restart the application and choose \"New File\".");
				}

			} else {
				// This should never happen unless a file changes permissions or existence in the
				// miliseconds
				// that it runs the above code after checks in StartupController
				UIManager.reportError("Failed to load file.");
				System.exit(1);
			}
		} catch (FileNotFoundException e) {
			UIManager.reportError("File does not exist");
			System.exit(1);
		} catch (ClassNotFoundException e) {
			UIManager.reportError("Invalid file");
			System.exit(1);
		} catch (NoSuchAlgorithmException e) {
			UIManager.reportError("Cannot decode the given file");
			System.exit(1);
		} catch (BadPaddingException e) {
			UIManager.reportError("Invalid file");
			System.exit(1);
		} catch (InvalidKeyException e) {
			UIManager.reportError("Cannot decode the given file");
			System.exit(1);
		} catch (NoSuchPaddingException e) {
			UIManager.reportError("Invalid file");
			System.exit(1);
		} catch (IOException e) {
			UIManager.reportError("Invalid file");
			System.exit(1);
		} catch (IllegalBlockSizeException e) {
			UIManager.reportError("Invalid file");
			System.exit(1);
		} catch (Exception e) {
			UIManager.reportError(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Display the main menu.
	 */
	public static void main() {
		try {
			ui.mainMenu();
		} catch (Exception e) {
			UIManager.reportError(e.getMessage());
		}
	}

	/**
	 * Handles importing a new file.
	 *
	 * @return whether imported successfully.
	 */
	public static boolean importFile() {
		// Call a dialog:
		File tempFile = ui.loadFileDialog();
		if (tempFile != null) {
			// If a file was selected, process the file:
			HubFile fileData = DataController.loadHubFile(tempFile);
			if (fileData != null) {
				if (!fileData.isUpdate() && !MainController.SPC.createStudyProfile(fileData)) {
					UIManager.reportError("This Study Profile is already created!");
				} else {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Save the current state of the program to file
	 *
	 * @return whether saved successfully.
	 */
	public static boolean save() {
		try {
			SPC.save(MainController.key64, MainController.plannerFile.getAbsolutePath());
			return true;
		} catch (Exception e) {
			UIManager.reportError("FAILED TO SAVE YOUR DATA!");
			return false;
		}
	}

	/**
	 * Sets the planner file that is loaded/saved.
	 *
	 * @param file
	 *            is the path used to load and save files
	 */
	public static void setPlannerFile(File file) {
		plannerFile = file;
		return;
	}

	/**
	 * Apparently (according to Stackoverflow) the Java Standard library doesn't have a standard
	 * check for testing if a string value is a number or not?!)
	 * <p>
	 * Therefore, we are using this proposed isNumeric method from:
	 * <p>
	 * http://stackoverflow.com/a/1102916
	 *
	 * @param str
	 *            String to be tested
	 * @return whether the given String is numeric.
	 */
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Early console based implementation.
	 *
	 * @param menu
	 *            menu option.
	 */
	private static void consoleUI(String menu) {
		while (!menu.equals("")) {
			switch (menu) {
			case "Quit Program":
				menu = "";
				break;
			case "Main Menu":
			case "Return to Main Menu":
				menu = View.ConsoleIO.view_main();
				break;
			case "Create Study Profile":
				menu = View.ConsoleIO.view_createSP();
				break;
			case "View Study Profile":
				menu = View.ConsoleIO.view_viewSP(SPC);
				break;
			case "Load Study Profile File":
				menu = View.ConsoleIO.view_loadSP(SPC);
			default:
				menu = "";
			}
		}
	}
}
