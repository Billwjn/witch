package com.wjn.question.repository;

import com.wjn.base.repository.BaseRepository;
import com.wjn.question.entity.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends BaseRepository<Question> {
}
