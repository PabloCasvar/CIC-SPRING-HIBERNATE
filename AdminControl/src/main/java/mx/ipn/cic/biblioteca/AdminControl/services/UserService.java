package mx.ipn.cic.biblioteca.AdminControl.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.biblioteca.AdminControl.model.UserModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository repository;

	public UserModel register(UserModel newUser) {

		return this.repository.save(newUser);

	}

	public UserModel findById(Integer id) {

		Optional<UserModel> found = this.repository.findById(id);

		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}

		return null;

	}

	public List<UserModel> findAll() {
		return this.repository.findAll();
	}

	public boolean delete(Integer idToDelete) {

		this.repository.deleteById(idToDelete);

		return true;

	}

	public UserModel edit(UserModel bookModel) {

		return this.repository.save(bookModel);

	}

}
