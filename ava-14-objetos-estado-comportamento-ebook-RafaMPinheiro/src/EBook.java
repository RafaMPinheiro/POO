public class EBook {
  final String titulo;
  final int paginas;
  int lendoPagina = 1;

  EBook(String paramTitulo, int paramPaginas) {
    if (paramTitulo.isBlank() || paramTitulo.isEmpty())
      throw new IllegalArgumentException("Titulo vazio");

    if (paramPaginas < 1 || paramPaginas > 5000)
      throw new IllegalArgumentException("Número de páginas invalido(1-5000)");

    this.titulo = paramTitulo;
    this.paginas = paramPaginas;
  }

  public void virarPagina() {
    if (lendoPagina == paginas)
      throw new IllegalStateException("");
    lendoPagina++;
  }

  public void voltarPagina() {
    if (lendoPagina == 1)
      throw new IllegalStateException("");
    lendoPagina--;
  }

  public void irParaPagina(int pagina) {
    if (pagina > paginas)
      throw new IllegalArgumentException("");
    lendoPagina = pagina;
  }
}
