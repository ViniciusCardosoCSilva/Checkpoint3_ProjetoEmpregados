package br.com.fiap.empregados.repositories;

import br.com.fiap.empregados.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
