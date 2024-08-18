INSERT INTO tb_papel (autoridade) VALUES ('ROLE_ADMIN');
INSERT INTO tb_papel (autoridade) VALUES ('ROLE_CONTABIL');
INSERT INTO tb_papel (autoridade) VALUES ('ROLE_FINANCEIRO');

INSERT INTO tb_usuario (email, senha) VALUES ('henrique@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario (email, senha) VALUES ('vitor@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario (email, senha) VALUES ('ricardo@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_usuario_papel (usuario_id, papel_id) VALUES (1, 1);
INSERT INTO tb_usuario_papel (usuario_id, papel_id) VALUES (2, 2);
INSERT INTO tb_usuario_papel (usuario_id, papel_id) VALUES (3, 3);