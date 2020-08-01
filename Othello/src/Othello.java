/*
主题：黑白棋
姓名：雷浩波
学号：2019210649
班级：2019211121
 */

import java.io.IOException;
import java.util.Scanner;

public class Othello {

    //生成初步棋盘，仅检查了是否为空可落子
    public static void Preliminary_receiving(int chessboard[][],int chessboard1[][],int player,int x,int y) throws IOException {
//        //检查棋盘初始化情况
//        System.out.print("\n");
//        for(int i = 0; i < 8; i++)
//        {
//            for(int j=0;j<8;j++)
//            {
//                System.out.print(chessboard1[i][j]);
//            }
//            System.out.print('\n');
//        }



        //判断位置是否为空，为空则生成初步落子盘
        if(chessboard[x-1][y-1]==0)
        {
            if(player==1)
                chessboard1[x-1][y-1]=1;
            if(player==2)
                chessboard1[x-1][y-1]=2;
        }

//        //检查初步棋盘是否生成成功
//        for(int i = 0; i < 8; i++)
//        {
//            for(int j=0;j<8;j++)
//            {
//                System.out.print(chessboard1[i][j]);
//            }
//            System.out.print('\n');
//        }
    }

    //探测翻子方法
    static void change(int chessboard[][], int chessboard1[][], int player, int x, int y) throws IOException {


        //向上探测
        int mark1 = 0;//标志位，有一个方向翻子成功则置1；
        int work1 = 0;//判断是否遇到了对方的子，遇到了变为1
        int work2 = 0;//判断是否遇到自己的子，遇到了变为1
        int count1 = 0;//计数有多少对方的子夹在中间
        int i1 = 1;
        //System.out.println("x=" + x + "  " + "y=" + y);
        for (; i1 < x; i1++) {
           // System.out.println(x - 1 - i1);
            //System.out.println(y - 1);
            //System.out.println("player is" + player);
            if (chessboard1[x - 1 - i1][y - 1] == 0 && i1 == 1) {
                break;
            }
            if (chessboard1[x - 1 - i1][y - 1] == player && i1 == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1 - i1][y - 1] == 2) {
                    //System.out.println("进了1");
                    work1 = 1;
                    count1++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 - i1][y - 1] == 1) {
                    //System.out.println("进了2");
                    work1 = 1;
                    count1++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1 - i1][y - 1] == 1) {
                    work2 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 - i1][y - 1] == 2) {
                    work2 = 1;
                    break;
                }
            }
        }
        //System.out.println("work1=" + work1 + "  " + "work2=" + work2 + "  i=" + i1 + "count=" + count1);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work1 == 1 && work2 == 1) {
            mark1 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count1; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x - i1 + q - 1][y - 1] = 1;
                }
                if (player == 2) {
                    chessboard1[x - i1 + q - 1][y - 1] = 2;
                }
            }

//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }

        }


        //向下探测
        int mark2 = 0;
        int work3 = 0;//判断是否遇到了对方的子，遇到了变为1
        int work4 = 0;//判断是否遇到自己的子，遇到了变为1
        int count2 = 0;//计数有多少对方的子夹在中间
        int i2 = 1;
        //System.out.println("x=" + x + "  " + "y=" + y);
        for (; i2 < 8 - x; i2++) {
//            System.out.println(x - 1 + i2);
//            System.out.println(y - 1);
//            System.out.println("player is" + player);
            if (chessboard1[x - 1 + i2][y - 1] == 0 && i2 == 1) {
                break;
            }
            if (chessboard1[x - 1 + i2][y - 1] == player && i2 == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1 + i2][y - 1] == 2) {
                    //System.out.println("进了1");
                    work3 = 1;
                    count2++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 + i2][y - 1] == 1) {
                    //System.out.println("进了2");
                    work3 = 1;
                    count2++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1 + i2][y - 1] == 1) {
                    work4 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 + i2][y - 1] == 2) {
                    work4 = 1;
                    break;
                }
            }
        }
        //System.out.println("work3=" + work3 + "  " + "work4=" + work4 + "  i=" + i2 + "  count=" + count2);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work3 == 1 && work4 == 1) {
            mark2 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count2; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x + i2 - q - 1][y - 1] = 1;
                }
                if (player == 2) {
                    chessboard1[x + i2 - q - 1][y - 1] = 2;
                }
            }

