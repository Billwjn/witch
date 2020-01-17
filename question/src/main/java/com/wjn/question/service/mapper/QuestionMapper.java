package com.wjn.question.service.mapper;

import com.wjn.api.dto.QuestionDto;
import com.wjn.base.mapper.BaseMapper;
import com.wjn.question.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends BaseMapper<Question, QuestionDto> {
}
