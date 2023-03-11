package com.author.lesson.controllers;

import com.author.lesson.beans.Author;
import com.author.lesson.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorByID(@PathVariable Long id)
    {
     return authorRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    public List<Author> addAuthor(@RequestBody Author author)
    {
    authorRepository.save(author);
    return authorRepository.findAll();
    }

    @PutMapping(consumes = "application/json")
    public List<Author> replaceAuthorList(@RequestBody List<Author> authorList)
    {
        authorRepository.deleteAll();
        authorRepository.saveAll(authorList);
        return authorRepository.findAll();
    }
    @PutMapping(value = "/{id}", consumes = "application/json")
    public List<Author> replaceAuthor(@PathVariable Long id, @RequestBody Author author)
    {
        authorRepository.deleteById(id);
        authorRepository.save(author);

        return authorRepository.findAll();
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public List<Author> updateAuthor(@PathVariable Long id, @RequestBody Author newAuthor)
    {
        Author oldAuthor = authorRepository.findById(id).get();
        oldAuthor.setAuthorName(newAuthor.getAuthorName());
        oldAuthor.setGenre(newAuthor.getGenre());
        oldAuthor.setBirthday(newAuthor.getBirthday());

        authorRepository.save(oldAuthor);

        return authorRepository.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public List<Author> deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
        return authorRepository.findAll();
    }

    @DeleteMapping()
    public List<Author> deleteAllAuthor(){
        authorRepository.deleteAll();
        return authorRepository.findAll();
    }

}
