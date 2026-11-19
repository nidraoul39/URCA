#include <stdio.h>
#include <string.h>

int main(void) {
    // 1. Allouer un tableau de 64 octets (63 caractères + '\0') et retirer 'const'
    char user[64];
    
    if (scanf("%63s", user) != 1) {
        return 1;
    }

    size_t len = strlen(user);
    char expected[72];

    for (size_t i = 0; i < len; i++) {
        expected[len - 1 - i] = user[i] ^ 0x1f;
    }
    
    // 2. Terminer proprement la chaîne de caractères sans avoir besoin de memset
    expected[len] = '\0';

    printf("%s\n", expected);
    return 0;
}
