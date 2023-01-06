import java.util.Arrays;
import java.util.Random;

public class Map {
    private int x = 0;
    private int y = 0;

    Random random = new Random();

    int[][] map = {

            {
                    2, 2, 2, 2, 2, 2, 2, 2, 2, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 2, 2, 2, 2, 2, 2, 2, 2, 2
            }
    };


    public void showMap() {
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    public void spawnPlayer() {
        x = getRandomNumberUsingNextInt(1, 8);
        y = getRandomNumberUsingNextInt(1, 8);
        map[y][x] = 1;
        showMap();
    }

    public void move(Options options) throws WrongDirectionException {
        switch (options) {
            case TOP -> {
                if (map[y - 1][x] == 0) {
                    map[y - 1][x] = 1;
                    map[y][x] = 2;
                    y--;
                } else {
                    throw new WrongDirectionException();
                }
            }
            case BOTTOM -> {
                if (map[y + 1][x] == 0) {
                    map[y + 1][x] = 1;
                    map[y][x] = 2;
                    y++;
                }else {
                    throw new WrongDirectionException();
                }
            }
            case LEFT -> {
                if (map[y][x - 1] == 0) {
                    map[y][x - 1] = 1;
                    map[y][x] = 2;
                    x--;
                }else {
                    throw new WrongDirectionException();
                }
            }
            case RIGHT -> {
                if (map[y][x + 1] == 0) {
                    map[y][x + 1] = 1;
                    map[y][x] = 2;
                    x++;
                }else {
                    throw new WrongDirectionException();
                }
            }
            default -> {
                throw new WrongDirectionException();
            }
        }
    }


    public int getRandomNumberUsingNextInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }
};