# # 💰 Painel Financeiro

Aplicação web para controle financeiro pessoal: cadastro de usuários, categorias de receitas/despesas, lançamento de transações e acompanhamento de saldo em tempo real.

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=black)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-informational)

---

## 📌 Índice

- [Sobre o projeto](#-sobre-o-projeto)
- [Screenshots](#-screenshots)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Como executar](#-como-executar)
- [API — endpoints consumidos](#-api--endpoints-consumidos)
- [Modelo de dados](#-modelo-de-dados)
- [Roadmap](#-roadmap)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)
- [Autor](#-autor)

---

## 📖 Sobre o projeto

O **Painel Financeiro** é uma aplicação de controle financeiro pessoal pensada para ser simples de usar e fácil de entender à primeira vista. O usuário se cadastra, faz login, cria categorias (receita ou despesa), lança transações e acompanha em um único painel:

- o total de **receitas**,
- o total de **despesas**,
- e o **saldo geral** atualizado automaticamente.

O frontend é 100% estático (HTML, CSS e JavaScript puro, sem frameworks ou build step) e se comunica com uma **API REST em Java/Spring Boot**, que é responsável por autenticação, persistência e regras de negócio.

---

## 🖼️ Screenshots

> Substitua os links abaixo pelas imagens reais do projeto (pasta `/docs` ou `/screenshots`, por exemplo).

| Login | Painel principal |
|---|---|
| ![Tela de login](docs/screenshot-login.png) | ![Painel principal](docs/screenshot-painel.png) |

---

## ✨ Funcionalidades

- ✅ Cadastro de novo usuário
- ✅ Login com e-mail e senha
- ✅ Criação de categorias personalizadas (Receita ou Despesa)
- ✅ Lançamento de transações vinculadas a uma categoria
- ✅ Cálculo automático de receitas, despesas e saldo total
- ✅ Histórico de transações com identificação visual por tipo
- ✅ Layout responsivo (desktop e mobile)

---

## 🛠️ Tecnologias

**Frontend**
- HTML5 semântico
- CSS3 (variáveis nativas, Grid e Flexbox — sem frameworks de UI)
- JavaScript (Fetch API, vanilla, sem dependências)
- Google Fonts: [Fraunces](https://fonts.google.com/specimen/Fraunces), [Inter](https://fonts.google.com/specimen/Inter) e [JetBrains Mono](https://fonts.google.com/specimen/JetBrains+Mono)

**Backend**
- Java
- Spring Boot (API REST)

> O frontend não depende de nenhuma ferramenta de build (Webpack, Vite, npm, etc.) — é HTML puro, aberto direto no navegador ou servido por qualquer servidor estático.

---

## 📁 Estrutura do projeto

```
painel-financeiro/
├── index.html          # Frontend completo (HTML + CSS + JS)
├── docs/                # Screenshots e materiais de apoio (opcional)
└── backend/             # API em Java/Spring Boot
```

> Ajuste esta árvore para refletir a organização real do seu repositório (por exemplo, se o backend estiver em outro repositório separado).

---

## 🚀 Como executar

### Pré-requisitos

- [Java 17+](https://adoptium.net/) e [Maven](https://maven.apache.org/) (ou o wrapper `mvnw` incluso no projeto do backend)
- Um navegador atualizado
- (Opcional) uma extensão como o [Live Server](https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer) para servir o frontend

### 1. Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

A API sobe por padrão em `http://localhost:8080`.

### 2. Frontend

O frontend é um único arquivo estático (`index.html`) que consome a API em `http://localhost:8080/api`. Basta abrir o arquivo diretamente no navegador ou servi-lo com um servidor estático:

```bash
# usando o módulo http.server do Python, por exemplo
python3 -m http.server 5500
```

Depois acesse `http://localhost:5500`.

> ⚠️ Como o frontend chama `http://localhost:8080` diretamente, o backend precisa ter **CORS habilitado** para a origem do frontend em ambiente de desenvolvimento.

---

## 🔌 API — endpoints consumidos

Endpoints atualmente utilizados pelo frontend (base: `http://localhost:8080/api`):

| Método | Endpoint | Descrição | Cabeçalho |
|---|---|---|---|
| `POST` | `/usuarios` | Cria um novo usuário | — |
| `POST` | `/auth/login` | Autentica e retorna o `usuarioId` | — |
| `GET` | `/categorias` | Lista as categorias do usuário | `X-Usuario-Id` |
| `POST` | `/categorias` | Cria uma nova categoria | `X-Usuario-Id` |
| `GET` | `/transacoes` | Lista as transações do usuário | `X-Usuario-Id` |
| `POST` | `/transacoes` | Registra uma nova transação | `X-Usuario-Id` |
| `GET` | `/transacoes/saldo` | Retorna o saldo total do usuário | `X-Usuario-Id` |

> A autenticação atual é feita via `usuarioId` enviado no cabeçalho `X-Usuario-Id`. Para produção, recomenda-se evoluir para um esquema baseado em token (JWT), evitando expor o identificador diretamente.

---

## 🗂️ Modelo de dados

**Usuário**
```json
{ "nome": "string", "emailPrincipal": "string", "senha": "string" }
```

**Categoria**
```json
{ "nome": "string", "descricao": "string", "tipo": "RECEITA | DESPESA" }
```

**Transação**
```json
{
  "descricao": "string",
  "valor": 0.0,
  "data": "yyyy-mm-dd",
  "tipo": "RECEITA | DESPESA",
  "categoriaId": 0
}
```

---

## 🗺️ Roadmap

- [ ] Autenticação com token (JWT) em vez de `X-Usuario-Id`
- [ ] Edição e exclusão de transações e categorias
- [ ] Filtros de período no histórico (mês, ano, intervalo customizado)
- [ ] Gráficos de gastos por categoria
- [ ] Exportação do histórico (CSV / PDF)
- [ ] Testes automatizados (frontend e backend)

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/minha-feature`)
3. Commit suas alterações (`git commit -m 'feat: minha nova feature'`)
4. Envie para o seu fork (`git push origin feature/minha-feature`)
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👤 Autor

Desenvolvido por **[Seu Nome]**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=flat&logo=github&logoColor=white)](https://github.com/seu-usuario)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://linkedin.com/in/seu-usuario)
