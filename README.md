# Training Scdf
	Start from
	https://docs.spring.io/spring-cloud-dataflow/docs/1.5.x/reference/htmlsingle/

	Download docker
		https://docs.docker.com/toolbox/overview/#ready-to-get-started
		
		Open Docker Quickstart terminal to let docker do it's setup
	
	Download docker-compose.yml	
	
		curl -o docker-compose.yml https://raw.githubusercontent.com/spring-cloud/spring-cloud-dataflow/v1.5.2.RELEASE/spring-cloud-dataflow-server-local/docker-compose.yml
		DATAFLOW_VERSION=1.5.2.RELEASE docker-compose up
		
		docker-machine ip
		
		got to http://192.168.99.100:9393/dashboard
		
		 winpty docker exec -it <YOUR_CONTAINER_ID> sh
		