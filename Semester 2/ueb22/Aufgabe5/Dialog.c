//
// Created by Jonas on 10.07.2023.
//

#include "String_Bibliothek.c"

int main() {
    printf("_________________________________\n");
    printf("strcmp:\n");
    const char *str1 = "Hello";
    const char *str2 = "World";

    int result = strcmp(str1, str2);

    if (result < 0) {
        printf("'%s' is smaller than '%s'\n", str1, str2);
    } else if (result > 0) {
        printf("'%s' is greater than '%s'\n", str1, str2);
    } else {
        printf("'%s' is equal to '%s'\n", str1, str2);
    }

    printf("_________________________________\n");
    printf("strlen:\n");
    const char *str3 = "Hello ";

    int len = strlen(str3);

    printf("Laenge: '%d'\n", len);

    printf("_________________________________\n");
    printf("firstIndexOf:\n");
    const char *str8 = "Hello ";

    int indexfirst = firstIndexOf(str8, 'l');

    printf("indexfirst: '%d'\n", indexfirst);

    printf("_________________________________\n");
    printf("lastIndexOf:\n");
    const char *str9 = "Hello ";

    int indexlast = lastIndexOf(str9, 'l');

    printf("indexlast: '%d'\n", indexlast);

    printf("_________________________________\n");
    printf("replace:\n");
    char str[] = "Hello, World!";
    char auszutauschender = 'o';
    char tauscher = 'x';

    printf("Originaler String: %s\n", str);

    replace(str, auszutauschender, tauscher);

    printf("Veränderter String: %s\n", str);


    printf("_________________________________\n");
    printf("toUpperCase:\n");
    char str5[] = "Hello, World!";

    printf("Originaler String: %s\n", str5);

    toUpperCase(str5);

    printf("String in Grosbuchstaben: %s\n", str5);


    printf("_________________________________\n");
    printf("swap:\n");
    char str11[] = "Hello";
    char str22[] = "World";

    printf("Vor dem Tausch:\n");
    printf("str1: %s\n", str11);
    printf("str2: %s\n", str22);

    swap(str11, str22);

    printf("\nNach dem Tausch:\n");
    printf("str1: %s\n", str11);
    printf("str2: %s\n", str22);

    return 0;
}