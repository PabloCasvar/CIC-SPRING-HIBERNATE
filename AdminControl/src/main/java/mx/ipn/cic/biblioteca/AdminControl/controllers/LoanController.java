package mx.ipn.cic.biblioteca.AdminControl.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.biblioteca.AdminControl.model.BookModel;
import mx.ipn.cic.biblioteca.AdminControl.model.LoanModel;
import mx.ipn.cic.biblioteca.AdminControl.model.UserModel;
import mx.ipn.cic.biblioteca.AdminControl.services.BookService;
import mx.ipn.cic.biblioteca.AdminControl.services.UserService;

@Controller
@RequestMapping(path = "/loan")
public class LoanController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/newLoanForm")
	public ModelAndView newLoanForm() {

		ModelAndView mav = new ModelAndView("loans/newLoan", "loanModel", new LoanModel());

		List<UserModel> users = this.userService.findAll();

		List<BookModel> books = this.bookService.findAll();

		mav.addObject("usuarios", users);
		mav.addObject("libros", books);

		return mav;

	}

	@PostMapping(path = "/register")
	public String register(@RequestParam(name = "bookId") Integer bookId,
			@RequestParam(name = "userId") Integer userId,
			@RequestParam(name = "startDate") String strStartDate,
			@RequestParam(name = "endDate") String strEndDate) {

		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = sdf.parse(strStartDate);
			Date endDate = sdf.parse(strEndDate);
			BookModel book = this.bookService.findById(bookId);
			UserModel user = this.userService.findById(userId);

			LoanModel loanModel = new LoanModel(startDate, endDate, book, user);

			//Invocación al servicio de préstamos y guardar.
			System.out.println(loanModel);

		} catch (ParseException e) {

		}
		return null;

	}

}
