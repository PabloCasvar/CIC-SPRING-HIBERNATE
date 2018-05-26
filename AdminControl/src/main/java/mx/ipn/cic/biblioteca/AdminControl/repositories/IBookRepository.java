package mx.ipn.cic.biblioteca.AdminControl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.biblioteca.AdminControl.model.BookModel;

@Repository
public interface IBookRepository extends JpaRepository<BookModel, Integer> {

}
