import java.util.ArrayList;

class EventoSatelite {
  String nome;
  Evento.Tipo tipo;
  Evento evento;
  ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();

  EventoSatelite(String nome, Evento.Tipo tipo, Evento evento) {
    this.nome = nome;
    this.tipo = tipo;
    this.evento = evento;
  }

  public String getCidade() {
    return this.evento.getCidade();
  }

  public Evento getEventoCentral() {
    return this.evento;
  }

  public Inscrito inscrever(String nome) throws NaoHaVagaException {
    Inscrito i = new Inscrito(nome);
    this.inscritos.add(i);
    return i;
  }

  public ArrayList<Inscrito> getInscritos() {
    return inscritos;
  }

  public Inscrito getInscrito(int i) {
    return inscritos.get(i - 1);
  }

  public int getQuantidadeInscritos() {
    return inscritos.size();
  }
}
