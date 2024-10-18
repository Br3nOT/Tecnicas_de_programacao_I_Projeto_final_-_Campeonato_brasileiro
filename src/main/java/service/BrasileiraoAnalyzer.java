package service;

import model.CardCounterImpl;
import reader.ReaderImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrasileiraoAnalyzer {
    public void analyze() {
        ReaderImpl reader = new ReaderImpl();
        CardCounterImpl cardCounter = new CardCounterImpl();

        String cartoes = "campeonato-brasileiro-cartoes.csv";
        String goals = "campeonato-brasileiro-gols.csv";
        String estatisticasFull = "campeonato-brasileiro-estatisticas-full.csv";
        String full = "campeonato-brasileiro-full.csv";
        List<String[]> dataCards = reader.readCsvFile(cartoes);
        List<String[]> dataGoals = reader.readCsvFile(goals);

        String cardColor1 = "Amarelo";
        String cardColor2 = "Vermelho";

        Map<String, Integer> contadorYellow = cardCounter.totalCards(dataCards, cardColor1);
        Map<String, Integer> contadorRed = cardCounter.totalCards(dataCards, cardColor2);

        String playerWithTheMostYellowCards = " ";
        Integer greaterCountYellow = 0;
        for (Map.Entry<String, Integer> entry : contadorYellow.entrySet()) {
            if (entry.getValue() > greaterCountYellow) {
                greaterCountYellow = entry.getValue();
                playerWithTheMostYellowCards = entry.getKey();
            }
        }

        System.out.println("JOGADOR: " + playerWithTheMostYellowCards + " teve " + greaterCountYellow + ", cartões amarelos.");

        String playerWithTheMostRedCards = " ";
        Integer greaterCountRed = 0;
        for (Map.Entry<String, Integer> entry : contadorRed.entrySet()) {
            if (entry.getValue() > greaterCountRed) {
                greaterCountRed = entry.getValue();
                playerWithTheMostRedCards = entry.getKey();
            }
        }

        System.out.println("JOGADOR: " + playerWithTheMostRedCards + " teve " + greaterCountRed + ", cartões Vermelhos.");

        Map <String, Integer> contadorGols = totalGoals(dataGoals, goals);

        String topScorer = " ";
        Integer greaterCountScore = 0;
        for (Map.Entry<String, Integer> entry : contadorGols.entrySet()) {
            if (entry.getValue() > greaterCountScore) {
                greaterCountScore = entry.getValue();
                topScorer = entry.getKey();
            }
        }
        //System.out.println("TOP PLAYER GOAL SCORER: " + topScorer + " teve " + greaterCountScore + " de gols");


        printTopScorer(contadorGols);


        String goalType = "Penalty";
        Map<String, Integer> penaltyCounter = totalGoalsByType(dataGoals, goalType);

        String totalPenaltyScorer = " ";
        Integer greaterPenaltyCounter = 0;
        for (Map.Entry<String, Integer> entry : penaltyCounter.entrySet()) {
            if(entry.getValue() > greaterPenaltyCounter){
                greaterPenaltyCounter = entry.getValue();
                totalPenaltyScorer = entry.getKey();
            }
        }


        System.out.println();


        System.out.println("TOP PLAYER PENALTY SCORER: " + totalPenaltyScorer + " teve " + greaterPenaltyCounter + " gols");

        goalType = "Gol Contra";
        Map<String, Integer> OwnGoalCounter = totalGoalsByType(dataGoals, goalType);

        String OwnGoalScorer = " ";
        Integer greaterOwnGoalCounter = 0;
        for (Map.Entry<String, Integer> entry : OwnGoalCounter.entrySet()) {
            if(entry.getValue() > greaterOwnGoalCounter){
                greaterOwnGoalCounter = entry.getValue();
                OwnGoalScorer = entry.getKey();
            }
        }

//        List<Map.Entry<String, Integer>> entradaOrdenada = new ArrayList<>(OwnGoalCounter.entrySet());
//        entradaOrdenada.sort(Map.Entry.comparingByValue());

        //entradaOrdenada.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

//        for (Map.Entry<String, Integer> entry : entradaOrdenada) {
//            System.out.println("ENTRADA: " + entry.getKey() + " - " + entry.getValue());
//        }

        System.out.println("JOGADOR: " + OwnGoalScorer + " teve " + greaterOwnGoalCounter + " gols contra");


    }

    private Map<String, Integer> totalGoals(List<String[]> dados, String filename) {
        Map<String, Integer> goalCounter = new HashMap<>();
        String player;

        for (int i = 1; i < dados.size(); i++) {
            String[] linha = dados.get(i);
            player = linha[3];
            if(goalCounter.containsKey(player)) {
                goalCounter.put(player, goalCounter.get(player) + 1);
            } else {
                goalCounter.put(player, 1);
            }

        }
        return goalCounter;
    }

    private Map<String, Integer> totalGoalsByType(List<String[]> dados, String goalType) {
        Map<String, Integer> typeCounter  = new HashMap<>();
        String player;
        for (int i = 1; i < dados.size(); i++) {
            String[] linha = dados.get(i);
            player = linha[3];
            if (linha[5] != null && !linha[5].isBlank() && linha[5].equalsIgnoreCase(goalType)) {
                typeCounter.put(player, typeCounter.getOrDefault(player, 0) + 1);
            }

        }
        return typeCounter;
    }
    private void printTopScorer (Map<String, Integer> GoalsCount){

        String Scorer = " ";
        Integer greaterCountScore = 0;
        for (Map.Entry<String, Integer> entry : GoalsCount.entrySet()) {
            if (entry.getValue() > greaterCountScore) {
                greaterCountScore = entry.getValue();
                Scorer = entry.getKey();
            }
        }
        System.out.println("TOP PLAYER GOAL SCORER: " + Scorer + " teve " + greaterCountScore + " de gols");
    }



}