#include <iostream>
#include <cstdio>
#include <string>
#include <queue>
#include <vector>
#include <cstring>
#include <conio.h>
#include <algorithm>
#include <cstdlib>
#include <windows.h>
using namespace std;

#define key_up 72
#define key_down 80
#define key_left 75
#define key_right 77

#define pp pair<int,int>
#define push push_back

struct st
{
    char name[20];
    int pt;
}r_h[100];
int sp_meter[] = { 50 , 30 , 10 },speed;
void dificulty()
{
    int x = 1;
    char c;
    do
    {
        printf("\n\n\n\n\n\t\t\t\t\tChose difficulty level\n");
        printf("\t\t\t\t\t");
        if(x==1) printf(">>");
        printf("EASY\n");
        printf("\t\t\t\t\t");
        if(x==2) printf(">>");
        printf("MEDIUM\n");
        printf("\t\t\t\t\t");
        if(x==3) printf(">>");
        printf("HARD\n");
        c = getche();
        system("cls");
        if(c == key_up) x--;
        if(c == key_down) x++;
        if(!x) x = 1;
        if(x==4) x = 3;
    }while(c!='\r');
    speed = sp_meter[x-1];
}
int p = 0;
bool  comp(st i,st j) { return i.pt>j.pt; }
int point;
void stop()
{
    p = 0;
    FILE *fp = fopen("ranking_history.txt", "a");
    char a[20];
    printf("\n\t\t\t\t\tEnter your name : "); scanf("%s",&a);
    fprintf(fp, "%s %d\n" , a ,point);
    fclose(fp);
    fp = fopen("ranking_history.txt", "r");
    while(fscanf(fp,"%s",r_h[p].name)!=EOF && fscanf(fp, "%d" ,&r_h[p++].pt)!=EOF);
    fclose(fp);
    sort(r_h,r_h+p,comp);
    system("cls");
    printf("\n\n\t\t\tNAME\t\t  SCORE\n");
    for(int i=0;i<p;i++)
    {
        printf("\t\t\t%.2d. %s",i+1,r_h[i].name);
        for(int j=10;j<25-strlen(r_h[i].name);j++)printf(" ");
        printf("%d\n",r_h[i].pt);
    }
    printf("\n\t\t\t\tPRESS ANY KEY\n");
    getch();
    system("cls");
}
int main()
{
    dificulty();
    printf("\n\n\n\n\n\n\n\t\t\t\t\t\tLOADING !!!\n\t\t\t\t\t  ");
    for(int i=0;i<22;i++)
    {
        for(int j=0;j<3e7;j++);
        printf("%c",178);
    }
    printf("\n");
    system("cls");
    vector <pp> Q,P;
    pp x;
    point = 0;
    Q.push(pp(10,5));
    Q.push(pp(10,6));
    Q.push(pp(10,7));
    Q.push(pp(10,8));
    char c = key_right,c_p = key_right;
    pp y;
    int a=10,b=8;
    y.first = y.second = -1;
    int f1 = rand()%18+1,f2 = rand()%28+1;
    bool strt = true;
    while(1)
    {
        here:
        printf("\n\n\n\t\t\t\t\tYour Point : %d\n",point);
        for(int i=0;i<20;i++,printf("\n"))
        {
            int w = 1;
            for(int j=0;j<30;j++)
            {
                if(j==0) printf("\t\t\t\t  ");
                bool flag = true;
                for(int k=0;k<Q.size()-1;k++)
                {
                    if(Q[k].first == a && Q[k].second == b) { printf("\n\n\n\n\n\n\t\t\t\t\tGAME OVER\n"); printf("\t\t\t\t\tScore : %d\n\n\n\n",point); stop(); printf("\n\n\nPress (y) to play again\nPress (n) to exit\n");
                    char cc = getch();
                    if(cc == 'y') { system("cls"); main();}
                    else return 0;}
                }
                if(i == f1 && j==f2 && i==a && j==b)
                {
                    point++;
                    Q = P;
                    f1 = rand()%18+1;
                    f2 = rand()%28+1;
                }
                if(i==f1&&j==f2) { printf("F ") ; continue; }
                if(i==0 || j==0 || j==29 || i==19 ) { printf("! ");flag = false; continue; }
                for(int k=0;k<Q.size();k++)
                {
                    x = Q[k];
    //                printf("%d %d\n",x.first,x.second);
                    if(i==x.first && j == x.second)
                    {
                        if(k==Q.size()-1)
                        {
                            if(c == key_up) printf("^ ");
                            if(c == key_down) printf("v ");
                            if(c == key_right) printf("> ");
                            if(c == key_left) printf("< ");
                            w = 0;
                            continue;
                        }
                        else {printf("* "); flag = false; continue; }
                    }
                }
                if(w++ && flag)printf("  ");
            }
        }
        if(strt) { getch(); strt = false; }
        bool flag = true;
        c_p = c;
        while(1)
        {
            if(kbhit()) {
                    c=getche();
                    system("cls");
                    break;
            }
//            for(int q=0;q<=1e7;q++);
            Sleep(speed);
            system("cls");
            P = Q;
            Q.erase(Q.begin());
            y = Q.back();
            if(c==key_right) Q.push(pp(y.first,y.second+1));
            if(c==key_up) Q.push(pp(y.first-1,y.second));
            if(c==key_down) Q.push(pp(y.first+1,y.second));
            if(c==key_left) Q.push(pp(y.first,y.second-1));
            y = Q.back();
            P.push(Q.back());
            a = y.first;
            b = y.second;
            if(a==0 || a == 19 || b == 0 || b == 29) {printf("\n\n\n\n\n\n\t\t\t\t\tGAME OVER\n"); printf("\t\t\t\t\tScore : %d\n\n\n\n",point); stop(); printf("\n\n\nPress (y) to play again\nPress (n) to exit\n");
            char cc = getch();
            if(cc == 'y') { system("cls"); main();}
            else return 0;}
            goto here;
        }
        system("cls");
    }
}
