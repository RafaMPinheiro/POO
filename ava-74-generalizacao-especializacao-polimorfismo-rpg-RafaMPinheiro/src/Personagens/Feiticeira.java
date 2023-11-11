package Personagens;

public class Feiticeira extends Personagem {
    @Override
    public int getForca() {
        return 2;
    }

    @Override
    public int getPontaria() {
        return 2;
    }

    @Override
    public int getMagica() {
        return 6;
    }

    @Override
    public String toString() {
        String toString = "Feiticeira ";
        if (getEscudo() == null) {
            toString += "sem escudo e ";
        }
        if (getArmaPrincipal() == null) {
            if (getArmaSecundaria() == null) {
                toString += "desarmada";
            } else {
                toString += "armada com " + getArmaSecundaria().nome;
            }
        } else {
            toString += "armada com " + getArmaPrincipal().nome;
        }
        return toString;
    }
}