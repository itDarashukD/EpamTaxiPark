package ui;

import api.ui.IConsolInput;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleInput  implements IConsolInput {

    private final Logger log = Logger.getLogger(ConsoleInput.class.getName());

    public  int consoleInputing() {

        log.info("IN consoleInputing() : reading was started");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int speed = 0;
        try   {

            speed = Integer.parseInt(reader.readLine());

        } catch (IOException e) {

            log.error("IN consoleInputing()" + e.getMessage(), e);
        }

        return speed;
    }

}