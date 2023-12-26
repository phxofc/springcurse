package br.com.pedro.springcurse.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;
    private String author;
    private Date launch_date;
    private double price;
    private String title;

    public BookVO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookVO bookVO = (BookVO) o;
        return Double.compare(price, bookVO.price) == 0 && Objects.equals(id, bookVO.id) && Objects.equals(author, bookVO.author) && Objects.equals(launch_date, bookVO.launch_date) && Objects.equals(title, bookVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launch_date, price, title);
    }
}
