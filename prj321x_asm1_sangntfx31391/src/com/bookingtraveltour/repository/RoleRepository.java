package com.bookingtraveltour.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookingtraveltour.db.DbConnection;
import com.bookingtraveltour.entity.Role;

public class RoleRepository {
	public List<Role> getAllRole() {
		String sqlQuery = "Select * from role";
		List<Role> list = new ArrayList<Role>();
		try {
			Connection dbConnection = DbConnection.getConnection();
			PreparedStatement ps = dbConnection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int role_id = rs.getInt("id");
				String role_name = rs.getString("role_name");
				list.add(new Role(role_id, role_name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
