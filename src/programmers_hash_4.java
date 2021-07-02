import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class programmers_hash_4 {
    public static void main(String[] args) {
        programmers_hash_4 p = new programmers_hash_4();
        System.out.println(
                Arrays.toString(p.solution(
                        new String[]{"classic", "pop", "classic", "classic", "pop"},
                        new int[]{500, 600, 150, 800, 2500}
                ))
        );
//        4,1,3,0

    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별로 가장많이 재생된 노래
        // 1. 속한 노래가 많이 재생된 장르
        // 2. 장르내에서 가장 많이 재생된 노래
        // 3. 같은 앨범 같은 재생수면 고유번호가 가장 낮은 노래
        List<Integer> answer = new ArrayList<>();

        HashMap<String, HashMap<Integer, Integer>> genresMap = new HashMap<>();
        HashMap<String, Integer> playsMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            final String genre = genres[i];
            HashMap<Integer, Integer> song;

            if (genresMap.containsKey(genre)) {
                song = genresMap.get(genre);
            } else {
                song = new HashMap<>();
            }


            song.put(i, plays[i]);
            genresMap.put(genre, song);

            if (playsMap.containsKey(genre)) {
                playsMap.put(genre, playsMap.get(genre) + plays[i]);
            } else {
                playsMap.put(genre, plays[i]);
            }
        }

        List<Map.Entry<String, Integer>> playsEntries = playsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> playsEntry : playsEntries) {
            int printed = 0;

            List<Map.Entry<Integer, Integer>> genreEntries = genresMap.get(playsEntry.getKey())
                    .entrySet().stream()
                    .sorted((o1, o2) -> {
                        if (o1.getValue() > o2.getValue()){
                            return -1;
                        } else if (o1.getKey() < o2.getKey()){
                            return 1;
                        } else {
                            return 1;
                        }
                    })
                    .collect(Collectors.toList());

            for (Map.Entry<Integer, Integer> genreEntry :
                    genreEntries) {
                printed++;
                answer.add(genreEntry.getKey());

                if (printed == 2){
                    break;
                }
            }
        }


        return answer
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }



}
