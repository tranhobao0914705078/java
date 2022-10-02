package com.hobao.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.product.entity.Category;

@Repository
public class CategoryDAO {
	@Autowired
	protected JdbcTemplate jdbc;

	public void insert(Category entity) {
		String sql = "INSERT INTO Categories (Name, NameVN) VALUES (?,?)";
		jdbc.update(sql, entity.getName(), entity.getNamevn());
	}

	public void update(Category entity) {
		String sql = "UPDATE Categories SET name=?, Description=? WHERE Id=?";
		jdbc.update(sql, entity.getName(), entity.getNamevn(), entity.getId());
	}

	public void delete(Serializable id) {
		String sql = "DELETE FROM Categories WHERE Id=?";
		jdbc.update(sql, id);
	}

	public Category getById(Serializable id) {
		String sql = "SELECT * FROM Categories WHERE Id=?";
		return jdbc.queryForObject(sql, getRowMapper(), id);
	}

	private RowMapper<Category> getRowMapper() {
		return new BeanPropertyRowMapper<Category>(Category.class);
	}

	public List<Category> getAll() {
		String sql = "SELECT * FROM Categories";
		return getBySql(sql);
	}

	protected List<Category> getBySql(String sql) {
		return jdbc.query(sql, getRowMapper());
	}
}
