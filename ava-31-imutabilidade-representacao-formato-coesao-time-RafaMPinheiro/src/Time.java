class Time {
  public static final Time MIDDAY = new Time(12, 0, 0);
  public static final Time MIDNIGHT = new Time();
  int horas;
  int minutos;
  int segundos;

  Time() {
    this.horas = 0;
    this.minutos = 0;
    this.segundos = 0;
  }

  Time(int horas, int minutos) {
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = 0;
  }

  Time(int horas, int minutos, int segundos) {
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
  }

  int getHoras() {
    return this.horas;
  }

  int getMinutos() {
    return this.minutos;
  }

  int getSegundos() {
    return this.segundos;
  }

  Time plus(Time time) {
    int newHoras = this.horas + time.horas;
    int newMinutos = this.minutos + time.minutos;
    if (newMinutos > 59) {
      newMinutos -= 60;
      newHoras += 1;
    }
    int newSegundos = this.segundos + time.segundos;
    if (newSegundos > 59) {
      newSegundos -= 60;
      newMinutos += 1;
    }
    return new Time(newHoras, newMinutos, newSegundos);
  }

  Time plusHours(int horas) {
    return this.plus(Time.fromSeconds(horas * 3600));
  }

  Time plusMinutes(int minutos) {
    return this.plus(Time.fromSeconds(minutos * 60));
  }

  Time plusSeconds(int segundos) {
    return this.plus(Time.fromSeconds(segundos));
  }

  Time minus(Time time) {
    this.horas -= time.horas;
    this.minutos -= time.minutos;
    this.segundos -= time.segundos;
    return new Time(this.horas, this.minutos, this.segundos);
  }

  Time minusHours(int horas) {
    this.horas -= horas;
    return new Time(this.horas, this.minutos, this.segundos);
  }

  Time minusMinutes(int minutos) {
    this.minutos -= minutos;
    if (this.minutos < 0) {
      this.minutos = 0;
    } else if (this.minutos < 0 && this.horas > 0) {
      this.minutos += 60;
      this.horas -= 1;
    }
    return new Time(this.horas, this.minutos, this.segundos);
  }

  Time minusSeconds(int segundos) {
    this.segundos -= segundos;
    if (this.segundos < 0) {
      this.segundos = 0;
    } else if (this.segundos < 0 && this.minutos > 0) {
      this.segundos += 60;
      this.minutos -= 1;
    }
    return new Time(this.horas, this.minutos, this.segundos);
  }

  boolean isMidDay() {
    return this.horas == 12 && this.minutos == 0 && this.segundos == 0;
  }

  boolean isMidNight() {
    return this.horas == 0 && this.minutos == 0 && this.segundos == 0;
  }

  public Time shift() {
    int newHoras = this.horas + 12;
    if (newHoras > 23) {
      newHoras -= 24;
    }
    return new Time(newHoras, this.minutos, this.segundos);
  }

  public Time tick() {
    int newSegundos = this.segundos + 1;
    return new Time(this.horas, this.minutos, newSegundos);
  }

  public String toString() {
    String horas = this.horas < 10 ? "0" + this.horas : "" + this.horas;
    String minutos = this.minutos < 10 ? "0" + this.minutos : "" + this.minutos;
    String segundos = this.segundos < 10 ? "0" + this.segundos : "" + this.segundos;
    return horas + ":" + minutos + ":" + segundos;
  }

  public String toLongString() {
    String horas = this.horas == 0 ? "" : this.horas + (this.horas == 1 ? " hora " : " horas ");
    String minutos = this.minutos == 0 ? "" : this.minutos + (this.minutos == 1 ? " minuto " : " minutos ");
    String segundos = this.segundos == 0 ? "" : this.segundos + (this.segundos == 1 ? " segundo" : " segundos");

    // Construct the complete string with all the parts
    String longString = "";
    if (!horas.isEmpty()) {
      longString += horas;
      if (!segundos.isEmpty()) {
        longString += minutos + "e " + segundos;
      } else if (!minutos.isEmpty()) {
        longString += "e " + minutos;
      }
    } else {
      if (!segundos.isEmpty()) {
        longString += minutos + "e " + segundos;
      } else if (!minutos.isEmpty()) {
        longString += minutos;
      }
    }
    return longString.trim();
  }

  public String toShortString() {
    String horas = (this.horas < 10 ? "0" : "") + this.horas + "h";
    String minutos = this.horas == 12 ? "" : (this.minutos < 10 ? "0" : "") + this.minutos + "m";
    String segundos = this.segundos == 0 ? "" : (this.segundos < 10 ? "0" : "") + this.segundos + "s";

    return horas + minutos + segundos;
  }

  public double toDouble() {
    return this.horas + (this.minutos / 60.0) + (this.segundos / 3600.0);
  }

  public int toInt() {
    return this.horas * 3600 + this.minutos * 60 + this.segundos;
  }

  public static Time fromString(String string) {
    String[] time = string.split(":");
    int horas = Integer.parseInt(time[0]);
    int minutos = Integer.parseInt(time[1]);
    int segundos = Integer.parseInt(time[2]);
    return new Time(horas, minutos, segundos);
  }

  public static Time fromDouble(double d) {
    int horas = (int) (d);
    int minutos = (int) ((d * 60) % 60);
    int segundos = (int) ((d * 3600) % 60);
    return new Time(horas, minutos, segundos);
  }

  public static Time fromSeconds(int i) {
    int horas = (int) (i / 3600);
    int minutos = (int) ((i % 3600) / 60);
    int segundos = (int) ((i % 3600) % 60);
    return new Time(horas, minutos, segundos);
  }

  public static Time from(Time trezeHorasQuatroMinutosCinquentaNoveSegundos) {
    int horas = trezeHorasQuatroMinutosCinquentaNoveSegundos.horas;
    int minutos = trezeHorasQuatroMinutosCinquentaNoveSegundos.minutos;
    int segundos = trezeHorasQuatroMinutosCinquentaNoveSegundos.segundos;
    return new Time(horas, minutos, segundos);
  }
}
