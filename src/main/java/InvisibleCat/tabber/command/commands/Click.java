package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Click implements Command {
    private final String displayMessage;
    String extra;
    private Robot robot;
    private int times = 1, delay = 100;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public Click(String displayMessage) {
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

    private void click(String button, int delay) throws InterruptedException {
        if (button.equalsIgnoreCase("l")) {
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
            robot.delay(delay);
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

        }
        if (button.equalsIgnoreCase("r")) {
            robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
            robot.delay(delay);
            robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
        }
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        if(App.findRole(author, "bitch") != null && App.findRole(author, "bitch").getName().equalsIgnoreCase("bitch")) {
            extra = "`Error`: Anit-bitch protection has been triggered. So nice try mf";
            return;
        }
        if(args.get(2) == null || (!args.get(2).equalsIgnoreCase("l")) && !args.get(2).equalsIgnoreCase("r")) {
            extra = "You need to specify what you want to do or you stupid and put the wrong shit. Example `!click send r`";
            return;
        }

        try {
            if (args.get(3) != null) {
                if(Integer.parseInt(args.get(3)) > 2000) {
                    extra = "Times must not be larger than 2000 because I am to lazy to code it well";
                    return;
                }
            times = Integer.parseInt(args.get(3));
            }
            if (args.get(4) != null) {
                if(Integer.parseInt(args.get(4)) > 500 && times >= 100) {
                    extra = "Stop being a bitch boi and make a shorter delay or less amount of clicks";
                    return;
                }
                delay = Integer.parseInt(args.get(4));
            }
            for(int i = 0; i < times; i++) {
                click(args.get(2), delay);
                extra = "Sent button " + args.get(2).toUpperCase() + ", " + times + " times. With a delay of " + delay;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
