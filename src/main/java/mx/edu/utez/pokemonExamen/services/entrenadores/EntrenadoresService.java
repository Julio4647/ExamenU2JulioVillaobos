package mx.edu.utez.pokemonExamen.services.entrenadores;

import mx.edu.utez.pokemonExamen.models.entrenadores.Entrenadores;
import mx.edu.utez.pokemonExamen.models.entrenadores.EntrenadoresRepository;
import mx.edu.utez.pokemonExamen.models.pokemons.Pokemon;
import mx.edu.utez.pokemonExamen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrenadoresService {
    @Autowired
    private EntrenadoresRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Entrenadores>>getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public  Response<Entrenadores>getOne(Long id){
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Entrenador no encontrado"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> insert(Entrenadores entrenadores){
        Optional<Entrenadores> exists=this.repository.findByName(entrenadores.getName());
        if (exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "EL entrenador ya se encuentra registrado"
            );
        return new Response<>(
                this.repository.saveAndFlush(entrenadores),
                false,
                200,
                "Entrenador registrado"
        );

    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> delete( Long id){
        Response response = null;
        if (this.repository.existsById(id))
        {
            this.repository.deleteById(id);
            response= new Response(this.repository.findById(id), false,200,"Entrenador Eliminado ");
        }else{
            response=  new Response<>(
                    null,
                    true,
                    400,
                    "POkemon no se encontró"
            );
        }
        return  response;

    }
}
