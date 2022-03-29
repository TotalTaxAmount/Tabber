package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;
import java.util.ArrayList;

public class MouseMove implements Command {
    private String extra;
    private String displayMessage;

    private Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public MouseMove(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    @Override
    public String extraMessage() {
        return extra;
    }

    @Override
    public String displayMessage() {
        return this.displayMessage;
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        if(App.findRole(author, "bitch") != null && App.findRole(author, "bitch").getName().equalsIgnoreCase("bitch")) {
            extra = "`Error`: Anit-bitch protection has been triggered. So nice try mf";
            return;
        }
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        if(args.get(2).equalsIgnoreCase("pos") || args.get(2).equalsIgnoreCase("position")) {
            extra = "Current mouse cords are: " + x + ", " + y;
            return;
        }
        if(args.get(2) == null || args.get(3) == null) {
            extra = "You are missing arguments. Example [!mouse 50 50]";
            return;
        }

        robot.mouseMove(Integer.parseInt(args.get(2)), Integer.parseInt(args.get(3)));
        extra = "Mouse successfully set to cords: " + Integer.parseInt(args.get(2)) + ", " + Integer.parseInt(args.get(3));

    }
}
