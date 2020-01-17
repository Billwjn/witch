package com.wjn.question.service;

import com.wjn.api.dto.QuestionDto;
import com.wjn.base.service.BaseService;
import com.wjn.question.entity.Question;
import com.wjn.question.repository.QuestionRepository;
import com.wjn.question.service.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends BaseService<QuestionDto, Question, QuestionMapper, QuestionRepository> {
}
