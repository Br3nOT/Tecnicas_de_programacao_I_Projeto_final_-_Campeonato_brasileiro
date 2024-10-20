package service;

import model.CardCounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardCounterImpl implements CardCounter {

    @Override
    public Map<String, Integer> totalCards(List<String[]> dados, String cardColor){
        Map<String, Integer> counter = new HashMap<>();
        String player;
            for (int i =1; i<dados.size(); i++) {
            String[] linha = dados.get(i);
            String coluna = linha[3];
            if (coluna.equalsIgnoreCase(cardColor)) {
                player = linha[4];
                if(counter.containsKey(player)) {
                    counter.put(player, counter.get(player) + 1);
                }else{
                    counter.put(player, 1);
                }
            }
        }
            return counter;
    }

}
