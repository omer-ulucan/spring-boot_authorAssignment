package com.author.lesson.repository;

import com.author.lesson.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
