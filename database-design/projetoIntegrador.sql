CREATE TABLE `usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome_completo` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`senha` varchar(16) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`categoria` varchar(30) NOT NULL,
	`descricao` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `postagem` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`titulo` varchar(100) NOT NULL,
	`descricao_post` varchar(1000) NOT NULL,
	`link_imagem` varchar(255) NOT NULL,
	`data` DATETIME NOT NULL,
	`prestador_servico` BOOLEAN NOT NULL,
	`id_usuario` INT NOT NULL,
	`id_tema` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario`(`id`);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk1` FOREIGN KEY (`id_tema`) REFERENCES `tema`(`id`);

