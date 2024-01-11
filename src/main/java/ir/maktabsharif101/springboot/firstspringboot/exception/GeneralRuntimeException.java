package ir.maktabsharif101.springboot.firstspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Setter
@Getter
public class GeneralRuntimeException extends RuntimeException {

    private String message;

    private HttpStatus status;
}
