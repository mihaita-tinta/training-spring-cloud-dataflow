package com.mih.logsink;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogSinkApplicationTests {

	@Autowired
	Sink sink;
	
	@Test
	public void contextLoads() {
		GenericMessage<String> message = new GenericMessage<>("foo");

		sink.input().send(message);
		
	}

}
