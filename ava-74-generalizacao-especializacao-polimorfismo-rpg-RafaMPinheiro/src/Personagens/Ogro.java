package Personagens;

public class Ogro extends Personagem {
    @Override
    public int getForca() {
        return 7;
    }

    @Override
    public int getPontaria() {
        return 2;
    }

    @Override
    public int getMagica() {
        return 1;
    }

    @Override
    public String toString() {
        String toString = "Ogro ";
        if (getEscudo() == null) {
            toString += "sem escudo e ";
        } else {
            toString += "com " + getEscudo().nome + " e ";
        }
        if (getArmaPrincipal() == null) {
            toString += "desarmado";
        } else {
            toString += "armado com " + getArmaPrincipal().nome;
        }
        return toString;
    }
}