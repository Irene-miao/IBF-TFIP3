package sg.edu.nus.iss.app;



public class MyRunnableImplementation implements Runnable {


    private String taskName;

    
    public MyRunnableImplementation(String taskName) {
        this.taskName = taskName;
    }


    @Override
    public void run() {
        
        for (int i=0; i < 5; i++) {
System.out.println(this.taskName + ": " + i);

        }
        
    }
    

}
