package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Kick implements Command {
    private String extra;


    @Override
    public String extraMessage() {
        return extra;
    }

    @Override
    public String displayMessage() {
        return "Bozo...";
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        extra = "Kicking " + author.getEffectiveName() + "...";
        author.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("YOUR A BOZO LLLLLL " + "<@"+author.getId()+">" + "trash gay ni...")).queue();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        author.kick("Bozo").reason("Lol ur stupid nerd").queue();
    }
}
