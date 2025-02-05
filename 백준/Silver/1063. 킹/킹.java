import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int kingR, kingC;
    static int stoneR, stoneC;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        kingR = king.charAt(1) - '0';
        kingC = king.charAt(0) - 'A' + 1;

        String stone = st.nextToken();
        stoneR = stone.charAt(1) - '0';
        stoneC = stone.charAt(0) - 'A' + 1;

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String order = br.readLine();

            if(order.equals("R")) {
                if(canMove(kingR, kingC + 1)) {
                    if(isStone(kingR, kingC + 1)) {
                        if(canMove(stoneR, stoneC + 1)) {
                            stoneC++;
                        } else {
                            continue;
                        }
                    }
                    kingC++;
                }
            }

            else if(order.equals("L")) {
                if(canMove(kingR, kingC - 1)) {
                    if(isStone(kingR, kingC - 1)) {
                        if(canMove(stoneR, stoneC - 1)) {
                            stoneC--;
                        } else {
                            continue;
                        }
                    }
                    kingC--;
                }
            }

            else if(order.equals("B")) {
                if(canMove(kingR - 1, kingC)) {
                    if(isStone(kingR - 1, kingC)) {
                        if(canMove(stoneR - 1, stoneC)) {
                            stoneR--;
                        } else {
                            continue;
                        }
                    }
                    kingR--;
                }
            }

            else if(order.equals("T")) {
                if(canMove(kingR + 1, kingC)) {
                    if(isStone(kingR + 1, kingC)) {
                        if(canMove(stoneR + 1, stoneC)) {
                            stoneR++;
                        } else {
                            continue;
                        }
                    }
                    kingR++;
                }
            }

            else if(order.equals("RT")) {
                if(canMove(kingR + 1, kingC + 1)) {
                    if(isStone(kingR + 1, kingC + 1)) {
                        if(canMove(stoneR + 1, stoneC + 1)) {
                            stoneR++;
                            stoneC++;
                        } else {
                            continue;
                        }
                    }
                    kingR++;
                    kingC++;
                }
            }

            else if(order.equals("LT")) {
                if(canMove(kingR + 1, kingC - 1)) {
                    if(isStone(kingR + 1, kingC - 1)) {
                        if(canMove(stoneR + 1, stoneC - 1)) {
                            stoneR++;
                            stoneC--;
                        } else {
                            continue;
                        }
                    }
                    kingR++;
                    kingC--;
                }
            }

            else if(order.equals("RB")) {
                if(canMove(kingR - 1, kingC + 1)) {
                    if(isStone(kingR - 1, kingC + 1)) {
                        if(canMove(stoneR - 1, stoneC + 1)) {
                            stoneR--;
                            stoneC++;
                        } else {
                            continue;
                        }
                    }
                    kingR--;
                    kingC++;
                }
            }

            else if(order.equals("LB")) {
                if(canMove(kingR - 1, kingC - 1)) {
                    if(isStone(kingR - 1, kingC - 1)) {
                        if(canMove(stoneR - 1, stoneC - 1)) {
                            stoneR--;
                            stoneC--;
                        } else {
                            continue;
                        }
                    }
                    kingR--;
                    kingC--;
                }
            }
        }

        System.out.print((char)(kingC + 'A' - 1));
        System.out.println(kingR);
        System.out.print((char)(stoneC + 'A' - 1));
        System.out.println(stoneR);
    }

    static boolean canMove(int r, int c) {
        return r >= 1 && c >= 1 && r <= 8 && c <= 8;
    }

    static boolean isStone(int r, int c) {
        return stoneR == r && stoneC == c;
    }
}