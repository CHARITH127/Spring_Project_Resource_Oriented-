package bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {


    @Autowired
    Environment environment;

    @Value("${user.country}")
    private String userCountry;

    @Value("${ijse.application.name}")
    private String projectName;


    public SpringBean() {
        System.out.println("Spring bean constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String age = environment.getProperty("age");
        System.out.println(age);
    }
}
