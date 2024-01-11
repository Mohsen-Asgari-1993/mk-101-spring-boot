package ir.maktabsharif101.springboot.firstspringboot.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id) {
        return "adminGetById";
    }

    @PostMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return "adminDeleteById";
    }

}
