package Arma;

public class Arco extends Arma {
  public Arco() {
    this.nome = "Arco";
    this.disponivel = true;

  }

  @Override
  public int getDano() {
    return 13;
  }
}
