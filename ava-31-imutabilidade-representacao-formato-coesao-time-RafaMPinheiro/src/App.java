class App {
  public static void main(String[] args) {

    System.out.println("Parte 1");

    Time zero = new Time();
    // representação string, padrão 00:00:00
    System.out.println(zero.toString().equals("00:00:00"));

    Time umaHoraQuarentaMinCincoSeg = new Time(1, 40, 5);
    System.out.println(umaHoraQuarentaMinCincoSeg.toString().equals("01:40:05"));

    Time umaHoraQuarentaMinutosCincoSegundos = zero.plus(umaHoraQuarentaMinCincoSeg);
    System.out.println(umaHoraQuarentaMinutosCincoSegundos.toString().equals("01:40:05"));
    System.out.println(umaHoraQuarentaMinutosCincoSegundos.getHoras() == 1);
    System.out.println(umaHoraQuarentaMinutosCincoSegundos.getMinutos() == 40);
    System.out.println(umaHoraQuarentaMinutosCincoSegundos.getSegundos() == 5);
    // deve ser imutável
    System.out.println(zero.getHoras() == 0);
    System.out.println(zero.getMinutos() == 0);
    System.out.println(zero.getSegundos() == 0);

    // plus
    Time tresHorasVinteMinDezSeg = umaHoraQuarentaMinutosCincoSegundos.plus(umaHoraQuarentaMinCincoSeg);
    System.out.println(tresHorasVinteMinDezSeg.toString().equals("03:20:10"));

    Time duasHorasQuarentaMinCincoSeg = umaHoraQuarentaMinCincoSeg.plusHours(1);
    System.out.println(duasHorasQuarentaMinCincoSeg.toString().equals("02:40:05"));

    Time duasHorasVinteMinDezSeg = tresHorasVinteMinDezSeg.plusHours(23);
    System.out.println(duasHorasVinteMinDezSeg.toString().equals("02:20:10"));

    Time duasHorasTrintaMinDezSeg = duasHorasVinteMinDezSeg.plusMinutes(10);
    System.out.println(duasHorasTrintaMinDezSeg.toString().equals("02:30:10"));

    Time duasHorasTrintaUmMinTrintaSeg = duasHorasTrintaMinDezSeg.plusSeconds(80);
    System.out.println(duasHorasTrintaUmMinTrintaSeg.toString().equals("02:31:30"));

    Time dezenoveHorasVinteTresMinDezoitoSeg = new Time().plusHours(19).plusMinutes(23).plusSeconds(18);
    System.out.println(dezenoveHorasVinteTresMinDezoitoSeg.toString().equals("19:23:18"));

    Time dezoitoHorasVinteDoisMinDezesseteSeg = dezenoveHorasVinteTresMinDezoitoSeg.plusHours(-1).plusMinutes(-1)
        .plusSeconds(-1);
    System.out.println(dezoitoHorasVinteDoisMinDezesseteSeg.toString().equals("18:22:17"));

    Time dezesseisHorasVinteMinQuinzeSeg = dezoitoHorasVinteDoisMinDezesseteSeg.minusHours(2).minusMinutes(2)
        .minusSeconds(2);
    System.out.println(dezesseisHorasVinteMinQuinzeSeg.toString().equals("16:20:15"));

    Time vinteUmaHorasVinteMinQuinzeSeg = dezesseisHorasVinteMinQuinzeSeg.minusHours(-5);
    System.out.println(vinteUmaHorasVinteMinQuinzeSeg.toString().equals("21:20:15"));

    Time dezenoveHoras = dezesseisHorasVinteMinQuinzeSeg.minus(vinteUmaHorasVinteMinQuinzeSeg);
    System.out.println(dezenoveHoras.toString().equals("00:00:00"));
    System.out.println(dezenoveHoras.isMidDay() == false);

    Time meiaNoite = dezenoveHoras.minus(dezenoveHoras);
    System.out.println(meiaNoite.toString().equals("00:00:00"));
    System.out.println(meiaNoite.isMidDay() == false);
    System.out.println(meiaNoite.isMidNight() == true);
    System.out.println(meiaNoite.plusHours(12).isMidDay() == true);
    System.out.println(meiaNoite.toString().equals(zero.toString()));

    Time tresHorasQuarentaMin = new Time(3, 40);
    System.out.println(tresHorasQuarentaMin.toString().equals("03:40:00"));

    Time quinzeHorasQuarentaMin = tresHorasQuarentaMin.shift();
    System.out.println(quinzeHorasQuarentaMin.toString().equals("15:40:00"));

    Time tresHorasQuarentaMinutos = quinzeHorasQuarentaMin.shift();
    System.out.println(tresHorasQuarentaMinutos.toString().equals("03:40:00"));

    Time tresHorasQuarentaMinutosUmSegundo = tresHorasQuarentaMinutos.tick();
    System.out.println(tresHorasQuarentaMinutosUmSegundo.toString().equals("03:40:01"));

    Time tresHorasQuarentaMinutosQuatroSegundos = tresHorasQuarentaMinutosUmSegundo.tick().tick().tick();
    System.out.println(tresHorasQuarentaMinutosQuatroSegundos.toString().equals("03:40:04"));

    Time quantoEuValho = tresHorasQuarentaMinutosQuatroSegundos.plusHours(50).plusMinutes(50).minusSeconds(50).tick()
        .shift();
    System.out.println(quantoEuValho.toString().equals("18:30:01"));

    System.out.println("Parte 2");

    Time noveQuarentaQuinze = new Time(9, 40, 15);
    System.out.println(noveQuarentaQuinze.toString().equals("09:40:15"));
    System.out.println(noveQuarentaQuinze.toLongString().equals("9 horas 40 minutos e 15 segundos"));

    // fromString, formato 00:00:00
    Time umaHoraTrintaSeisMinutos = Time.fromString("01:36:00");
    System.out.println(umaHoraTrintaSeisMinutos.toLongString().equals("1 hora e 36 minutos"));

    // fromDouble
    Time tresPontoOitocentosVinteQuatroHoras = Time.fromDouble(3.824);
    System.out.println(tresPontoOitocentosVinteQuatroHoras.toLongString().equals("3 horas 49 minutos e 26 segundos"));
    System.out.println(Time.fromDouble(17.1447).toLongString().equals("17 horas 8 minutos e 40 segundos"));

    // fromSeconds
    Time setentaSeisMilSeiscentosTrintaDoisSegundos = Time.fromSeconds(76632);
    System.out
        .println(setentaSeisMilSeiscentosTrintaDoisSegundos.toLongString().equals("21 horas 17 minutos e 12 segundos"));
    System.out.println(Time.fromSeconds(68400).toLongString().equals("19 horas"));

    // toDouble
    Time dezesseisHorasQuarentaCincoMinOnzeSeg = Time.fromString("16:45:11");
    System.out.println(dezesseisHorasQuarentaCincoMinOnzeSeg.toDouble() == 16.753055555555555); // faça o ajuste para o
                                                                                                // valor
    // correto retornado
    System.out.println(Time.fromString("13:04:59").toDouble() == 13.083055555555555); // faça o ajuste para o valor
                                                                                      // correto

    // retornado
    double trezePontoUnsQuebradosHoras = Time.fromString("13:04:59").toDouble();
    Time trezeHorasQuatroMinutosCinquentaNoveSegundos = Time.fromDouble(trezePontoUnsQuebradosHoras);
    System.out.println(
        trezeHorasQuatroMinutosCinquentaNoveSegundos.toLongString().equals("13 horas 4 minutos e 59 segundos"));

    // fromTime
    Time trezeHorasQuatroMinutosCinquentaNoveSegundosCopia =
    Time.from(trezeHorasQuatroMinutosCinquentaNoveSegundos);
    // toShortString
    System.out.println(trezeHorasQuatroMinutosCinquentaNoveSegundosCopia.toShortString().equals("13h04m59s"));
    System.out.println(Time.fromString("15:03:00").toShortString().equals("15h03m"));
    System.out.println(Time.fromString("15:00:01").toShortString().equals("15h00m01s"));

    // constantes de classe (atributos estáticos)
    Time meioDia = Time.MIDDAY;
    System.out.println(meioDia.toShortString().equals("12h"));
    System.out.println(Time.MIDDAY.toInt() == 43200); // segundos
    System.out.println(Time.MIDDAY.toDouble() == 12.0); // horas

    Time midnight = Time.MIDNIGHT;
    System.out.println(midnight.toShortString().equals("00h00m"));
    System.out.println(Time.MIDNIGHT.toInt() == 0);
    System.out.println(Time.MIDNIGHT.toDouble() == 0.0);
  }
}
