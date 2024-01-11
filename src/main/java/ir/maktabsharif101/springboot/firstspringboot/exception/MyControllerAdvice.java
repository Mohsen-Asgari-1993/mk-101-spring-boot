package ir.maktabsharif101.springboot.firstspringboot.exception;

import ir.maktabsharif101.springboot.firstspringboot.dto.ErrorDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//@ControllerAdvice
@RestControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = GeneralRuntimeException.class)
    public ErrorDTO handle(GeneralRuntimeException exception) {
        exception.printStackTrace();
        return new ErrorDTO(
                exception.getMessage(),
                ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }

    @ExceptionHandler(value = MvcRuntimeException.class)
    public ModelAndView handle(MvcRuntimeException exception) {
        ModelAndView view = new ModelAndView("error");
        view.addObject("message", exception.getMessage());
        return view;
    }

}
