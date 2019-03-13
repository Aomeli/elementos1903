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
 * @author T-107
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControladorUsuario {
    @Autowired RepoUsuario repoU;    
//1.-guardar :save()
    @PostMapping("/usuario")
    Estatus guardar(@RequestBody String json)throws Exception{
    
        ObjectMapper maper=new ObjectMapper();
        Usuario u=maper.readValue(json, Usuario.class);
        repoU.save(u);
        Estatus e=new Estatus("Usuario guardado",true);
        return e;
    }
    
    //2. buscar todos
    @GetMapping("/usuario")
    List<Usuario> buscarTodos(){
        return repoU.findAll();
    }
    
    //3. buscar por id
    @GetMapping("/usuario/{id}")
    Usuario buscarPorId(@PathVariable Integer id){
        return repoU.findById(id).get();
    }
    
    //4.AEctualizar
    @PutMapping("/usuario")
    Estatus actualizar(@RequestBody String json)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        Usuario u=mapper.readValue(json, Usuario.class);
        repoU.save(u);
        Estatus e=new Estatus("usuario actualizado", true);
        return e;
    }
    
    //5. Borrar
    @DeleteMapping("/usuario/{id}")
    Estatus borrar(@PathVariable Integer id){
        repoU.deleteById(id);
        Estatus e=new Estatus("Usuario borrado", true);
        return e;
    }
}
