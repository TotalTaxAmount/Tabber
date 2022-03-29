package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;

public class NoOp implements Command {

    @Override
    public String extraMessage() {
        return null;
    }

    @Override
    public String displayMessage() {
        return "This command does not exist";
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        if(author.getUser().getId().equalsIgnoreCase(String.valueOf(695359899852341379L))) {
            author.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("Lucse ur stupid. sml pp")).queue();
            Kick kick = new Kick();
            kick.run(args, author, message);
            return;
        }
        author.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("bad stupid")).queue();

    }

}
