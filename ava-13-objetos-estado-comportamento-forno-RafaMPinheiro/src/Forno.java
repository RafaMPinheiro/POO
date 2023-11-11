class Forno {
  final int volume;
  final int tensao;
  final int potencia;
  final int largura;
  final int altura;
  final int profundidade;

  private int temperatura = 0;
  private boolean ligado = false;
  private int timer = 0;

  Forno(int volume, int tensao, int potencia, int largura, int altura, int profundidade) {
    this.volume = volume;
    this.tensao = tensao;
    this.potencia = potencia;
    this.largura = largura;
    this.altura = altura;
    this.profundidade = profundidade;
  }

  public int temperatura() {
    return temperatura;
  }

  public boolean ligado() {
    return ligado;
  }

  public void ligar() {
    ligado = true;
    temperatura = 50;
  }

  public void desligar() {
    ligado = false;
    temperatura = 0;
  }

  public void aumentarTemperatura() {
    if (ligado == false) {
      ligar();
      return;
    }

    if (temperatura == 200)
      temperatura -= 30; // (200 - 30) + 50 == 220
    if (temperatura == 220)
      temperatura -= 20; // (220 - 20) + 50 == 250

    if (temperatura < 300)
      temperatura += 50;
  }

  public void diminuirTemperatura() {
    if (ligado == false)
      return;

    if (temperatura == 250)
      temperatura += 20; // (250 + 20) - 50 == 220
    if (temperatura == 220)
      temperatura += 30; // (220 + 30) - 50 == 200

    if (temperatura > 50)
      temperatura -= 50;
  }

  public void setTimer(int timer) {
    if (timer > 0)
      this.timer = timer;
  }

  public void tick() {
    if (timer > 0)
      this.timer--;
    if (timer == 0)
      desligar();
  }

  public int tempoRestante() {
    return timer;
  }
}