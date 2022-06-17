package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class formController {

    @PostMapping
    public String test1(@ModelAttribute CustomerDTO dto){
        return "Request receaved" + dto.toString();
    }
}
