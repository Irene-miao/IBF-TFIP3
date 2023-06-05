package auto;



public class Main {
    public static void main(String[] args) {
        

       // Deck deck = new Deck();

        //System.out.print(deck);
        // New instance of Car
        Car myCar = new Car();
        myCar.setMake("Toyota");
        myCar.setRegistration("s12345");
        myCar.comments = "This is my car";

        System.out.printf("Car make: %s, registration: %s\n", 
        myCar.getMake(), myCar.getRegistration());
        System.out.printf("comments: %s\n", myCar.comments);
        
        myCar.start();


        Car myOtherCar = new Car();
        myOtherCar.setMake("Tesla");
        myOtherCar.setRegistration("s54321");
        System.out.printf("myOtherCar make: %s, registration: %s", 
        myOtherCar.getMake(), myOtherCar.getRegistration());
        System.out.printf("myOtherCar service: %b\n", myOtherCar.needToService());


        FlyingCar myFlyingCar = new FlyingCar(null);
        myFlyingCar.setRegistration("s77777");
        System.out.printf("My Flying car registration: %s\n", 
        myFlyingCar.getRegistration());


        // FlyingCar is a Car
        Car c = new FlyingCar("s5555");
        // Electric Car
         c = new ElectricCar();
        
        if (c instanceof FlyingCar) {
            // Cast it to FLyingCar
            myFlyingCar = (FlyingCar)c;
            System.out.print("C is flying car");
            myFlyingCar.climb(4f);

        } else if (c instanceof ElectricCar) {
            ElectricCar ec = (ElectricCar)c;
            System.out.print("c is ElectricCar");
        } else {
            System.out.print("c is a car");
        }

        // Cast c into something into it is not
       //  myFlyingCar = (FlyingCar)c;  
       // ERROR: class auto.ElectricCar cannot be cast to class auto
    
    }
}
