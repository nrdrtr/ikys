package bitirme.odevi.ikys.core.utilities.results;

public class SuccessResult extends Result{


    public SuccessResult(String success) {
        super(true);
    }

    public SuccessResult(boolean success, String message) {
        super(true, message);
    }
}
