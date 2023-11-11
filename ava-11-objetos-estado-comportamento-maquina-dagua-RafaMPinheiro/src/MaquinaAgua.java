class MaquinaAgua {
  private int agua;
  private int copos200;
  private int copos300;

  MaquinaAgua(int agua, int copos200, int copos300) {
    this.agua = agua;
    this.copos200 = copos200;
    this.copos300 = copos300;
  }

  MaquinaAgua() {
  }

  public int agua() {
    return agua;
  }

  public void abastecerAgua() {
    agua += 20000;
    if (agua > 20000) {
      agua = 20000;
    }
  }

  public int copos200() {
    return copos200;
  }

  public void abastecerCopo200() {
    copos200 += 100;
    if (copos200 >= 100) {
      copos200 = 100;
    }
  }

  public void servirCopo200() {
    if (copos200 > 0 && agua > 200) {
      copos200--;
      agua -= 200;
    }
  }

  public int copos300() {
    return copos300;
  }

  public void abastecerCopo300() {
    copos300 += 100;
    if (copos300 >= 100) {
      copos300 = 100;
    }
  }

  public void servirCopo300() {
    if (copos300 > 0 && agua >= 300) {
      copos300--;
      agua -= 300;
    }
  }
}