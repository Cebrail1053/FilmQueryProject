package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

//	private void test() throws SQLException {
//		Film film = new Film();
//		film.setActors(db.findActorsByFilmId(1));
//		for (Actor a : film.getActors()) {
//			System.out.println(a);
//		}
//	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		int selection;

		do {
			printMenu();
			selection = input.nextInt();
			input.nextLine();

			switch (selection) {
			case 1:
				System.out.print("Please enter the search ID: ");
				int id = input.nextInt();
				input.nextLine();
				Film film = db.findFilmById(id);
				if (film == null) {
					System.out.println("No film found by that ID, Please try a different ID!\n");
				} else {
					film.setActors(db.findActorsByFilmId(id));
					film = db.findFilmLanguageByCode(film.getLanguageId(), film);
					System.out.println(
							film.getTitle() + ", Year: " + film.getReleaseYear() + ", Rating: " + film.getRating()
									+ ", Language: " + film.getLanguage() + "\n" + film.getDescription() + "\n");
					System.out.println("Actors in film:\n------------------------");
					for (Actor a : film.getActors()) {
						System.out.println(a.getFirstName() + " " + a.getLastName());
					}
					System.out.println();
				}
				break;
			case 2:
				System.out.print("Please enter the search Keyword: ");
				String keyword = input.nextLine();
				List<Film> films = db.findFilmsByKeyword(keyword);
				if (films.isEmpty()) {
					System.out.println("No films found using this keyword, Please try a different search!");
				} else {
					for (Film f : films) {
						f.setActors(db.findActorsByFilmId(f.getId()));
						f = db.findFilmLanguageByCode(f.getLanguageId(), f);
						System.out.println(f.getTitle() + ", Year: " + f.getReleaseYear() + ", Rating: " + f.getRating()
								+ ", Language: " + f.getLanguage() + "\n" + f.getDescription() + "\n");
						System.out.println("Actors in film:\n-------------------------");
						for (Actor a : f.getActors()) {
							System.out.println(a.getFirstName() + " " + a.getLastName());
						}
						System.out.println();
					}
				}
				break;
			case 3:
				System.out.println("Thank You for shopping at BlockBuster!\n");
				break;
			default:
				System.err.println("Invalid input, try again!\n");
			}

		} while (selection != 3);
	}

	private void printMenu() {
		System.out.println("------- Menu -------");
		System.out.println("1. Search film by ID");
		System.out.println("2. Search film by Keyword");
		System.out.println("3. Exit\n");
	}

}
