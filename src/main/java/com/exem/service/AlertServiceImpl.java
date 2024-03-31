package com.exem.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem.dao.DustDao;
import com.exem.dto.SelectAlertRecord;

@Service
public class AlertServiceImpl implements AlertService {

   @Autowired
   private DustDao dustDao;

   private static final int PORT = 5000; // server port 설정

   private static final String SERVER_ADDRESS = "127.0.0.1"; //

   private static final int SERVER_PORT = 5000;


   @Override
   public void server() {
	   /*
      List<SelectAlertRecord> list = dustDao.selectAlertRecord();

      List<String> alertMessages = new ArrayList<>();

      for (SelectAlertRecord dto : list) {
         String stationName = dto.getMeasurement_station_name();
         String alertLevel = dto.getAlert_level();
         String alertTime = dto.getMeasurement_time();
         //String.format(alertTime, "");

         alertMessages.add(stationName + "\t" + alertTime + "\t" + alertLevel);
      }
*/      
      ServerSocket server = null;
      Socket socket = null;
      
      try {
			server = new ServerSocket(501); // AS CENTER
			System.out.println("[SERVER] 1. 통신사 OPEN");
			socket = server.accept();
			System.out.println("[SERVER] 2. 상담사가 준비중입니다.");
			// 말하기
			Sender sender = new Sender(socket);
			sender.start();
			// 듣기
			Receiver receiver = new Receiver(socket);
			receiver.start();
			// 3. 데이터 주고-받기
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("[SERVER 종료]");
			if(!server.isClosed()) {
				try {
					server.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}//end isClosed
		}//end catch
      
      
     /* try (ServerSocket serverSocket = new ServerSocket(PORT)) {
         System.out.println("서버가 시작되었습니다." + PORT);

         while (true) {
             try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client 연결 ! : " + clientSocket.getInetAddress());

                // 클라이언트에게 메시지 보내기
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out.println("경보 알림 서비스입니다. 경보 알림을 받아보시겠습니까? (Y/N)");
                String response = in.readLine();

                if (response != null && (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes"))) {
                   System.out.println("클라이언트가 경보 알림 수신에 동의했습니다.");

                   Sender sender = new Sender(clientSocket, alertMessages);
                   sender.start();

                   Receiver receiver = new Receiver(clientSocket);
                   receiver.start();
                } else {
                   System.out.println("클라이언트가 경보 알림 수신에 동의하지 않았습니다.");
                   out.println("경보 알림 수신에 동의하지 않았습니다. 연결을 종료합니다.");
                   clientSocket.close();
                }
             } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
             }
          }
      } catch (IOException e) {
         System.out.println("Server exception: " + e.getMessage());
         e.printStackTrace();
      } */
   }

   @Override
   public void client() {
	   Socket socket = null;
	   
	   try {
			socket=new Socket("127.0.0.1", 501);
			System.out.println("[CLIENT] 3. AS CENTER - 연결함");
			// 말하기
			Sender sender = new Sender(socket);
			sender.start();
			// 듣기
			Receiver receiver = new Receiver(socket);
			receiver.start();
			// 3. 데이터 주고-받기
		} catch (IOException e) {
			
			//e.printStackTrace();
		}
	   
   }

   
}


class Sender extends Thread {
   private DataOutputStream out;
   private Socket socket;
   private String who;

   SimpleDateFormat df; 
	public Sender() {
		this.df=new SimpleDateFormat("hh-mm-ss");
	}

	public Sender(Socket socket) { // 상대방 정보
		this();
		this.who = "[" + (socket.getPort()==501?"CLIENT ":"SERVER ");
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (out != null) {
				// STEP 1. 내가말하기
				String data = in.readLine();
				if(data!=null) {
					// STEP 2. 말한것을 전송
					out.writeUTF(who+df.format(System.currentTimeMillis())+"]"+ data);
					// 힌트4) who+df.format(System.currentTimeMills()) 추가
					out.flush();
				} else {
					out.writeUTF("\n"+who+" 1:1 상담을 종료합니다. >> 채팅방 OUT "+socket);
					System.out.println("1:1상담을 종료합니다 >> 채팅방 OUT.");
					break;
				}
			} // end while
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Receiver extends Thread {
   private DataInputStream in;
   private Socket socket;

   public Receiver() {
	}

	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (in != null) {
				System.out.println(in.readUTF());
			}
		} catch (Exception e) {
			//e.printStackTrace();
			//System.out.println(socket   +"...............");
			System.out.println((socket.getPort()!=501? "CLIENT ":"SERVER " )+"통신을 마무리합니다 >> 채팅방 OUT\n"+socket);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (socket != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
