//
// Created by Jonas on 10.07.2023.
//
#include <stdio.h>

int main() {

    int zeichen;
    int zeilen;
    printf("\nWie viele Zeilen? ");
    scanf("\n%d", &zeilen);
    printf("\nWie viele Zeichen? ");
    scanf("\n%d", &zeichen);

    long l = '140732807899964';
    long* pl = &l;
    printf(“%p\n“, &*pl);
    printf(“%p\n“, &pl);
    printf(“%p\n“, *pl);

    for (int z = 0; z < zeilen; z++) {
        for (int s = 0; s < zeichen; s++) {
            if (z == s || zeichen-z-1 == s) {
                printf("*");
            } else {
                printf("_");
            }
        }
        printf("\n");
    }

    return 0;
}