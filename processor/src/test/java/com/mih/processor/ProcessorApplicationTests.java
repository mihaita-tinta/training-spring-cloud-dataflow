package com.mih.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.BlockingQueue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.cloud.stream.test.matcher.MessageQueueMatcher;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "transformer.expression=payload.toUpperCase()")
public class ProcessorApplicationTests {

	@Autowired
	private MessageCollector collector;
	
	@Autowired
	private Processor processor;
	
	@Test
	public void contextLoads() {
		GenericMessage<String> message = new GenericMessage<>("foo");
		processor.input().send(message);
		
		BlockingQueue<Message<?>> messages = collector.forChannel(processor.output());
		
		assertThat(messages, MessageQueueMatcher.receivesPayloadThat(is("FOO")));
		
	}

}
