package pl.dietician.error;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }

}
