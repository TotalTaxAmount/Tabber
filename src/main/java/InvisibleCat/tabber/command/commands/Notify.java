package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import javax.print.DocFlavor;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Notify implements Command {
    private String displayMessage;
    private String extra;

    public Notify(String displayMessage) {
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

        try {
            displayTray(args.get(2), args.get(0).replace("!" + args.get(1) +" "+ args.get(2), ""));
            extra = "Sent notification lol";
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
    public void displayTray(String title, String msg) throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = null;
        try {
            image = Toolkit.getDefaultToolkit().createImage(new URL("https://github.com/austingreco/ImageListPreference/blob/master/images/screenshot2.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        TrayIcon trayIcon = new TrayIcon(image, "FBI");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Joe Biden");
        trayIcon.displayMessage(title, msg, TrayIcon.MessageType.WARNING);

        tray.add(trayIcon);


    }
}
