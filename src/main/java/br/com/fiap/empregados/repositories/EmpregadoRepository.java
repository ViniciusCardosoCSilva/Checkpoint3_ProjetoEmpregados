package br.com.fiap.empregados.repositories;

import br.com.fiap.empregados.models.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}
