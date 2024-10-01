package verificacion_balanceo;

import java.util.Stack;

public class Verificacion_Balanceo {
    
    public static boolean verificarBalanceo(String expresion) {
        Stack<Character> pila = new Stack<>();
        
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            
            if (caracter == '(' || caracter == '{' || caracter == '[') {
                pila.push(caracter);
            }
            else if (caracter == ')' || caracter == '}' || caracter == ']') {
                if (pila.isEmpty()) {
                    return false;
                }
                
                char ultimoApertura = pila.pop();
                
                if ((caracter == ')' && ultimoApertura != '(') ||
                    (caracter == '}' && ultimoApertura != '{') ||
                    (caracter == ']' && ultimoApertura != '[')) {
                    return false;
                }
            }
        }
        
        return pila.isEmpty();
    }
    
    public static void main(String[] args) {
        String expresion1 = "{[()]}"; 
        String expresion2 = "{[(])}"; 
        String expresion3 = "({[]})"; 
        String expresion4 = "([{})";  

        System.out.println("¿Esta balanceada la expresion 1? " + verificarBalanceo(expresion1)); 
        System.out.println("¿Esta balanceada la expresion 2? " + verificarBalanceo(expresion2)); 
        System.out.println("¿Esta balanceada la expresion 3? " + verificarBalanceo(expresion3)); 
        System.out.println("¿Esta balanceada la expresion 4? " + verificarBalanceo(expresion4)); 
    }
}

