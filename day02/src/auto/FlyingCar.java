package auto;


//inheritance promote reuse
public class FlyingCar extends Car {

    // members
    private float altitude = 0f;

    // constructor
    public FlyingCar(String registration) {
        this.setRegistration(registration);
    }


    // Getter and setter
    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    // Methods
    public void climb(float feet){
        if (this.altitude < 100) {
this.altitude = Math.min(this.altitude + feet, 100f);
        }
    } 

    public void climb() {
        this.climb(5);;  
    }


    @Override
    public String getRegistration() {
        
        return "F" + super.getRegistration();
    }


    @Override
    public void start() {
    
        super.start();
        this.altitude = 5;
    }

    

    
    




    
}