package TrabalhoRegraSimpson;

import java.util.function.Function;

public class app {
    public static class Result {
        public double[] x;
        public double[] fx;
        public double v;

        public Result(double[] x, double[] fx, double v) {
            this.x = x;
            this.fx = fx;
            this.v = v;
        }
    }

    public static Result simpson(double a, double b, int n, Function<Double, Double> func) {
        double h = (b - a) / n;
        double[] x = new double[n+1];
        double[] fx = new double[n+1];
        
        for (int i = 0; i <= n; i++) {
            x[i] = a+i*h;
            fx[i] = func.apply(x[i]);
        }

        double v = fx[0] + fx[n];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                v += 2 * fx[i];
            } else {
                v += 4 * fx[i];
            }
        }

        v = h/3*v;

        return new Result(x, fx, v);
    }
}