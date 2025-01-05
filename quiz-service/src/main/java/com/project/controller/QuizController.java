package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.model.QuestionWrapper;
import com.project.model.QuizDto;
import com.project.model.Response;
import com.project.service.QuizService;

import java.util.List;


@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("quiz/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategory(), quizDto.getTitle());
    }
    
    @GetMapping("quiz/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("quiz/submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> responses){
        return quizService.calculateResult(responses);
    }


}
