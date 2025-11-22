

CREATE TABLE IF NOT EXISTS tb_softfact_projeto (
                                                   id BIGSERIAL PRIMARY KEY,
                                                   nome VARCHAR(255) NOT NULL,
    descricao TEXT
    );


CREATE TABLE IF NOT EXISTS tb_softfact_projeto_aluno (
                                                         projeto_id BIGINT NOT NULL,
                                                         aluno_id BIGINT NOT NULL,
                                                         PRIMARY KEY (projeto_id, aluno_id),

    CONSTRAINT fk_projeto_aluno_projeto
    FOREIGN KEY (projeto_id)
    REFERENCES tb_softfact_projeto(id)
    ON DELETE CASCADE,

    CONSTRAINT fk_projeto_aluno_aluno
    FOREIGN KEY (aluno_id)
    REFERENCES tb_softfact_aluno(id)
    ON DELETE CASCADE
    );


CREATE TABLE IF NOT EXISTS tb_softfact_projeto_stack (
                                                         projeto_id BIGINT NOT NULL,
                                                         stack_id BIGINT NOT NULL,
                                                         PRIMARY KEY (projeto_id, stack_id),

    CONSTRAINT fk_projeto_stack_projeto
    FOREIGN KEY (projeto_id)
    REFERENCES tb_softfact_projeto(id)
    ON DELETE CASCADE,

    CONSTRAINT fk_projeto_stack_stack
    FOREIGN KEY (stack_id)
    REFERENCES tb_softfact_stack(id)
    ON DELETE CASCADE
    );
