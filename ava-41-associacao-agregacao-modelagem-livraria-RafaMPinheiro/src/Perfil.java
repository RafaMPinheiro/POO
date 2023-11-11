import java.util.ArrayList;

class Perfil {
  String nome;
  ArrayList<ListaDesejos> listaDeDesejos = new ArrayList<ListaDesejos>();

  Perfil(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public ArrayList<ListaDesejos> getListasDeDesejos() {
    return this.listaDeDesejos;
  }

  public ListaDesejos getListaDeDesejos(int i) {
    if (i < 0 || i >= this.listaDeDesejos.size()) {
      return null;
    }
    return this.listaDeDesejos.get(i);
  }

  public ListaDesejos getListaDeDesejos(String nome) {
    for (ListaDesejos lista : this.listaDeDesejos) {
      if (lista.getNome().equals(nome)) {
        return lista;
      }
    }
    return null;
  }

  public boolean isEmpty() {
    if (this.listaDeDesejos == null) {
      return true;
    }
    return false;
  }

  ListaDesejos novaListaDesejos(String nome, boolean publica) {
    ListaDesejos lista = new ListaDesejos(nome, publica);
    this.listaDeDesejos.add(lista);
    return lista;
  }
}
