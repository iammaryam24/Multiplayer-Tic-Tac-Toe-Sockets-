// TTTClient.java
import java.net.*; import java.io.*; import java.util.*;
public class TTTClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",6000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        Scanner sc = new Scanner(System.in);
        new Thread(() -> { try { String l; while((l=in.readLine())!=null) System.out.println("Other: "+l); } catch(Exception e){} }).start();
        while(true) {
            String send = sc.nextLine();
            out.write(send+"\n"); out.flush();
            if(send.equalsIgnoreCase("quit")) break;
        }
    }
}
