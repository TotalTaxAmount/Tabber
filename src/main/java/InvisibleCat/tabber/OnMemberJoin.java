package InvisibleCat.tabber;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OnMemberJoin extends ListenerAdapter {
    private ArrayList<Long> ids = new ArrayList<>();

    public void config() {
        ids.add(715258506005053491L);
        ids.add(450334076419833859L);
        ids.add(782425201190371378L);
//        ids.add(695359899852341379L);
        ids.add(810878716019474432L);
        ids.add(816807275716804638L);
    }


    @Override // USE THIS WHEN YOU WANT TO OVERRIDE A METHOD
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Member user = event.getMember();

        JDA client = event.getJDA(); // DO NOT CREATE A NEW JDA INSTANCE EVERY TIME
        checkUser(user);
    }

    public void checkUser(Member user) {
        if (!ids.contains(user.getIdLong())) {
            if(user != App.jda.getSelfUser()) {
                user.getUser().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("You are not allowed to join the server " + user.getUser().getAsMention())).queue();
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.kick("Not allowed to join").queue();
            }
        }
    }
}
