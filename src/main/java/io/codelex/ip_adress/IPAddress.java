package io.codelex.ip_adress;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

//
public class IPAddress {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter IP address to:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String IPRawData = getIPAddress(input);

        JSONObject ipAddressObject = new JSONObject(IPRawData);
        if (ipAddressObject.get("status").equals("fail")) {
            System.out.println("Invalid IP Address");
        } else {
            System.out.println("Country of origin for the IP address is " + ipAddressObject.get("country"));
        }
        System.out.println();
    }

    public static String getIPAddress(String ipAddress) throws IOException {
        String theURL = "http://ip-api.com/json/" + ipAddress;
        URL url = new URL(theURL);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder inputData = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            inputData.append(inputLine);
        }

        return inputData.toString();
    }
}
