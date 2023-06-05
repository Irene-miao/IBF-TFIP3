package sg.edu.nus.ibf.workshop24.exception;

public class DataIntegrityViolationException extends Exception {
    
    public DataIntegrityViolationException(){
        super();
    }

    public DataIntegrityViolationException(String message){
        super(message);
    }
}
