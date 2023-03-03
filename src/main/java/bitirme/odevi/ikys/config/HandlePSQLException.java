//package bitirme.odevi.ikys.config;
//
//import bitirme.odevi.ikys.core.utilities.exceptions.PSQLException;
//import bitirme.odevi.ikys.core.utilities.exceptions.ProblemDetails;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//@Configuration
//public class HandlePSQLException {
//    @ExceptionHandler
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    public ProblemDetails handlePSQLException(PSQLException psqlException) {
//
//        ProblemDetails problemDetails = new ProblemDetails();
//        problemDetails.setMessage(psqlException.getMessage());
//        problemDetails.setCause(psqlException.getCause());
//        return problemDetails;
//    }
//}
