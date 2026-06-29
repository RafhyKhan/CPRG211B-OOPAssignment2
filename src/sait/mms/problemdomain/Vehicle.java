package sait.mms.problemdomain;

//abstract cause of the toFileFormat Absract method, its unique for each sub class
public abstract class Vehicle {
	
	
	//initialize all the variables used
    private String subType;
    private int    speed;
    private double fuel;
    private int    seats;
    private String carId;
    private String vehicleType;
    private int    year;
    private String driveTrain;
    private int    price;
    private int    quantity;


	public Vehicle(String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String driveTrain, int price, int quantity) {
		
		//get values for all variables
		this.carId       = carId;
        this.vehicleType = vehicleType;
        this.subType     = subType;
        this.speed       = speed;
        this.fuel        = fuel;
        this.seats       = seats;
        this.year        = year;
        this.driveTrain  = driveTrain;
        this.price       = price;
        this.quantity    = quantity;
		
	}
	
	
    
   //Getter Method
   public String getSubType()     { 
	   return subType; 
	}
	  
   
    //Getter Method 
    public int    getSpeed()       { 
    	return speed; 
	}
    
    
    //Getter Method
    public double getFuel()        { 
    	return fuel; 
	}
    
    
    //Getter Method
    public int    getSeats()       { 
    	return seats; 
	}
    
    
    //Getter Method
    public int    getYear()        { 
    	return year; 
	}
    
    
    //Getter Method
    public String getCarId()       { 
    	return carId;
	}
    
    
    //Getter Method
    public String getVehicleType() { 
    	return vehicleType; 
	}
    
    
    //Getter Method
    public String getDriveTrain()  { 
    	return driveTrain; 
	}
    
    
    //Getter Method
    public int    getPrice()       { 
    	return price; 
	}
    
    
    //Getter Method
    public int    getQuantity()    { 
    	return quantity; 
	}
    
    
    //Setter method for quantity.
    public void setQuantity(int newQuantity) { 
    	quantity = newQuantity; 
   
    }
    
    
    //All formats are returned in right file format order, abstract so other classess can add their own values at end
    public abstract String toFileFormat();
    
    
    
    //Using this so when we return the values its in the proper format String for display
    protected String commonToString() {
        return String.format(
            "Car ID:           %s%n" +
            "Vehicle Type:%s%n" +
            "Sub Type:    %s%n" +
            "Speed:       %d%n" +
            "Fuel:        %.1f%n" +
            "Number of Seats:  %d%n" +
            "Year:        %d%n" +
            "DriveTrain:       %s%n" +
            "Price:       %d%n" +
            "Available:        %d",
            carId, vehicleType, subType, speed, fuel,
            seats, year, driveTrain, price, quantity);
    }
    
    

}
