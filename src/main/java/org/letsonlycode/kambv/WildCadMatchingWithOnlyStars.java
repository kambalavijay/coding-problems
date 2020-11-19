package org.letsonlycode.kambv;

public class WildCadMatchingWithOnlyStars {

    public static void main(String[] args) {

        String pattern = "a*bc*d";
        String str = "abcd";
        /*String pattern = "ab*d";
        String str = "abd";*/

        int i = 0, j = 0;
        boolean isMatch = true;

        while (i < pattern.length() && j < str.length()){
            if(pattern.charAt(i) == str.charAt(j)){
                i++;
                j++;
                continue;
            }
            else if(pattern.charAt(i) == '*'){
                i++;
                if(pattern.charAt(i) == str.charAt(j)){
                    j++;
                    i++;
                    while(j < str.length() && str.charAt(j) == str.charAt(j-1)){
                        j++;
                    }
                }
                // if it is not matching with char after * then it means it is matching with the *
                else if(pattern.charAt(i) != str.charAt(j)){
                    j++;
                    while(j < str.length() && str.charAt(j) == str.charAt(j-1)){
                        j++;
                    }
                    if(str.charAt(j) != pattern.charAt(i)){
                        isMatch = false;
                        break;
                    }
                    else{
                        i++;
                        j++;
                    }
                }
            }
            else{
                isMatch = false;
                break;
            }
        }

        if(pattern.length() - i > 0)  {
            isMatch = false;
        }
        System.out.println(isMatch);
    }

}
