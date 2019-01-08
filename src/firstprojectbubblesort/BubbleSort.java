
package firstprojectbubblesort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alessio-Mirko
 */
public class BubbleSort {
    
    /*
     Method that receives a String with the numbers written by the user and order them with Bubble Sort.
     Return an array with two index: the first contain the ordered array; the secondo contain the number of invalid values.
    */
    public static String[] getSort(String onOrderString) {
        
        /*
         Variables: 
         -tmp for the swap of the array's cell
         -cont for the number of the invalid values
         -orderString
        */
        
        double tmp = 0;                                   
        int cont = 0;                                     
        String orderString = "";
        
        String ar[] = onOrderString.split("\\s+");       //Array con all'interno i numeri senza spazi
        
        List<Double> at = new ArrayList<Double>();        
        
        for(int i = 0; i < ar.length; i++) {                   //Ciclo per aggiungere in un ArrayList i numeri
            try {
                at.add(Double.parseDouble(ar[i]));      //Aggiunge il numero convertendolo in Double
            }
            catch(Exception e){                         //se l'inserimento del valore non è andato a buon fine, si contano le eccezioni
                cont++;                                 //Conta quante volte viene inserito un carattere diverso da un numero
            }                                           
        }
        
         //Bubble Sort
         for(int i = 0; i < at.size(); i++){  
                 for(int j = 1; j < (at.size()-i); j++){  
                          if(at.get(j-1) > at.get(j)){      //confronta il valore indicato con il suo precedente
                          //se il valore precedente è minore non viene fatta nessuna modifica
                                 tmp = at.get(j-1);         //viene inserito il valore maggiore in una variabile di appoggio
                                 at.set(j-1, at.get(j));    //invertiamo le loro posizioni
                                 at.set(j, tmp); 
                         }  
                          
                 }  
         }

        for(double c: at){
           orderString = orderString + String.valueOf(c).replaceAll("\\.0+", "")+" ";
        }                                                   //composizione della stringa con valori
        
        return new String[]{orderString, String.valueOf(cont)};                                 //ritorno della stringa        
    }
    
}
