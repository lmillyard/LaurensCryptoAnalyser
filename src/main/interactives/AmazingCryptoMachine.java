package main.interactives;

// Implements the Menu class and funnels through to correct option - encrypt/decrypt.

//TODO  Maybe give the option of encrypting a sentence from console as well as a file?
//TODO - could give the options of doing multiple files at once?
public class AmazingCryptoMachine extends Menu{
    private int timesRoundCounter = 0;
    private String contents;
    private String language;


    public void start() {

        while(true) {

            if (timesRoundCounter == 0) {
                welcomeMessage();
                timesRoundCounter++;
            }else {
                welcomeBackMessage();
            }

            // Option 1 = encrypt, Option 2 = decrypt, Option 0 = exit.
            int option = pickAnOption();

            if (option == 0) {
                goodbyeMessage();
                break;
            } else if (option == 1) {
                encrypt();
            } else if (option == 2) {
                decrypt();
            }
        }
    }

    private void welcomeMessage() {
        System.out.println("""
                \t~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                Welcome to the amazing crypto machine!
                \t~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");
    }

    private void welcomeBackMessage(){
        System.out.println("\t\tWelcome back!");
    }

    private void goodbyeMessage() {
        System.out.println("\tThank you and goodbye!");
    }

    private void encrypt() {
        contents = pickAFile();
        int offset = pickAnOffset();
        encrypt(contents, offset);
    }

    private void decrypt() {
        contents = pickAFile();
        language = pickALanguage();
        decrypt(contents, language);
    }
}
