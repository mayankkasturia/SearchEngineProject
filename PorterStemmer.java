package porterstemmer;

import java.util.regex.*;
public class PorterStemmer {

   // a single consonant
   private static final String c = "[^aeiou]";
   // a single vowel
   private static final String v = "[aeiouy]";

   // a sequence of consonants; the second/third/etc consonant cannot be 'y'
   private static final String C = c + "[^aeiouy]*";
   // a sequence of vowels; the second/third/etc cannot be 'y'
   private static final String V = v + "[aeiou]*";

   // this regex pattern tests if the token has measure > 0 [at least one VC].
   private static final Pattern mGr0 = Pattern.compile("^(" + C + ")?" + V + C);

   // add more Pattern variables for the following patterns:
   // m equals 1: token has measure == 1
   private static final Pattern mEq1 = Pattern.compile("^(" + C + ")?" + V + C + "$");
// m greater than 1: token has measure > 1
   private static final Pattern mGr1 = Pattern.compile("^(" + C + ")?" + V + C + V + C);
   // vowel: token has a vowel after the first (optional) C
   private static final Pattern vowel = Pattern.compile("^(" + C + ")?" + "[aeiou]");

   // double consonant: token ends in two consonants that are the same, 
   //			unless they are L, S, or Z. (look up "backreferencing" to help 
   //			with this)
   // m equals 1, cvc: token is in Cvc form, where the last c is not w, x,
   //			or y.
   
   public static String processToken(String token) {
      if (token.length() < 3) {
         return token; // token must be at least 3 chars
      }
      // step 1a.1
      if (token.endsWith("sses")) {
         token = token.substring(0, token.length() - 2);
      }
      // step 1a.2
      if (token.endsWith("ies")) {
         token = token.substring(0, token.length() - 2);
      }
      // step 1a.3 - token ends with s and not ss
      if (token.endsWith("s")) {
           if (token.endsWith("ss")) {
           } else {
               token = token.substring(0, token.length() - 1);
          }
      }
      
      // step 1b
      boolean doStep1bb = false;
      //		step 1b
      if (token.endsWith("eed")) { // 1b.1
         // token.substring(0, token.length() - 3) is the stem prior to "eed".
         // if that has m>0, then remove the "d".
         String stem = token.substring(0, token.length() - 3);
         if (mGr0.matcher(stem).find()) { // if the pattern matches the stem
            token = stem + "ee";
         }
      }
      // program the rest of 1b. set the boolean doStep1bb to true if Step 1b* 
      // should be performed.
      if (token.endsWith("ed")){
          if(token.endsWith("eed")){
          }else {
              String stem = token.substring(0, token.length()-2);
              if(vowel.matcher(stem).find()){
                  token = stem;
                  doStep1bb = true;
              }
          }
      }
      if (token.endsWith("ing")){
              String stem = token.substring(0, token.length()-3);
              if(vowel.matcher(stem).find()){
                  token = stem;
                  doStep1bb = true;
              }
          }
      // step 1b*, only if the 1b.2 or 1b.3 were performed.
      if (doStep1bb) {
         if (token.endsWith("at") || token.endsWith("bl")
          || token.endsWith("iz")) {

            token = token + "e";
         }
         // use the regex patterns you wrote for 1b*.4 and 1b*.5
      }

      // step 1c
      // program this step. test the suffix of 'y' first, then test the 
      // condition *v* on the stem.


      
      
      
      

      // step 2
      // program this step. for each suffix, see if the token ends in the 
      // suffix. 
      //    * if it does, extract the stem, and do NOT test any other suffix.
      //    * take the stem and make sure it has m > 0.
      //        * if it does, complete the step and do not test any others.
      //          if it does not, attempt the next suffix.

      // you may want to write a helper method for this. a matrix of
      // "suffix"/"replacement" pairs might be helpful. It could look like
      // string[][] step2pairs = {  new string[] {"ational", "ate"}, 
      //										new string[] {"tional", "tion"}, ....
      

      


      // step 3
      // program this step. the rules are identical to step 2 and you can use
      // the same helper method. you may also want a matrix here.
      



      // step 4
      // program this step similar to step 2/3, except now the stem must have
      // measure > 1.
      // note that ION should only be removed if the suffix is SION or TION, 
      // which would leave the S or T.
      // as before, if one suffix matches, do not try any others even if the 
      // stem does not have measure > 1.
      



      // step 5
      // program this step. you have a regex for m=1 and for "Cvc", which
      // you can use to see if m=1 and NOT Cvc.
      // all your code should change the variable token, which represents
      // the stemmed term for the token.
      return token;
   }
}