import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@SpringBootApplication
@RequestMapping("/weather/")
public class Main {
    static Logger logger;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @GetMapping()
    public String getwheatherinfo(){

        String str = "https://home.openweathermap.org/users/sign_in";
        try{
            // httpclient = new httpcient(str);
            // httpcleint.execute
        }
        catch (Exception e){
            logger.info("Error occured, Ubale to to connect to openweathermap server...");
        }


        return "Hello";
    }

}
