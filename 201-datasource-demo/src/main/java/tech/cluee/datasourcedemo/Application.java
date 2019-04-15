package tech.cluee.datasourcedemo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		showConnection();
		
		showData();
	}

	private void showConnection() throws SQLException {
		log.info("dataSource:"+dataSource.toString());
		Connection connection = dataSource.getConnection();
		log.info("connection:"+connection.toString());
		connection.close();

	}
	
	private void showData() {
		jdbcTemplate.queryForList("SELECT * FROM FOO ;")
		.forEach(row->log.info(row.toString()));
	}

}
