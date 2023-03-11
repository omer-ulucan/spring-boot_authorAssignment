package com.author.lesson.boostraps;

import com.author.lesson.beans.Author;
import com.author.lesson.repository.AuthorRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AuthorBootstrap implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepository;


    @Override
    public void run(String... args) throws Exception {
        authorRepository.save(Author.builder().AuthorName("Friedrich Nietzsche").birthday(LocalDate.parse("1844-10-15")).genre("Philosophy").build());
        authorRepository.save(Author.builder().AuthorName("Oğuz Atay").birthday(LocalDate.parse("1934-12-10")).genre("Fiction").build());
        authorRepository.save(Author.builder().AuthorName("John Ronald Reuel Tolkien").birthday(LocalDate.parse("1892-01-03")).genre("High-Fantasy").build());
        authorRepository.save(Author.builder().AuthorName("George Orwell").birthday(LocalDate.parse("1903-06-25")).genre("Dystopian Fiction").build());
        authorRepository.save(new Author(0L,"Franz Kafka",LocalDate.parse("1883-07-03"),"Modernist Fiction"));
    }
}
