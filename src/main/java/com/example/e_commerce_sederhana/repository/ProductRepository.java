package com.example.e_commerce_sederhana.repository;

import com.example.e_commerce_sederhana.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbc;

    public ProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Product product) {
        String sql = """
            INSERT INTO products(name, price, stock, seller_id)
            VALUES (?, ?, ?, ?)
        """;
        jdbc.update(sql,
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getSellerId()
        );
    }

    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getBigDecimal("price"));
            p.setStock(rs.getInt("stock"));
            p.setSellerId(rs.getLong("seller_id"));
            return p;
        }, id);
    }

    public void updateStock(Long id, int stock) {
        jdbc.update(
                "UPDATE products SET stock = ? WHERE id = ?",
                stock, id
        );
    }
}

