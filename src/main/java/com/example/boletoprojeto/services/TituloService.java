package com.example.boletoprojeto.services;

import com.example.boletoprojeto.model.TituloModel;
import com.example.boletoprojeto.repositories.TituloRepositorie;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class TituloService {

    TituloService tituloService;

    final
    TituloRepositorie tituloRepositorie;

    public TituloService(TituloRepositorie tituloRepositorie){
        this.tituloRepositorie = tituloRepositorie;
    }

    @Transactional
    public TituloModel save(TituloModel tituloModel) {
        return tituloRepositorie.save(tituloModel);
    }


    //@Autowired Injeta a dependencia do repositorio na classe de Serviço
    //TituloRepositorie tituloRepositorie;

}
