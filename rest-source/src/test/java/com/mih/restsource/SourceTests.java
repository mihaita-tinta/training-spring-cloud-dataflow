package com.mih.restsource;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.concurrent.BlockingQueue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.cloud.stream.test.matcher.MessageQueueMatcher;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SourceTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private Source channels;

	@Autowired
	private MessageCollector collector;
	
	@Test
	public void contextLoads() {
		  BlockingQueue<Message<?>> messages = collector.forChannel(channels.output());
		  
		  new TestRestTemplate().postForEntity("http://localhost:"+ port + "/", "foo", String.class);

		  assertThat(messages, MessageQueueMatcher.receivesPayloadThat(is("foo")));
	}

}
