package br.com.fiap.empregados.dto;

import br.com.fiap.empregados.models.Departamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartamentoDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    public DepartamentoDTO(Departamento entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

}
