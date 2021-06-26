package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";
	private String sql;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		sql = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
					rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
					rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
					rs.getString("rating"), rs.getString("special_features"));

			return film;
		}

		rs.close();
		stmt.close();
		conn.close();

		return null;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		sql = "SELECT * FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));

			return actor;
		}

		rs.close();
		stmt.close();
		conn.close();

		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id"
				+ " JOIN film ON film_actor.film_id = film.id" + " WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		ArrayList<Actor> list = new ArrayList<>();
		while (rs.next()) {
			Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));

			list.add(actor);
		}

		rs.close();
		stmt.close();
		conn.close();

		return list;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");
		ResultSet rs = stmt.executeQuery();

		ArrayList<Film> list = new ArrayList<>();
		while (rs.next()) {
			Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
					rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
					rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
					rs.getString("rating"), rs.getString("special_features"));

			list.add(film);
		}

		rs.close();
		stmt.close();
		conn.close();

		return list;
	}

	@Override
	public Film findFilmLanguageByCode(int code, Film f) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		sql = "SELECT * FROM language WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, code);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			f.setLanguage(rs.getString("name"));
		}

		return f;
	}
}
