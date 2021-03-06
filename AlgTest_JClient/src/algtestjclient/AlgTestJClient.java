/*  
    Copyright (c) 2008-2012 Petr Svenda <petr@svenda.com>

     LICENSE TERMS

     The free distribution and use of this software in both source and binary
     form is allowed (with or without changes) provided that:

       1. distributions of this source code include the above copyright
          notice, this list of conditions and the following disclaimer;

       2. distributions in binary form include the above copyright
          notice, this list of conditions and the following disclaimer
          in the documentation and/or other associated materials;

       3. the copyright holder's name is not used to endorse products
          built using this software without specific written permission.

     ALTERNATIVELY, provided that this notice is retained in full, this product
     may be distributed under the terms of the GNU General Public License (GPL),
     in which case the provisions of the GPL apply INSTEAD OF those given above.

     DISCLAIMER

     This software is provided 'as is' with no explicit or implied warranties
     in respect of its properties, including, but not limited to, correctness
     and/or fitness for purpose.

    Please, report any bugs to author <petr@svenda.com>
/**/

package algtestjclient;

import java.io.*;

/**
 *
 * @author petr
 */
public class AlgTestJClient {

    static CardMngr cardManager = new CardMngr();

    public final static int STAT_OK = 0;    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            

            StringBuilder atr = new StringBuilder(); 
            StringBuilder reader = new StringBuilder();
            StringBuilder protocol = new StringBuilder();
            
            
            // Find first card with AlgTest applet and connect
            if (cardManager.ConnectToCard(reader, atr, protocol)) {
               
                String message = "";
                String fileName = "AlgTest_" + atr + ".csv";
                fileName = fileName.replace(":", "");

                FileOutputStream file = new FileOutputStream(fileName);
                

                message += "Used reader; " + reader + "\n";
                System.out.println(message);
                file.write(message.getBytes());
                message = "Card ATR; " + atr + "\n";
                System.out.println(message);
                file.write(message.getBytes());
                message = "Used protocol; " + protocol + "\n";
                System.out.println(message);
                file.write(message.getBytes());
                

                StringBuilder value = new StringBuilder();
                System.out.println("\n\n#########################");
                System.out.println("\nJCSystem information");

                if (cardManager.GetJCSystemInfo(value, file) == CardMngr.STAT_OK) {}
                else { System.out.println("\nERROR: GetJCSystemInfo fail"); }


                System.out.println("\n\n#########################");
                System.out.println("\n\nQ: Do you like to test supported algorithms?");
                System.out.println("Type 1 for yes, 0 for no: ");	
                int	answ = Integer.decode(br.readLine());                
                if (answ == 1) {

                        System.out.println("#########################");

                        // Class javacardx.crypto.Cipher
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_CIPHER, CardMngr.CIPHER_STR, value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacardx.crypto.Cipher fail\n"); }
                        file.flush();

                        // Class javacard.security.Signature
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_SIGNATURE, CardMngr.SIGNATURE_STR, value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: jav1acard.security.Signature fail\n"); }
                        file.flush();

                        // Class javacard.security.MessageDigest
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_MESSAGEDIGEST, CardMngr.MESSAGEDIGEST_STR, value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.MessageDigest fail\n"); }
                        file.flush();

                        // Class javacard.security.RandomData
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_RANDOMDATA, CardMngr.RANDOMDATA_STR, value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.RandomData fail\n"); }
                        file.flush();

                        // Class javacard.security.KeyBuilder
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_KEYBUILDER, CardMngr.KEYBUILDER_STR, value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.KeyBuilder fail\n"); }
                        file.flush();

                        // Class javacard.security.KeyPair RSA
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_KEYPAIR_RSA, CardMngr.KEYPAIR_RSA_STR, value, file, CardMngr.CLASS_KEYPAIR_RSA_P2) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.KeyPair RSA fail\n"); }
                        file.flush();
                        // Class javacard.security.KeyPair RSA_CRT
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_KEYPAIR_RSA_CRT, CardMngr.KEYPAIR_RSACRT_STR, value, file, CardMngr.CLASS_KEYPAIR_RSACRT_P2) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.KeyPair RSA_CRT fail\n"); }
                        file.flush();
                        // Class javacard.security.KeyPair DSA
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_KEYPAIR_DSA, CardMngr.KEYPAIR_DSA_STR, value, file, CardMngr.CLASS_KEYPAIR_DSA_P2) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.KeyPair DSA fail\n"); }
                        file.flush();
                        // Class javacard.security.KeyPair EC_F2M
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_KEYPAIR_EC_F2M, CardMngr.KEYPAIR_EC_F2M_STR, value, file,  CardMngr.CLASS_KEYPAIR_EC_F2M_P2) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.KeyPair EC_F2M fail\n"); }
                        file.flush();
                        // Class javacard.security.KeyPair EC_FP
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_KEYPAIR_EC_FP, CardMngr.KEYPAIR_EC_FP_STR, value, file, CardMngr.CLASS_KEYPAIR_EC_FP_P2) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.KeyPair EC_FP fail\n"); }
                        file.flush();

                        // Class javacard.security.KeyAgreement
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_KEYAGREEMENT, CardMngr.KEYAGREEMENT_STR, value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.KeyAgreement fail\n"); }
                        file.flush();

                        // Class javacard.security.Checksum
                        value.setLength(0);
                        if (cardManager.GetSupportedAndParse(CardMngr.CLASS_CHECKSUM, CardMngr.CHECKSUM_STR, value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: javacard.security.Checksum fail\n"); }
                        file.flush();
                }

                System.out.println("\n\n#########################");
                System.out.println("\n\nQ: Do you like to test support for variable RSA public exponent?");
                System.out.println("Type 1 for yes, 0 for no: ");	
                answ = Integer.decode(br.readLine());                
                if (answ == 1) {
                        // Variable public exponent
                        value.setLength(0);
                        if (cardManager.TestVariableRSAPublicExponentSupport(value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: Test variable public exponnet support fail\n"); }
                        file.flush();
                }

                System.out.println("\n\n#########################");
                System.out.println("\n\nQ: Do you like to test RAM memory available for allocation?");
                System.out.println("\n\nSTRONG WARNING: There is possibility that your card become unresponsive after this test. All cards I tested required just to delete AlgTest applet to reclaim allocated memory. But it might be possible that your card will be unusuable after this test.?");
                System.out.println("\n\nWARNING: Your card should be free from other applets - otherwise memory already claimed by existing applets will not be included. Value is approximate +- 100B");
                System.out.println("Type 1 for yes, 0 for no: ");	
                answ = Integer.decode(br.readLine());                
                if (answ == 1) {                    
                        // Available memory
                        value.setLength(0);
                        if (cardManager.TestAvailableRAMMemory(value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: Get available RAM memory fail\n"); }
                        file.flush();
                }

                System.out.println("\n\n#########################");
                System.out.println("\n\nQ: Do you like to test EEPROM memory available for allocation?");
                System.out.println("\n\nSTRONG WARNING: There is possibility that your card become unresponsive after this test. All cards I tested required just to delete AlgTest applet to reclaim allocated memory. But it might be possible that your card will be unusuable after this test.");
                System.out.println("\n\nWARNING: Your card should be free from other applets - otherwise memory already claimed by existing applets will not be included. Value is approximate +- 5KB");
                System.out.println("Type 1 for yes, 0 for no: ");	
                answ = Integer.decode(br.readLine());                
                if (answ == 1) {
                        // Available memory
                        value.setLength(0);
                        if (cardManager.TestAvailableEEPROMMemory(value, file, (byte) 0) == STAT_OK) {}
                        else { System.out.println("\nERROR: Get available EEPROM memory fail\n"); }
                        file.flush();
                }
                
                file.close();

                cardManager.DisconnectFromCard();
            }
            else { System.out.println("\nERROR: fail to connect to card with AlgTest applet"); }

        } 
        catch (IOException ex) {
            System.out.println("IOException : " + ex);
        }
        catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
}
