#include <stdio.h>

// Pointer-based swap function: receives memory addresses and modifies actual variables
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Pass-by-value swap function: receives copies of arguments (Step 7)
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    /* 
     * NOTE: This does NOT swap the variables in main. 
     * 'a' and 'b' are local copies created on the function's stack frame. 
     * Any changes here only affect these local copies and disappear when the function returns.
     */
}

int main(void) {
    int x = 10;
    int y = 20;

    // 1. Working Swap (Pointers)
    printf("--- Testing swap() with pointers ---\n");
    printf("Before swap: x = %d, y = %d\n", x, y);
    
    // Pass the addresses of x and y using the '&' operator
    swap(&x, &y);
    
    printf("After swap:  x = %d, y = %d\n\n", x, y);

    // Reset values to test broken_swap
    x = 10;
    y = 20;

    // 2. Broken Swap (Value copies)
    printf("--- Testing broken_swap() without pointers ---\n");
    printf("Before broken_swap: x = %d, y = %d\n", x, y);
    
    // Passes values directly (copies)
    broken_swap(x, y);
    
    printf("After broken_swap:  x = %d, y = %d\n", x, y);

    return 0;
}