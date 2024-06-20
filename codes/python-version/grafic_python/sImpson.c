// simpson.c
#include <stdio.h>

__declspec(dllexport) double f(double x) {
    return x * x; // Exemplo de função: x^2
}

__declspec(dllexport) double simpson(double a, double b, int n) {
    double h = (b - a) / n;
    double sum = f(a) + f(b);

    for (int i = 1; i < n; i++) {
        double x = a + i * h;
        if (i % 2 == 0) {
            sum += 2 * f(x);
        } else {
            sum += 4 * f(x);
        }
    }
    return (h / 3) * sum;
}
