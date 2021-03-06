
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author manikhanuja
 */
public class TestPorterStemmer {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter token");
        while (scan.hasNext()) {
            String token = scan.next();
            if (token.equals("q")) {
                break;
            }
            String processToken;
            ArrayList<String> normalizeToken=new ArrayList<>();
            normalizeToken = NormalizeToken.normalizeToken(token);
            Iterator iter=normalizeToken.iterator();
            while(iter.hasNext()){ 
                System.out.println("Normalized Token: " + iter.next().toString());
                processToken = PorterStemmer.processToken(iter.next().toString());
                System.out.println("stem: " + processToken);
            }
        }
    }
}
