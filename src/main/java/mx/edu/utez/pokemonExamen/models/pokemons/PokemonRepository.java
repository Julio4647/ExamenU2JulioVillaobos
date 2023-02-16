package mx.edu.utez.pokemonExamen.models.pokemons;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findById(Long id);
    Optional<Pokemon>findByName(String name);






}
