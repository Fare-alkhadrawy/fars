package practicum6;

import java.time.LocalDate;

public class Game {
    String naam;
    int releaseJaar;
    double nieuwprijs;

    public Game (String nm, int rj, double nwpr) {
        naam = nm;
        releaseJaar = rj;
        nieuwprijs = nwpr;
    }

    public double huidigeWaarde ( ) {
        int leeftijd = LocalDate.now().getYear() - releaseJaar;
        double prijs = nieuwprijs;
        for (int i = 0; i < leeftijd; i++) {
            prijs = prijs * 0.70;
        }
        return prijs;
    }

    public boolean equals (Object andereObject) {
        boolean flag = false;
        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (naam.equals(andereGame.naam) && releaseJaar == andereGame.releaseJaar) {

                flag = true;
            }
        }
        return flag;
    }

    public String getNaam ( ) {
        return naam;
    }

    public String toString ( ) {
        double prijs = huidigeWaarde();
        String nieuw = String.format("%.2f", nieuwprijs);
        String result = String.format("%.2f", prijs);
        return this.naam + ", uitgegeven in " + this.releaseJaar + "; nieuwprijs: €" + nieuw + " nu voor: €" + result;
    }
}