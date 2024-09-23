package com.jpaEjemplo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /* esto indica que jpa va a general él la clave primaria PK */
    private Long id;

    private String name;

    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST) /* targetEntity indica con que entidad se va a hacer la relación y cascateType.Persist, es para comportamiento en cascada, en este caso cuando ingrese un club va a agregar el coach pero si elimino el club el coach no le hace nada*/
    @JoinColumn(name = "id_coach") /* esto indica el nombre que se colocará en la base de datos*/
    private Coach coach; /* esto indica que la tabla Coach se va a referenciar en la tabla club */

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club") /* Fetch.LAZY indica que cuando players se utiliza trae los datos, esta relación se va a mapear con la relación "club" es decir el id de club pasa como FK a la tabla Placers */
    private List<Player> players; /* se debe crear una lista porque un club va a tener muchos jugadores*/

    @ManyToOne(targetEntity = FootballAssociation.class)
    private FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
    @JoinTable(name = "club_competitions", joinColumns =@JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition"))
    private List<FootballCompetition> footballCompetition;
}
