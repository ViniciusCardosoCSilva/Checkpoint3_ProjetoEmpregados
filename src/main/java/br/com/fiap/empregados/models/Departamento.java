package br.com.fiap.empregados.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nome"})

@Entity
@Table(name = "tb_departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message = "Campo requerido")
//    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Empregado> empregados = new ArrayList<>();

}
