class MaquinaAguaConfiguravel {
  private int agua = 0;
  private int copos200 = 0;
  private int copos300 = 0;
  public int capacidadeAgua;
  public int capacidadeCopos200;
  public int capacidadeCopos300;

  MaquinaAguaConfiguravel(int capacidadeAgua, int capacidadeCopos200, int capacidadeCopos300) {
    if (capacidadeAgua <= 0) {
      throw new IllegalArgumentException("Quantidade água deve ser positivo");
    }
    if (capacidadeCopos200 <= 0) {
      throw new IllegalArgumentException("Copos de 200mL deve ser positivo");
    }
    if (capacidadeCopos300 <= 0) {
      throw new IllegalArgumentException("Copos de 300mL deve ser positivo");
    }

    this.capacidadeAgua = capacidadeAgua;
    this.capacidadeCopos200 = capacidadeCopos200;
    this.capacidadeCopos300 = capacidadeCopos300;
  }

  public int agua() {
    return agua;
  }

  public void abastecerAgua() {
    agua += 10000;
    if (agua > capacidadeAgua) {
      agua = capacidadeAgua;
    }
  }

  public int copos200() {
    return copos200;
  }

  public void abastecerCopo200() {
    copos200 += 100;
    if (copos200 >= capacidadeCopos200) {
      copos200 = capacidadeCopos200;
    }
  }

  public void servirCopo200() {
    if (agua < 200) {
      throw new IllegalStateException("Não há água suficiente ");
    } else if (copos200 == 0) {
      throw new IllegalStateException("Não há copos de 200mL");
    }
    copos200--;
    agua -= 200;
  }

  public int copos300() {
    return copos300;
  }

  public void abastecerCopo300() {
    copos300 += 100;
    if (copos300 >= capacidadeCopos300) {
      copos300 = capacidadeCopos300;
    }
  }

  public void servirCopo300() {
    if (agua < 300) {
      throw new IllegalStateException("Não há água suficiente");
    } else if (copos300 == 0) {
      throw new IllegalStateException("Não há copos de 300mL");
    }
    copos300--;
    agua -= 300;
  }
}