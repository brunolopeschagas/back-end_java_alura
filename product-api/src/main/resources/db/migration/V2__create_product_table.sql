CREATE TABLE products.product(
    id BIGSERIAL PRIMARY KEY,
    product_identifier VARCHAR NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    preco FLOAT NOT NULL,
    category_id BIGINT REFERENCES products.category(id)
);