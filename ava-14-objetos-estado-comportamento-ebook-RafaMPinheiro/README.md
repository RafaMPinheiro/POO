# 1.4 // Objetos, Estado e Comportamento // E-Book

Use este link do GitHub Classroom para ter sua cópia alterável deste repositório: <https://classroom.github.com/a/9D7HKw7k>

Implementar respeitando os fundamentos de Orientação a Objetos.

**Tópicos desta atividade:** abstrações, classes, objetos, construtores, validade, atributos, estado, comportamento, comandos e consultas, excepcionalidades e especificações.

---

Considere uma classe para modelar/descrever o que seria um leitor de livros digitais. Os objetos da classe `EBook` devem ter pelo menos duas informações básicas: (1) o título do livro e (2) o número de páginas. O título nunca pode ser vazio e a quantidade de páginas deve sempre ser maior que zero até o limite de 5000 páginas. O objeto deve guardar e manter atualizada a página atual sendo lida, começando em 1 e nunca maior que a quantidade de páginas disponíveis no livro. Neste sentido, objetos do tipo `EBook` são mutáveis, já que permitem navegar no livro alterando o estado do objeto, neste caso, a página atual. O título e total de páginas, por outro lado, são imutáveis (`final`).

Dada essa especificação, a implementação deve aderir aos seguintes casos de teste que demonstram a  interação com a `EBook`.



```java
// Copie estes Casos de Teste para o `main`

// titulo = "Os inovadores", paginas = 544
EBook osInovadores = new EBook("Os inovadores", 544);

System.out.println(osInovadores.titulo); // Os inovadores
System.out.println(osInovadores.titulo.equals("Os inovadores")); // true

// Essa linha não deve compilar (comente-a)
osInovadores.titulo = "Alterando o título";

// Páginas também é imutável
System.out.println(osInovadores.paginas); // 544
System.out.println(osInovadores.paginas == 544); // true

// Essa linha não deve compilar (comente-a)
osInovadores.paginas = 120

// Página atual sendo lida sempre inicia com 1
System.out.println(osInovadores.lendoPagina == 1);

// Sequência de e-books inválidos,
// os construtores devem lançar uma IllegalArgumentException.

try {
  EBook ebookInvalido = new EBook("", 544); // titulo vazio
  System.out.println(false); // essa linha não deve ser alcançada
} catch(IllegalArgumentException e) { // a exceção deve ser capturada
  System.err.println(e);
}

try {
  EBook ebookInvalido = new EBook("Um titulo", 0); // sem páginas
  System.out.println(false);
} catch (IllegalArgumentException e) {
  System.err.println(e);
}

try {
  EBook ebookInvalido = new EBook("Um titulo", -10); // páginas negativas
  System.out.println(false);
} catch (IllegalArgumentException e) {
  System.err.println(e);
}

try {
  EBook ebookInvalido = new EBook("Um titulo", 6000); // páginas > 5000
  System.out.println(false);
} catch (IllegalArgumentException e) {
  System.err.println(e);
}

EBook aCatedralEOBazar = new EBook("A catedral e o bazar", 14);
// http://www.dominiopublico.gov.br/pesquisa/DetalheObraForm.do?select_action=&co_obra=8679
System.out.println(aCatedralEOBazar.titulo.equals("A catedral e o bazar"));
System.out.println(aCatedralEOBazar.paginas == 14);
System.out.println(aCatedralEOBazar.lendoPagina == 1);

EBook oComoventeGuiaDeRuby = new EBook("O (comovente) guia de Ruby do why", 121);
// http://why.carlosbrando.com/ https://en.wikipedia.org/wiki/Why_the_lucky_stiff
System.out.println(oComoventeGuiaDeRuby.titulo.equals("O (comovente) guia de Ruby do why"));
System.out.println(oComoventeGuiaDeRuby.paginas == 121);
System.out.println(oComoventeGuiaDeRuby.lendoPagina == 1);

aCatedralEOBazar.virarPagina(); // lendoPagina + 1

System.out.println(aCatedralEOBazar.lendoPagina == 2);

for (int i = 0; i < 10; i++) aCatedralEOBazar.virarPagina(); // 10 pag viradas

System.out.println(aCatedralEOBazar.lendoPagina == 12);

aCatedralEOBazar.voltarPagina();

System.out.println(aCatedralEOBazar.lendoPagina == 11);

for (int i = 0; i < 10; i++) aCatedralEOBazar.voltarPagina(); // 10 pag atrás

System.out.println(aCatedralEOBazar.lendoPagina == 1);

// tentar voltar página antes do 1 deve ser proibido
// lançando IllegalStateException

try {
  aCatedralEOBazar.voltarPagina(); // deve lançar IllegalStateException
  System.out.println(false);
} catch (IllegalStateException e) {
  System.err.println(e);
}

System.out.println(aCatedralEOBazar.lendoPagina == 1);

aCatedralEOBazar.irParaPagina(14)

System.out.println(aCatedralEOBazar.lendoPagina == 14);

// não deve virar página ou ir além do total de páginas:
try {
  aCatedralEOBazar.virarPagina(); // deve lançar IllegalStateException
  System.out.println(false);
} catch (IllegalStateException e) { // Illegal State por que limitado internamente
  System.err.println(e);
}

try {
  aCatedralEOBazar.irParaPagina(15); // deve lançar IllegalArgumentException
  System.out.println(false);
} catch (IllegalArgumentException e) { // Illegal Argument por que o argumento 15 é inválido
  System.err.println(e);
}

// Escreva mais 5 casos de teste interagindo com um novo livro à sua escolha,
// comentando sua intenção.
```

---
Obs.: os casos de teste não podem ser alterados, mas outros podem ser adicionados. Fique a vontade para adicionar códigos que imprimem ou separam os testes, por exemplo.
