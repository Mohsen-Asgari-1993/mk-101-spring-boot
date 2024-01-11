package ir.maktabsharif101.springboot.firstspringboot.controller;

import ir.maktabsharif101.springboot.firstspringboot.dto.PersonInfoDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/page")
    public ModelAndView getAllPersonPage() {
//        Model
        ModelAndView modelAndView = new ModelAndView("persons");
        modelAndView.addObject(
                "myName",
                RandomStringUtils.randomAlphabetic(8)
        );
        return modelAndView;
    }

    @GetMapping("/raw")
    @ResponseBody
    public List<PersonInfoDTO> getAllPersonInfo() {
        int numberOfPersons = ThreadLocalRandom.current().nextInt(5, 10);
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
        return personInfoDTOS;
    }
}
