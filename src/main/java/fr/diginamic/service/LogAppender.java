package fr.diginamic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAppender {
    private static final Logger LOG =
            LoggerFactory.getLogger(LogAppender.class);
    public static void executer(String param) {
        LOG.debug("Traitement 1 : param = {}", param);
    }
}
