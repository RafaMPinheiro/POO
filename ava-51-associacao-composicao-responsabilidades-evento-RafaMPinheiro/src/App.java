import java.util.ArrayList;

class App {
  public static void main(String[] args) throws NaoHaVagaException {

    System.out.println("Olá mundo!");
    Evento ev1 = new Evento("Semana Acadêmica IFRS", "Rio Grande", Evento.Tipo.Semana, 2021);
    Atividade atv1 = ev1.novaAtividade("Seminário TCCs TADS", 40, Atividade.Tipo.Seminario);
    Atividade atv2 = ev1.novaAtividade("Minicurso ECMA6", 20, 8, Atividade.Tipo.Minicurso);

    System.out.println(ev1.getNome().equals("Semana Acadêmica IFRS"));
    System.out.println(ev1.getTipo() == Evento.Tipo.Semana);
    System.out.println(ev1.getCidade().equals("Rio Grande"));
    System.out.println(ev1.getAno() == 2021);

    ArrayList<Atividade> atvs = ev1.getAtividades();
    System.out.println(atvs.size() == 2);
    System.out.println(atvs.get(0).equals(atv1));
    System.out.println(atvs.get(1).equals(atv2));

    System.out.println(ev1.getAtividade(1).equals(atv1));
    System.out.println(ev1.getAtividade(2).equals(atv2));

    System.out.println(atv1.getDescricao().equals("Seminário TCCs TADS"));
    System.out.println(atv1.getVagas() == 40);
    System.out.println(atv1.getTipo() == Atividade.Tipo.Seminario);
    System.out.println(atv1.getAno() == 2021);

    System.out.println(atv2.getDescricao().equals("Minicurso ECMA6"));
    System.out.println(atv2.getVagas() == 20);
    System.out.println(atv2.getHoras() == 8);
    System.out.println(atv2.getTipo() == Atividade.Tipo.Minicurso);

    System.out.println(atv1.getEvento().equals(ev1));
    System.out.println(atv2.getEvento().equals(ev1));

    Ministrante paulo = new Ministrante("Paulo Silva",
        "Paulo é formado em Análise e Desenvolvimento de Sistemas pelo IFRS e possui]5 anos de experiência na área");
    Ministrante maria = new Ministrante("Maria Santos",
        "Maria possui doutorado em Ciência de Dados e é professora na UFRGS há anos");

    Evento ev2 = new Evento("Escola Regional de Banco de Dados", "Bagé", Evento.Tipo.Escola, 2021);
    Atividade atv3 = ev2.novaAtividade("BigData com Apache Hadoop", paulo, 20, 4, Atividade.Tipo.Oficina);
    Atividade atv4 = ev2.novaAtividade("Data Science: uma introdução", maria, Atividade.Tipo.Palestra);

    System.out.println(atv3.getDescricao().equals("BigData com Apache Hadoop"));
    System.out.println(atv3.getMinistrante().equals(paulo));
    System.out.println(atv3.getVagas() == 20);
    System.out.println(atv3.getHoras() == 4);
    System.out.println(atv3.getTipo() == Atividade.Tipo.Oficina);
    System.out.println(atv3.getAno() == 2021);

    Evento ev3 = new Evento("3º Salão de Pesquisa, Extensão e Ensino do IFRS", "Bento Gonçalves", Evento.Tipo.Salao,
        2022);
    EventoSatelite sat1 = ev3.novoEventoSatelite("7º Seminário de Iniciação Científica e Tecnológica (SICT)",
        Evento.Tipo.Seminario);
    EventoSatelite sat2 = ev3.novoEventoSatelite("5º Seminário de Educação Profissional e Tecnológica (SEMEPT)",
        Evento.Tipo.Seminario);
    EventoSatelite sat3 = ev3.novoEventoSatelite("Mostra de Arte e Cultura", Evento.Tipo.Mostra);

    System.out.println(ev3.getCidade().equals("Bento Gonçalves"));
    System.out.println(sat1.getCidade().equals(ev3.getCidade()));
    System.out.println(sat1.getCidade().equals("Bento Gonçalves"));

    System.out.println(sat1.getEventoCentral().equals(ev3));

    System.out.println(ev3.getEventosSatelites().size() == 3);
    System.out.println(ev3.getEventoSatelite(1).equals(sat1));
    System.out.println(ev3.getEventoSatelite(2).equals(sat2));
    System.out.println(ev3.getEventoSatelite(3).equals(sat3));

    System.out.println(atv1.getVagas() == 40);
    System.out.println(atv1.getVagasRemanescentes() == 40);

    Inscrito insc1 = atv1.inscrever("Jean-Luc Picard");
    Inscrito insc2 = atv1.inscrever("Worf");

    System.out.println(insc1.getNome().equals("Jean-Luc Picard"));
    System.out.println(insc2.getNome().equals("Worf"));

    System.out.println(atv1.getVagasRemanescentes() == 38);

    Chave chave = insc1.getChave();
    String chaveString = chave.getChave();
    System.out.println(chaveString.length() == 16);
    for (var c : chaveString.toCharArray())
      System.out.println(c >= 65 && c <= 90);

    System.out.println(insc1.getChave().equals(insc2.getChave()) == false);

    System.out.println(insc1.isConcluido() == false);

    ArrayList<Inscrito> inscritos = atv1.getInscritos();
    System.out.println(inscritos.get(0).equals(insc1));
    System.out.println(inscritos.get(1).equals(insc2));
    System.out.println(atv1.getInscrito(2).isConcluido() == false);

    System.out.println(insc1.isConcluido() == false);
    insc1.confirmarPresenca();
    System.out.println(insc1.isConcluido() == true);
    System.out.println(atv1.getInscrito(1).isConcluido() == true);
    System.out.println(atv1.getInscrito(2).isConcluido() == false);
    atv1.getInscrito(2).confirmarPresenca();
    System.out.println(atv1.getInscrito(2).isConcluido() == true);

    for (int i = 0; i < 38; i++)
      atv1.inscrever("Klingon #" + i);

    System.out.println(atv1.getVagasRemanescentes() == 0);

    try {
      atv1.inscrever("Data");
      System.out.println(false);
    } catch (NaoHaVagaException e) {
      System.err.println(true);
    }

    sat1.inscrever("Geordi Laforge");

    System.out.println(sat1.getInscrito(1).getNome().equals("Geordi Laforge"));
    Inscrito insc3 = sat1.getInscrito(1);
    Chave chave3 = insc3.getChave();
    System.out.println(insc3 != null);
    System.out.println(chave3 != null);
    System.out.println(sat1.getQuantidadeInscritos() == 1);

    System.out.println(atv4.getVagas() == 0);
    System.out.println(atv4.getHoras() == 0);
    System.out.println(atv4.getVagasRemanescentes() == 0);
    System.out.println(atv4.getTipo().equals(Atividade.Tipo.Palestra));

    atv4.inscrever("Beverly Crusher");
    atv4.inscrever("Deanna Troi");
    System.out.println(atv4.getInscritos().size() == 2);
    System.out.println(atv4.getQuantidadeInscritos() == 2);
  }
}
