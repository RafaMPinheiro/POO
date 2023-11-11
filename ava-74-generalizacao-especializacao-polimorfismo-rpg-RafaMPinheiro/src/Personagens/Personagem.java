package Personagens;

import Arma.Arma;
import Escudo.Escudo;

public class Personagem {
  public int saude;
  public boolean vivo;
  public Escudo escudo;
  public Arma armaPrincipal;
  public Arma armaSegundaria;

  Personagem() {
    this.saude = 100;
    this.vivo = true;
    this.escudo = null;
    this.armaPrincipal = null;
    this.armaSegundaria = null;
  }

  public boolean estaVivo() {
    return vivo;
  }

  public int getSaude() {
    return saude;
  }

  public Arma getArmaPrincipal() {
    return armaPrincipal;
  }

  public Arma getArmaSecundaria() {
    return armaSegundaria;
  }

  public Escudo getEscudo() {
    return escudo;
  }

  public int getForca() {
    return 0;
  }

  public int getPontaria() {
    return 0;
  }

  public int getMagica() {
    return 0;
  }

  public boolean estaDesarmado() {
    return getArmaPrincipal() == null;
  }

  public void pegaArma(Arma a) {
    if (a.disponivel) {
      a.disponivel = false;
      this.armaSegundaria = getArmaPrincipal();
      this.armaPrincipal = a;
    }
  }

  public void largaArma() {
    if (this.armaPrincipal != null)
      this.armaPrincipal.disponivel = true;
    this.armaPrincipal = getArmaSecundaria();
    this.armaSegundaria = null;
  }

  public String toString() {
    return "";
  }

  public void trocaArma() {
    if (getArmaPrincipal() != null && getArmaSecundaria() != null) {
      Arma aux = getArmaPrincipal();
      this.armaPrincipal = getArmaSecundaria();
      this.armaSegundaria = aux;
    }
  }

  public void ataca(Personagem personagem) {
    double dano;
    Arma arma = getArmaPrincipal();
    Escudo escudo = personagem.getEscudo();

    if (arma != null) {
      switch (arma.getNome()) {
        case "Martelo":
          dano = Math.ceil((double) getForca() / 10 * arma.getDano());
          break;
        case "Arco":
          dano = Math.ceil((double) getPontaria() / 10 * arma.getDano());
          break;
        case "Pó Mágico":
          dano = Math.ceil((double) getMagica() / 10 * arma.getDano());
          break;
        default:
          dano = 0;
          break;
      }

      if (escudo != null) {
        personagem.getEscudo().deteriorar(dano);
        double defesaEscudo = escudo.getTaxaAbsorcao();
        dano -= (defesaEscudo / 10 * dano);
        dano = Math.floor(dano);
      }

      personagem.saude -= (int) dano;
    }
  }

  public void pegaEscudo(Escudo escudo) {
    if (getEscudo() == null && escudo.isDisponivel()) {
      this.escudo = escudo;
      escudo.disponivel = false;
    }
  }

  public void largaEscudo() {
    if (getEscudo() != null) {
      getEscudo().disponivel = true;
      this.escudo = null;
    }
  }
}
