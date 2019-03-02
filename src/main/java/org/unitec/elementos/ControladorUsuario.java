/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author campitos
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControladorUsuario {
 @Autowired RepoUsuario repoU;
 @PostMapping("/usuario")
 Estatus guardar (@RequestBody String json)throws Exception
 {
    
    ObjectMapper maper =new ObjectMapper();
    Usuario u = maper.readValue(json,Usuario.class);
    repoU.save(u);
    Estatus e=new Estatus ("Usuario guardado",true);
    return e;
}
    @GetMapping("/usuario")
    List<Usuario>buscarTodos(){
        return repoU.findAll();
    }
    
      @GetMapping("/usuari/{id}")
    Usuario buscarPorId(@PathVariable Integer id){
        return repoU.findById(id).get();    
    }
     @PutMapping("/usuario")
     Estatus actualizar(@RequestBody String json)throws Exception{
         ObjectMapper mapper=new ObjectMapper();
                 Usuario u=mapper.readValue(json, Usuario.class);
                 repoU.save(u);
                 Estatus e=new Estatus ("Usuario actualizado",true);
                 return e;
         
     }
     
          @DeleteMapping("/usuario/{id}")
    Estatus borrar(@PathVariable Integer id){
        repoU.deleteById(id);
        Estatus e=new Estatus ("Usuario borrado",true);
                 return e;
     
     }
   
}
