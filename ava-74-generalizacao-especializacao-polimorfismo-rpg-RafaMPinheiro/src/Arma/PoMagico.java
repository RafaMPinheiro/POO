package Arma;

public class PoMagico extends Arma {
  public PoMagico() {
    this.nome = "Pó Mágico";
    this.disponivel = true;
  }

  @Override
  public int getDano() {
    return 15;
  }
}
