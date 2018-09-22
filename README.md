# Training Scdf
	Start from
	https://docs.spring.io/spring-cloud-dataflow/docs/1.5.x/reference/htmlsingle/

	Download docker
		https://docs.docker.com/toolbox/overview/#ready-to-get-started
		
		Open Docker Quickstart terminal to let docker do it's setup
	
	Add shared folder
		http://support.divio.com/local-development/docker/how-to-use-a-directory-outside-cusers-with-docker-toolbox-on-windowsdocker-for-windows
		docker-machine stop
		
		add a shared folder in virtual box
		
		docker-machine start
		docker-machine ssh
		sudo vi /mnt/sda1/var/lib/boot2docker/profile
		mkdir /home/docker/projects
		sudo mount -t vboxsf -o uid=1000,gid=50 shared-folder-to-virtual-box /home/docker/projects/
		
		in docker file add:
		
			volumes:
			   - /shared-folder-to-virtual-box:/shared-from-windows
		 
	Download docker-compose.yml	
	
		curl -o docker-compose.yml https://raw.githubusercontent.com/spring-cloud/spring-cloud-dataflow/v1.5.2.RELEASE/spring-cloud-dataflow-server-local/docker-compose.yml
		
		DATAFLOW_VERSION=1.5.2.RELEASE docker-compose up
		
		docker-machine ip
		
		got to http://192.168.99.100:9393/dashboard
		
		winpty docker exec -it <YOUR_CONTAINER_ID> sh
		
	Go to: start-scs.spring.io choose 2.0.3 RELEASE
		
		Generate rest-source, choose http source, rabbit binder
		
		Generate log-sink, choose log sink, rabbit binder
		
		Generate processor, choose transform processor, rabbit binder
		
		docker build . -t app:0.0.1
		
		docker run -P dc2eef3b92c1
		
		curl -X POST http://192.168.99.100:32768/
		
		first-stream=http --port=8895 | log
		:first-stream.http > log
		:first-stream.http > field-value-counter --field-name=key --name=key-counter