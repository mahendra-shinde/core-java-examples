package com.mahendra.library.app;

import java.util.Scanner;

import com.mahendra.library.dao.BookDAO;
import com.mahendra.library.dao.BookDAOImpl;
import com.mahendra.library.dao.BookIssueDAO;
import com.mahendra.library.dao.BookIssueDAOImpl;
import com.mahendra.library.dao.MemberDAO;
import com.mahendra.library.dao.MemberDAOImpl;
import com.mahendra.library.exceptions.ApplicationException;
import com.mahendra.library.models.Book;
import com.mahendra.library.services.BookIssueService;
import com.mahendra.library.services.BookIssueServiceImpl;
import com.mahendra.library.services.BookService;
import com.mahendra.library.services.BookServiceImpl;
import com.mahendra.library.services.MemberService;
import com.mahendra.library.services.MemberServiceImpl;

public class AppUI {
	private Scanner sc = new Scanner(System.in);
	private static boolean doQuit = false;

	private BookDAO bookDao = new BookDAOImpl();
	private MemberDAO memberDao = new MemberDAOImpl();
	private BookIssueDAO issueDao = new BookIssueDAOImpl();

	private BookService bookService = new BookServiceImpl(bookDao);
	private MemberService memberService = new MemberServiceImpl(memberDao);
	private BookIssueService issueService = new BookIssueServiceImpl(issueDao);

	private static DataWriter dataWriter = new DataWriter();

	public String input() {
		System.out.println("COMMAND [Enter XX for Main Menu] : ");
		String ln = sc.nextLine();
		return ln;
	}

	public static void main(String[] args) {
		AppUI ui = new AppUI();

		dataWriter.loadData();
		while (!doQuit) {
			String ln = ui.input();
			ui.action(ln);
		}
	}

	public void closeApp() {
		System.out.println("Are sure you want to QUIT ?");
		System.out.println("Press N to continue application, any other key to QUIT");
		String ln = sc.nextLine();
		if (!ln.equalsIgnoreCase("N"))
			AppUI.doQuit = true;
		System.out.println("Writing changes to persistent file...");
		dataWriter.writeData();
		System.out.println("Bye....");
	}

	public void action(String command) {
		command = command.toUpperCase();
		switch (command) {
		case "B":
			showBookMenu();
			break;
		case "M":
			showMemberMenu();
			break;
		case "I":
			showIssuesMenu();
			break;
		case "Q":
			closeApp();
			break;
		case "XX":
			showMenu();
			break;
		case "NB":
			addBook();
			break;
		case "FB":
			findBookById();

		}
	}

	public void showMenu() {
		System.out.println("\n\n");
		System.out.println("+------------------------Main Menu -----------------------+");
		System.out.println("| Books Menu                                          [B] |");
		System.out.println("| Members Menu                                        [M] |");
		System.out.println("| Issues Menu                                         [I] |");
		System.out.println("| Quit App                                            [Q] |");
		System.out.println("+---------------------------------------MAHENDRA----------+");
		System.out.println("\n\n");
	}

	public void showBookMenu() {
		System.out.println("\n\n");
		System.out.println("+------------------------Books Menu ----------------------+");
		System.out.println("| Add new Book                                       [NB] |");
		System.out.println("| Find Book by ID                                    [FB] |");
		System.out.println("| Find by title                                      [TB] |");
		System.out.println("| Find by title (available only)                     [TA] |");
		System.out.println("| Find by category (all books)                       [CA] |");
		System.out.println("| Find by category (available only)                  [CB] |");
		System.out.println("| Find by author (all Books)                         [AB] |");
		System.out.println("| Find by author (available only)                    [AA] |");
		System.out.println("| Find and update Book by ID                         [UB] |");
		System.out.println("| RETURN TO MAIN MENU                                [XX] |");
		System.out.println("+---------------------------------------MAHENDRA----------+");
		System.out.println("\n\n");
	}

	public void showMemberMenu() {
		System.out.println("\n\n");
		System.out.println("+------------------------Members Menu ----------------------+");
		System.out.println("| Add new Member                                     [NM] |");
		System.out.println("| Find Member by ID                                  [FM] |");
		System.out.println("| Find by Name                                       [NM] |");
		System.out.println("| List Members with no pending books                 [FE] |");
		System.out.println("| Find and update Member by ID                       [UM] |");
		System.out.println("| RETURN TO MAIN MENU                                [XX] |");
		System.out.println("+---------------------------------------MAHENDRA----------+");
		System.out.println("\n\n");
	}

	public void showIssuesMenu() {
		System.out.println("\n\n");
		System.out.println("+------------------------Issues Menu ---------------------+");
		System.out.println("| Issue a Book                                       [IB] |");
		System.out.println("| Find Issue by ID                                   [FI] |");
		System.out.println("| List by Member ID                                  [MI] |");
		System.out.println("| List by Book ID                                    [MB] |");
		System.out.println("| List Pending books                                 [LP] |");
		System.out.println("| Find and update Issue by ID                        [UI] |");
		System.out.println("| List all pending (due) Books                       [LD] |");
		System.out.println("| RETURN TO MAIN MENU                                [XX] |");
		System.out.println("+---------------------------------------MAHENDRA----------+");
		System.out.println("\n\n");
	}

	public void addBook() {
		Book book = new Book();
		System.out.println("+--------- Adding new book ------------------------------+");
		System.out.println("| Enter title        : ");
		book.setTitle(sc.nextLine());
		System.out.println("| Enter author's name: ");
		book.setAuthor(sc.nextLine());
		System.out.println("| Enter catergory    : ");
		book.setCategory(sc.nextLine());
		System.out.println("| Status set to 'A' [Available] for new book. ");
		book.setStatus('A');
		try {
			Book temp = bookService.create(book);
			System.out.println("Book created and assigned ID: " + temp.getId());
		} catch (ApplicationException ex) {
			System.out.println("Unable to add new book, " + ex.getMessage());
		}
	}

	private void findBookById() {
		System.out.println("+--------- Searching for book ------------------------------+");
		System.out.println("| Enter ID        : ");
		int id = sc.nextInt();
		try {
			Book book = bookService.findById(id);
			System.out.println("| Found book: ");
			System.out.println("|   title: " + book.getTitle());
			System.out.println("|   author: " + book.getAuthor());
			System.out.println("|   category: " + book.getCategory());
			String status = book.getStatus() == 'A' ? "Yes" : "No";
			System.out.println("|   Available: " + status);

		} catch (ApplicationException ex) {
			System.out.println("| Cannot find book, " + ex.getMessage());
		}
		System.out.println("+-----------------------------------------------------------+");

	}

}