//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }

        }


        //向左探测
        int mark3 = 0;//标志位，有一个方向翻子成功则置1；
        int work5 = 0;//判断是否遇到了对方的子，遇到了变为1
        int work6 = 0;//判断是否遇到自己的子，遇到了变为1
        int count3 = 0;//计数有多少对方的子夹在中间
        int i3 = 1;
        //System.out.println("x=" + x + "  " + "y=" + y);
        for (; i3 < y; i3++) {
//            System.out.println(x - 1);
//            System.out.println(y - 1 - i3);
//            System.out.println("player is" + player);
            if (chessboard1[x - 1][y - 1 - i3] == 0 && i3 == 1) {
                break;
            }
            if (chessboard1[x - 1][y - 1 - i3] == player && i3 == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1][y - 1 - i3] == 2) {
                    //System.out.println("进了1");
                    work5 = 1;
                    count3++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1][y - 1 - i3] == 1) {
                    //System.out.println("进了2");
                    work5 = 1;
                    count3++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1][y - 1 - i3] == 1) {
                    work6 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1][y - 1 - i3] == 2) {
                    work6 = 1;
                    break;
                }
            }
        }
        //System.out.println("work5=" + work5 + "  " + "work6=" + work6 + "  i=" + i3 + "count5=" + count3);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work5 == 1 && work6 == 1) {
            mark3 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count3; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x - 1][y - 1 - i3 + q] = 1;
                }
                if (player == 2) {
                    chessboard1[x - 1][y - 1 - i3 + q] = 2;
                }
            }

//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }

        }


        //向右探测
        int mark4 = 0;//标志位，有一个方向翻子成功则置1；
        int work7 = 0;//判断是否遇到了对方的子，遇到了变为1
        int work8 = 0;//判断是否遇到自己的子，遇到了变为1
        int count4 = 0;//计数有多少对方的子夹在中间
        int i4 = 1;
        //System.out.println("x=" + x + "  " + "y=" + y);
        for (; i4 < 8 - y; i4++) {
//            System.out.println(x - 1);
//            System.out.println(y - 1 + i4);
//            System.out.println("player is" + player);
            if (chessboard1[x - 1][y - 1 + i4] == 0 && i4 == 1) {
                break;
            }
            if (chessboard1[x - 1][y - 1 + i4] == player && i4 == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1][y - 1 + i4] == 2) {
                    //System.out.println("进了1");
                    work7 = 1;
                    count4++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1][y - 1 + i4] == 1) {
                    //System.out.println("进了2");
                    work7 = 1;
                    count4++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1][y - 1 + i4] == 1) {
                    work8 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1][y - 1 + i4] == 2) {
                    work8 = 1;
                    break;
                }
            }
        }
        //System.out.println("work7=" + work7 + "  " + "work8=" + work8 + "  i=" + i4 + "count4=" + count4);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work7 == 1 && work8 == 1) {
            mark4 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count4; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x - 1][y - 1 + i4 - q] = 1;
                }
                if (player == 2) {
                    chessboard1[x - 1][y - 1 + i4 - q] = 2;
                }
            }

//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }

        }


        //向左上探测
        int mark5 = 0;
        int work9 = 0;
        int work10 = 0;
        int count5 = 0;
        int i5x = 1;
        int i5y = 1;
        for (; i5x < x && i5y < y; i5x++, i5y++) {
            //System.out.println(x - 1 - i5x);
            //System.out.println(y - 1 - i5y);
            //System.out.println("player is" + player);
            if (chessboard1[x - 1 - i5x][y - 1 - i5y] == 0 && i5x == 1) {
                break;
            }
            if (chessboard1[x - 1 - i5x][y - 1 - i5y] == player && i5x == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1 - i5x][y - 1 - i5y] == 2) {
                    //System.out.println("进了1");
                    work9 = 1;
                    count5++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 - i5x][y - 1 - i5y] == 1) {
                    //System.out.println("进了2");
                    work9 = 1;
                    count5++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1 - i5x][y - 1 - i5y] == 1) {
                    work10 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 - i5x][y - 1 - i5y] == 2) {
                    work10 = 1;
                    break;
                }
            }
        }
        //System.out.println("work9=" + work9 + "  " + "work10=" + work10 + "  i=" + i4 + "count4=" + count4);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work9 == 1 && work10 == 1) {
            mark5 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count5; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x - 1 - i5x + q][y - 1 - i5y + q] = 1;
                }
                if (player == 2) {
                    chessboard1[x - 1 - i5x + q][y - 1 - i5y + q] = 2;
                }
            }

