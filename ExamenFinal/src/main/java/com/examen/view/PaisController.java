package com.examen.view;

import com.examen.modelo.Aerolinea;
import com.examen.modelo.Pais;
import com.examen.service.PaisService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Scope(value = "session")
@Component
@Data
public class PaisController implements Serializable {

    private String codigo, nombre;
    private PaisService paisService;

    private List<Aerolinea> aerolineaList;

    @PostConstruct
    public void init() {
        System.out.print("");
        codigo = "";
        nombre = "";
    }

    @Autowired
    public PaisController( PaisService paisService){
        this.paisService = paisService;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void guardar(){

        Pais pais = new Pais();
        pais.setIdPais(codigo);
        pais.setNombre(nombre);
        paisService.guardar(pais);

        addMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Guardado correctamente");

        codigo = "";
        nombre = "";
    }

    public void consumoApi(){
        String url = "http://localhost:8092/prod/Aerolinea/todos";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("",""));
        Aerolinea [] result = restTemplate.getForObject(url,Aerolinea[].class);
        aerolineaList = Arrays.asList(result);
    }
}
