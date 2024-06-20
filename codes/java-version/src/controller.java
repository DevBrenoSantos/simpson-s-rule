package TrabalhoRegraSimpson;

import java.util.function.Function;
public class controller {
    public static void main(String[] args) {
        double limiteInferior = 0;
        double limiteSuperior = Math.PI;
        int subintervalos = 10;
        Function<Double, Double> func = x -> Math.sin(x);

        app.Result result = app.simpson(limiteInferior, limiteSuperior, subintervalos, func);

        System.out.println("x: ");
        for (double xi : result.x) {
            System.out.println(xi + " ");
        }
        System.out.println("\nfx: ");
        for (double fxi : result.fx) {
            System.out.println(fxi + " ");
        }
        System.out.println("\nv: " + result.v);
    }
}

// Documentação:
//  'limiteInferior' (double): O limite inferior do intervalo de integração. Representa o ponto inicial do intervalo sobre o qual você deseja calculcar a integral da função

// 'b' (double): O limite superior do intervalo de integração. Representa o ponto final do intervalo sobre o qual você deseja calcular a integral da função.

// 'n' (int): O número de subintervalos em que o intervalo [a, b] será dividido. Para a Regra de Simpson, esse valor deve ser um número par, pois a fórmula da regra padrão exige pares de subintevalos.

// 'func' (Function<Double, Double>): A função que você deseja integrar. Esta função toma um valor do tipo 'Double' e retorna um valor do tipo 'Double'

// Array 'x': Os pontos xi no intervalo [a, b] onde a função será avaliada. Esses pontos são igualmente espaçado com uma distância h entre eles, onde h = (b-a)/n

// Array 'fx': Os valores da função 'func' avaliados nos pontos xi.

// Valor 'v': O valor aproximado da integral da função 'func' no intervalo [a, b] usando a Regra de Simpson. 