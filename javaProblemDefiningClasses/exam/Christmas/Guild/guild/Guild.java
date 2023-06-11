package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
      //  return roster.removeIf(p -> p.getName().equals(name)); -> премахва само първия намерен

        /*
        int index = -1;
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)){
                index = i;
            }
        }
        if (index != -1){
            roster.remove(index); //премахва обекта, който стои на този индекс
            return true;
        }
        return false;
         */
        Player pl = roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (pl != null){
            roster.remove(pl);
            return true;
        }
        return false;
    }

    //promotePlayer(String name) - не връща нищо
    public void promotePlayer(String name) {
        /*
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
                break;
            }
        }
         */
        Player pl = roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (pl != null){
            pl.setRank("Member");
        }
    }

    //demotePlayer(String name) -> не връща нищо
    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
                break;
            }
        }
        // roster.stream()
        //          .filter(player -> player.getName().equals(name) && !player.getRank().equals("Trial"))
        //          .findFirst()
        //          .ifPresent(player -> player.setRank("Trial"));
    }

//  kickPlayersByClass(String clazz) - връща Player масив

    public Player[] kickPlayersByClass(String clazz) {
       List<Player> removedPl = roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
               .collect(Collectors.toList());

       roster.removeAll(removedPl);

       return removedPl.toArray(Player[]::new);

        /*
        List<Player> removed = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                removed.add(player);
            }
        }
        roster.removeAll(removed);
        return removed.toArray(new Player[0]);
         */

        /*
        int count = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)){
                count++;
            }
        }
        Player[]arr = new Player[count];
        int index = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)){
                arr[index++] = player;
            }
        }
        for (Player player : arr) {
            roster.remove(player);
        }
        return arr;

         */
    }

    //count()

    public int count(){
        return roster.size();
    }

    public String report(){
        return String.format("Players in the guild: %s:%n%s", name,
                roster.stream().map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                ).trim();
        /*
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Players in the guild: %s:", this.name))
                .append(System.lineSeparator());
        for (Player player : roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString().trim();
         */
    }
}
