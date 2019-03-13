
package org.unitec.elementos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ControladorHola {
    
    @GetMapping("/")
    public String HolaMundo(){
    
        return "Mi primer servicio REST :D";
    }
    
}
