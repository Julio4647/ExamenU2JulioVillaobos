package mx.edu.utez.pokemonExamen.controller.pokemons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemonExamen.models.entrenadores.Entrenadores;
import mx.edu.utez.pokemonExamen.models.pokemons.Pokemon;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private long id;
    private String name;
    private String type;
    private long poder;
    private long salud;
    private long ataque;
    private long defensa;
    private Entrenadores entrenadores;

    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getName(),
                getType(),
                getPoder(),
                getSalud(),
                getAtaque(),
                getDefensa(),
                entrenadores
        );
    }
}
