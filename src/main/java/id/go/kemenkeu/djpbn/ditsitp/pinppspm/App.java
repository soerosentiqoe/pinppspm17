package id.go.kemenkeu.djpbn.ditsitp.pinppspm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ImportResource("classpath:/integration.xml")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run("classpath:/beans.xml", args);
    }
}
