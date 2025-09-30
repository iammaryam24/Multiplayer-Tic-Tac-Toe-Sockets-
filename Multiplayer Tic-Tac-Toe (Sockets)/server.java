// TTTServer.java
import java.net.*; import java.io.*;
public class TTTServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        System.out.println("Waiting for two players...");
        Socket p1 = ss.accept(); System.out.println("P1 connected");
        Socket p2 = ss.accept(); System.out.println("P2 connected");
        new Thread(new Relay(p1.getInputStream(), p2.getOutputStream())).start();
        new Thread(new Relay(p2.getInputStream(), p1.getOutputStream())).start();
    }
    static class Relay implements Runnable {
        InputStream in; OutputStream out;
        Relay(InputStream in, OutputStream out){this.in=in;this.out=out;}
        public void run(){ try { int b; while((b=in.read())!=-1) out.write(b); } catch(Exception e){ } }
    }
}
