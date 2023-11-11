import java.util.ArrayList;

import model.Desenvolvedor;
import model.Projeto;

public class App {
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

    // Considere três projetos
    Projeto projetoBanco = new Projeto("Banco");
    Projeto projetoEcommerce = new Projeto("E-Commerce");
    Projeto projetoRedeSocial = new Projeto("Rede Social");
    Projeto projetoERP = new Projeto("ERP");

    // Considere 7 desenvolvedores(as)
    Desenvolvedor devFlavia = new Desenvolvedor("Flavia");
    Desenvolvedor devArtur = new Desenvolvedor("Artur");
    Desenvolvedor devNatalia = new Desenvolvedor("Natalia");
    Desenvolvedor devPedro = new Desenvolvedor("Pedro");
    Desenvolvedor devRoberta = new Desenvolvedor("Roberta");
    Desenvolvedor devRogerio = new Desenvolvedor("Rogerio");
    Desenvolvedor devMarina = new Desenvolvedor("Marina");

    // Um projeto pode ter um dev alocado à ele:
    projetoBanco.alocarDev(devFlavia);

    // Ao mesmo tempo que o Projeto tem Desenvolvedores.
    // Desesenvolvedores têm Projetos (tá aí a bidirecionalidade).
    System.out.println(devFlavia.getProjetos().size() == 1);

    projetoEcommerce.alocarDev(devFlavia);
    System.out.println(devFlavia.getProjetos().size() == 2);

    projetoRedeSocial.alocarDev(devFlavia);
    System.out.println(devFlavia.getProjetos().size() == 2);

    // Deve retornar um clone da lista e não causar efeito.
    devFlavia.getProjetos().add(projetoEcommerce); // não deveria causar efeito
    devFlavia.getProjetos().add(projetoRedeSocial); // não deveria causar efeito
    // mas causa a inconsistência:
    System.out.println(devFlavia.getProjetos().size() == 2); // FALSE, deveria ser TRUE

    // o método podeSerAlocado deveria ser inacessível para o App.java
    // System.out.println(devFlavia.podeSerAlocado(projetoRedeSocial)); // comentar

    devArtur.alocarNo(projetoERP);
    devNatalia.alocarNo(projetoERP);
    devPedro.alocarNo(projetoERP);
    devRoberta.alocarNo(projetoERP);
    devRogerio.alocarNo(projetoERP);
    devMarina.alocarNo(projetoERP);

    System.out.println(projetoERP.getDesenvolvedores().size() == 5);

    // Consultando se um dev está no projeto:
    System.out.println(projetoERP.temDesenvolvedor(devArtur) == true);
    System.out.println(projetoERP.temDesenvolvedor(devRoberta) == true);
    System.out.println(projetoERP.temDesenvolvedor(devMarina) == false);

    ArrayList<Desenvolvedor> devLista = new ArrayList<Desenvolvedor>();
    devLista.add(devMarina);
    devLista.add(devArtur);
    devLista.add(devRoberta);
    Projeto projetoEdu = new Projeto("Educação", devLista);

    // Verificar se a lista de desenvolvedores do projeto de Educação contém os desenvolvedores corretos
    System.out.println(projetoEdu.getDesenvolvedores().contains(devMarina) == true);
    System.out.println(projetoEdu.getDesenvolvedores().contains(devArtur) == true);
    System.out.println(projetoEdu.getDesenvolvedores().contains(devRoberta) == true);
  }
}
