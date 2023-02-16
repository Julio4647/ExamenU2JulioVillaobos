package mx.edu.utez.pokemonExamen.controller.entrenadores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemonExamen.models.entrenadores.Entrenadores;
import mx.edu.utez.pokemonExamen.models.pokemons.Pokemon;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntrnadoresDto {
    private long id;
    private String name;
    private String team;
    private List<Pokemon> pokemones;
    public Entrenadores getEntrnadores(){
        return new Entrenadores(
                getId(),
                getName(),
                getTeam(),
                pokemones
        );
    }
}
