package insu.springsecuritydemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class home {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal UserDetails user,
                       HttpSession HttpSession,
                       Model model){
        if(user != null){
            model.addAttribute("user", user);
            String sessionId = HttpSession.getId();
            String username = user.getUsername();
            System.out.printf("ID : %s, name : %s \n",sessionId,username);
        }
        return "home";
    }
}
