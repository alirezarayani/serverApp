package ir.lazydeveloper.serverapp.controller;

import ir.lazydeveloper.serverapp.model.Question;
import ir.lazydeveloper.serverapp.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getUserByUsername() {
        List<Question> questions = questionService.getByName();
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }
}
