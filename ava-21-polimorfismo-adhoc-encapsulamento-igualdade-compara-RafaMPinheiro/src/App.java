class App {
  public static void main(String[] args) {

    System.out.println("Olá mundo!");

    Dinheiro d1 = new Dinheiro(); // construtor vazio significa R$ 0,00
    System.out.println(d1.getReais() == 0);
    System.out.println(d1.getCentavos() == 0);

    Dinheiro d3 = new Dinheiro(3, 45); // três reais e 45 centavos
    System.out.println(d3.getReais() == 3);
    System.out.println(d3.getCentavos() == 45);

    Dinheiro d2 = new Dinheiro(d3); // d2 recebe os valores de d3, R$ 3,45
    System.out.println(d2.getReais() == 3);
    System.out.println(d2.getCentavos() == 45);

    Dinheiro d4 = new Dinheiro(200); // duzentos reais
    System.out.println(d4.getReais() == 200);
    System.out.println(d4.getCentavos() == 0);

    // Dinheiro d5 = new Dinheiro("R$ 345,75"); // trezentos e quarenta e cinco
    // reais e setenta e cinco centavos
    // System.out.println(d5.getReais());
    // System.out.println(d5.getCentavos());

    // Dinheiro d6 = new Dinheiro("R$ 1.000.000,11"); // um milhão de reais com onze
    // centavos
    // System.out.println(d6.getReais() == 1000000);
    // System.out.println(d6.getCentavos() == 11);

    // Dinheiro d7 = new Dinheiro("R$ 2.567,89");
    // System.out.println(d7.getReais() == 2567);
    // System.out.println(d7.getCentavos() == 89);

    Dinheiro d8 = new Dinheiro(9.75);
    System.out.println(d8.getReais() == 9);
    System.out.println(d8.getCentavos() == 75);

    Dinheiro d9 = new Dinheiro(17.569); // dezessete reais e cinquenta e seis centavos -- é truncado nas duas casas, não
                                        // arredondado!
    System.out.println(d9.getReais() == 17);
    System.out.println(d9.getCentavos() == 56);

    d3.somar(d4); // somar o valor de d4 em d3
    System.out.println(d3.getReais() == 203);
    System.out.println(d3.getCentavos() == 45);

    // d5.somar(100);
    // System.out.println(d5.getReais() == 445);
    // System.out.println(d5.getCentavos() == 75);

    // d6.somar(1.90);
    // System.out.println(d6.getReais() == 1000002);
    // System.out.println(d6.getCentavos() == 01);
    // d6.imprimir(); // R$ 1.000.002,01

    // d7.somar("R$ 998.817,86");
    // System.out.println(d7.getReais() == 1001385);
    // System.out.println(d7.getCentavos() == 75);
    // d7.imprimir(); // R$ 1.001.385,75

    Dinheiro d10 = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
    Dinheiro d11 = new Dinheiro(8, 99); // oito reais com noventa e nove centavos
    Dinheiro d12 = null; // nulo
    Dinheiro d13 = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
    Dinheiro d14 = d10; // mesma identidade de d10

    System.out.println(d10.equals(d11) == false);
    System.out.println(d10.equals(d12) == false);
    System.out.println(d10.equals(d13) == false);
    System.out.println(d10.equals(d14) == true);

    // System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
    // System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
    // System.out.println(!new Dinheiro("R$ 5,43").equals(null)); // nunca é igual a
    // null
  }
}
