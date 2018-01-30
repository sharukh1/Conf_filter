/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inspiron
 */
public class Dsender {

    static DatagramSocket ds;
    static String str = "1";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("sender ready");
        while (!str.equals("0")) {
            try {
                System.out.print("send->");
                str = sc.next();
                ds = new DatagramSocket();
                InetAddress ip = InetAddress.getLocalHost();
                DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
                ds.send(dp);

            } catch (SocketException ex) {
                Logger.getLogger(Dsender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Dsender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dsender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ds.close();
    }
}
