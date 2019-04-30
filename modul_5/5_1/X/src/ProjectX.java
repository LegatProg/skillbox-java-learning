/*  1234567
* 1 x     x
* 2  x   x
* 3   x x
* 4    x
* 5   x x
* 6  x   x
* 7 x     x
* */

public class ProjectX {
    public static void main(String[] args) {

        char[][] arrayX = new char[7][7];

        for (int y = 0; y < arrayX.length; y++) {
            for (int x = 0; x < arrayX[y].length; x++) {
                if (x == y){
                    arrayX[y][x] = 'X';
                } else if (x == arrayX.length - y - 1) {
                    arrayX[y][x] = 'X';
                } else {
                    arrayX[y][x] = ' ';
                }
                System.out.print(arrayX[y][x]);
            }
            System.out.println();
        }
    }
}
