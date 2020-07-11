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

        int fieldsHalfSize = fields.size() / 2;

        List<String> team1List = fields.stream().limit(fieldsHalfSize).collect(Collectors.toList());
        List<String> team2List = fields.stream().skip(fieldsHalfSize).collect(Collectors.toList());

        String team1 = getTeam(team1List);
        String team2 = getTeam(team2List);

        int orderCriteria = (int) Math.round(Math.random());
        if (orderCriteria == 0)
            return new String[] {team1, team2};
        else
            return new String[] {team2, team1};
    }

    private String getTeam(List<String> fields) {
        StringBuilder teamBuilder = new StringBuilder();

        fields.forEach(field -> teamBuilder.append(field).append("\n"));

        return teamBuilder.toString();
    }

    private String messageWithoutPrefix(String message) {
        return message.replaceAll("(?i)!sorteio ", "")
                .replaceAll("(?i)!draw ", "");
    }
}
