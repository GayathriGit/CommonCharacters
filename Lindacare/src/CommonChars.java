
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 

public class CommonChars { 
public static void main(String[] args) { 
String[] strArray = new String[]{"String","Strong"};
char[] ch = getCommonCharacters(strArray); 
System.out.println("common chracter are"); 
for(char c : ch){ 
System.out.print(c); 
} 
} 

private static char[] getCommonCharacters(String[] strArray) { 
Map<Character,Integer[]> outputMap = new HashMap<Character,Integer[]>(); 
List<Character> li = new ArrayList<Character>(); 
for(int i=0;i<strArray.length;i++){ 
String str = strArray[i]; 
char[] chA = str.toCharArray(); 
List<Character> list = new ArrayList<Character>(); 
for(char ch : chA){ 
if(list.contains(ch)) 
continue; 
list.add(ch); 
if(outputMap.get(ch) == null){ 
Integer[] intAr = new Integer[strArray.length]; 
for(int r =0;r<intAr.length;r++){ 
intAr[r] = -1; 
} 
intAr[0] = i; 
outputMap.put(ch, intAr); 
} 
else{ 
Integer[] objArr = outputMap.get(ch); 
objArr[i] = i; 
} 
} 
} 
for(Map.Entry<Character, Integer[]> entry: outputMap.entrySet()){ 
boolean isCommon = true; 
for(Integer integer : entry.getValue()){ 
if(integer.intValue() ==-1){ 
isCommon = false; 
break; 
} 
} 
if(isCommon){ 
li.add(entry.getKey()); 
} 
} 
char[] ch = new char[li.size()]; 
int w=0; 
for(Character c : li){ 
ch[w] = li.get(w++); 
} 
return ch; 
} 
}