//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }

        }


        //向右上探测
        int mark6 = 0;
        int work11 = 0;
        int work12 = 0;
        int count6 = 0;
        int i6x = 1;
        int i6y = 1;
        for (; i6x < x && i6y < 8 - y; i6x++, i6y++) {
//            System.out.println(x - 1 - i6x);
//            System.out.println(y - 1 + i6y);
//            System.out.println("player is" + player);
            if (chessboard1[x - 1 - i6x][y - 1 + i6y] == 0 && i6x == 1) {
                break;
            }
            if (chessboard1[x - 1 - i6x][y - 1 + i6y] == player && i6x == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1 - i6x][y - 1 + i6y] == 2) {
                    //System.out.println("进了1");
                    work11 = 1;
                    count6++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 - i6x][y - 1 + i6y] == 1) {
                    //System.out.println("进了2");
                    work11 = 1;
                    count6++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1 - i6x][y - 1 + i6y] == 1) {
                    work12 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 - i6x][y - 1 + i6y] == 2) {
                    work12 = 1;
                    break;
                }
            }
        }
        //System.out.println("work11=" + work11 + "  " + "work12=" + work12 + "  i=" + i6x + "count6=" + count6);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work11 == 1 && work12 == 1) {
            mark6 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count6; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x - 1 - i6x + q][y - 1 + i6y - q] = 1;
                }
                if (player == 2) {
                    chessboard1[x - 1 - i6x + q][y - 1 + i6y - q] = 2;
                }
            }

//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }

        }


        //向左下探测
        int mark7 = 0;
        int work13 = 0;
        int work14 = 0;
        int count7 = 0;
        int i7x = 1;
        int i7y = 1;
        for (; i7x < 8-x && i7y < y; i7x++, i7y++) {
//            System.out.println(x - 1 + i7x);
//            System.out.println(y - 1 - i7y);
//            System.out.println("player is" + player);
            if (chessboard1[x - 1 + i7x][y - 1 - i7y] == 0 && i7x == 1) {
                //System.out.println("");
                break;
            }
            if (chessboard1[x - 1 + i7x][y - 1 - i7y] == player && i7x == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1 + i7x][y - 1 - i7y] == 2) {
                    //System.out.println("进了1");
                    work13 = 1;
                    count7++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 + i7x][y - 1 - i7y] == 1) {
                    //System.out.println("进了2");
                    work13 = 1;
                    count7++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1 + i7x][y - 1 - i7y] == 1) {
                    work14 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 + i7x][y - 1 - i7y] == 2) {
                    work14 = 1;
                    break;
                }
            }
        }
        //System.out.println("work13=" + work13 + "  " + "work14=" + work14 + "  i=" + i7x + "count7=" + count7);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work13 == 1 && work14 == 1) {
            mark7 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count7; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x - 1 + i7x -q][y - 1 - i7y +q] = 1;
                }
                if (player == 2) {
                    chessboard1[x - 1 + i7x - q][y - 1 - i7y + q] = 2;
                }
            }
