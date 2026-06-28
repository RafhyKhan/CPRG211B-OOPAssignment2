package sait.mms.managers;

import java.io.*;
import java.util.*;
import sait.mms.problemdomain.*;

public class VehicleManager {

	private static final String VEHICLES_FILE = "res/vehicles.txt";

	private ArrayList<Vehicle> vehicles;

	public VehicleManager() throws IOException {
		vehicles = new ArrayList<>();
		populateVehicles();
	}

	private void populateVehicles() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(VEHICLES_FILE));
		String line;

		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty()) continue;

			String[] parts = line.split(";");
			char firstDigit = parts[0].charAt(0);

			Vehicle v = null;
			switch (firstDigit) {
				case '1':
					v = parseSed(parts);
					break;
				case '2':
					v = parseHatchback(parts);
					break;
				case '3':
					v = parseSUV(parts);
					break;
				case '4':
				case '5':
					v = parseHybrid(parts);
					break;
				case '6':
					v = parsePickupTruck(parts);
					break;
					
			}

			if (v != null) vehicles.add(v);
		}

		reader.close();
	}

	private Sedan parseSed(String[] p) {
		return new Sedan(p[0], p[1], p[2], Integer.parseInt(p[3]),
				Double.parseDouble(p[4]), Integer.parseInt(p[5]),
				Integer.parseInt(p[6]), p[7], Integer.parseInt(p[8]),
				Integer.parseInt(p[9]), p[10]);
	}

	private Hatchback parseHatchback(String[] p) {
		return new Hatchback(p[0], p[1], p[2], Integer.parseInt(p[3]),
				Double.parseDouble(p[4]), Integer.parseInt(p[5]),
				Integer.parseInt(p[6]), p[7], Integer.parseInt(p[8]),
				Integer.parseInt(p[9]), p[10]);
	}

	private SUV parseSUV(String[] p) {
		return new SUV(p[0], p[1], p[2], Integer.parseInt(p[3]),
				Double.parseDouble(p[4]), Integer.parseInt(p[5]),
				Integer.parseInt(p[6]), p[7], Integer.parseInt(p[8]),
				Integer.parseInt(p[9]));
	}

	private Hybrid parseHybrid(String[] p) {
		return new Hybrid(p[0], p[1], p[2], Integer.parseInt(p[3]),
				Double.parseDouble(p[4]), Integer.parseInt(p[5]),
				Integer.parseInt(p[6]), p[7], Integer.parseInt(p[8]),
				Integer.parseInt(p[9]), p[10], Integer.parseInt(p[11]));
	}

	private PickupTruck parsePickupTruck(String[] p) {
		return new PickupTruck(p[0], p[1], p[2], Integer.parseInt(p[3]),
				Double.parseDouble(p[4]), Integer.parseInt(p[5]),
				Integer.parseInt(p[6]), p[7], Integer.parseInt(p[8]),
				Integer.parseInt(p[9]), p[10], Integer.parseInt(p[11]));
	}


	public void purchaseVehicle(Scanner sc) {
		System.out.print("Enter CarId: ");
		String carId = sc.nextLine().trim();

		Vehicle found = findById(carId);

		if (found == null) {
			System.out.println("No vehicle with CarID " + carId + " was found.");
			return;
		}

		if (found.getQuantity() <= 0) {
			System.out.println("Sorry, " + found.getVehicleType() + " " + found.getSubType()
					+ " is not available.");
			return;
		}

		found.setQuantity(found.getQuantity() - 1);
		System.out.println("The Vehicle \"" + found.getVehicleType() + " "
				+ found.getSubType() + "\" has been checked out.");
	}


	public void displayByType(Scanner sc) {
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String type = sc.nextLine().trim();

		System.out.println("Matching vehicles:");
		boolean found = false;
		for (Vehicle v : vehicles) {
			if (v.getVehicleType().equalsIgnoreCase(type)) {
				System.out.println(v);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No vehicles of type \"" + type + "\" found.");
		}
	}


	public void displayBySubtype(Scanner sc) {
		System.out.println("# \tSub Type");
		System.out.println("1 \tSedan");
		System.out.println("2 \tHatchBack");
		System.out.println("3 \tSUV");
		System.out.println("4 \tHybrid");
		System.out.println("5 \tPickup Truck");
		System.out.print("Enter type of vehicle: ");
		String choice = sc.nextLine().trim();

		switch (choice) {
			case "1":
				searchSedanByTrunk(sc);
				break;
			case "2":
				searchHatchbackByHatchType(sc);
				break;
			case "3":
				searchSUVByDrivetrain(sc);
				break;
			case "4":
				searchHybridByPowertrain(sc);
				break;
			case "5":
				searchPickupByCargoBeds(sc);
				break;
			default:
				System.out.println("Invalid selection.");
		}
	}

	private void searchSedanByTrunk(Scanner sc) {
		System.out.print("Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk): ");
		String code = sc.nextLine().trim().toUpperCase();
		System.out.println("Matching Vehicles:");
		for (Vehicle v : vehicles) {
			if (v instanceof Sedan) {
				Sedan s = (Sedan) v;
				if (s.getTrunkSize().equalsIgnoreCase(code)) System.out.println(s);
			}
		}
	}

	private void searchHatchbackByHatchType(Scanner sc) {
		System.out.print("Enter HatchType (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
		String code = sc.nextLine().trim().toUpperCase();
		System.out.println("Matching Vehicles:");
		for (Vehicle v : vehicles) {
			if (v instanceof Hatchback) {
				Hatchback h = (Hatchback) v;
				if (h.getHatchType().equalsIgnoreCase(code)) System.out.println(h);
			}
		}
	}

	private void searchSUVByDrivetrain(Scanner sc) {
		System.out.print("Enter Drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): ");
		String code = sc.nextLine().trim().toUpperCase();
		System.out.println("Matching Vehicles:");
		for (Vehicle v : vehicles) {
			if (v instanceof SUV) {
				if (v.getDrivetrain().equalsIgnoreCase(code)) System.out.println(v);
			}
		}
	}

	private void searchHybridByPowertrain(Scanner sc) {
		System.out.print("Enter a PowerTrain (E for Series Hybrid , A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
		String code = sc.nextLine().trim().toUpperCase();
		System.out.println("Matching Vehicles:");
		for (Vehicle v : vehicles) {
			if (v instanceof Hybrid) {
				Hybrid h = (Hybrid) v;
				if (h.getPowerTrain().equalsIgnoreCase(code)) System.out.println(h);
			}
		}
	}

	private void searchPickupByCargoBeds(Scanner sc) {
		System.out.print("Enter CargoBeds (SB for Short Beds , EB for Extended Beds, DB for Dump Beds): ");
		String code = sc.nextLine().trim().toUpperCase();
		System.out.println("Matching Vehicles:");
		for (Vehicle v : vehicles) {
			if (v instanceof PickupTruck) {
				PickupTruck pt = (PickupTruck) v;
				if (pt.getCargoBeds().equalsIgnoreCase(code)) System.out.println(pt);
			}
		}
	}


	public void randomList(Scanner sc) {
		System.out.print("Enter number of vehicles to display: ");
		int count;
		try {
			count = Integer.parseInt(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Invalid number.");
			return;
		}

		if (count > vehicles.size()) count = vehicles.size();

		ArrayList<Vehicle> pool = new ArrayList<>(vehicles);
		Collections.shuffle(pool);

		System.out.println("Random Vehicles:");
		for (int i = 0; i < count; i++) {
			System.out.println(pool.get(i));
			System.out.println("----------------------------------");
		}
	}


	public void persist() throws IOException {
		System.out.print("Saving Vehicles... ");
		PrintWriter writer = new PrintWriter(new FileWriter(VEHICLES_FILE));

		for (Vehicle v : vehicles) {
			writer.println(v.toFileFormat());
		}

		writer.close();
		System.out.println("Done!");
	}


	private Vehicle findById(String carId) {
		for (Vehicle v : vehicles) {
			if (v.getCarId().equals(carId)) return v;
		}
		return null;
	}
}
