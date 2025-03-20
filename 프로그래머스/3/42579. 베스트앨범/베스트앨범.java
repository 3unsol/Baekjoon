import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // map에 장르, 총 재생횟수 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // map의 key를 list로 만듦
        List<String> genreList = new ArrayList<>();
        for(String genre : map.keySet()) {
            genreList.add(genre);
        }
        // 재생횟수 많은 순서로 정렬
        genreList.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        // 일단 리스트에 먼저 넣고 나중에 배열로 변환
        List<Integer> list = new ArrayList<>();
        
        // 장르별로 재생횟수 많은 곡 찾기
        for(String genre : genreList) {
            // 장르별로 곡 리스트 만들기
            List<Music> musics = new ArrayList<>();
            // 같은 장르면 리스트에 넣기
            for(int i = 0; i < genres.length; i++) {
                if(genre.equals(genres[i])) {
                    musics.add(new Music(i, plays[i]));
                }
            }
            // 재생횟수 많은 순으로 정렬
            Collections.sort(musics);
            // 제일 많이 재생된 곡 리스트에 넣기
            list.add(musics.get(0).index);
            // 2곡 이상이면 하나 더 넣기
            if(musics.size() > 1) {
                list.add(musics.get(1).index);
            }
            
        }
        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int index : list) {
            answer[idx++] = index;
        }
        return answer;
    }
    // 인덱스, 재생 횟수
    static class Music implements Comparable<Music> {
        int index, cnt;
        Music(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Music o) {
            if(this.cnt == o.cnt) {
                return this.index - o.index;
            }
            return o.cnt - this.cnt;
        }
    }
}
