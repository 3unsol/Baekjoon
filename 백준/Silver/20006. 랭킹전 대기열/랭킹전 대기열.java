import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int p, m;
    static Player[] players;
    static List<ArrayList<Player>> channel = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        matching();
        check();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        players = new Player[p];

        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            players[i] = new Player(level, nickname);
        }
    }

    static void matching(){

        // 첫번째 플레이어 리스트 넣어주기
        channel.add(new ArrayList<>());
        channel.get(0).add(players[0]);

        // 플레이어마다 확인
        for(int i = 1; i < players.length; i++) {

            // 들어갔는지 확인할 플래그
            boolean isEnter = false;

            // 현재 생성된 방 확인
            for (int j = 0; j < channel.size(); j++) {
                // 현재 방
                ArrayList<Player> nowRoom = channel.get(j);
                // 방장이랑 레벨 +-10 가능?
                if (nowRoom.size() < m && nowRoom.get(0).level <= players[i].level + 10 && nowRoom.get(0).level >= players[i].level - 10) {
                    // 가능하면 그 방에 넣어
                    nowRoom.add(players[i]);
                    isEnter = true;
                    break;
                }
            }

            // 방에 못 들어갔으면 방 생성
            if (!isEnter) {
                channel.add(new ArrayList<>());
                channel.get(channel.size() - 1).add(players[i]);
            }
        }
    }

    static void check(){
        for(int i = 0; i < channel.size(); i++){

            List<Player> nowRoom = channel.get(i);
            Collections.sort(nowRoom, new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.nickname.compareTo(o2.nickname);
                }
            });

            if (nowRoom.size() == m) {
                System.out.println("Started!");
            }
            else {
                System.out.println("Waiting!");
            }
            for(int j = 0; j < nowRoom.size(); j++){
                System.out.println(nowRoom.get(j).level + " " + nowRoom.get(j).nickname);
            }
        }
    }

    static class Player {
        int level;
        String nickname;

        Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }
}