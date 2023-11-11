package Escudo;

public class Escudo {
  public String nome;
  public int absorcao;
  public int integridade;
  public int deteriorizacao;
  public boolean disponivel;

  public String getNome() {
    return nome;
  }

  public int getTaxaAbsorcao() {
    return absorcao;
  }

  public int getIntegridade() {
    return integridade;
  }

  public int getTaxaDeteriorizacao() {
    return deteriorizacao;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  public void deteriorar(double dano) {
    double taxaDeteriorizacao = (double) (this.getTaxaDeteriorizacao() + 10) / 10;
    dano = dano * taxaDeteriorizacao;
    dano = Math.ceil(dano);
    this.integridade -= dano;
  }
}
