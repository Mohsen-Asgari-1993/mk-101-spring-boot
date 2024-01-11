package ir.maktabsharif101.springboot.firstspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class MvcRuntimeException extends RuntimeException {

    private String message;
}
