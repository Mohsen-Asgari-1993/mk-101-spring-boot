package ir.maktabsharif101.springboot.firstspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO implements Serializable {

    private String message;

    private String date;
}
