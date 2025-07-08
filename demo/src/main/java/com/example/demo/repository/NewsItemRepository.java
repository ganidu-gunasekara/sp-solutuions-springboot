package com.example.demo.repository;

import com.example.demo.entities.NewsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NewsItemRepository extends JpaRepository<NewsItem, Long> {
    @Query("SELECT n FROM NewsItem n LEFT JOIN FETCH n.comments WHERE n.id = :id")
    Optional<NewsItem> findByIdWithComments(@Param("id") Long id);
}
