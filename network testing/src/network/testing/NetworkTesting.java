/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package network.testing;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author planet
 */
public class NetworkTesting {
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try
        {
            // Socket لإستقبال أي إتصال من قبل المستخدم, أي لإستقبال أي ServerSocket هنا قمنا بإنشاء كائن من الكلاس
            ServerSocket ss = new ServerSocket(3333);
 
            // آخر Socket يمكنه تبادل الببانات مع أي كائن Socket و التي ترجع كائن نوعه accept() هنا قمنا باستدعاء الدالة
            Socket s = ss.accept();
 
            // s سنستخدمه لقراءة محتوى الكائن dis الكائن
            DataInputStream dis = new DataInputStream(s.getInputStream());
 
            // s سنستخدمه للكتابة في الكائن dos الكائن
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
 
            // سنستخدمه لقراءة البيانات التي سيدخلها السيرفر من لوحة المفاتيح br الكائن
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
            // serverMsg و رسالات السيرفر ستتخزن في المتغير clientMsg رسالات المستخدم ستتخزن في المتغير
            String serverMsg,clientMsg;
 
            // end هنا سيستمر التواصل بين السيرفر و المستخدم طالما أن المستخدم لم يكتب
            do{
                //clientMsg = dis.readUTF();
                //System.out.println("client says: "+ clientMsg);
                serverMsg = br.readLine();
                System.out.println(serverMsg);
                dos.writeUTF(serverMsg);
                dos.flush();
            }
            //while(!clientMsg.equals("end"));
            while(!serverMsg.equals("end"));
            // عند إنتهاء الإتصال قمنا بإغلاق جميع الكائنات التي استخدمناها لإنشاء الإتصال و التي لم يعد لها حاجة
            dis.close();
            s.close();
            ss.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        
        
        
        // TODO code application logic here
    }
    
}
