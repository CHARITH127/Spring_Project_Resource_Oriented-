package lk.ijse.spring.advisor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler({Exception.class})
    public String exceptionHandler(Exception e){
        return e.getMessage();
    }
}
