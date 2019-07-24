package controller;

import model.*;
import repositories.*;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProfessorController {


    Logger log = LoggerFactory.getLogger(ProfessorController.class);
    private final ProfessorRepository repo;

    public ProfessorController(ProfessorRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/user/professor/listAll")
    public String listAllProfessors(Model model) {
        model.addAttribute("allProfessors",repo.findAll());

        return "listAllProfessors";
    }

    @GetMapping("/user/professor/add")
    public String initNewProfessor(Model model) {
        model.addAttribute("prof", new Professor());

        log.info("-------------------------");
        log.info("Start to input");
        log.info("-------------------------");

        return "newProfessorForm";
    }

    @PostMapping("/user/professor/add")
    public String resultNewProfessor(@ModelAttribute Professor prof) {

        if (prof != null && prof.getFirstName() != null && prof.getLastName() != null){
            repo.save(prof);
            log.info("-------------------------");
            log.info(Long.toString(prof.getUid()) + " , " + prof.getFirstName() + " , " + prof.getLastName());
            log.info("-------------------------");
        }else {
            log.info("-------------------------");
            log.info("professor not found");
            log.info("-------------------------");
        }
        
        return "newProfessorResult";
    }

    @GetMapping("/test")
    public String testPage(Model model) {
        model.addAttribute("testProf",new Professor(999,"test","test",99999));

        return "testPage";
    }
}