 # 💰 Painel Financeiro

Aplicação web para controle financeiro pessoal: cadastro de usuários, categorias de receitas/despesas, lançamento de transações e acompanhamento de saldo em tempo real.

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=black)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white)


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

| Tela de login(<img width="1907" height="896" alt="Screenshot 2026-08-27 233833" src="https://github.com/user-attachments/assets/86fac4d4-73a0-4ba0-a219-32088f83884c" />
) | ![Painel principal](<img width="1889" height="903" alt="Screenshot 2026-08-27 233944" src="https://github.com/user-attachments/assets/c944223d-8fa6-414e-aac9-d75d614fd627" />
)

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



## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/minha-feature`)
3. Commit suas alterações (`git commit -m 'feat: minha nova feature'`)
4. Envie para o seu fork (`git push origin feature/minha-feature`)
5. Abra um Pull Request



## 👤 Autor

Desenvolvido por **[Matheus_Brizzi]**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=flat&logo=github&logoColor=white)](https://github.com/seu-usuario)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://linkedin.com/in/seu-usuario)
