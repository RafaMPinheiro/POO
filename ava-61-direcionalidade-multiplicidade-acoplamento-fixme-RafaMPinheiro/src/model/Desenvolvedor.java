package model;

import java.util.ArrayList;

public class Desenvolvedor {

  private final String nome;
  private final ArrayList<Projeto> projetos = new ArrayList<Projeto>();
  private final int maxProjetos;

  public Desenvolvedor(String nome) {
    this.nome = nome;
    this.maxProjetos = 2;
  }

  public String getNome() {
    return nome;
  }

  public ArrayList<Projeto> getProjetos() {
    return new ArrayList<Projeto>(projetos);
  }

  public boolean podeSerAlocado(Projeto projeto) {
    return projetos.size() < maxProjetos && !projetos.contains(projeto);
  }

  public void alocarNo(Projeto projeto) {
    if (podeSerAlocado(projeto)) {
      projetos.add(projeto);
      projeto.alocarDev(this);
    }
  }

  @Override
  public String toString() {
    return "DEV_" + this.nome;
  }
}
