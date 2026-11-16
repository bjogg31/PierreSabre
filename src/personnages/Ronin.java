package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int quantiteArgent) {
		super(nom, boissonFavorite, quantiteArgent);
	}

	public void donner(Commercant beneficiare) {
		int don = (10 * getQuantiteArgent()) / 100;
		parler(beneficiare.getNom() + " prend ces " + don + " sous.");
		perdreArgent(don);
		beneficiare.recevoir(don);
		honneur++;
	}

	public void provoquer(Yakuza adversaire) {
		int force = honneur * 2;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakusa!");
			honneur++;
			int argent = adversaire.perdre();
			gagnerArgent(argent);
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			honneur--;
			int argent = getQuantiteArgent();
			perdreArgent(argent);
			adversaire.gagner(argent);
		}
	}
}
