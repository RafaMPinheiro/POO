import java.text.NumberFormat;
import java.util.Locale;

public class Dinheiro {
  private int centavos;

  public Dinheiro() {
    this.centavos = 0;
  }

  public Dinheiro(int reais, int centavos) {
    this.centavos = centavos + (reais * 100);
  }

  public Dinheiro(double dinheiro) {
    this.centavos = (int) (dinheiro * 100);
  }

  public Dinheiro(Dinheiro dinheiro) {
    this.centavos = dinheiro.centavos;
  }

  public int getCentavos() {
    return centavos % 100;
  }

  public int getReais() {
    return centavos / 100;
  }

  public void somar(Dinheiro dinheiro) {
    this.centavos += dinheiro.centavos;
  }

  public void somar(int reais, int centavos) {
    this.centavos += centavos + (reais * 100);
  }

  public void somar(double dinheiro) {
    this.centavos += (int) (dinheiro * 100);
  }

  @Override
  public String toString() {
    double valor = centavos / 100.0;
    NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    return moeda.format(valor);
  }

  public void imprimir() {
    System.out.println(this.toString());
  }
}