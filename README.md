# Teste de Repositories com Infra de DB Indefinida
A aplicação de arquitetura hexagonal (portas e adaptadores) com acesso a elementos de infraestrutura como bancos de dados é feita por meio de adaptadores, que são apenas implementações de interfaces (portas) definidas pelo domínio. Neste projeto, forneceremos duas implementações da mesma porta de repositório, uma in-memory e outra baseada em JPA, focando em como testar ambas as implementações com o mesmo conjunto de testes.

# Teste de repositório de código limpo

Muitas das soluções de software que geralmente são desenvolvidas no contexto corporativo, possuem algum tipo de estado que precisa ser mantido em um armazenamento durável para acesso posterior. Dependendo dos requisitos funcionais e não funcionais específicos, a seleção da solução de persistência certa pode ser difícil de fazer e, provavelmente, exigiria um registro de decisão de arquitetura (ADR) onde a lógica da seleção, incluindo alternativas e compensações, são detalhadas. Para persistir o estado da sua aplicação, muito provavelmente você irá consultar o Teorema CAP para tomar a decisão mais adequada.

Esse processo de decisão não deve atrasar o design e o desenvolvimento do modelo de domínio de seu aplicativo. As equipes de engenharia devem se concentrar em fornecer valor (comercial), não em manter um monte de scripts DDL e desenvolver um esquema de banco de dados altamente variável, pois algumas semanas (ou meses) depois percebem que seria melhor usar um banco de dados de documentos em vez de um relacional base de dados.

O foco também no valor do domínio de entrega evita que a equipe tome decisões relacionadas ao domínio com base nas restrições de uma decisão técnica e/ou infraestrutura tomada muito cedo (ou seja, a tecnologia de banco de dados neste caso). 2F%2Fpublish.twitter.com%2F%3Fquery%3Dhttps3A2F2Ftwitter.com2Funclebobmartin2Fstatus2F118403913937453056widget%3DTweet), a arquitetura deve permitir adiar as decisões de framework (e também de infraestrutura)

## Adiar decisões relacionadas à infraestrutura

Voltando ao exemplo da tecnologia de banco de dados, uma forma de adiar a decisão de infraestrutura sobre qual tecnologia de banco de dados deve ser usada seria começar com uma simples implementação in-memory de seu repositório onde as entidades de domínio podem ser armazenadas em uma lista na memória. Essa abordagem acelera a descoberta, o design e a implementação de recursos e casos de uso de domínio, permitindo ciclos rápidos de feedback com seus stakeholders sobre o que realmente importa: **Valor do domínio**.

Agora você pode estar pensando: *"mas então, eu não estou entregando um recurso e2e funcionando"* ou *"mas como eu verifico o recurso com um adaptador na memória do meu repositório"*. Aqui entram em ação padrões de arquitetura como Arquitetura Hexagonal (também conhecida como portas e adaptadores) e metodologias como DDD (não obrigatório por ter uma Arquitetura Limpa e, por fim, Código Limpo).

## Arquitetura Hexagonal

Muitos aplicativos são projetados seguindo a arquitetura clássica de três camadas, com camadas de Apresentação/Controlador, Serviço (lógica de negócios) e Persistência. Este tipo de arquitetura tende a misturar a definição de domínio (por exemplo, entidades de domínio e objetos de valor) com tabelas (por exemplo, entidades ORM) geralmente representadas como simples objetos de transferência de dados. Isso é mostrado abaixo:

![Em camadas](images/layered.png)

Pelo contrário, com a Arquitetura Hexagonal, as classes reais relacionadas à persistência são todas definidas com base no modelo de domínio.

![Hexagonal](images/hexagonal.png)

Ao usar a porta (interface) do repositório (que é definida como parte do modelo de domínio) é possível definir *definições de teste de integração* independente da tecnologia subjacente, apenas verifica as expectativas do domínio em relação ao repositório. A próxima imagem mostra um exemplo de tal porta:

## Mostre-me o código

![Porta do repositório](images/port.png)

Com base na especificação da porta do repositório, é possível criar a *definição do teste de integração* que depende apenas da porta e, portanto, independente de qualquer decisão de tecnologia subjacente feita para persistir o estado do domínio. Esta classe de teste terá como propriedade uma instância da interface do repositório (porta) sobre a qual as expectativas são verificadas. A próxima imagem mostra como são esses testes:

![Definição do Teste de Integração](images/test-definition.png)

Depois que a definição do teste do repositório estiver concluída, podemos criar um tempo de execução de teste (teste de integração) para o repositório na memória:

![Teste de integração na memória](article/img/IT-inmemory.png)

Ou um teste de integração um pouco mais elaborado para JPA com postgres.

![Teste de integração JPA-Postgres](article/img/IT-jpa-postgres.png)

Ambos os *tempos de execução de teste* estão estendendo a mesma definição de teste, portanto, podemos ter certeza de que, ao mudar do adaptador na memória para a persistência final com recursos JPA completos, nenhum teste será afetado, sendo necessário apenas configurar o tempo de execução do teste correspondente.

Esta abordagem permitirá definir os testes da porta do repositório sem qualquer dependência de frameworks, e reutilizar esses testes uma vez que o domínio esteja melhor definido, sendo mais estável, e a equipe decida avançar com a tecnologia de banco de dados para melhor atender a qualidade da solução atributos.

A estrutura geral do projeto é apresentada a seguir