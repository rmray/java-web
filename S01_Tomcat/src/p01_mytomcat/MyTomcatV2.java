package p01_mytomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现简单的 Tomcat
 */
public class MyTomcatV2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (!serverSocket.isClosed()) {
            System.out.println("Socket is running at 8080...");
            Socket socket = serverSocket.accept();

            // 1. 读取请求报文
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                System.out.println(line);
            }

            // 2. 添加 HTTP/1.1 响应头和内容
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C01_Tomcat/src/p01_mytomcat/hello.html"));
            String buf = "";
            String line2;
            while ((line2 = bufferedReader.readLine()) != null) {
                buf += line2 + "\n";
            }
            byte[] body = buf.getBytes();
            String head = """
                    HTTP/1.1 200 OK
                    Content-Type: text/html;charset=utf-8
                    Content-Length: %d
                    Content:close
                    
                    """.formatted(body.length);

            // 3. 写入响应
            OutputStream out = socket.getOutputStream();
            out.write(head.getBytes());
            out.write(body);
            out.flush();

            bufferedReader.close();
            socket.shutdownOutput();
            socket.close();
        }
        serverSocket.close();
    }
}
