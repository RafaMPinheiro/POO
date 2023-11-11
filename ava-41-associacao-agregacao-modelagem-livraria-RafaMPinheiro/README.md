# 4.1 // Associação, Agregação e Modelagem // Livraria

Use este link do GitHub Classroom para ter sua cópia alterável deste repositório: <https://classroom.github.com/a/daIRYkOv>

Implementar respeitando os fundamentos de Orientação a Objetos.

**Tópicos desta atividade:** associações, dependências, agregações, modelagem

---

Implementar o sistema de livraria online. Todas as classes devem ser implementadas no pacote [model](src/model/) e importadas pelo [App.java](src/App.java). Casos de Teste:

```java
Editora editoraRecord = new Editora("Record");
System.out.println(editoraRecord.getNome().equals("Record"));

Editora editoraWMF = new Editora("WMF");
System.out.println(editoraWMF.getNome().equals("WMF"));

Editora editoraCompanhiaDeBolso = new Editora("Companhia de Bolso");
System.out.println(editoraCompanhiaDeBolso.getNome().equals("Companhia de Bolso"));

Autor autorGleiser = new Autor("Gleiser", "Marcelo");
System.out.println(autorGleiser.getNomeCompleto().equals("Marcelo Gleiser"));
System.out.println(autorGleiser.getSobrenome().equals("Gleiser"));
System.out.println(autorGleiser.getNome().equals("Marcelo"));
System.out.println(autorGleiser.toString().equals("Gleiser, Marcelo"));

Autor autorSponville = new Autor("Sponville", "André Comte");
System.out.println(autorSponville.getNomeCompleto().equals("André Comte Sponville"));
System.out.println(autorSponville.getSobrenome().equals("Sponville"));
System.out.println(autorSponville.getNome().equals("André Comte"));
System.out.println(autorSponville.toString().equals("Sponville, André Comte"));

Autor autorSagan = new Autor("Sagan", "Carl");
System.out.println(autorSagan.getNomeCompleto().equals("Carl Sagan"));
System.out.println(autorSagan.getSobrenome().equals("Sagan"));
System.out.println(autorSagan.getNome().equals("Carl"));
System.out.println(autorSagan.toString().equals("Sagan, Carl"));

// Instanciação de um Livro
Livro livroCaldeiraoAzul = new Livro("O caldeirão azul", autorGleiser, 2019, editoraRecord);
System.out.println(livroCaldeiraoAzul.getTitulo().equals("O caldeirão azul"));
// Note que o método getAutor retorna um Autor, portanto o equals
System.out.println(livroCaldeiraoAzul.getAutor() == autorGleiser);
System.out.println(livroCaldeiraoAzul.getAutor().equals(autorGleiser));
System.out.println(livroCaldeiraoAzul.getAno() == 2019);
// Note que o método getEditora retorna uma Editora, portanto o equals
System.out.println(livroCaldeiraoAzul.getEditora() == editoraRecord);
System.out.println(livroCaldeiraoAzul.getEditora().equals(editoraRecord));
System.out.println(livroCaldeiraoAzul.toString().equals("Gleiser, Marcelo. O caldeirão azul. Ed. Record, 2019."));

// Outros livros
Livro livroCriacaoImperfeita = new Livro("Criação imperfeita", autorGleiser, 2010, editoraRecord);
System.out.println(livroCriacaoImperfeita.getTitulo().equals("Criação imperfeita"));
System.out.println(livroCriacaoImperfeita.getAutor().equals(autorGleiser));
System.out.println(livroCriacaoImperfeita.getAno() == 2010);
System.out.println(livroCriacaoImperfeita.getEditora().equals(editoraRecord));

Livro livroPequenoTratado = new Livro("Pequeno tratado das grandes virtudes", autorSponville, 2016, editoraWMF);
System.out.println(livroPequenoTratado.getTitulo().equals("Pequeno tratado das grandes virtudes"));
System.out.println(livroPequenoTratado.getAutor().equals(autorSponville));
System.out.println(livroPequenoTratado.getAno() == 2016);
System.out.println(livroPequenoTratado.getEditora().equals(editoraWMF));

Livro livroFelicidadeDesesperadamente = new Livro("A Felicidade, Desesperadamente", autorSponville, 2015, editoraWMF);
System.out.println(livroFelicidadeDesesperadamente.getTitulo().equals("A Felicidade, Desesperadamente"));
System.out.println(livroFelicidadeDesesperadamente.getAutor().equals(autorSponville));
System.out.println(livroFelicidadeDesesperadamente.getAno() == 2015);
System.out.println(livroFelicidadeDesesperadamente.getEditora().equals(editoraWMF));

Livro livroMundoAssombrado = new Livro("O mundo assombrado pelos demônios", autorSagan, 2006, editoraCompanhiaDeBolso);
System.out.println(livroMundoAssombrado.toString().equals("Sagan, Carl. O mundo assombrado pelos demônios. Ed. Companhia de Bolso, 2006."));


// Um Usuario do Sistema terá um Perfil
Perfil meuPerfil = new Perfil("Meu Nome Aqui");
System.out.println(meuPerfil.getNome().equals("Meu Nome Aqui"));

// Um perfil de usuário pode ter várias listas de desejos (ver como funciona em amazon.com.br)
ArrayList listasDesejos = meuPerfil.getListasDeDesejos();
System.out.println(listasDesejos.isEmpty()); // não há nenhuma lista
System.out.println(listasDesejos.size() == 0); // não há nenhuma lista


// Criando uma lista de desejos, armazena internamente e devolve
ListaDesejos minhaLista = meuPerfil.novaListaDesejos("Minha lista", true); // true é pública, false é privada
System.out.println(minhaLista != null);
System.out.println(minhaLista.getNome().equals("Minha lista"));
System.out.println(minhaLista.isPublica() == true);
// agora há uma lista de desejos no perfil
System.out.println(meuPerfil.getListasDeDesejos().isEmpty() == false);
System.out.println(meuPerfil.getListasDeDesejos().size() == 1);
// deve ser possível pegar a lista por índice e por nome
System.out.println(meuPerfil.getListaDeDesejos(0) == minhaLista);
System.out.println(meuPerfil.getListaDeDesejos("Minha lista") == minhaLista);
// se não existe devolve null
System.out.println(meuPerfil.getListaDeDesejos(1) == null);
System.out.println(meuPerfil.getListaDeDesejos("Uma lista que não existe") == null);

// adicionar dois livros à lista de desejos "Minha Lista"
minhaLista.adicionar(livroCaldeiraoAzul); // pode ser pelo objeto devolvido
meuPerfil.getListaDeDesejos(0).adicionar(livroPequenoTratado); // ou navegando no grafo


// Listas de desejos têm livros, getLivros devolve o ArrayList com os livros
ArrayList minhaListaLivros = minhaLista.getLivros();
System.out.println(minhaListaLivros); // imprime os dois livros
// quais livros? é acessível por getLivro(indice)
System.out.println(minhaListaLivros.get(0).equals(livroCaldeiraoAzul));
System.out.println(minhaLista.getLivro(0).equals(livroCaldeiraoAzul));
System.out.println(minhaListaLivros.get(1).equals(livroPequenoTratado));
System.out.println(minhaLista.getLivro(1).equals(livroPequenoTratado));
// se não existe, volta null
System.out.println(minhaLista.getLivro(2) == null);
// getLivros() devolve o ArrayList então pode ser operado direto
System.out.println(minhaLista.getLivros().get(0).equals(livroCaldeiraoAzul));
System.out.println(minhaLista.getLivros().get(1).equals(livroPequenoTratado));


// Criando uma nova lista de desejos que por sua vez pode ter mais livros
ListaDesejos listaUrgente = meuPerfil.novaListaDesejos("Comprar Urgente", false);
System.out.println(listaUrgente != null);
System.out.println(listaUrgente.isPublica() == false);
System.out.println(listaUrgente.isPrivada() == true);
System.out.println(listaUrgente.getNome().equals("Comprar Urgente"));

// Existem duas listas agora (getListasDeDesejos retorna ArrayList)
System.out.println(meuPerfil.getListasDeDesejos().size() == 2);

// não há livros na lista Comprar Urgente
System.out.println(listaUrgente.getQuantidade() == 0);
System.out.println(listaUrgente.isVazia() == true);

// adiciona o primeiro livro à lista Comprar Urgente
listaUrgente.adicionar(livroFelicidadeDesesperadamente);
// há um livro na lista Comprar Urgente
System.out.println(listaUrgente.getQuantidade() == 1);
System.out.println(listaUrgente.isVazia() == false);

// adiciona mais um livro à Minha Lista
meuPerfil.getListaDesejos("Minha lista").adicionar(livroCriacaoImperfeita);
// adiciona mais dois livros à Comprar Urgente
meuPerfil.getListaDesejos("Comprar Urgente").adicionar(livroCriacaoImperfeita);
meuPerfil.getListaDesejos("Comprar Urgente").adicionar(livroMundoAssombrado);

// assumindo que a lista Comprar Urgente tem três livros
// método getQuantidade é de ListaDesejos
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getQuantidade() == 3);
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(0).equals(livroFelicidadeDesesperadamente));
// Assumindo que o segundo livro da lista Comprar Urgente é o Criação Imperfeita
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(1).equals(livroCriacaoImperfeita));
// Assumindo que o terceiro livro da lista Comprar Urgente é o Mundo Assombrado
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(2).equals(livroMundoAssombrado));

// navegando no grafo de objetos
// Obtendo o nome do autor do primeiro livro da lista de desejos Minha Lista
System.out.println(meuPerfil.getListaDesejos("Minha lista").getLivro(0).getAutor().getNome()); // Marcelo
System.out.println(meuPerfil.getListaDesejos("Minha lista").getLivro(0).getAutor().getNome().equals("Marcelo"));
// O sobrenome do autor do terceiro livro da lista de desejos Comprar Urgente
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(2).getAutor().getSobrenome());
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(2).getAutor().getSobrenome().equals("Sagan"));
// Obtendo o nome da editora do terceiro livro da lista de desejos Comprar Urgente
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(2).getEditora().getNome());
System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(2).getEditora().getNome().equals("Companhia de Bolso"));

// Obtendo o título do segundo livro da segunda lista de desejos
System.out.println(meuPerfil.getListaDesejos(1).getLivro(1).getTitulo().equals("Criação imperfeita"));
```

---
Obs.: os casos de teste não podem ser alterados, mas outros podem ser adicionados. Fique a vontade para adicionar códigos que imprimem ou separam os testes, por exemplo.
