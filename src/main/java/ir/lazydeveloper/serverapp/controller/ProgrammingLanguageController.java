package ir.lazydeveloper.serverapp.controller;

import ir.lazydeveloper.serverapp.model.ProgrammingLanguage;
import ir.lazydeveloper.serverapp.service.ProgrammingLanguageService;
import ir.lazydeveloper.serverapp.statics.constants.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestApi.PUBLIC)
public class ProgrammingLanguageController {

    private final ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping(RestApi.PROGRAMMING_LANGUAGES)
    public ResponseEntity<List<ProgrammingLanguage>> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageService.getAll();
        return ResponseEntity.ok(programmingLanguages);
    }
}
