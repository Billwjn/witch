package com.wjn.question.web;

import com.wjn.api.dto.QuestionDto;
import com.wjn.base.web.BaseController;
import com.wjn.question.service.QuestionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
@CrossOrigin
public class QuestionController extends BaseController<QuestionDto, QuestionService> {
}
