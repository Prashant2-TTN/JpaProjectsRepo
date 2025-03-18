package com.prashant.SpringDataJpaAssignment3;
import com.prashant.SpringDataJpaAssignment3.entity.Author;
import com.prashant.SpringDataJpaAssignment3.entity.Book;
import com.prashant.SpringDataJpaAssignment3.entity.Subject;
import com.prashant.SpringDataJpaAssignment3.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringDataJpaAssignment3ApplicationTests {
	@Autowired
	AuthorRepository authorRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createAuthorTestSubject(){
		Author author =new Author();
		author.setName("Chitralekha");
		List<Subject> subjects=new ArrayList<>();
		Subject subject1=new Subject();
		subject1.setName("Quantum physics");
		subject1.setAuthor(author);
		Subject subject2=new Subject();
		subject1.setName("AI");
		subject2.setAuthor(author);
		Subject subject3=new Subject();
		subject1.setName("Robotics");
		subject3.setAuthor(author);
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);

		author.setSubjects(subjects);

		authorRepository.save(author);

	}

	@Test
	public void  createAuthorTestBook(){
		Author author=new Author();
		author.setName("Veena");
		Book book = new Book();
		book.setBookName("Harry potter");
		Book book2 = new Book();
		book2.setBookName("Alchemist");
		List<Book> list=new ArrayList<>();
		list.add(book);
		list.add(book2);
		author.setBook(list);

		authorRepository.save(author);


	}

}
