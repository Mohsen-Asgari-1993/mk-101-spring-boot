package ir.maktabsharif101.springboot.firstspringboot.controller;

import ir.maktabsharif101.springboot.firstspringboot.dto.PersonInfoDTO;
import jakarta.validation.Valid;
import org.apache.commons.lang3.RandomStringUtils;
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
    public ResponseEntity<PersonInfoDTO> postByRequestBody(@RequestBody @Valid PersonInfoDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/raw")
    public ResponseEntity<List<PersonInfoDTO>> getAllPersonInfo() {
        int numberOfPersons = ThreadLocalRandom.current().nextInt(5, 10);
        if (numberOfPersons == 6) {
            return ResponseEntity.status(400).build();
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
