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
}
