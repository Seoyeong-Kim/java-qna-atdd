package nextstep.web;

import nextstep.service.QnaService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final QnaService qnaService;

    public HomeController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    @GetMapping("/")
    public String home(@RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int size,
                       Model model) {
        model.addAttribute("questions", qnaService.findAll(PageRequest.of(page - 1, size)));
        return "home";
    }
}
