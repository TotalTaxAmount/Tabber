package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;
import java.util.ArrayList;

public class Tab implements Command {

    private final String displayMessage;
    private final Robot robot;
    private String extra;


    public Tab(String displayMessage) throws AWTException {
        this.displayMessage = displayMessage;
        this.robot = new Robot();
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
        robot.keyPress(18);
        robot.keyPress(9);
        robot.keyRelease(18);
        robot.keyRelease(9);
    }
}
