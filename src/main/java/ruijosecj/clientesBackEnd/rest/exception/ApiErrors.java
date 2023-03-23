package ruijosecj.clientesBackEnd.rest.exception;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {

 
    private List<String> errors = new ArrayList<>();
    

    public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public ApiErrors(List<String> errors){
        this.errors = errors;
    }

    public ApiErrors(String message){
        this.errors = Arrays.asList(message);
    }
}
