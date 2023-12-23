import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.next();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            Map<String, Integer> votes = new TreeMap<>();
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");

                if(votes.containsKey(fields[0])){
                    int votesSoFar = votes.get(fields[0]);
                    votes.put(fields[0], Integer.valueOf(fields[1]) + votesSoFar);
                }else{
                    votes.put(fields[0], Integer.valueOf(fields[1]));
                }
                line = br.readLine();
            }
            for (String key: votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}