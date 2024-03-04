package com.javateam.bookGradle.repository;

import java.util.List;
import com.javateam.bookGradle.domain.Book;

public interface BookRepository {
	
	List<Book> getAllBookList();
	
}
