package br.com.fiap.empregados.services;

import br.com.fiap.empregados.dto.EmpregadoDTO;
import br.com.fiap.empregados.models.Empregado;
import br.com.fiap.empregados.models.Projeto;
import br.com.fiap.empregados.repositories.EmpregadoRepository;
import br.com.fiap.empregados.repositories.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository repository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Transactional(readOnly = true)
    public List<EmpregadoDTO> findAll() {
        List<Empregado> list = repository.findAll();
        return list.stream().map(EmpregadoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public EmpregadoDTO insert(EmpregadoDTO dto) {
        Empregado entity = new Empregado();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EmpregadoDTO(entity);
    }

    @Transactional(readOnly = true)
    public EmpregadoDTO findById(Long id) {

        Empregado empregado = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return new EmpregadoDTO(empregado);
    }

    @Transactional
    public EmpregadoDTO update(Long id, EmpregadoDTO dto) {
        try {
            Empregado empregado = repository.getReferenceById(id);
            copyDtoToEntity(dto, empregado);
            empregado = repository.save(empregado);
            return new EmpregadoDTO(empregado);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
    }

    private void copyDtoToEntity(EmpregadoDTO dto, Empregado entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSalario(dto.getSalario());
        entity.setDepartamento(dto.getDepartamento());

        entity.getProjetos().clear();
        for (Projeto item: dto.getProjetos()){
            Projeto projeto = projetoRepository.getReferenceById(item.getId());
            entity.getProjetos().add(projeto);
        }
    }


}
