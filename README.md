# 📊 Transações Simplificadas - Desafio Backend PicPay

Este repositório contém a implementação do desafio proposto pelo PicPay Simplificado. O objetivo deste projeto é criar uma plataforma de pagamentos simplificada onde usuários podem realizar transferências de dinheiro entre si e para lojistas, seguindo algumas regras de negócios.

### O sistema foi desenvolvido com base nas seguintes regras de negócios:

- **Cadastro de Usuários**: Para ambos os tipos de usuário (comum e lojista), é necessário o Nome Completo, CPF, E-mail e Senha. O CPF/CNPJ e E-mails devem ser únicos.
- **Transferências**: Usuários podem enviar dinheiro para lojistas e entre si. Lojistas apenas recebem transferências.
- **Validação de Saldo**: O sistema valida se o usuário tem saldo suficiente antes de realizar a transferência.
- **Serviço Autorizador Externo**: Antes de finalizar uma transferência, é feito uma consulta ao serviço de autorizador externo.
- **Transações**: A operação de transferência é transacional e será revertida em caso de falha.
- **Notificação**: Ao receber um pagamento, tanto o usuário quanto o lojista devem ser notificados via e-mail ou SMS por um serviço de terceiro, simulando um serviço de envio de notificações.

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Gradle (Groovy)**

## ⚙️ Configuração e Execução

### 📌 **Pré-requisitos**
- **Java 17+** instalado
- **Gradle 7+** instalado
- **Docker** instalado

### ▶️ **Executando a Aplicação**
1. **Clone o repositório**
   ```sh
   git clone https://github.com/fabricioaquiles/desafio-picpay.git
   cd desafio-picpay
2. **Executar via Docker**
   ```sh
   docker-compose up --build

# 📌 Endpoints da API

## 1️⃣ Criar uma Transação
**📌 POST /transfer**

**Descrição:** Realiza uma transação entre usuários.

**Exemplo de requisição:**
```json
{
  "value": 100.0,
  "payer": 4,
  "payee": 15
}
```
**Respostas**:
   * `201 Created`: Transação realizada com sucesso.
   * `422 Unprocessable Entity`: Transação inválida (usuario, valor negativo, etc).
   * `404 Not Found`: Usuário não encontrado.
   * `400 Bad Request`: Requisição malformada.
   * `403 Forbidden`: Transação não autorizada.
   * `500 Internal Server Error`: Erro interno no servidor
