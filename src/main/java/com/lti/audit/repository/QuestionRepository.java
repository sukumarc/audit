package com.lti.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.Question;
import com.lti.audit.vo.QuestionsVO;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	
	String query = "select q.id, q.questionDescription, adr.id as responseId, adr.evidence, "
			+ "adr.remarks, adr.response, adr.auditDimension.id as auditDimensionId from Question q "
			+ "left join AuditDimensionResponse adr "
			+ "on adr.question.id = q.id   and "
			+ "(adr.auditDimension.id = :auditDimensionId or adr.auditDimension.id is null)";
	
	List<Question> findBySubDimensionDimensionDimensionDescription(String dimension);
	
	List<Question> findBySubDimensionDimensionId(Integer dimensionId);

	@Query(query)
	List<QuestionsVO> getQuestions(@Param("auditDimensionId") Integer auditDimensionId);
}
