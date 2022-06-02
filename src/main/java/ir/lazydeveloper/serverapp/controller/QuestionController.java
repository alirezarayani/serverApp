package ir.lazydeveloper.serverapp.controller;

import ir.lazydeveloper.serverapp.model.Question;
import ir.lazydeveloper.serverapp.service.QuestionService;
import ir.lazydeveloper.serverapp.statics.constants.RestApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(RestApi.PUBLIC)
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(RestApi.QUESTION_ID)
    public ResponseEntity<List<Question>> getQuestionByID(@PathVariable("id") Integer id) {
        List<Question> questions = questionService.getByProgrammingLID(id);
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }
}
