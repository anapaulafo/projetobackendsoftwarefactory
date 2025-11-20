package br.edu.uniesp.softfact.domain.projeto;

import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;

import java.util.Set;

public interface UpdateProjetoService {

    ProjetoResponse criar(Projeto dto);

    ProjetoResponse atualizar(Long id, Projeto dto);

    ProjetoResponse criar(Projeto domain, Set<Long> alunosIds, Set<Long> stacksIds);

    ProjetoResponse atualizar(Long id, Projeto domain, Set<Long> alunosIds, Set<Long> stacksIds);

    void excluir(Long id);

    Object buscarDomainPorId(Long id);
}