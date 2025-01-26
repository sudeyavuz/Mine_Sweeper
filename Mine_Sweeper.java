package JAVA101;
import java.util.Random;
import java.util.Scanner;


public class Mine_Sweeper {
    int col;
    int row;
    int size;
    int mineNum;
    int[][] map;
    int[][] field;
    Random random = new Random();
    Scanner input = new Scanner(System.in);


Mine_Sweeper(int row,int col){
    this.row = row;
    this.col = col;
    this.size = col*row;
    this.field = new int[row][col];
    this.map = new int[row][col];

}
boolean isCheck(){
    return (this.row>2&&this.col>2);
}
boolean isWin(){
    return true;
}


void solvedMap(){
    mineNum = (size/4);
    int placed_mines=0;
    while(placed_mines<mineNum) {
        int randomRow = random.nextInt(row);
        int randomCol = random.nextInt(col);
        if (map[randomRow][randomCol] != 1) {
            map[randomRow][randomCol] = 1;
            placed_mines++;
        }
    }
        System.out.println("Çözülmüş Harita: ");

    for (int[] r : map) {
        for (int c : r) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

}


void printField(){
    System.out.println("tarla: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    System.out.println("================================");
    }


void bombingField() {
    int openedcells=0;
    int nonminecells = row*col-mineNum;
    do {
        System.out.print("Satır girin (0 ile " + (row - 1) + " arasında): ");
        int inputRow = input.nextInt();
        System.out.print("Sütun girin (0 ile " + (col - 1) + " arasında): ");
        int inputCol = input.nextInt();
        if (inputRow < row && inputCol < col) {
            if (field[inputRow][inputCol] != 0) {
                System.out.println("Bu hücre zaten açıldı. Lütfen başka bir hücre seçin.");
                continue;
            }

            field[inputRow][inputCol] = 1;
            openedcells++;
        }
        if (inputRow < row && inputCol < col) {
            field[inputRow][inputCol] = 1;
            if (map[inputRow][inputCol] == 1) {
                System.out.println("Mayına bastınız! Oyun bitti!");
                field[inputRow][inputCol] = 1;
                printField();
                break;
            } else {
                int bombcount = 0;
                if (inputRow > 0 && map[inputRow - 1][inputCol] == 1) {
                    bombcount++;
                }

                if (inputRow < map.length - 1 && map[inputRow + 1][inputCol] == 1) {
                    bombcount++;
                }

                if (inputCol > 0 && map[inputRow][inputCol - 1] == 1) {
                    bombcount++;
                }

                if (inputCol < map[0].length - 1 && map[inputRow][inputCol + 1] == 1) {
                    bombcount++;
                }

                if (inputRow > 0 && inputCol > 0 && map[inputRow - 1][inputCol - 1] == 1) {
                    bombcount++;
                }

                if (inputRow > 0 && inputCol < map[0].length - 1 && map[inputRow - 1][inputCol + 1] == 1) {
                    bombcount++;
                }

                if (inputRow < map.length - 1 && inputCol > 0 && map[inputRow + 1][inputCol - 1] == 1) {
                    bombcount++;
                }

                if (inputRow < map.length - 1 && inputCol < map[0].length - 1 && map[inputRow + 1][inputCol + 1] == 1) {
                    bombcount++;
                }
                field[inputRow][inputCol] = bombcount;
                if (bombcount == 0) {
                    field[inputRow][inputCol] = 1;
                    map[inputRow][inputCol] = 1;
                } else if (bombcount == 1) {
                    field[inputRow][inputCol] = -1;
                    map[inputRow][inputCol] = -1;
                } else if (bombcount == 2) {
                    field[inputRow][inputCol] = -2;
                    map[inputRow][inputCol] = -2;
                } else if (bombcount == 3) {
                    field[inputRow][inputCol] = -3;
                    map[inputRow][inputCol] = -3;
                } else if (bombcount == 4) {
                    field[inputRow][inputCol] = -4;
                    map[inputRow][inputCol] = -4;
                } else if (bombcount == 5) {
                    field[inputRow][inputCol] = -5;
                    map[inputRow][inputCol] = -5;
                } else {
                    map[inputRow][inputCol] = -bombcount;
                }
                if (openedcells == nonminecells) {
                    System.out.println("Tebrikler! Tüm mayın olmayan alanları açtınız ve kazandınız!");
                    printField();
                    break;
                }


                printField();
            }

        }else {
            System.out.println("girilen koordinatlarla tarlanın büyüklüğü uyuşmamakta,lütfen yeni değer giriniz.");

        }
    }while (true);

}


void run() {
    solvedMap();
    System.out.println("Mayın Tarlasına Hoş Geldiniz !  ");
    printField();
    bombingField();
}
}

