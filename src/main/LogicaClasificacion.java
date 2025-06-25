package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        StringBuilder invertido = new StringBuilder();
        Stack<Character> pila = new Stack<>();
        for (Character c:texto.toCharArray()){
            pila.push(c);
        }
        while(!pila.isEmpty()){
            invertido.append(pila.pop());
        }
        return invertido.toString();

        // for (int i=0; i>texto.length();i++){
        // }
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        Map<Character, Character> pares = new HashMap<>();
        pares.put(')', '(');
        pares.put(']', '[');
        pares.put('}', '{');

        for (char c : expresion.toCharArray()) {
            if (pares.containsValue(c)) { // Si es de apertura
                pila.push(c);
            } else if (pares.containsKey(c)) { // Si es de cierre
                if (pila.isEmpty() || pila.pop() != pares.get(c)) {
                    return false;
                }
            }
            // Si no es símbolo relevante, simplemente lo ignora
        }
        return pila.isEmpty();
    }


    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
            Stack<Integer> pilaAuxiliar = new Stack<>();
            while (!pila.isEmpty()) {
                int temp = pila.pop();
                while (!pilaAuxiliar.isEmpty() && pilaAuxiliar.peek() > temp) {
                    pila.push(pilaAuxiliar.pop());
                }
                pilaAuxiliar.push(temp);
            }

            return new ArrayList<>(pilaAuxiliar);
        }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
            LinkedList<Integer> pares = new LinkedList<>();
            LinkedList<Integer> impares = new LinkedList<>();

            for (int i = 0; i < original.size(); i++) {
                int num = original.get(i);

                int division = num / 2;
                if (division * 2 == num) {
                    pares.add(num);
                } else {
                    impares.add(num);
                }
            }

            pares.addAll(impares);
            return pares;
        }
}
