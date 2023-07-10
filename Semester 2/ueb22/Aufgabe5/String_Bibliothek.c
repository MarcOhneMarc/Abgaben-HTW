//
// Created by Jonas on 10.07.2023.
//
#include <stdio.h>
#include <ctype.h>

int strcmp(const char  *firstStr, const char  *secondStr) {
    int i = 0;
    while (firstStr[i] != '\0' || secondStr[i] != '\0') {
        if (firstStr[i] == '\0') {
            return -1;
        } else if (secondStr[i] == '\0') {
            return 1;
        }
        i++;
    }
    return 0;
}

int strlen(const char *str) {
    int i = 0;
    while (str[i] != '\0') {
        i++;
    }
    return i;
}

int firstIndexOf(const char *str, char zuSuchenderChar) {
    for (int i = 0; i <= strlen(str); i++) {
        if (str[i] == zuSuchenderChar) {
            return i;
        }
    }
    return -1;
}

int lastIndexOf(const char *str, char zuSuchenderChar) {
    int index;
    for (int i = 0; i <= strlen(str); i++) {
        if (str[i] == zuSuchenderChar) {
            index = i;
        }
    }
    if (index <= 0) {
        return -1;
    } else {
        return index;
    }
}

int replace(char *str, char auszutauschender, char tauscher) {
    int i = 0;
    while (str[i] != '\0') {
        if (str[i] == auszutauschender) {
            str[i] = tauscher;
        }
        i++;
    }
    return -1;
}

void toUpperCase(char *str) {
    int i = 0;
    while (str[i] != '\0') {
        if (str[i] >= 'a' && str[i] <= 'z') {
            str[i] = str[i] - 'a' + 'A';
        }
        i++;
    }
}

int swap(char  *firstStr, char  *secondStr) {
    int i = 0;
    while (firstStr[i] != '\0' || secondStr[i] != '\0') {
        char temp  = firstStr[i];
        firstStr[i]  = secondStr[i];
        secondStr[i] = temp;
        i++;
    }
    return 0;
}