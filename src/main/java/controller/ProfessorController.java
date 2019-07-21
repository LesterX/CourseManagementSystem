package controller;

import model.*;
import repositories.*;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
public class ProfessorController {

    private final ProfessorRepository repo;

    public ProfessorController(ProfessorRepository repo) {
        this.repo = repo;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/users/professors")
    public String listAllProfessors(Model model) {
        model.addAttribute("allProfessors",repo.findAll());

        return "listAllProfessors";
    }
}