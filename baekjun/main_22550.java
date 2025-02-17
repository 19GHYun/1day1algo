import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 마스 개수
        int[] p = new int[N + 1]; // 1-based index
        for (int i = 1; i <= N; i++) {
            p[i] = sc.nextInt();
        }

        int[] memo = new int[N + 1]; 
        Arrays.fill(memo, -2); // -2: 미처리, -1: 무효한 위치, 다른 값: 최종 위치

        // 1. 마스 효과 적용 (사이클 감지 & 최종 위치 저장)
        for (int i = 1; i <= N; i++) {
            if (memo[i] == -2) {
                List<Integer> path = new ArrayList<>();
                Set<Integer> visited = new HashSet<>();
                int current = i;
                int result = -2;

                while (true) {
                    if (visited.contains(current)) {
                        // 사이클 발생 -> 경로 중복 확인 후 모두 -1 처리
                        int idx = path.indexOf(current);
                        for (int j = idx; j < path.size(); j++) {
                            memo[path.get(j)] = -1;
                        }
                        for (int j = 0; j < idx; j++) {
                            memo[path.get(j)] = -1;
                        }
                        result = -1;
                        break;
                    }
                    if (memo[current] != -2) {
                        result = memo[current];
                        break;
                    }
                    
                    visited.add(current);
                    path.add(current);

                    if (current >= N) {
                        result = N;
                        break;
                    }

                    int pi = p[current];
                    if (pi == 0) {
                        result = current;
                        break;
                    }

                    int nextCurrent = current + pi;
                    if (nextCurrent >= N) {
                        result = N;
                        break;
                    }

                    current = nextCurrent;
                }

                // 결과를 반영
                if (result != -2) {
                    for (int node : path) {
                        memo[node] = result;
                    }
                }
            }
        }

        // 2. BFS를 활용하여 최단 거리 계산
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int j = 1; j <= 6; j++) {
                int newPos = current + j;

                if (newPos >= N) {
                    System.out.println(distance[current] + 1);
                    return;
                }

                if (newPos < 1) continue;

                int finalPos = memo[newPos];
                if (finalPos == -1) continue; // 무효한 경로
                if (finalPos >= N) {
                    System.out.println(distance[current] + 1);
                    return;
                }

                if (distance[finalPos] == -1) {
                    distance[finalPos] = distance[current] + 1;
                    queue.add(finalPos);
                }
            }
        }

        // 문제에서 항상 도착 가능하다고 했으므로 -1이 출력되는 경우는 없음
        System.out.println(-1);
    }
}
