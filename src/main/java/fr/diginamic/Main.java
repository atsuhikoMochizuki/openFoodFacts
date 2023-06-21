package fr.diginamic;


import fr.diginamic.mochizukiTools.Params;
import fr.diginamic.mochizukiTools.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Utils.clearConsole();
        Params.welcomePrompt();
    }
}