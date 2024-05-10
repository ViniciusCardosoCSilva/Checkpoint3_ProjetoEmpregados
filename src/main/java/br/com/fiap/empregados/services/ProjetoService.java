package br.com.fiap.empregados.services;

import br.com.fiap.empregados.dto.ProjetoDTO;
import br.com.fiap.empregados.models.Projeto;
import br.com.fiap.empregados.repositories.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Transactional(readOnly = true)
    public List<ProjetoDTO> findAll(){
        List<Projeto> projetos = repository.findAll();
        return projetos.stream().map(ProjetoDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjetoDTO findById(Long id) {
        Projeto entity = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );
        return new ProjetoDTO(entity);
    }

    @Transactional
    public ProjetoDTO update(Long id, ProjetoDTO dto){
        try {
            Projeto projeto = repository.getReferenceById(id);
            copyDtoToEntity(dto, projeto);
            projeto = repository.save(projeto);
            return new ProjetoDTO(projeto);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    private void copyDtoToEntity(ProjetoDTO dto, Projeto entity) {
        entity.setNome(dto.getNome());
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

}
