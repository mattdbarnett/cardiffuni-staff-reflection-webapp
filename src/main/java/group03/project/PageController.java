package group03.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class PageController {

    private String appMode;

    @Autowired
    public void WebAppController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

//    @GetMapping("/dashboard")
//    public ModelAndView home(){
//        ModelAndView model = new ModelAndView();
//        model.setViewName("dashboard");
//        return model;
//    }

//    @RequestMapping("/login")
//    public ModelAndView login() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("login"); //cannot resolve MVC login
//                                    //works as html, does not work as jasper
//                                    //implies an issue with jasper dependency in build.gradle
//        return model;
//    }

//    @GetMapping("/")
//    public ModelAndView getRedirect() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("dashboard");
//        return model;
//    }




    /*@RequestMapping(value="/login",method= RequestMethod.POST)
    public void loginUser(LoginRequest  ){

    }*/
}
