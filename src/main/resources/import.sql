INSERT INTO tb_departamento(nome) VALUES('Desenvolvimento');
INSERT INTO tb_departamento(nome) VALUES('Infraestrutura de TI');
INSERT INTO tb_departamento(nome) VALUES('Segurança da Informação');
INSERT INTO tb_departamento(nome) VALUES('Suporte Técnico');
INSERT INTO tb_departamento(nome) VALUES('Gestão de Projetos de TI');

INSERT INTO tb_projeto (nome) VALUES ('Desenvolvimento de um aplicativo móvel');
INSERT INTO tb_projeto (nome) VALUES ('Migração de datacenter local para ambiente em nuvem');
INSERT INTO tb_projeto (nome) VALUES ('Sistema de prevenção de intrusões');
INSERT INTO tb_projeto (nome) VALUES ('Lançamento de portal de autoatendimento para os usuários');
INSERT INTO tb_projeto (nome) VALUES ('Solução de gestão projetos baseada em nuvem');

INSERT INTO tb_empregado(nome, email, salario, departamento_id) VALUES('Vinícius', 'vinicius@gmail.com', 6500.0, 2);
INSERT INTO tb_empregado(nome, email, salario, departamento_id) VALUES('Gabriel', 'gabriel@gmail.com', 6600.0, 1);
INSERT INTO tb_empregado(nome, email, salario, departamento_id) VALUES('William', 'william@gmail.com', 6400.0, 3);
INSERT INTO tb_empregado(nome, email, salario, departamento_id) VALUES('Jhamil', 'jhamil@gmail.com', 6500.0, 4);
INSERT INTO tb_empregado(nome, email, salario, departamento_id) VALUES('Hugo', 'hugo@gmail.com', 5999.00, 5);

INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (1, 1);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (1, 3);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (2, 1);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (2, 4);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (3, 2);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (4, 2);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (5, 2);






