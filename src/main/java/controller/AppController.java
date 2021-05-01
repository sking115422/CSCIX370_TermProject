package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {


    @GetMapping("/spy")
    public String spyChart() {
        return "spyChart";
    }

    @GetMapping("/qqq")
    public String qqqChart(Model model) {
        return "qqqChart";
    }

    @GetMapping("/vti")
    public String vtiChart(Model model) {
        return "vtiChart";
    }

    @GetMapping("/iwm")
    public String iwmChart(Model model) {
        return "iwmChart";
    }

}
