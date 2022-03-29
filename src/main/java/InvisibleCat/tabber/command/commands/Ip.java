package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ip implements Command {

    private final String displayMessage;
    private String extra;
    private final JSONObject jsonData = new JSONObject();
    public boolean ipConfig;


    public Ip(String displayMessage) {
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
        Pattern ipCheck = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = ipCheck.matcher(args.get(2));
        if(!matcher.matches()) {
            extra = args.get(2) + " is not a valid ip!";
            return;
        }
        jsonData.put(author.getEffectiveName(), args.get(2));
        try {
            System.out.println(App.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath());
            FileWriter file = new FileWriter(App.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath() + ".json");
            System.out.println(jsonData);
            file.write(jsonData.toJSONString());
            file.close();
            extra = "Success! ip for user `" + author.getEffectiveName() + "` is now: " + args.get(2);
            if(jsonData.containsKey(author.getEffectiveName())) {
                if(jsonData.get(author.getEffectiveName()).equals(App.getInfo()))
                    ipConfig = true;

            } else {
                ipConfig = false;
                System.out.println(jsonData.get(author.getEffectiveName()));
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
