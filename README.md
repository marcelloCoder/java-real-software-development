# 📘 Desenvolvimento Real de Software

Este repositório é dedicado ao projeto **Desenvolvimento Real de Software**, onde estou aplicando na prática os conceitos fundamentais e técnicas de desenvolvimento de software utilizando **Java**.

## 🎯 Objetivo do Projeto

Desenvolver um programa em Java que automatize o processamento de extratos bancários mensais, lendo os dados a partir de arquivos no formato **CSV** e realizando análises automatizadas.

---

## ✅ Capítulo 2 – Práticas Aplicadas

Abaixo estão as principais práticas e princípios aprendidos e aplicados na implementação inicial do projeto:

### 🔹 Single Responsibility Principle (SRP)

Este princípio estabelece que uma **classe deve ter apenas uma responsabilidade** ou motivo para mudar. No projeto, cada classe foi desenhada com um propósito único:
- Uma classe para leitura de arquivos CSV.
- Outra para processamento dos dados.
- E uma terceira para geração de relatórios ou estatísticas.

Isso torna o código mais organizado, modular e fácil de manter.

### 🔹 Princípio KISS (Keep It Short and Simple)

Evitei complexidade desnecessária nas implementações. O objetivo é manter o código **simples e direto**, facilitando o entendimento e manutenção futura. Soluções simples tendem a ser mais confiáveis e fáceis de testar.

### 🔹 Manutenibilidade do Código

Desde o início, o projeto foi estruturado pensando na **facilidade de manutenção e evolução**. O uso de boas práticas como SRP, KISS e DRY ajudam a manter um código limpo e fácil de modificar.

### 🔹 Princípio DRY (Don’t Repeat Yourself)

Evitei repetições no código ao reutilizar funções e componentes sempre que possível. Isso reduz erros e facilita atualizações futuras.

---

## 🧠 Coesão

Coesão se refere ao grau em que os elementos de um módulo pertencem juntos. Os diferentes níveis de coesão estudados e aplicados foram:

- **Funcional**: Todos os elementos contribuem para uma única tarefa (nível mais alto de coesão).
- **Sequencial**: A saída de uma parte é a entrada da próxima.
- **Informacional**: Módulo realiza várias ações com os mesmos dados.
- **Lógica**: Múltiplas operações relacionadas logicamente, com escolha por meio de parâmetros.
- **Utilitária**: Elementos estão relacionados apenas por estarem na mesma classe.
- **Temporal**: Elementos agrupados por ocorrerem no mesmo tempo (ex: inicialização).
- **Coincidente**: Elementos agrupados arbitrariamente (nível mais baixo de coesão).

Busquei manter a coesão nos níveis **funcional** e **sequencial**, especialmente nas classes principais do projeto.

---

## 🔄 Acoplamento

Um código com **baixo acoplamento** é preferível, pois permite que mudanças em uma parte do sistema não afetem outras. O projeto foi estruturado para minimizar dependências diretas entre módulos.

---

## 🧪 Testes Automatizados

Implementei testes automatizados com os seguintes objetivos:
- **Confiança**: Garantir que o código funcione corretamente.
- **Robustez**: Prevenir regressões com mudanças futuras.
- **Compreensão**: Facilitar o entendimento de como o sistema deve se comportar.
- **Code Coverage**: Buscar boa cobertura de código para aumentar a segurança no desenvolvimento.

---

## 📂 Estrutura do Arquivo de Entrada

O sistema lê extratos bancários no formato **CSV**, contendo dados como:
Data,Descrição,Valor 2025-01-01,
Supermercado,-150.00 2025-01-02,
Salário,3000.00 2025-01-05,


Esses dados são processados para gerar relatórios financeiros, como total de receitas, despesas e saldo final do mês.


## 🚧 Status do Projeto

📘 O **Capítulo 2** foi **finalizado com sucesso**!  
As práticas descritas foram implementadas e testadas com exemplos reais.  
O projeto segue em andamento, e novos capítulos serão incorporados nas próximas fases, trazendo novos conceitos como:
- Tratamento de exceções
- Refatoração contínua
- Integração com banco de dados
- Interface de visualização (CLI ou Web)


## 🧠 Aprendizados até aqui

Este projeto tem sido uma excelente oportunidade para consolidar conhecimentos teóricos em um caso real, com foco em:
- Boas práticas de design
- Código limpo e bem testado
- Modularização e clareza
- Disciplina de desenvolvimento profissional

---

**Obrigado por visitar este repositório!** 🚀  
Sinta-se à vontade para dar um ⭐ caso este projeto tenha te inspirado de alguma forma!
