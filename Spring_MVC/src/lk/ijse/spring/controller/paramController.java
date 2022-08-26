package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("param")
public class paramController {
    @GetMapping(params = {"param1","param2"})
    public String test1(String param1 ,String param2) {
        return "Hello 1" +param1 + " " + param2;
    }

    @GetMapping
    public String test2() {
        return "Hello 2";
    }

    @GetMapping(params = {"name","salary"})
    public String test3(String name ,double salary) {
        return  name +" "+salary;
    }


}
