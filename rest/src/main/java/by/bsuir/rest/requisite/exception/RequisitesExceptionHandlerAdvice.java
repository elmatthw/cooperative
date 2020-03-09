package by.bsuir.rest.requisite.exception;

import by.bsuir.reguisites.exception.DataManipulateException;
import com.mongodb.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "by.bsuir.rest.requisite")
public class RequisitesExceptionHandlerAdvice {

    @ExceptionHandler
    public void handle(DataManipulateException e) {
    }

    @ExceptionHandler
    public void handle(DuplicateKeyException e) {
    }
}
