package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class KeySender implements Command {
    private String extra;
    private Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String extraMessage() {
        return extra;
    }

    @Override
    public String displayMessage() {
        return "Keystroke sender for: " + App.getInfo();
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        if(App.findRole(author, "bitch") != null && App.findRole(author, "bitch").getName().equalsIgnoreCase("bitch")) {
            extra = "`Error`: Anit-bitch protection has been triggered. So nice try mf";
            return;
        }
        String key = args.get(2);
        int pressedCount = 1;
        long delay = 100;

        if (args.get(2) == null) {
            extra = "A key must be in the input field: Example ```!sendkey e``` ";
            return;
        } if(args.get(2).equalsIgnoreCase("enter")) {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            extra = "Enter key has been sent";
            return;
        }
        if (args.get(3) != null) {
            pressedCount = Integer.parseInt(args.get(3));
        }
        if (args.get(4) != null) {
            delay = Integer.parseInt(args.get(4));
        }

        for (int i = 0; i < pressedCount; i++) {
            writeString(key, delay);
        }
        extra = "Key/word *" + key + "* has been sent " + pressedCount + " times to `" + App.getInfo() + "`";
    }

    private void writeString(String s, long delay) {
        try {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isUpperCase(c)) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(Character.toUpperCase(c));
                TimeUnit.MILLISECONDS.sleep(4);
                robot.keyRelease(Character.toUpperCase(c));

                if (Character.isUpperCase(c)) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
            }
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


