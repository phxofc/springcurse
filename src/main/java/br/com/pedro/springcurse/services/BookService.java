package br.com.pedro.springcurse.services;

import br.com.pedro.springcurse.controllers.BookController;

import br.com.pedro.springcurse.data.model.Book;

import br.com.pedro.springcurse.data.vo.BookVO;


import br.com.pedro.springcurse.exceptions.RequiredObjectIsNullException;
import br.com.pedro.springcurse.exceptions.ResourceNotFoundException;
import br.com.pedro.springcurse.mapper.DozerMapper;
import br.com.pedro.springcurse.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {


    @Autowired
    BookRepository repository;

    public BookVO findById(Long id) throws Exception {
        var entity = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));


        var vo = DozerMapper.parseObject(entity,BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public List<BookVO> findAll(){

        var books =  DozerMapper.parseListObject(repository.findAll(),BookVO.class);
        books
                .stream()
                .forEach(p -> {
                    try {
                        p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return books;
    }

    public BookVO create (BookVO book) throws Exception {
        if (book== null) throw new RequiredObjectIsNullException();

        var entity = DozerMapper.parseObject(book, Book.class);

        var vo = DozerMapper.parseObject(repository.save(entity),BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;

    }

    public BookVO update (BookVO book) throws Exception {
        if (book== null) throw new RequiredObjectIsNullException();

        var entity =  repository.findById(book.getKey()).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunch_date(book.getLaunch_date());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo = DozerMapper.parseObject(repository.save(entity),BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete (Long id){
        var entity =  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO RECORDS FOUND FOR THIS ID!"));
        repository.delete(entity);

    }


}
