package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
import com.example.demo.entities.NewsItem;
import com.example.demo.service.NewsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {

    @Autowired
    private NewsItemService newsItemService;

    @GetMapping("/news/{id}")
    public String showNewsItem(@PathVariable Long id, Model model) {
        NewsItem newsItem = newsItemService.getNewsItemWithComments(id);
        model.addAttribute("newsItem", newsItem);
        model.addAttribute("commentDTO", new CommentDTO());
        return "news-details";
    }

    @PostMapping("/news/{id}/comment")
    public String addComment(@PathVariable Long id, @ModelAttribute CommentDTO commentDTO) {
        newsItemService.addCommentToNewsItem(id, commentDTO);
        return "redirect:/news/" + id;
    }
}
