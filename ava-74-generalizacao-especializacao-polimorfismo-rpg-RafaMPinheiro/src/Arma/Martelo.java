package Arma;

public class Martelo extends Arma {
  public Martelo(){
    this.nome = "Martelo";
    this.disponivel = true;

  }

  @Override
  public int getDano() {
    return 19;
  }
}
