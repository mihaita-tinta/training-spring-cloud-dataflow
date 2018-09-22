package com.mih.restsource;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.MediaType;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "heart-beat.enabled", matchIfMissing = true)
public class HeartBeatService {
	private static final Logger log = LoggerFactory.getLogger(HeartBeatService.class);
	private final String[] names = new String[] {"Mihaita", "Gabi", "Diana", "Tony", "Radu"};
	private final Random random = new Random();
	
	@Autowired
	private Source channels;
	
	@Scheduled(fixedRate = 500)
	public void heartBeat() {
		int lucky = random.nextInt(names.length);
		log.info("heartBeat - send " + names[lucky]);
		Map<String, Object> headers = new HashMap<>();
		headers.put("contentType", MediaType.APPLICATION_JSON_VALUE);
		GenericMessage<String> message = new GenericMessage<>(
				"{\"key\" : \"" + names[lucky] + "\"}",
				new MessageHeaders(headers)
				);
		channels.output().send(message);
		
	}

}
