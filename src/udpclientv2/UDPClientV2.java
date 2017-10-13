/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclientv2;

/**
 *
 * @author Asif
 */

import java.net.*;
import java.io.*;

public class UDPClientV2 {

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket socket = new DatagramSocket();
        
        // Sending data to server
        String str = "Hello";
        byte[] buf = str.getBytes();
        //InetAddress ipAddr = InetAddress.getByName("localhost");
        InetAddress ipAddr = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, ipAddr, 2245);
        socket.send(dp);
        
        // Receiving Data
        byte[] bufRcv = new byte[1000];
        DatagramPacket dpRcv = new DatagramPacket(bufRcv, bufRcv.length);
        socket.receive(dpRcv);
        System.out.println(new String(dpRcv.getData()));
    }
    
}
