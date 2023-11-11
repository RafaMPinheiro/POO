package model;

import java.util.ArrayList;

public class Projeto {

  private final String nome;
  private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<Desenvolvedor>();
  private final int maxDevs;

  public Projeto(String nome) {
    this.nome = nome;
    this.maxDevs = 5;
  }

  public Projeto(String nome, ArrayList<Desenvolvedor> devLista) {
    this.nome = nome;
    this.desenvolvedores = devLista;
    this.maxDevs = 5;
  }

  public String getNome() {
    return nome;
  }

  public ArrayList<Desenvolvedor> getDesenvolvedores() {
    return new ArrayList<Desenvolvedor>(desenvolvedores);
  }

  private boolean podeAlocar(Desenvolvedor dev) {
    return !this.desenvolvedores.contains(dev) && this.desenvolvedores.size() < maxDevs;
  }

  public void alocarDev(Desenvolvedor dev) {
    if (this.podeAlocar(dev)) {
      this.desenvolvedores.add(dev);
      dev.alocarNo(this);
    }
  }

  @Override
  public String toString() {
    return "PROJ_" + this.nome;
  }

  public boolean temDesenvolvedor(Desenvolvedor dev) {
    return desenvolvedores.contains(dev);
  }
}
