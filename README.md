To enable logging to a text file in Java Spring Boot, do this

1) add this to pom.xml

     		<dependency>
      		<groupId>org.springframework.boot</groupId>
    	  	<artifactId>spring-boot-starter-logging</artifactId>
		    </dependency>

2) add this to applications.properties

  logging.level.org.springframework=INFO
  logging.level.com.example=DEBUG
  logging.file.path=logs/ 
  logging.file.name=logs/application.log 

3) import this to your Java source code
  
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;



4) declare Logger, instantiate logger, call looger in your Java source code

  public class ScoredbApplication {
  
  	public static final Logger logger = LoggerFactory.getLogger(ScoredbApplication.class);
  
  	public static void main(String[] args) throws ExecutionException, InterruptedException, IOException 
  	{
  
  		logger.info("XAC : Starting in main");
  		   
  		logger.trace("XAC Log level: TRACE");
          logger.info("XAC Log level: INFO");
          logger.debug("XAC Log level: DEBUG");
          logger.error("XAC Log level: ERROR");
          logger.warn("XAC Log level: WARN");
  
  		SpringApplication.run(ScoredbApplication.class, args);
  	} // main 
  
   } // class ScoredbApplication

5) in a terminal, use Maven to compile and run

  ./mvnw spring-boot:run

6) see console output

  10:04:31.631 [main] WARN com.actech.scoredb.ScoredbApplication -- XAC Log level: WARN
  
    .   ____          _            __ _ _
   /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
  ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
   \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
   =========|_|==============|___/=/_/_/_/
  
   :: Spring Boot ::                (v3.3.4)
  
7) use curl to hit endpoint(s)

  % curl localhost:8085
  Welcome to the Secrete Database. v0.1%   
  
  % curl localhost:8085/test
  Test OK!%  
  
  % curl localhost:8085/boo 
  {"timestamp":"2024-10-02T17:06:08.530+00:00","status":404,"error":"Not Found","path":"/boo"}%                            

8) look at log file (specified in application.properties file)
   
  % more logs/application.log 
  2024-10-02T09:13:45.857-07:00  INFO 49518 --- [scoredb] [main] com.actech.scoredb.ScoredbApplication    :
  Starting ScoredbApplication using Java 21.0.1 with PID 49518 (/Users/jless/SpringBootFun/ScoreDb/scoredb/target/classes started by jless in /Users/jless/SpringBootFun/ScoreDb/scoredb)

  2024-10-02T10:06:01.316-07:00  INFO 74351 --- [scoredb] [http-nio-8085-exec-1] com.actech.scoredb.ScoredbApplication    : XAC : in default endpoint
  2024-10-02T10:06:05.314-07:00  INFO 74351 --- [scoredb] [http-nio-8085-exec-2] com.actech.scoredb.ScoredbApplication    : XAC : in /test endpoin
