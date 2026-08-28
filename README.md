 # 💰 Controle Financeiro

Aplicação web para controle financeiro pessoal: cadastro de usuários, categorias de receitas/despesas, lançamento de transações e acompanhamento de saldo em tempo real.


---

## Tecnologias utilizadas
<div align="left">
   <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" height="40" alt="html5 logo"  />
  <img width="12" />
   <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" height="40" alt="css logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" height="40" alt="javascript logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" height="40" alt="java logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" height="40" alt="spring boot logo" />
</div>


---

## 📌 Índice

- [Sobre o projeto](#-sobre-o-projeto)
- [Fotos do projeto](#️-fotos-do-projeto)
- [Funcionalidades](#-funcionalidades)
- [Como executar](#-como-executar)
- [Contribuindo](#-contribuindo)
- [Autor](#-autor)

---

## 📖 Sobre o projeto

O **Painel Financeiro** é uma aplicação de controle financeiro pessoal pensada para ser simples de usar e fácil de entender à primeira vista. O usuário se cadastra, faz login, cria categorias (receita ou despesa), lança transações e acompanha em um único painel:

- o total de **receitas**,
- o total de **despesas**,
- e o **saldo geral** atualizado automaticamente.

O frontend é 100% estático (HTML, CSS e JavaScript puro, sem frameworks ou build step) e se comunica com uma **API REST em Java/Spring Boot**, que é responsável por autenticação, persistência e regras de negócio.

---

## 🖼️ Fotos do Projeto

| Login | Painel Principal |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/86fac4d4-73a0-4ba0-a219-32088f83884c" width="400" alt="Tela de Login"> | <img src="https://github.com/user-attachments/assets/c944223d-8fa6-414e-aac9-d75d614fd627" width="400" alt="Painel Principal"> |

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



## 🚀 Como executar

### Pré-requisitos

- [Java 17+](https://adoptium.net/) e [Maven](https://maven.apache.org/) (ou o wrapper `mvnw` incluso no projeto do backend)
- Um navegador atualizado
- (Opcional) uma extensão como o [Live Server](https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer) para servir o frontend

### 1. Backend (Spring Boot)

```bash
cd SEU_DIRETORIO
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

Desenvolvido por **Matheus Brizzi**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=flat&logo=github&logoColor=white)](https://github.com/MatheusBrizzi)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/matheus-brizzi-956b29268/)
