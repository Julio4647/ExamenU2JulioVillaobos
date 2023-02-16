package mx.edu.utez.pokemonExamen.models.entrenadores;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemonExamen.models.pokemons.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "entrenadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entrenadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 50)
    private String team;

    @OneToMany(mappedBy = "entrenadores")
    @JsonIgnore
    private List<Pokemon> pokemons;

}
