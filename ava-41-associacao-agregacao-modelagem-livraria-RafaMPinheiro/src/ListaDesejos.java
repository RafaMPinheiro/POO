import java.util.ArrayList;

class ListaDesejos {
  String nome;
  boolean publica;
  ArrayList<Livro> livros = new ArrayList<Livro>();

  ListaDesejos(String nome, boolean publica) {
    this.nome = nome;
    this.publica = publica;
  }

  public String getNome() {
    return this.nome;
  }

  public ArrayList<Livro> getLivros() {
    if (this.publica) {
      return this.livros;
    }
    return null;
  }

  public Livro getLivro(int i) {
    if (i < 0 || i >= this.livros.size()) {
      return null;
    }
    return livros.get(i);
  }

  public int getQuantidade() {
    return this.livros.size();
  }

  boolean isPublica() {
    return this.publica;
  }

  boolean isVazia() {
    return this.livros.size() == 0 ? true : false;
  }

  public boolean isPrivada() {
    return !this.publica;
  }

  public void adicionar(Livro livro) {
    this.livros.add(livro);
  }
}
