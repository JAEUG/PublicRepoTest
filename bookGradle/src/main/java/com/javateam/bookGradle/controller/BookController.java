package com.javateam.bookGradle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javateam.bookGradle.domain.Book;
import com.javateam.bookGradle.service.BookService;

@Controller
public class BookController {
	// log 객체
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	
	@Autowired
	private BookService bookService;
	
	// @RequestMapping(value="/books", method=RequestMethod.GET)
	@GetMapping("/books")
	public String requestBookList(Model model) {
		
		log.info("/books 도서 목록");
		
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		
		// return "books";
		return "books_bootstrap";
	}

}
