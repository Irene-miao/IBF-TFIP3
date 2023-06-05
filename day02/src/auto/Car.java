package auto;

public class Car {

    // members
    private String registration;
    private String make;
    private boolean started = false;
    private int counter = 0;

    public String comments;

    // Constructor called once
    public Car() {
        System.out.print(">>>> ");
        System.out.print(">>>>> in Car constructor");
        System.out.print(">>>");
    }

    // Getter and setter
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
this.registration = registration;
    }


    public boolean needToService() {
        return this.counter > 5; 
    }

    public void serviceCar() {
        System.out.print("Servicing car");
        this.counter = 0;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean isStarted() {
        return started;
    }


    public void setStarted(boolean started) {
        if (this.started) {
            this.start();
        } else {
            this.stop();
        }
    }

// Methods
    
    public void start() {
        if (this.started) {
System.out.println("Car is coming");
        }else {
            this.started = true;
            this.counter++;
            System.out.print("Vroom...");
        }
    }

    public void stop() {
        if (!this.started) {
            System.out.println("Car is not running");
        } else {
            this.started = false;
            System.out.println("Splutter.. stop");
        }
    }
}