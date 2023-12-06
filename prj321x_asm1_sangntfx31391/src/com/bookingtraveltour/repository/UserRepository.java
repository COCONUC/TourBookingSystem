package com.bookingtraveltour.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookingtraveltour.db.DbConnection;
import com.bookingtraveltour.dto.UserDto;
import com.bookingtraveltour.entity.User;

public class UserRepository {
	// chuc nang admin lay ra danh sach nguoi dung
	public List<UserDto> getAllUser() {
		String sqlQuery = "Select u.*, r.role_name from user u join role r on u.role_id = r.id";
		List<UserDto> list = new ArrayList<UserDto>();

		try {
			Connection dbConnection = DbConnection.getConnection();
			PreparedStatement ps = dbConnection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int role_id = rs.getInt("role_id");
				String role_name = rs.getString("role_name");
				String fullname = rs.getString("fullname");
				String password = rs.getString("password");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				boolean status = rs.getBoolean("status");

				list.add(new UserDto(id, role_id, role_name, fullname, password, username, email, phoneNumber, address,
						status));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<UserDto> getAllUser(int index) {
		// String sqlQuery = "select * from user u where u.id between ?*3-2 and ?*3
		// order by u.id";
		String sqlQuery = "Select u.*, r.role_name from user  u join role  r on u.role_id = r.id where u.id between ?*3-2 and ?*3 order by u.id;";
		List<UserDto> list = new ArrayList<UserDto>();

		try {
			Connection dbConnection = DbConnection.getConnection();
			PreparedStatement ps = dbConnection.prepareStatement(sqlQuery);
			ps.setInt(1, index);
			ps.setInt(2, index);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int role_id = rs.getInt("role_id");
				String role_name = rs.getString("role_name");
				String fullname = rs.getString("fullname");
				String password = rs.getString("password");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				boolean status = rs.getBoolean("status");

				list.add(new UserDto(id, role_id, role_name, fullname, password, username, email, phoneNumber, address,
						status));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// count de phan trang
	public int countUserInList() {
		String sqlQuery = "Select count(*) from user";

		try {
			Connection dbConnection = DbConnection.getConnection();
			PreparedStatement ps = dbConnection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void addUserInfor(User user) {
		String sqlQuery = "Insert into user (role_id, fullname, password, username, email, phoneNumber, address, status) values (?,?,?,?,?,?,?,?)";

		try {
			Connection dbConnection = DbConnection.getConnection();
			PreparedStatement ps = dbConnection.prepareStatement(sqlQuery);
			ps.setInt(1, user.getRole_id());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhoneNumber());
			ps.setString(7, user.getAddress());
			ps.setBoolean(8, user.isStatus());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUserInfor(String fullname, String phoneNumber, String address, int role, int id) {
		/* fullname,phoneNumber,address,role */

		String sqlQuery = "Update user set fullname = ? , phoneNumber = ? , address = ? , role_id = ? where id = ? ";

		try {
			Connection dbConnection = DbConnection.getConnection();
			PreparedStatement ps = dbConnection.prepareStatement(sqlQuery);
			/*
			 * ps.setString(1, user.getFullname()); ps.setString(2, user.getPhoneNumber());
			 * ps.setString(3, user.getAddress()); ps.setInt(4, user.getRole_id());
			 * ps.setInt(5, user.getId());
			 */

			ps.setString(1, fullname);
			ps.setString(2, phoneNumber);
			ps.setString(3, address);
			ps.setInt(4, role);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserDto findUserById(int userId) {
		/* fullname,phoneNumber,address,role */

		String sqlQuery = "Select u.*, r.role_name from user u join role r on u.role_id = r.id where u.id = ?";
		UserDto dto = null;
		try {
			Connection dbConnection = DbConnection.getConnection();
			PreparedStatement ps = dbConnection.prepareStatement(sqlQuery);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int roleId = rs.getInt("role_id");
				int id = rs.getInt("id");
				String roleName = rs.getString("role_name");
				String fullname = rs.getString("fullname");
				String password = rs.getString("password");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				boolean status = rs.getBoolean("status");
				dto = new UserDto(id, roleId, roleName, fullname, password, username, email, phoneNumber, address,
						status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
