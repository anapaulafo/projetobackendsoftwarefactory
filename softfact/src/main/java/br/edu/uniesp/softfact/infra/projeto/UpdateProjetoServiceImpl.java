package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.UpdateProjetoService;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.infra.aluno.AlunoRepository;
import br.edu.uniesp.softfact.infra.mapper.ProjetoEntityMapper;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateProjetoServiceImpl implements UpdateProjetoService {

    private final ProjetoRepository repo;
    private final AlunoRepository alunoRepo;
    private final StackTecRepository stackRepo;
    private final ProjetoEntityMapper mapper;

    @Override
    public ProjetoResponse criar(Projeto dto) {
        ProjetoEntity entity = mapper.toEntity(dto);

        entity.setAlunos(buscarAlunos(dto.getAlunos()
                .stream().map(AlunoEntity::getId).collect(Collectors.toSet())));

        entity.setStacks(buscarStacks(dto.getStacks()
                .stream().map(StackTecnologia::getId).collect(Collectors.toSet())));

        return mapper.toResponse(repo.save(entity));
    }

    @Override
    public ProjetoResponse atualizar(Long id, Projeto dto) {
        ProjetoEntity existente = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado: " + id));

        existente.setNome(dto.getNome());
        existente.setDescricao(dto.getDescricao());

        existente.setAlunos(buscarAlunos(
                dto.getAlunos().stream().map(Aluno::getId).collect(Collectors.toSet())
        ));

        existente.setStacks(buscarStacks(
                dto.getStacks().stream().map(StackTecnologia::getId).collect(Collectors.toSet())
        ));

        return mapper.toResponse(existente);
    }

    @Override
    public ProjetoResponse criar(Projeto domain, Set<Long> alunosIds, Set<Long> stacksIds) {
        return null;
    }

    @Override
    public ProjetoResponse atualizar(Long id, Projeto domain, Set<Long> alunosIds, Set<Long> stacksIds) {
        return null;
    }

    @Override
    public void excluir(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Projeto não encontrado: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public Object buscarDomainPorId(Long id) {
        return null;
    }

    private Set<AlunoEntity> buscarAlunos(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) return Set.of();
        return ids.stream()
                .map(id -> alunoRepo.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado: " + id)))
                .collect(Collectors.toSet());
    }

    private Set<StackTecnologia> buscarStacks(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) return Set.of();
        return ids.stream()
                .map(id -> stackRepo.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Stack não encontrada: " + id)))
                .collect(Collectors.toSet());
    }
}