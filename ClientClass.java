package com.ems.base;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ems.controller.DeleteController;
import com.ems.controller.DisplayController;
import com.ems.controller.RegistrationController;
import com.ems.controller.SearchController;

/**
 * @author Challa This class used for the testing the required user
 *         functionality
 */
public class ClientClass {

	private static void userMenu() {
		String methodName = "userMenu()";
		System.out.println("Method Invoked:" + methodName);
		System.out.println("**************************************");
		System.out.println("1) Register Employee Module");
		System.out.println("2) Display Employee Module");
		System.out.println("3) Search Employee Module");
		System.out.println("4) Delete Employee Module");
		System.out.println("**************************************");
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter User Choice");
			int userChoice = scanner.nextInt();
			start: switch (userChoice) {
			case 1:
				RegistrationController regController = new RegistrationController();
				regController.readEmployeeDetails();
				break;
			case 2:
				DisplayController dispController = new DisplayController();
				dispController.displayEmpList();
				break;
			case 3:
				SearchController sController = new SearchController();
				sController.searchDetails();

				break;
			case 4:
				DeleteController dController = new DeleteController();
				dController.deleteEmp();

				break;
			default:
				System.out.println("Please Enter The Correct Choice");
				System.exit(0);
				break;
			}

		} catch (InputMismatchException e) {
			e.printStackTrace();
		} finally {

			scanner.close();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		userMenu();
	}
}
