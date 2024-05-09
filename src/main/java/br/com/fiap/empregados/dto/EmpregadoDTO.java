package br.com.fiap.empregados.dto;

import br.com.fiap.empregados.models.Departamento;
import br.com.fiap.empregados.models.Empregado;
import br.com.fiap.empregados.models.Projeto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpregadoDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Email(message = "Forneça um e-mail válido")
    private String email;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private Double salario;

    private Departamento departamento;

    private List<Projeto> projetos = new ArrayList<>();

    public EmpregadoDTO(Empregado entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        salario = entity.getSalario();
        departamento = entity.getDepartamento();

        projetos.addAll(entity.getProjetos()); //<-- Verificar em caso de erros.
    }

}
