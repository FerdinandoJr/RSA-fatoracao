
package com.mycompany.quebracodigo;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;


public class QuebraCodigo {
    
    public static List<BigInteger> trialDivision(BigInteger n){
        // O fatores são armazenados numa lista ligada
        // Entretanto você pode usar a estrutura que quiser
        // Exemplos: Array, ArrayList, Stack (pilha)
        List<BigInteger> factors = new LinkedList<BigInteger>();
        
        
        BigInteger two =  new BigInteger("2");
        // Verifica se 2 é fator
        while(n.mod(two).compareTo(BigInteger.ZERO) == 0){
            factors.add(two);
            n = n.divide(two);
        }
         
        // Agora verifica os possíveis fatores ímpares
        // Só ímpares são possíveis
        BigInteger d = new BigInteger("3"); // Possíveis fatores
        BigInteger d2 = new BigInteger("9"); // d2 = d * d
        while(d2.compareTo(n) <= 0){
            // Se d é fator, faz a divisão e armazena o fator
            if(n.mod(d).compareTo(BigInteger.ZERO)== 0){
                factors.add(d);
                n = n.divide(d);
            }else{
                // Se d não é fator, verifica o próximo
                d = d.add(two);
                d2 = d.multiply(d); // d2 = d*d
            }
        }
        // Essa condição é necessária quando n for primo
        if(n.compareTo(BigInteger.ONE) == 1){
            factors.add(n);
        }
        return factors;
    }
     
    // Testes
    public static void main(String[] args) {
//        System.out.println("Fatores de 10 = " + trialDivision(10));
//        System.out.println("Fatores de 50 = " + trialDivision(50));
//        System.out.println("Fatores de 24 = " + trialDivision(24));
//        System.out.println("Fatores de 350 = " + trialDivision(350));
//        System.out.println("Fatores de 107 = " + trialDivision(107));
//        System.out.println("Fatores de 1025 = " + trialDivision(1025));
//        System.out.println("Fatores de 3 * 5 * 7 * 11 * 13 * 17 = " +
//        trialDivision(3 * 5 * 7 * 11 * 13 * 17);

        BigInteger n = new BigInteger("31861");
        System.out.println("Fatores: "+ trialDivision(n));
    }
}
