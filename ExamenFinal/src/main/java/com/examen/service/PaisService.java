package com.examen.service;

import com.examen.modelo.Pais;
import com.examen.repo.dao.PaisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaisService {

    private PaisDao paisDao;

    @Autowired
    public PaisService(PaisDao pasajeroDao){
        this.paisDao = pasajeroDao;
    }

    public void guardar(Pais pais ){
        paisDao.save(pais);
    }
}
