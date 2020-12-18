package org.decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Word {

    private ArrayList<String> words;
    private String secret;

    private Character[] associated;
    private ArrayList<String[]> secretsWords;

    private String[] decrypt;
    private String special="#";
    private int sizeAlfa=44;

    private int[] ts;

    public void setWords(String file){
        words = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while(true){
                line = br.readLine();
                if(line!=null){
                    words.add(line);
                }else{
                    break;
                }
            }
            while(line!=null){
                words.add(line);
                line = br.readLine();
            }
        }catch(Exception e){
            System.out.println("Error on load file "+file);
        }
    }

    public ArrayList<String> getWords(){
        return words;
    }

    public void setSecret(String file){
        secret="";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while(true){
                line = br.readLine();
                if(line!=null){
                    secret = secret + line+special;;
                }else{
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Error on load file "+file);
        }
    }

    public void setAssociated(){
        associated = new Character[sizeAlfa];
        for (int i = 0; i<26;i++){
            associated[i]=(char)(i+65);
        }
        associated[26]='.';
        associated[27]=',';
        associated[28]=';';
        associated[29]='!';
        associated[30]='?';
        associated[31]='Ã';
        associated[32]='ƒ';
        associated[33]='€';
        associated[34]='‚';
        associated[35]='‰';
        associated[36]='Š';
        associated[37]='?';
        associated[38]='“';
        associated[39]='•';
        associated[40]='”';
        associated[41]='š';
        associated[42]='œ';
        associated[43]='‡';
    }

    public String getSecret() {
        return secret;
    }

    public Character[] getAssociated() {
        return associated;
    }

    public void setAssociated(Character[] associated) {
        this.associated = associated;
    }

    public String makeKey(int key, String message){
        String result="";
        Character charPos='\0';
        int pos=0;
        for (int i=0;i<message.length();i++){
            charPos=message.charAt(i);
            for (int j=0; j<associated.length;j++){
                if(charPos.equals(associated[j])){
                    pos=j+key;
                    if(pos>=sizeAlfa){
                        pos-=sizeAlfa;
                    }
                    result=result+associated[pos];
                }
            }
        }
        return result;
    }

    public ArrayList<String[]> makekey0to5(){
        secretsWords = new ArrayList<String[]>();
        String[] secretWords = getSecret().split(special);
        String[] line;
        for (int i=0;i<5;i++){
            line = new String[secretWords.length];
            for (int j=0;j<secretWords.length;j++){
                line[j] = makeKey(i,secretWords[j]);
            }
            secretsWords.add(line);
        }
        return secretsWords;
    }

    public ArrayList<String[]> makekey0to44(){
        secretsWords = new ArrayList<String[]>();
        String[] secretWords = getSecret().split(special);
        String[] line;
        for (int i=0;i<sizeAlfa;i++){
            line = new String[secretWords.length];
            for (int j=0;j<secretWords.length;j++){
                line[j] = makeKey(i,secretWords[j]);
            }
            secretsWords.add(line);
        }
        return secretsWords;
    }

    public String[] makekeyx(int x){
        String[] secretWords = getSecret().split(special);
        String[] line;
        line = new String[secretWords.length];
        for (int j=0;j<secretWords.length;j++){
            line[j] = makeKey(x,secretWords[j]);
        }
        return line;
    }

    public String getDecrypt() {
        String temp="";
        for (String a: decrypt) {
            temp+=a+" ";
        }
        return temp;
    }

    public int[] countMatch(){
        ts = new int[secretsWords.size()];
        for (int i=0; i<secretsWords.size(); i++){
            for (int j=0;j<secretsWords.get(i).length;j++){
                System.out.print(secretsWords.get(i)[j]);
                System.out.print("#");
                if(words.contains(secretsWords.get(i)[j].toLowerCase())){
                    ts[i]++;
                }
            }
        }
        return ts;

    }

    public int biggerCount(){
        int m=0;
        int position=0;
        for(int i=0;i<ts.length;i++){
            if(ts[i]>m){
                m=ts[i];
                position=i;
            }
        }
        return position;
    }

}
