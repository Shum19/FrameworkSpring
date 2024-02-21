package seventh.hometask.authorizationserver.SemSeventhHomeTask.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControlller {
    @GetMapping("/index")
    public String indexPage(){
        return "index.html";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "admin.html";
    }
}

