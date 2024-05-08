package br.com.fiap.empregados.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nome", "email", "salario", "departamento"})

@Entity
@Table(name = "tb_empregado")
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @Email(message = "O email não é válido", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Campo requerido")
    private String email;

    @NotNull(message = "Campo requerido")
    private Double salario;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "departamento_id", nullable = false)
//    private Departamento departamento;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "tb_empregado_projeto",
//            joinColumns = @JoinColumn(name = "empregado_id"),
//            inverseJoinColumns = @JoinColumn(name = "projeto_id"))
//    private Set<Projeto> projetos = new HashSet<>();

}
