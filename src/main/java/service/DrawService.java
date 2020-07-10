package service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrawService {

    public String[] getSortedFields(String message) {
        List<String> fields = Arrays.asList(messageWithoutPrefix(message)
                .split(" "));

        Collections.shuffle(fields);

        String team1 = getTeam1(fields);
        String team2 = getTeam2(fields);

        int orderCriteria = (int) Math.round(Math.random());
        if (orderCriteria == 0)
            return new String[] {team1, team2};
        else
            return new String[] {team2, team1};
    }

    private String getTeam2(List<String> fields) {
        List<String> team2 = fields.stream().skip(fields.size() / 2).collect(Collectors.toList());
        StringBuilder teamBuilder = new StringBuilder();

        team2.forEach(field -> teamBuilder.append(field).append("\n"));

        return teamBuilder.toString();
    }

    private String getTeam1(List<String> fields) {
        List<String> team1 = fields.stream().limit(fields.size() / 2).collect(Collectors.toList());
        StringBuilder teamBuilder = new StringBuilder();

        team1.forEach(field -> teamBuilder.append(field).append("\n"));

        return teamBuilder.toString();
    }

    private String messageWithoutPrefix(String message) {
        return message.replaceAll("(?i)!sorteio ", "")
                .replaceAll("(?i)!draw ", "");
    }
}
