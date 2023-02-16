package mx.edu.utez.pokemonExamen.controller.pokemons;

import mx.edu.utez.pokemonExamen.controller.pokemons.dto.PokemonDto;
import mx.edu.utez.pokemonExamen.models.pokemons.Pokemon;
import mx.edu.utez.pokemonExamen.services.pokemons.PokemonService;
import mx.edu.utez.pokemonExamen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokemon/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {

    @Autowired
    private PokemonService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>getOne(@PathVariable("id") Long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>>insert(
            @RequestBody PokemonDto pokemonDto
    ){
        return new ResponseEntity<>(
                this.service.insert(pokemonDto.getPokemon()),
                HttpStatus.CREATED
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>delete(@PathVariable long id , @RequestBody PokemonDto pokemonDto){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
