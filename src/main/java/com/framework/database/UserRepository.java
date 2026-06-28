package com.framework.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.framework.api.models.CreateUserRequestWithoutLombok;
import com.framework.models.UserDBModel;

public class UserRepository {

	public UserDBModel getUserByEmail(String email) {

		try {

			String query = String.format(DBQueries.USER_BY_EMAIL, email);
			System.out.println("Executing Query: " + query);

			ResultSet rs = DBUtils.executeQuery(query);

			UserDBModel user = new UserDBModel();

			if (rs.next()) {

				user.setId(rs.getInt("id"));

				user.setName(rs.getString("name"));

				user.setEmail(rs.getString("email"));
			}

			return user;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public void saveUser(CreateUserRequestWithoutLombok user) {

		try {

			String query =

					"INSERT INTO users " + "(name,email,password,title," + "birth_date,birth_month,birth_year,"
							+ "firstname,lastname,company," + "address1,address2,country,"
							+ "zipcode,state,city,mobile_number)" + " VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			Connection connection = DBConnectionManager.getConnection();

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, user.getName());

			ps.setString(2, user.getEmail());

			ps.setString(3, user.getPassword());

			ps.setString(4, user.getTitle());

			ps.setString(5, user.getBirth_date());

			ps.setString(6, user.getBirth_month());

			ps.setString(7, user.getBirth_year());

			ps.setString(8, user.getFirstname());

			ps.setString(9, user.getLastname());

			ps.setString(10, user.getCompany());

			ps.setString(11, user.getAddress1());

			ps.setString(12, user.getAddress2());

			ps.setString(13, user.getCountry());

			ps.setString(14, user.getZipcode());

			ps.setString(15, user.getState());

			ps.setString(16, user.getCity());

			ps.setString(17, user.getMobile_number());

			ps.executeUpdate();

			System.out.println("User saved in local DB");

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}
}
