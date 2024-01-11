package ir.maktabsharif101.springboot.firstspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ir.maktabsharif101.springboot.firstspringboot.dto.ErrorDTO;
import ir.maktabsharif101.springboot.firstspringboot.dto.PersonInfoDTO;
import ir.maktabsharif101.springboot.firstspringboot.exception.GeneralRuntimeException;
import ir.maktabsharif101.springboot.firstspringboot.exception.MvcRuntimeException;
import jakarta.validation.Valid;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/person")
public class PersonResource {

    @GetMapping("/by-path-variable/{id}")
    public ResponseEntity<PersonInfoDTO> getByIdByPathVariable(@PathVariable Integer id) {
        return ResponseEntity.ok(
                new PersonInfoDTO(
                        id,
                        RandomStringUtils.randomAlphabetic(5),
                        RandomStringUtils.randomAlphabetic(5)
                )
        );
    }

    @GetMapping("/by-request-param")
    public ResponseEntity<PersonInfoDTO> getByIdByRequestParam(@RequestParam Integer id) {
        return ResponseEntity.ok(
                new PersonInfoDTO(
                        id,
                        RandomStringUtils.randomAlphabetic(5),
                        RandomStringUtils.randomAlphabetic(5)
                )
        );
    }

    @PostMapping("/by-request-body")
    @Operation(
            summary = "this is api summary",
            description = "this is api description",
            responses = {
                    @ApiResponse(responseCode = "200", description = "every thing is ok"),
                    @ApiResponse(
                            responseCode = "400", description = "required fields missed",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorDTO.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<PersonInfoDTO> postByRequestBody(@RequestBody @Valid PersonInfoDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/raw")
    public ResponseEntity<List<PersonInfoDTO>> getAllPersonInfo() {
        int numberOfPersons = ThreadLocalRandom.current().nextInt(5, 10);
        if (numberOfPersons == 6) {
            throw new GeneralRuntimeException(
                    "numberOfPersons is 6",
                    HttpStatus.FORBIDDEN
            );
        } else if (numberOfPersons == 5) {
            throw new MvcRuntimeException(
                    "numberOfPersons is 5"
            );
        } else {
            List<PersonInfoDTO> personInfoDTOS = new ArrayList<>();
            for (int i = 0; i < numberOfPersons; i++) {
                personInfoDTOS.add(
                        new PersonInfoDTO(
                                i,
                                "" + i,
                                "" + i
                        )
                );
            }
            return ResponseEntity.status(201).body(personInfoDTOS);
        }
    }

}
