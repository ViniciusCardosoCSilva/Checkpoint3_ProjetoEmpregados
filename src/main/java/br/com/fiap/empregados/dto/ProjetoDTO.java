package br.com.fiap.empregados.dto;

import br.com.fiap.empregados.models.Projeto;
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
public class ProjetoDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "Campo requerido")
    private String nome;

    public ProjetoDTO(Projeto entity) {
        id = entity.getId();
        nome =  entity.getNome();
    }

}
