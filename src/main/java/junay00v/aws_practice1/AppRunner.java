package junay00v.aws_practice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext context;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment env = context.getEnvironment();

        env.getProperty("db_name");
        env.getProperty("db_url");
    }
}
