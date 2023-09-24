package pe.edu.cibertec.appwebformulariosS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.appwebformulariosS.model.Primo;

@Controller
public class FormPrimosController {

    public Boolean esPrimo(Integer numero){
        Integer contador = 0;
        for(int i = 1; i<=numero; i++){
            if((numero%i)==0){
                contador++;
            }
        }
        return contador<=2;
    }

    @GetMapping("/frmPrimos")
    public String primos(Model model){
        model.addAttribute("verresultado", false);
        model.addAttribute("Primo", new Primo());
        return "frmPrimos";
    }

    @PostMapping("calcularprimo")
    public String calcularprimo(@ModelAttribute("Primo")Primo primo, Model model){
        String resultado= esPrimo(primo.getNumero())
                ? "El número " + primo.getNumero()+" es PRIMO"
                :"El número " + primo.getNumero()+" NO es PRIMO";
        model.addAttribute("verresultado",true);
        model.addAttribute("resultado", resultado);
        return "frmPrimos";
    }
}
