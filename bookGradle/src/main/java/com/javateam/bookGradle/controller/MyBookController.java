package com.javateam.bookGradle.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javateam.bookGradle.domain.Book;
import com.javateam.bookGradle.service.BookService;


@Controller
public class MyBookController {

	
	public static final Logger log = LoggerFactory.getLogger(MyBookController.class);
	
	// BookService 객체 자동 생성
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/my", method = RequestMethod.GET)
	@ResponseBody
	public String myGet(Book book) {
		
		String msg = "";
		
		List<Book> books = bookService.getAllBookList();
		
		for (Book bk : books) {
			
			log.info(bk.toString() + "\n\n");
			
			msg += bk.toString() + "<br><br>";
			
		}
		
		
		
		return msg;
	}
	
	
	@RequestMapping(value="/your", method=RequestMethod.POST)
	@ResponseBody
	public String yourPost() {
		
		List<Book> yourbooks = bookService.getAllBookList();
		
		String[] splitmsgs = yourbooks.toString().split("]");
		
		String combinedmsgs = "";
		
		for (int i = 0; i < splitmsgs.length; i++) {
			combinedmsgs += splitmsgs[i] + "<br><br><br>";
			
		}
		
		
		return combinedmsgs;
		
	}
	
	@PostMapping("/req")
	// @ResponseBody
	public String reqBooks(Book book, @RequestParam String[] bookrqst, Model model) {
		
		List<Book> boooks = bookService.getAllBookList();
		log.info("--------------------------------------------------------------------------------------");
		log.info("전체 내용 생김새: " + boooks.toString());
		
		String[] rqstbook = boooks.toString().replaceAll("," , "/").split("]");
		
		
		String[] new_rqstbook = new String[rqstbook.length];
		
		for (int i = 0; i < rqstbook.length; i++) {
			
			new_rqstbook[i] = rqstbook[i].replace("," , "<br>");
		}
		
		
//		for (String r : rqstbook) {
//			log.info(r + "\n\n");
//		}
		
		// log.info(bookrqst[0] + ", " + bookrqst[1] + ", " + bookrqst[2]);
		// C#_txtbook, Node.js_txtbook, 어도비XD_txtbook
		
		for (String x: bookrqst) {
			
			log.info("요청된 책들은: " + x + "\n");
		}
		
		
		// bookShopClient에서 요청한 체크박스 value에 따라 책값을 담을 리스트
		List<String> finalBooks = new ArrayList<>();
		
		if (Arrays.asList(bookrqst).contains("C#_txtbook")) {
			finalBooks.add("BOOK 1: " + new_rqstbook[0] + "\n");
		}
		if (Arrays.asList(bookrqst).contains("Node.js_txtbook")) {
			finalBooks.add("BOOK 2: " + new_rqstbook[1] + "\n");
		}
		if (Arrays.asList(bookrqst).contains("어도비XD_txtbook")) {
			finalBooks.add("BOOK 3: " + new_rqstbook[2] + "\n");
		}
		
		log.info("===============================================================================================");
		log.info("===============================================================================================");
		
		
		for (String x : finalBooks) {
			
			log.info(x);
			System.out.println("sysout버전: " + x);
		}
		
		// 뷰(showBooks)에 전달되는 최종 인자
		model.addAttribute("requestedBooks", finalBooks);
 		
		
		return "showBooks";
	}
	
	
	
}
