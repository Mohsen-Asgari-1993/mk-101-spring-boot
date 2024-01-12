package ir.maktabsharif101.springboot.firstspringboot.exception;

import ir.maktabsharif101.springboot.firstspringboot.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@ControllerAdvice
@RestControllerAdvice
public class MyControllerAdvice /*extends ResponseEntityExceptionHandler*/ {

    @ExceptionHandler(value = GeneralRuntimeException.class)
    public ResponseEntity<ErrorDTO> handle(GeneralRuntimeException exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                new ErrorDTO(
                        exception.getMessage(),
                        ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                ),
                exception.getStatus()
        );
    }

    @ExceptionHandler(value = MvcRuntimeException.class)
    public ModelAndView handle(MvcRuntimeException exception) {
        ModelAndView view = new ModelAndView("error");
        view.addObject("message", exception.getMessage());
        return view;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> getMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST);

        //Get all errors
        List<FieldErrorDTO> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new FieldErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldErrorDTO implements Serializable {
        private String field;
        private String message;
    }

}
