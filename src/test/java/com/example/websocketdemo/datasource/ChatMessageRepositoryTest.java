package com.example.websocketdemo.datasource;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import com.example.websocketdemo.repository.MessageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatMessageRepositoryTest extends EmbeddedDBTest {

	@ClassRule
    public static PostgreSQLContainer postgreSQLContainer = UnitTestPostgreSQLContainer.getInstance();
 
	@Autowired
	private MessageRepository repository;

	@Test
	@Transactional
	public void queryingMessageCountInDB() {
//		long messageSize = Iterables.size(repository.findAll());
		long messageSize = repository.count();
//		assertThat(messageSize).isEqualTo(4);
		assertEquals(4, messageSize);
	}
}
