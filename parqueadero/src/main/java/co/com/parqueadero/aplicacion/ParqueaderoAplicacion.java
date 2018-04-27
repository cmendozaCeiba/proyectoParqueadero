package co.com.parqueadero.aplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("co.com.parqueadero")
@SpringBootApplication
public class ParqueaderoAplicacion {

	public static void main(String[]  args) throws Exception{
		SpringApplication.run(ParqueaderoAplicacion.class, args);
	}
	
}
