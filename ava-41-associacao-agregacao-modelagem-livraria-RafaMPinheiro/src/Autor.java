class Autor {
  String nome;
  String sobrenome;

  Autor(String s, String n) {
    this.nome = n;
    this.sobrenome = s;
  }

  public String getNome() {
    return this.nome;
  }

  public String getSobrenome() {
    return this.sobrenome;
  }

  public String getNomeCompleto() {
    return this.getNome() + " " + this.getSobrenome();
  }

  public String toString() {
    return this.getSobrenome() + ", " + this.getNome();
  }
}
