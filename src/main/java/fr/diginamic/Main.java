package fr.diginamic;


import fr.diginamic.mochizukiTools.Params;
import fr.diginamic.mochizukiTools.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Utils.clearConsole();
        Params.welcomePrompt();

        Path path = Paths.get("C:/Users/pc/Downloads/open-food-facts.csv");
        Path destination = Paths.get("C:/Users/pc/Downloads/open-food-facts-clean.csv");


        Integer iteration = 0;
        String[] dataSource = new String[30];
        HashMap<String, String> dictSourceData = new HashMap<>();
        HashMap<Integer, HashMap<String, String>> data = new HashMap<>();

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        Iterator<String> iter = lines.iterator();
        String entete = iter.next();
        String enteteClean = entete.replace(";", "").replace("|", ";");
        String[] splitEntete = enteteClean.split(";");

        Set<String> listeIngredients = new HashSet<>();
        Set<String> additifs = new HashSet<>();

        while (iter.hasNext()) {
            iteration++;
            String line = iter.next();
            String line1 = line.replace(";", "").replace("|", ";");
            String[] lineSplit = line1.split(";", 30);
            for (int i = 0; i < lineSplit.length; i++) {
                String s = lineSplit[i].toLowerCase();
                if(s.contains("%") || s.contains("_")){
                    s.replace("_", "");
                }
                if(i == 4){
                    s = s.replaceAll("([0-9]).*%", "");
                    s = s.replace(".", "");
                    s = s.replace("_", "");
                    s = s.replace("*", "");
                    s = s.replace("]", "");
                    s = s.replace("[", "");
                    s = s.replaceAll(".-.+.:.", ",");
                    String[] splitS = s.split(",");
                    for (String s1: splitS){
                        s1 = s1.trim();
                        if(s1.contains("conservateur")){
                            additifs.add(s1);
                        }
                        listeIngredients.add(s1);
                    }
                }
                if(s.equals("")){
                    s = "null";
                }
                lineSplit[i] = s;
            }
//            System.out.println(Arrays.toString(lineSplit));
//            System.out.println(lineSplit.length);
        }
        listeIngredients.forEach(System.out::println);
//        additifs.forEach(System.out::println);
//            for (int i = 0; i < splitEntete.length; i++) {
//                String s = splitFirstLine[i];
//                dataSource[i] = s;
//            }
//            for (int i = 0; i < splitEntete.length; i++) {
//                dictSourceData.put(splitEntete[i], dataSource[i]);
//            }
//            data.put(iteration, dictSourceData);
//            iteration++;

//        for (int i = 0; i < data.size(); i++) {
//            System.out.println(data.get(i));
//        }

    }
}