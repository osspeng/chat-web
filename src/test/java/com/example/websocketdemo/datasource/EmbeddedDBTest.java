package com.example.websocketdemo.datasource;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import com.example.websocketdemo.repository.MessageRepository;

//@RunWith(SpringRunner.class)
////@SpringBootTest(properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource")
//@DataJpaTest
//@ContextConfiguration(initializers = { EmbeddedDBTest.Initializer.class })
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmbeddedDBTest {

//	@Autowired
//	private DataSource dataSource;

	@ClassRule
	public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:12.1")
			.withDatabaseName("postgres").withUsername("postgres").withPassword("postgres");

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues
					.of("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
							"spring.datasource.username=" + postgreSQLContainer.getUsername(),
							"spring.datasource.password=" + postgreSQLContainer.getPassword())
					.applyTo(configurableApplicationContext.getEnvironment());
		}
	}

//	@Test
//	public void hikariConnectionPoolIsConfigured() {
//		assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
//	}

//	@Test
//	@Transactional
//	public void queryingMessageCountInDB() {
////		long messageSize = Iterables.size(repository.findAll());
//		long messageSize = repository.count();
////		assertThat(messageSize).isEqualTo(4);
//		assertEquals(4, messageSize);
//	}

}