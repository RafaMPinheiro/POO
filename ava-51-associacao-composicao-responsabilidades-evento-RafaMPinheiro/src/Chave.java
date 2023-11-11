import java.security.SecureRandom;

class Chave {
  String chave;

  Chave() {
    this.chave = gerarChave();
  }

  public String getChave() {
		return this.chave;
	}

  private String gerarChave() {
    int length = 16; // comprimento da chave
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // caracteres permitidos na chave
    SecureRandom random = new SecureRandom();
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomIndex = random.nextInt(caracteres.length());
      sb.append(caracteres.charAt(randomIndex));
    }
    return sb.toString();
  }
}
