import java.util.ArrayList;

class Atividade {
  String descricao;
  int vagas;
  int horas;
  boolean isConcluido = false;
  Tipo tipo;
  Evento evento;
  Ministrante ministrante;
  ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();

  enum Tipo {
    Seminario, Minicurso, Oficina, Palestra
  }

  Atividade(String descricao, int vagas, int horas, Atividade.Tipo tipo, Evento evento) {
    this.descricao = descricao;
    this.vagas = vagas;
    this.horas = horas;
    this.tipo = tipo;
    this.evento = evento;
  }

  Atividade(String descricao, int vagas, Atividade.Tipo tipo, Evento evento) {
    this.descricao = descricao;
    this.vagas = vagas;
    this.tipo = tipo;
    this.evento = evento;
  }

  Atividade(String descricao, int vagas, int horas, Atividade.Tipo tipo, Evento evento, Ministrante ministrante) {
    this.descricao = descricao;
    this.vagas = vagas;
    this.horas = horas;
    this.tipo = tipo;
    this.evento = evento;
    this.ministrante = ministrante;
  }

  public Atividade(String descricao, Ministrante ministrante, Atividade.Tipo tipo) {
    this.descricao = descricao;
    this.ministrante = ministrante;
    this.tipo = tipo;
    this.horas = 0;
    this.vagas = 0;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public int getVagas() {
    return this.vagas;
  }

  public int getHoras() {
    return this.horas;
  }

  public Tipo getTipo() {
    return this.tipo;
  }

  public Evento getEvento() {
    return this.evento;
  }

  public int getAno() {
    return this.evento.getAno();
  }

  public Object getMinistrante() {
    return this.ministrante;
  }

  public int getVagasRemanescentes() {
    return this.vagas - this.inscritos.size();
  }

  public Inscrito inscrever(String nome) throws NaoHaVagaException {
    if (this.getVagasRemanescentes() == 0 && this.vagas != 0) {
      throw new NaoHaVagaException("Não há mais vagas!");
    }
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
