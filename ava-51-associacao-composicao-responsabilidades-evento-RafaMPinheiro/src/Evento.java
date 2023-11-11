import java.util.ArrayList;

class Evento {
  String nome;
  String cidade;
  int ano;
  Tipo tipo;
  ArrayList<Atividade> atividades = new ArrayList<Atividade>();
  ArrayList<EventoSatelite> eventoSatelite = new ArrayList<EventoSatelite>();

  enum Tipo {
    Semana, Escola, Salao, Seminario, Mostra
  }

  Evento(String nome, String cidade, Tipo tipo, int ano) {
    this.nome = nome;
    this.cidade = cidade;
    this.ano = ano;
    this.tipo = tipo;
  }

  public Atividade novaAtividade(String descricao, int vagas, Atividade.Tipo tipo) {
    Atividade a = new Atividade(descricao, vagas, tipo, this);
    this.atividades.add(a);
    return a;
  }

  public Atividade novaAtividade(String descricao, int vagas, int horas, Atividade.Tipo tipo) {
    Atividade a = new Atividade(descricao, vagas, horas, tipo, this);
    this.atividades.add(a);
    return a;
  }

  public Atividade novaAtividade(String descricao, Ministrante ministrante, int vagas, int horas, Atividade.Tipo tipo) {
    Atividade a = new Atividade(descricao, vagas, horas, tipo, this, ministrante);
    this.atividades.add(a);
    return a;
  }

  public Atividade novaAtividade(String descricao, Ministrante ministrante, Atividade.Tipo tipo) {
    Atividade a = new Atividade(descricao, ministrante, tipo);
    this.atividades.add(a);
    return a;
  }

  public String getNome() {
    return nome;
  }

  public String getCidade() {
    return cidade;
  }

  public int getAno() {
    return ano;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public ArrayList<Atividade> getAtividades() {
    return this.atividades;
  }

  public Atividade getAtividade(int i) {
    return this.atividades.get(i - 1);
  }

  public EventoSatelite novoEventoSatelite(String nome, Evento.Tipo tipo) {
    EventoSatelite e = new EventoSatelite(nome, tipo, this);
    this.eventoSatelite.add(e);
    return e;
  }

  public ArrayList<EventoSatelite> getEventosSatelites() {
    return this.eventoSatelite;
  }

  public EventoSatelite getEventoSatelite(int i) {
    return this.eventoSatelite.get(i - 1);
  }
}