package practicum6;

import java.util.ArrayList;

public class Person {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Person (String nm, double bdg){
        naam = nm;
        budget = bdg;
        mijnGames = new ArrayList<Game>();
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {
//        for (Game game : mijnGames) {
//            if (g.equals(game)) {
//
//                return false;
//            }
//        }
        if (mijnGames.contains(g))
            return false;
        if (budget > g.huidigeWaarde()) {
            budget = budget - g.huidigeWaarde();
            mijnGames.add(g);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verkoop(Game g, Person koper) {
        if (mijnGames.contains(g)) {
            if (koper.koop(g)) {
                mijnGames.remove(g);
                budget = budget + g.huidigeWaarde();
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public Game zoekGameOpNaam(String name) {
        for(Game a : mijnGames) {
            if (a.getNaam().equals(name))
                return a;


        }
        return null;
    }
    public ArrayList<Game> bepaalGamesNietInBezit (ArrayList<Game> games){
        ArrayList<Game> GamesNietInBezit = new ArrayList<>();
        for(Game nGame : games){
            if (!mijnGames.contains(nGame)){
                GamesNietInBezit.add(nGame);
            }
        }
        return GamesNietInBezit;
    }

    public String toString(){
        String Bbudget = String.format("%.2f", budget);
        String s =  naam + " heeft een budget van €" +Bbudget + " en bezit de volgende games:";
        for (Game game : mijnGames){
            s = s + "\n" + (game);
        }
        return s;
    }
}