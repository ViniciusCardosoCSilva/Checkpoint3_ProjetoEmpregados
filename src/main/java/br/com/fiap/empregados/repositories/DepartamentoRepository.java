package br.com.fiap.empregados.repositories;

import br.com.fiap.empregados.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
