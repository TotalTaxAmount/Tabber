package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Stop implements Command {

    public Stop() {

    }

    @Override
    public String extraMessage() {
        return null;
    }

    @Override
    public String displayMessage() {
        return "Shutting Down on **" + App.getInfo() + "** in 3 seconds";
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message)  {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
