package InvisibleCat.tabber.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;

public interface Command {
    String extraMessage();
    String displayMessage();
    void run(ArrayList<String> args, Member author, Message message);
}
