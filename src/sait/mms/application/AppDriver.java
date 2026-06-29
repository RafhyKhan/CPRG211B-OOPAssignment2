package sait.mms.application;

import java.io.*;
import java.util.Scanner;
import sait.mms.managers.VehicleManager;

public class AppDriver {

	
	//Starts the program
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VehicleManager manager;

		try {
			manager = new VehicleManager();
		} catch (IOException e) {
			System.out.println("Error loading vehicles: " + e.getMessage());
			return;
		}

		boolean running = true;
		while (running) {
			printMenu();
			System.out.println();
			System.out.print("Enter option: ");
			String choice = sc.nextLine().trim();

			switch (choice) {
				case "1":
					manager.purchaseVehicle(sc);
					break;
				case "2":
					manager.displayByType(sc);
					break;
				case "3":
					manager.displayBySubtype(sc);
					break;
				case "4":
					manager.randomList(sc);
					break;
				case "5":
					try {
						manager.persist();
					} catch (IOException e) {
						System.out.println("Error saving vehicles: " + e.getMessage());
					}
					System.out.println("Goodbye!");
					running = false;
					break;
				default:
					System.out.println("Invalid option. Please enter 1–5.");
			}
		}

		sc.close();
	}

	private static void printMenu() {
		System.out.println("\nWelcome to DriveMasters");
		System.out.println("Please choose any option below");
		System.out.println("---------------------------------");
		System.out.println("1\tPurchase Vehicle");
		System.out.println("2\tDisplay Vehicles by Type");
		System.out.println("3\tDisplay Vehicles by Subtype");
		System.out.println("4\tProduce a Random List of Vehicles");
		System.out.println("5\tSave & Exit");
	}
}
