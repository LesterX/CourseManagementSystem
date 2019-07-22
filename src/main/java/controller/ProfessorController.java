package controller;

import model.*;
import repositories.*;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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

    @GetMapping("/user/professor/listAll")
    public String listAllProfessors(Model model) {
        model.addAttribute("allProfessors",repo.findAll());

        return "listAllProfessors";
    }

    @GetMapping("/user/professor/add")
    public String initNewProfessor(Model model) {
        model.addAttribute("prof", new Professor());

        return "newProfessorForm";
    }

    @PostMapping("/user/professor/add")
    public String resultNewProfessor(@ModelAttribute Professor prof) {
        if (prof != null && prof.getFirstName() != null && prof.getLastName() != null)
            repo.save(prof);
        
        return "newProfessorResult";
    }
}