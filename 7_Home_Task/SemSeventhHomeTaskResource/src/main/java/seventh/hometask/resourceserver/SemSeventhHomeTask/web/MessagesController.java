package seventh.hometask.resourceserver.SemSeventhHomeTask.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MessagesController {

    @GetMapping("/index")
    public String indexPage() {
        return "index.html";
    }
}
