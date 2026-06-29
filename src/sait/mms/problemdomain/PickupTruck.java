package sait.mms.problemdomain;

public class PickupTruck extends Vehicle {

	
	
	//initialize classess unique variables
    private int cargoCapacity; 
    private String cargoBed;    
	
    //constructor
	public PickupTruck (String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String drivetrain, int price, int quantity, String cargoBeds, int cargoCapacity) {
		
		super(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		
		//getting values
		this.cargoBed = cargoBeds;
		this.cargoCapacity = cargoCapacity;
	
	}
	
	
	
	//returning string value of cargobed type
	public String toString() {
		
		String cargoBedDescription; 
	
		//Upper case it all for comparison in switch statement
		String cargoBedUpper = cargoBed.toUpperCase();
		
		
		//Changing return value based on given trunk size.
		switch(cargoBedUpper) {
			case "SB":
				cargoBedDescription = "Short Bed";
				break;
			case "EB":
				cargoBedDescription = "Extended Bed";
				break;
			case "DB":
				cargoBedDescription = "Dump Bed";
				break;
			default:
				cargoBedDescription = cargoBed;
		}
		
		
		//using common String so its in the right format. Than adding at the end, capacity and cargo bed description
		return commonToString() + String.format("%nCargo Capacity:   %d%nCargo Beds:  %s",
                cargoCapacity, cargoBedDescription);
	}
	

	//getter
	public String getCargoBeds() {
		return cargoBed;
	}
	
	
	
	//getter
	public int getCargoCapacity () {
		return cargoCapacity;
	}
	
	
	
	
	//returning it all in the right format
   @Override
    public String toFileFormat() {
	   
        return String.join(";",
            getCarId(), 
            getVehicleType(), 
            getSubType(),
            String.valueOf(getSpeed()),
            String.valueOf(getFuel()),
            String.valueOf(getSeats()),
            String.valueOf(getYear()),
            getDriveTrain(),
            String.valueOf(getPrice()),
            String.valueOf(getQuantity()),
            cargoBed,
            String.valueOf(cargoCapacity));
    }

	
}