//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }

        }


        //向右下探测
        int mark8 = 0;
        int work15 = 0;
        int work16 = 0;
        int count8 = 0;
        int i8x = 1;
        int i8y = 1;
        for (; i8x < 8-x && i8y < 8-y; i8x++, i8y++) {
//            System.out.println(x - 1 + i8x);
//            System.out.println(y - 1 + i8y);
//            System.out.println("player is" + player);
            if (chessboard1[x - 1 + i8x][y - 1 + i8y] == 0 && i8x == 1) {
                //System.out.println("");
                break;
            }
            if (chessboard1[x - 1 + i8x][y - 1 + i8y] == player && i8x == 1) {
                break;
            }
            if (player == 1) {
                if (chessboard1[x - 1 + i8x][y - 1 + i8y] == 2) {
                    //System.out.println("进了1");
                    work15 = 1;
                    count8++;
                    continue;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 + i8x][y - 1 + i8y] == 1) {
                    //System.out.println("进了2");
                    work15 = 1;
                    count8++;
                    continue;
                }
            }
            //System.out.println("进了");

            if (player == 1) {
                //System.out.println("进了");
                if (chessboard1[x - 1 + i8x][y - 1 + i8y] == 1) {
                    work16 = 1;
                    break;
                }
            }
            if (player == 2) {
                if (chessboard1[x - 1 + i8x][y - 1 + i8y] == 2) {
                    work16 = 1;
                    break;
                }
            }
        }
        //System.out.println("work15=" + work15 + "  " + "work16=" + work16 + "  i=" + i8x + "count8=" + count8);
        //判断是否可以向上翻棋，如果可以就翻转棋子
        if (work15 == 1 && work16 == 1) {
            mark8 = 1;
            //int position=i;//从该位的下一位开始翻棋
            for (int q = 1; q <= count8; q++) {
                //System.out.println("q=" + q);
                if (player == 1) {
                    chessboard1[x - 1 + i8x -q][y - 1 + i8y -q] = 1;
                }
                if (player == 2) {
                    chessboard1[x - 1 + i8x - q][y - 1 + i8y - q] = 2;
                }
            }
//            //翻棋后检查结果
//            for (int o = 0; o < 8; o++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard1[o][j]);
//                }
//                System.out.print('\n');
//            }
        }

        if(mark1==0&&mark2==0&&mark3==0&&mark4==0&&mark5==0&&mark6==0&&mark7==0&&mark8==0)
        {
            System.out.println("此处不能落子！");
            for (int o = 0; o < 8; o++) {
                for (int j = 0; j < 8; j++) {
                    chessboard1[o][j]=chessboard[o][j];
                }
            }
            System.out.println("请玩家"+player+"落子");
            x=getx();
            y=gety();
            System.out.println(x+" "+y);
            Preliminary_receiving(chessboard,chessboard1,player,x,y);
            change(chessboard,chessboard1,player,x,y);

        }
        else
        {
            for (int o = 0; o < 8; o++) {
                for (int j = 0; j < 8; j++) {
                    chessboard[o][j]=chessboard1[o][j];
                }
            }
            System.out.println("棋盘现状为：");
            for(int i = 0; i < 8; i++)
            {
                for(int j=0;j<8;j++)
                {
                    System.out.print(chessboard[i][j]+" ");
                }
                System.out.print('\n');
            }
        }
    }

    //横坐标输入
    static int getx() throws IOException {
        System.out.println("请输入要落子位置的x坐标（横坐标从1-8）");
        Scanner input=new Scanner(System.in);
        int x;
        x=input.nextInt();
        return x;
    }

    //纵坐标输入
    static int gety() throws IOException {
        System.out.println("请输入要落子位置的y坐标（纵坐标从1-8）");
        Scanner input=new Scanner(System.in);
        int y;
        y=input.nextInt();
        return y;
    }

    public static void main(String args[]) throws IOException
    {
        int chessboard[][]=new int[8][8];
        //chessboard[8][8]={0};

        //1代表黑棋，2代表白棋
        //棋盘初始化
        for(int i = 0; i < 8; i++)
        {
           for(int j=0;j<8;j++)
           {
               chessboard[i][j]=0;
           }
        }
        chessboard[3][3]=1;
        chessboard[4][4]=1;
        chessboard[3][4]=2;
        chessboard[4][3]=2;

        //下面为测试用数据
        //chessboard[2][2]=2;
        //chessboard[2][5]=1;
        //chessboard[5][2]=1;
        //chessboard[5][5]=2;

        //检查棋盘初始化情况
        for(int i = 0; i < 8; i++)
        {
            for(int j=0;j<8;j++)
            {
               System.out.print(chessboard[i][j]+" ");
            }
            System.out.print('\n');
        }

        int chessboard1[][]=new int[8][8];
        for(int i = 0; i < 8; i++)
        {
            for(int j=0;j<8;j++)
            {
                chessboard1[i][j]=chessboard[i][j];
            }
        }

        int player=2;

        int count[]=new int [3];
        count[2]=1;
        int playerchange=1;

        while(count[2]!=0)
        {
            if(playerchange%2==1)player=1;
            if(playerchange%2==0)player=2;
            System.out.println("请玩家"+player+"落子");
            //接入落子坐标
            int x=getx();
            int y=gety();
            System.out.println(x+" "+y);
            //初步生成落子后棋盘，做进一步的是否落子判断
            Preliminary_receiving(chessboard,chessboard1,player,x,y);
            change(chessboard,chessboard1,player,x,y);
            Count(count,chessboard);
            System.out.println("黑棋个数："+count[0]);
            System.out.println("白棋个数："+count[1]);
            playerchange++;
        }


    }

    private static void Count(int i, int i1) {
    }


    //统计棋局情况的函数
    static void Count(int count[], int chessboard[][])
    {
        int number_Black=0;
        int number_White=0;
        int number_Empty=0;
        for(int i = 0; i < 8; i++)
        {
            for(int j=0;j<8;j++)
            {
                if(chessboard[i][j]==0)number_Empty++;
                if(chessboard[i][j]==1)number_Black++;
                if(chessboard[i][j]==2)number_White++;
            }
        }
        count[0]=number_Black;
        count[1]=number_White;
        count[2]=number_Empty;
    }
}
