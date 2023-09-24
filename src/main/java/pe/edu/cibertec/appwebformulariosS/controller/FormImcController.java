package pe.edu.cibertec.appwebformulariosS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.appwebformulariosS.model.IMC;
import pe.edu.cibertec.appwebformulariosS.model.PromedioModel;

@Controller
public class FormImcController {

    @GetMapping("/frmImc")
    public String index(Model model){
        model.addAttribute("verresultado", false);
        model.addAttribute("IMC", new IMC());
        return "frmImc";
    }

    @PostMapping("/calcularimc")
    public String calcularIMC(@ModelAttribute("IMC") IMC imc, Model model){
        Double tallam=imc.getAltura()/100;
        Double calimc = imc.getPeso()/ (tallam*tallam);
        String coloralert="alert-danger";

        String resultadoIMC ="";

        if (calimc<=18.5){
            resultadoIMC="Por debajo del paso";
            coloralert="alert-dark";
        } else if (calimc<=25) {
            resultadoIMC="Con peso normal";
            coloralert="alert-primary";

        } else if(calimc<=30) {
            resultadoIMC="Con sobrepaso";
            coloralert="alert-warning";
        } else if(calimc<=35) {
            resultadoIMC="con obesidad leve";
        } else if(calimc<=39) {
            resultadoIMC="con obesidad media";
        } else{
            resultadoIMC="Con obesidad mórbida";
        }

        model.addAttribute("coloralerta", coloralert);
        model.addAttribute("verresultado",true);
        model.addAttribute("resultado","su valor de IMC es: " + String.format("%.2f",calimc)
                + " ,usted se encuentra: "+resultadoIMC);
        return "frmImc";
    }
}
