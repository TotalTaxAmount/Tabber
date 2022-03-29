package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Auto implements Command {

    private final String displayMessage;
    public String extra;
    private final Tab tab = new Tab("Auto tabbed " + App.getInfo());
    public static boolean autoEnabled = false;
    private AutoThread autoThread;
    private int delayMin = 60, delayMax = 300;


    public Auto(String displayMessage) throws AWTException {
        this.displayMessage = displayMessage;
        this.extra = null;
        this.autoThread = new AutoThread();
        autoThread.start();


    }
    private class AutoThread extends Thread {

        private volatile boolean cancel = false;
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                if(!cancel) {
                    int delay = random.nextInt(delayMin, delayMax);
                    try {
                        TimeUnit.SECONDS.sleep(delay);
                    } catch (InterruptedException e) {
                        extra = "```" + e + "```";
                        return;
                    }
                    tab.run(null, null, null);
                }
            }
        }

        public void tabGo() {
            cancel = false;
        }
        public void cancel() {
            cancel = true;
        }
    }

    public void doAuto(ArrayList<String> arg) {
        if(arg.get(2).equalsIgnoreCase("on")) {
            autoEnabled = true;
            extra = "Auto tab enabled for ``" + App.getInfo() + "``";
            this.autoThread.tabGo();
        } else if (arg.get(2).equalsIgnoreCase("off")) {
            autoEnabled = false;
            extra = "Auto tab disabled for ``" + App.getInfo() + "``";
            this.autoThread.cancel();
        } else if (arg.get(2).equalsIgnoreCase("status")) {
            extra = "Auto tab enabled for " + App.getInfo() + ": " + autoEnabled;
        } else if (arg.get(2).equalsIgnoreCase("delay")) {
            if(arg.get(3) == null || arg.get(4) == null) {
                extra = "You need to input a minimum and maximum value";
                return;
            }
            delayMax = Integer.parseInt(arg.get(4));
            delayMin = Integer.parseInt(arg.get(3));
            extra = "Success delay set to " + delayMin + " and " + delayMax;

        }

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
    public void run(ArrayList<String> args, Member author   , Message message) {
        if(App.findRole(author, "bitch") != null && App.findRole(author, "bitch").getName().equalsIgnoreCase("bitch")) {
            extra = "`Error`: Anit-bitch protection has been triggered. So nice try mf";
            return;
        }
        extra = "";
        doAuto(args);
    }
}
