import java.util.ArrayList;

class App {
  public static void main(String[] args) {

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

    Livro livroCaldeiraoAzul = new Livro("O caldeirão azul", autorGleiser, 2019, editoraRecord);
    System.out.println(livroCaldeiraoAzul.getTitulo().equals("O caldeirão azul"));
    System.out.println(livroCaldeiraoAzul.getAutor() == autorGleiser);
    System.out.println(livroCaldeiraoAzul.getAutor().equals(autorGleiser));
    System.out.println(livroCaldeiraoAzul.getAno() == 2019);
    System.out.println(livroCaldeiraoAzul.getEditora() == editoraRecord);
    System.out.println(livroCaldeiraoAzul.getEditora().equals(editoraRecord));
    System.out.println(livroCaldeiraoAzul.toString().equals("Gleiser, Marcelo. O caldeirão azul. Ed. Record, 2019."));

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

    Livro livroFelicidadeDesesperadamente = new Livro("A Felicidade, Desesperadamente", autorSponville, 2015,
        editoraWMF);
    System.out.println(livroFelicidadeDesesperadamente.getTitulo().equals("A Felicidade, Desesperadamente"));
    System.out.println(livroFelicidadeDesesperadamente.getAutor().equals(autorSponville));
    System.out.println(livroFelicidadeDesesperadamente.getAno() == 2015);
    System.out.println(livroFelicidadeDesesperadamente.getEditora().equals(editoraWMF));

    Livro livroMundoAssombrado = new Livro("O mundo assombrado pelos demônios", autorSagan, 2006,
        editoraCompanhiaDeBolso);
    System.out.println(livroMundoAssombrado.toString()
        .equals("Sagan, Carl. O mundo assombrado pelos demônios. Ed. Companhia de Bolso, 2006."));

    Perfil meuPerfil = new Perfil("Meu Nome Aqui");
    System.out.println(meuPerfil.getNome().equals("Meu Nome Aqui"));

    ArrayList<ListaDesejos> listasDesejos = meuPerfil.getListasDeDesejos();
    System.out.println(listasDesejos.isEmpty());
    System.out.println(listasDesejos.size() == 0);

    ListaDesejos minhaLista = meuPerfil.novaListaDesejos("Minha lista", true);
    System.out.println(minhaLista != null);
    System.out.println(minhaLista.getNome().equals("Minha lista"));
    System.out.println(minhaLista.isPublica() == true);
    System.out.println(meuPerfil.getListasDeDesejos().isEmpty() == false);
    System.out.println(meuPerfil.getListasDeDesejos().size() == 1);
    System.out.println(meuPerfil.getListaDeDesejos(0) == minhaLista);
    System.out.println(meuPerfil.getListaDeDesejos("Minha lista") == minhaLista);
    System.out.println(meuPerfil.getListaDeDesejos(1) == null);
    System.out.println(meuPerfil.getListaDeDesejos("Uma lista que não existe") == null);

    minhaLista.adicionar(livroCaldeiraoAzul);
    meuPerfil.getListaDeDesejos(0).adicionar(livroPequenoTratado);

    ArrayList<Livro> minhaListaLivros = minhaLista.getLivros();
    System.out.println(minhaListaLivros.get(0).equals(livroCaldeiraoAzul));
    System.out.println(minhaLista.getLivro(0).equals(livroCaldeiraoAzul));
    System.out.println(minhaListaLivros.get(1).equals(livroPequenoTratado));
    System.out.println(minhaLista.getLivro(1).equals(livroPequenoTratado));
    System.out.println(minhaLista.getLivro(2) == null);
    System.out.println(minhaLista.getLivros().get(0).equals(livroCaldeiraoAzul));
    System.out.println(minhaLista.getLivros().get(1).equals(livroPequenoTratado));

    ListaDesejos listaUrgente = meuPerfil.novaListaDesejos("Comprar Urgente", false);
    System.out.println(listaUrgente != null);
    System.out.println(listaUrgente.isPublica() == false);
    System.out.println(listaUrgente.isPrivada() == true);
    System.out.println(listaUrgente.getNome().equals("Comprar Urgente"));

    System.out.println(meuPerfil.getListasDeDesejos().size() == 2);

    System.out.println(listaUrgente.getQuantidade() == 0);
    System.out.println(listaUrgente.isVazia() == true);

    listaUrgente.adicionar(livroFelicidadeDesesperadamente);
    System.out.println(listaUrgente.getQuantidade() == 1);
    System.out.println(listaUrgente.isVazia() == false);

    meuPerfil.getListaDeDesejos("Minha lista").adicionar(livroCriacaoImperfeita);
    meuPerfil.getListaDeDesejos("Comprar Urgente").adicionar(livroCriacaoImperfeita);
    meuPerfil.getListaDeDesejos("Comprar Urgente").adicionar(livroMundoAssombrado);

    System.out.println(meuPerfil.getListaDeDesejos("Comprar Urgente").getQuantidade() == 3);
    System.out
        .println(meuPerfil.getListaDeDesejos("Comprar Urgente").getLivro(0).equals(livroFelicidadeDesesperadamente));
    System.out.println(meuPerfil.getListaDeDesejos("Comprar Urgente").getLivro(1).equals(livroCriacaoImperfeita));
    System.out.println(meuPerfil.getListaDeDesejos("Comprar Urgente").getLivro(2).equals(livroMundoAssombrado));

    System.out.println(meuPerfil.getListaDeDesejos("Minha lista").getLivro(0).getAutor().getNome().equals("Marcelo"));

    System.out
        .println(meuPerfil.getListaDeDesejos("Comprar Urgente").getLivro(2).getAutor().getSobrenome().equals("Sagan"));

    System.out.println(
        meuPerfil.getListaDeDesejos("Comprar Urgente").getLivro(2).getEditora().getNome().equals("Companhia de Bolso"));

    System.out.println(meuPerfil.getListaDeDesejos(1).getLivro(1).getTitulo().equals("Criação imperfeita"));
  }
}
