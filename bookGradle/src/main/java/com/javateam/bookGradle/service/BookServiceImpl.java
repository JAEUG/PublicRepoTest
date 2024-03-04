package com.javateam.bookGradle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javateam.bookGradle.repository.BookRepository;
import com.javateam.bookGradle.domain.Book;


@Service
public class BookServiceImpl implements BookService {
	
	// 스프링 컨테이너가 자동적으로 인스턴스(객체)를 생성해준다.
	@Autowired
	private BookRepository bookRepository;
	
	// @Transactional(readOnly=true)
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return bookRepository.getAllBookList();
	}
	
	
	// 트랜잭션(Commit or Rollback)

}
