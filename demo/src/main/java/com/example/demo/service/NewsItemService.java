package com.example.demo.service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.NewsItemDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Comment;
import com.example.demo.entities.NewsItem;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsItemService {
    @Autowired
    private NewsItemRepository newsItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentRepository commentRepository;


    public NewsItem getNewsItemWithComments(Long id) {
        return newsItemRepository.findByIdWithComments(id)
                .orElseThrow(() -> new RuntimeException("News item not found"));
    }

    public void addCommentToNewsItem(Long newsItemId, CommentDTO commentDTO) {
        NewsItem newsItem = newsItemRepository.findById(newsItemId)
                .orElseThrow(() -> new RuntimeException("News item not found"));

        Comment comment = new Comment();
        comment.setText(commentDTO.getText());
        comment.setNewsItem(newsItem);

        commentRepository.save(comment);
    }
}
