import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpClient {
    public static void main(String[] args){

        try{
            String serverIp = "127.0.0.1";

            System.out.println(getTime() + "서버에 연결중입니다. 서버 IP :" + serverIp);
            // 소켓을 생성하여 연결을 요청합니다.
            Socket socket = new Socket(serverIp, 7777);

            // 소켓의 입력 스트림을 얻습니다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 소켓으로부터 받은 데이터를 출력
            System.out.println(getTime() + "서버로부터 받은 메시지 :"+dis.readUTF());
            System.out.println(getTime() + "연결을 종료합니다.");

            // 스트림과 소켓을 닫습니다.
            dis.close();
            socket.close();
            System.out.println(getTime() + "연결이 종료되었습니다.");
        } catch(ConnectException ce){
            ce.printStackTrace();
        } catch(IOException ie){
            ie.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    static String getTime(){
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
