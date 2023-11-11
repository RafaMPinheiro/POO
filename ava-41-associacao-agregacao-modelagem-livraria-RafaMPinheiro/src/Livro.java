class Livro {
  String titulo;
  Autor autor;
  int ano;
  Editora editora;

  Livro(String t, Autor a, int ano, Editora e) {
    this.titulo = t;
    this.autor = a;
    this.ano = ano;
    this.editora = e;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public Autor getAutor() {
    return this.autor;
  }

  public Editora getEditora() {
    return this.editora;
  }

  public int getAno() {
    return this.ano;
  }

  public String toString() {
    return this.autor.toString() + ". " + this.titulo + ". Ed. " + this.editora.getNome() + ", " + this.ano + ".";
  }
}
