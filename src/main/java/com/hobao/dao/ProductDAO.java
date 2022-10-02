package com.hobao.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.product.entity.Product;

@Repository
public class ProductDAO {
	@Autowired
	protected JdbcTemplate jdbc;

	public void insert(Product entity) {
		String sql = "INSERT INTO Products (Name, UnitPrice, Quantity, Image, CategoryId) VALUES (?,?,?,?,?)";
		jdbc.update(sql, entity.getName(), entity.getUnitPrice(), entity.getQuantity(), entity.getImage(),
				entity.getCategoryId());
	}

	public void update(Product entity) {
		String sql = "UPDATE Products SET Name=?, UnitPrice=?, Quantity=?, Image=?, CategoryId=? WHERE Id=?";
		jdbc.update(sql, entity.getName(), entity.getUnitPrice(), entity.getQuantity(), entity.getImage(),
				entity.getCategoryId(), entity.getId());
	}

	public void delete(Serializable id) {
		String sql = "DELETE FROM Products WHERE Id=?";
		jdbc.update(sql, id);
	}

	public List<Product> getAll() {
		String sql = "SELECT * FROM Products";
		return getBySql(sql);
	}

	protected List<Product> getBySql(String sql) {
		return jdbc.query(sql, getRowMapper());
	}

	public Product getById(Serializable id) {
		String sql = "SELECT * FROM Products WHERE Id=?";
		return jdbc.queryForObject(sql, getRowMapper(), id);
	}

	private RowMapper<Product> getRowMapper() {
		return new BeanPropertyRowMapper<Product>(Product.class);
	}

	public List<Product> getByName(String name) {
		String sql = "SELECT * FROM Products WHERE Name LIKE ?";
		return jdbc.query(sql, getRowMapper(), "%" + name + "%");
	}

	public List<Product> getByCategoryId(Integer categoryId) {
		String sql = "SELECT * FROM Products WHERE CategoryId=?";
		return jdbc.query(sql, getRowMapper(), categoryId);
	}
}
