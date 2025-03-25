


# Muralis Challenge!

## Primeiro: Explicando a Estrutura do Projeto!

O projeto segue uma organização baseada no padrão MVC, com camadas adicionais para separação de responsabilidades. As camadas estão organizadas da seguinte forma:

- **Model**: Contém as entidades e estrutura do banco de dados, incluindo as regras de negócio relacionadas às tabelas.
- **Repository**: Responsável pela comunicação direta com o banco de dados, utilizando o `JpaRepository`.
- **Service**: Define as funcionalidades principais do sistema, ou seja, os métodos que processam os dados.
- **Service Implementation**: Implementa os métodos definidos no Service, contendo a lógica do sistema.
- **Controller**: Gerencia as requisições HTTP e direciona as chamadas para os serviços adequados.

---

## Segundo: Configuração e Scripts do Banco de Dados

Para testar o banco de dados, é necessário criar as tabelas utilizando os seguintes comandos:

### **Criação do Banco de Dados:**

```sql
CREATE DATABASE muralis;
```

### **Criação das Tabelas:**

```sql
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
```

### **População da Tabela Cliente:**

```sql
INSERT INTO cliente (nome, cpf, data_nascimento, endereco) VALUES
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
```

### **População da Tabela Contato:**

```sql
INSERT INTO contato (cliente_id, tipo, valor, observacao) VALUES
(8, 'Telefone', '11987654321', 'Número pessoal'),
(9, 'Telefone', '21988776655', 'Contato de emergência'),
(10, 'E-mail', 'joao@email.com', 'E-mail principal'),
(8, 'E-mail', 'maria@email.com', 'E-mail alternativo'),
(9, 'Telefone', '31991234567', 'Número comercial'),
(10, 'Telefone', '41999887766', 'WhatsApp'),
(8, 'E-mail', 'pedro@email.com', 'E-mail de trabalho'),
(9, 'Telefone', '51995544332', 'Contato secundário'),
(10, 'E-mail', 'ana@email.com', 'E-mail pessoal'),
(8, 'Telefone', '61993322110', 'Número residencial'),
(9, 'Telefone', '71991112233', 'Celular'),
(10, 'E-mail', 'lucas@email.com', 'E-mail corporativo'),
(8, 'Telefone', '81992233445', 'Fixo da empresa'),
(9, 'E-mail', 'carla@email.com', 'Contato profissional'),
(10, 'Telefone', '21998877665', 'Telefone alternativo'),
(8, 'E-mail', 'ricardo@email.com', 'E-mail pessoal'),
(9, 'Telefone', '31994455667', 'Contato de emergência'),
(10, 'E-mail', 'fernanda@email.com', 'E-mail do trabalho'),
(8, 'Telefone', '41997778899', 'WhatsApp pessoal'),
(9, 'E-mail', 'juliana@email.com', 'E-mail principal');
```

---

## Terceiro: Instruções para Execução do Projeto

### **1. Configuração do Backend**

Antes de rodar a aplicação, é necessário garantir que o ambiente está corretamente configurado:

- Instale o **Java Development Kit (JDK) 21** ou superior.
- Instale o **MySQL** e certifique-se de que o servidor está rodando. Se estiver utilizando **XAMPP**, inicie o MySQL antes de executar o sistema.
- Verifique se o arquivo `application.properties` contém as configurações corretas do banco de dados:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/muralis
spring.datasource.username=root
spring.datasource.password=senha_aqui
spring.jpa.hibernate.ddl-auto=update
```

- Para rodar o backend, execute o seguinte comando na raiz do projeto Spring Boot:

```bash
   mvn spring-boot:run
```

---

### **2. Configuração do Frontend (React.js)**

O frontend foi desenvolvido utilizando **React.js**, então é necessário ter o **Node.js** instalado. Se ainda não instalou, faça o download no site oficial: [https://nodejs.org/](https://nodejs.org/).

Após instalar o Node.js, siga estes passos:

1. Navegue até a pasta do frontend:

```bash
   cd frontend
```

2. Instale as dependências do projeto:

```bash
   npm install
```

3. Para rodar o frontend, execute:

```bash
   npm start
```

Caso necessário, configure variáveis de ambiente (`.env`) para integração com o backend.

---

### **3. Executando o Projeto**

Para que o sistema funcione corretamente, siga esta ordem:

1. Inicie o **MySQL** e verifique que o banco está configurado corretamente.
2. Execute o **backend** com `mvn spring-boot:run`.
3. Execute o **frontend** com `npm start`.
4. Acesse a aplicação no navegador pelo endereço `http://localhost:3000/`.

Se todas as configurações estiverem corretas, o sistema estará pronto para uso.

---






    



   
    


    




