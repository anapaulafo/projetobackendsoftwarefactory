package br.edu.uniesp.softfact.application.projeto;

import br.edu.uniesp.softfact.zo.old.stack.dto.StackResumo;
import java.util.Set;

public record ProjetoResponse(
        Long id,
        String nome,
        String descricao,
        Set<Long> alunosIds,
        Set<StackResumo> stacks
) {}



