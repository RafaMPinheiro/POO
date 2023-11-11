class Inscrito {
  String nome;
  Chave chave;
  boolean isConcluido = false;

  Inscrito(String nome) {
    this.nome = nome;
    this.chave = new Chave();
  }

  public String getNome() {
    return this.nome;
  }

  public Chave getChave() {
    return this.chave;
  }

  public boolean isConcluido() {
    return this.isConcluido;
  }

  public void confirmarPresenca() {
    this.isConcluido = true;
  }
}
