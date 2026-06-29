Group 10

Assignment 2: Abstract Class and Inheritance
Scenario
A local company, DriveMasters, has hired you to implement a system to manage their vehicle
inventory more efficiently. They want a system that allows both employees and customers to
find, list and purchase vehicles.
The company has provided you with a data file containing a sample list of vehicles. The data file
contains five types of vehicles: Sedan, SUV, Hatchback, Pickup Truck and Hybrid cars. Each
vehicle is uniquely identified using CarID, and information about each type of vehicle is
described in the formatting section.


 *Group Members: Rafhy Khan, Bruno Resende Silva
 * Program Description:
 * The program is meant to simulate a user approaching a dealer-ship. All vehicles are stored
 * in an txt file, with a specific format. Extracting from the file, an Array-list of objects was created
 * for each vehicle. DisplayBy method search using car ID, displayed by type uses getVehicleType getter for
 * each object, display by subtype gets the unique variable in each object and finds correct value from there.
 * Random display method copies array, scrambles objects than displays values. 
 * An abstract Vehicle super class was created. 5 sub classes were created for each vehicle type, they
 * inherited many of the methods and variables from the superclass, but certain methods were "override", so each class
 * can have their uniqueness. toString() was OVERRIDE, and fileformat method was abstract as it had to be unique
 * for each subclass. 
 * 
 * Inputs were vehicle txt file, user inputs. These were than processed through the program, which used
 * polymorphism, inheritance, Array-list of objects, scanner, file altering and other OOP topics. Outputs
 * were updated vehicle txt file, a console displaying results.
