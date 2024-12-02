--Olá aqui é um projeto teste em SQL!!!

--Criar Tabela

CREATE TABLE Produtos(

        ID INT PRIMARY KEY,
        Nome VARCHAR(100),
        Preço DECIMAL(10,2),
        Quantidade INT
);

--Inserir dados da tabela

INSERT INTO Produtos (ID, Nome, Preço, Quantidade) VALUES

(1, 'camiseta', 19.99, 100 ),
(2, 'calça Jeans', 29.99, 50 ),
(3, 'Sapato', 49.99, 30 );

--Selecionar todos os produtos

SELECT * FROM Produtos;


--The end