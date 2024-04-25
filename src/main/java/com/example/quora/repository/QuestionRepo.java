package com.example.quora.repository;

import com.example.quora.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
//    @Query(nativeQuery = true ,
//            value = "SELECT * FROM question q JOIN base_model b ON q.id=b.id " +
//                    "WHERE q.title LIKE CONCAT('%', :keyword, '%')")
//    @Query("SELECT q FROM Question q JOIN BaseModel b ON q.id = b.id " +
//            "WHERE q.title LIKE CONCAT('%', :keyword, '%')")
//    public List<Question> findByTitleLike(String keyword);

    public List<Question> findAllByTitleContaining(String keyword);

    public List<Question> findByUserId(Long id);

    public List<Question> findByCreatedAtBetween(Date startDate, Date endDate);
}

