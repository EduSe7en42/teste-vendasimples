CREATE TABLE cliente (
	id BIGINT AUTO_INCREMENT,
	nome VARCHAR(255),
	email VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE produto (
	id BIGINT AUTO_INCREMENT,
	nome VARCHAR(255),
	preco DECIMAL (3,2),
	PRIMARY KEY (id)
);

CREATE TABLE pedido (
	id BIGINT AUTO_INCREMENT,
	data_criacao DATE,
	status VARCHAR(255),
	cliente_id BIGINT,
	PRIMARY KEY (id)
);

CREATE TABLE itens_pedido (
	id BIGINT AUTO_INCREMENT,
	quantidade INT,
	produto_id BIGINT,
	pedido_id BIGINT,
	PRIMARY KEY (id)
);

ALTER TABLE pedido
ADD CONSTRAINT cliente_pedido_fk
FOREIGN KEY (cliente_id) REFERENCES cliente(id);

ALTER TABLE itens_pedido
ADD CONSTRAINT itens_pedido_produto_fk
FOREIGN KEY (produto_id) REFERENCES produto(id);

ALTER TABLE itens_pedido
ADD CONSTRAINT itens_pedido_pedido_fk
FOREIGN KEY (pedido_id) REFERENCES pedido(id);

INSERT INTO cliente VALUES (1, "Eduardo", "eduardo@teste.com");
INSERT INTO produto VALUES (1, "Caneca", 2.50);
