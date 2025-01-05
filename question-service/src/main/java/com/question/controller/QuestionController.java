package com.question.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.question.model.Question;
import com.question.model.QuestionWrapper;
import com.question.model.Response;
import com.question.service.QuestionService;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("question/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("question/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("question/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }
    
    
    @GetMapping("question/genarate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(
    									@RequestParam String category) {
    	
    	return questionService.getQuestionsForQuiz(category);
    }
    
    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
    	return questionService.getQuestionsFormId(questionIds);
    }
    
    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
    	return questionService.getScore(responses);
    }

}
