package pe.edu.cibertec.appwebformulariosS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormSumaController {

    @GetMapping("/frmSuma")
    public String Index(){
        return "frmSuma";
    }
}
