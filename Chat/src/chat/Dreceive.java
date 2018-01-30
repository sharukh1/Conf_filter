/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inspiron
 */
public class Dreceive {

    static String str = "1";
    static byte[] b = new byte[1024];

    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket(3000);System.out.println("client started");
            while (!str.equals("0")) {
                DatagramPacket dp = new DatagramPacket(b, 1024);
                ds.receive(dp);
                str = new String(dp.getData(), 0, dp.getLength());
                 System.out.print("received->");System.out.print(str);System.out.println("");
            }
            ds.close();
        } catch (SocketException ex) {
            Logger.getLogger(Dreceive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dreceive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
