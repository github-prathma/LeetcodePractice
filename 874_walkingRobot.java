import java.util.*;
import java.io.*;

class WalkingRobot {
    enum Direction {
        TOP, LEFT, BOTTOM, RIGHT;
    }

    public static Direction changeDir(Direction dir, int c) {
        if (dir == Direction.TOP) {
            return c == -1 ? Direction.RIGHT : Direction.LEFT;
        } else if (dir == Direction.LEFT) {
            return c == -1 ? Direction.TOP : Direction.BOTTOM; 
        } else if (dir == Direction.RIGHT) {
            return c == -1 ? Direction.BOTTOM : Direction.TOP;
        } else {
            return c == -1 ? Direction.LEFT : Direction.RIGHT;
        }
    }

    public static boolean isObstacle(HashMap<Integer, HashSet<Integer> > mp, int[] pos) {
        if (mp.containsKey(pos[0])) {
            if (mp.get(pos[0]).contains(pos[1])) {
                return true;
            }
        }
        return false;
    }

    public static int maxDistance(int[] pos) {
        return (pos[0]*pos[0] + pos[1]*pos[1]);
    }

    public static void move(Direction dir, int command, HashMap<Integer, HashSet<Integer> > obs, int[] pos) {

        for (int i=0; i<command; ++i) {
            int[] newPos = new int[2];

            if (dir == Direction.TOP) {
                newPos[0] = pos[0];
                newPos[1] = pos[1] + 1;
            } else if (dir == Direction.LEFT) {
                newPos[0] = pos[0] - 1;
                newPos[1] = pos[1];

            } else if (dir == Direction.BOTTOM) {
                newPos[0] = pos[0];
                newPos[1] = pos[1] - 1;

            } else {
                newPos[0] = pos[0] + 1;
                newPos[1] = pos[1];
            }
            if (!isObstacle(obs, newPos)) {
                pos[0] = newPos[0];
                pos[1] = newPos[1];
            } else {
                break;
            }
        }
    }

    public static int robotSimulation(int[] commands, int[][] obstacles) {
        HashMap<Integer, HashSet<Integer> > mp = new HashMap<>();
        for (int i=0; i<obstacles.length; ++i) {
            if (mp.containsKey(obstacles[i][0])) {
                mp.get(obstacles[i][0]).add(obstacles[i][1]);
            } else {
                HashSet<Integer> ycoor = new HashSet<>();
                ycoor.add(obstacles[i][1]);
                mp.put(obstacles[i][0], ycoor);
            }
        }

        int[] pos = {0,0};
        Direction dir = Direction.TOP;

        int max = 0;

        for (int c : commands) {
            if (c == -1 || c == -2) { 
                dir = changeDir(dir, c);
            } else {
                move(dir, c, mp, pos);
                // System.out.println(pos[0] + ", " + pos[1]);
                max = Math.max(max, maxDistance(pos));
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        String[] cStr = l1.split(" ");
        int[] commands = new int[cStr.length];

        for (int i=0; i<commands.length; ++i) {
            commands[i] = Integer.parseInt(cStr[i]);
        }

        System.out.println("Enter no. of obstacles:");
        int n = Integer.parseInt(br.readLine());
        
        int[][] obs = new int[n][2];

        for (int i=0; i<n; i++) {
            String l = br.readLine();
            String[] oStr = l.split(" ");
            obs[i][0] = Integer.parseInt(oStr[0]);
            obs[i][1] = Integer.parseInt(oStr[1]);
        }

        int ans = robotSimulation(commands, obs);
        System.out.println(ans);
    }
}