
CREATE TABLE cliente (

    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(100) NOT NULL,
    cpf             VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL, 
    endereco        VARCHAR(255)

);

CREATE TABLE contato (

    id         INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    tipo       VARCHAR(50) NOT NULL,
    valor      VARCHAR(100) NOT NULL,
    observacao VARCHAR(255),

    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);



INSERT INTO cliente (nome, cpf, data_nascimento, endereco)
VALUES
    ('Ingmar', '9783928651', '2024-11-29', '37 Tennessee Point'),
    ('Chandal', '0339119071', '2024-11-29', '92024 Grayhawk Hill'),
    ('Pierre', '1158413661', '2025-01-26', '2792 Kipling Trail'),
    ('Tailor', '6912153410', '2025-02-08', '71150 Bluejay Way'),
    ('Lindy', '9258921364', '2024-12-19', '16754 Hoard Circle'),
    ('Rubi', '1741621216', '2024-09-10', '6 Florence Parkway'),
    ('Buddy', '5915750850', '2025-02-03', '6911 Straubel Junction'),
    ('Igor', '7918088743', '2024-08-21', '37 Ilene Center'),
    ('Tessa', '2943365122', '2024-06-24', '7 Westridge Way'),
    ('Christalle', '9847686785', '2024-07-10', '3 Lakewood Pass');


INSERT INTO contato (cliente_id, tipo, valor, observacao) VALUES
    (1, 'Telefone', '11987654321', 'Número pessoal'),
    (2, 'Telefone', '21988776655', 'Contato de emergência'),
    (3, 'E-mail', 'joao@email.com', 'E-mail principal'),
    (4, 'E-mail', 'maria@email.com', 'E-mail alternativo'),
    (5, 'Telefone', '31991234567', 'Número comercial'),
    (6, 'Telefone', '41999887766', 'WhatsApp'),
    (7, 'E-mail', 'pedro@email.com', 'E-mail de trabalho'),
    (8, 'Telefone', '51995544332', 'Contato secundário'),
    (9, 'E-mail', 'ana@email.com', 'E-mail pessoal'),
    (10, 'Telefone', '61993322110', 'Número residencial'),
    (1, 'Telefone', '71991112233', 'Celular'),
    (2, 'E-mail', 'lucas@email.com', 'E-mail corporativo'),
    (3, 'Telefone', '81992233445', 'Fixo da empresa'),
    (4, 'E-mail', 'carla@email.com', 'Contato profissional'),
    (5, 'Telefone', '21998877665', 'Telefone alternativo'),
    (6, 'E-mail', 'ricardo@email.com', 'E-mail pessoal'),
    (7, 'Telefone', '31994455667', 'Contato de emergência'),
    (8, 'E-mail', 'fernanda@email.com', 'E-mail do trabalho'),
    (9, 'Telefone', '41997778899', 'WhatsApp pessoal'),
    (10, 'E-mail', 'juliana@email.com', 'E-mail principal');



