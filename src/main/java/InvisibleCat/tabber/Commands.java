package InvisibleCat.tabber;

import InvisibleCat.tabber.command.Command;
import InvisibleCat.tabber.command.CommandFactory;
import InvisibleCat.tabber.command.commands.Ip;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commands extends ListenerAdapter {
    public static boolean auto = true;
    public static Event eventMsg;
    private static Pattern word = Pattern.compile("[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+");
    private static final Pattern pattern = Pattern.compile("^!(\\w+)\\s?("+word+")?\\s?("+word+")?\\s?("+word+")?\\s?("+word+")?\\s?("+word+")?\\s?("+word+")?\\s?("+word+")?");
    private CommandFactory factory = new CommandFactory();
    private OnMemberJoin onMemberJoin = new OnMemberJoin();


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Ip ipStuff = new Ip("");
        System.out.println(ipStuff.ipConfig + " omr");
        eventMsg = event;
        User author = event.getAuthor();
        Member user = event.getMember();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();

        String msg = message.getContentDisplay();
        boolean bot = author.isBot();
        if (event.isFromType(ChannelType.TEXT)) {
            Guild guild = event.getGuild();
            TextChannel textChannel = event.getTextChannel();
            Member member = event.getMember();

            String name;
            Matcher matcher = pattern.matcher(msg);
            if (matcher.matches()) {
                ArrayList<String> args = new ArrayList<>();
                for (int j = 0; j <= matcher.groupCount(); j++) {
                    args.add(matcher.group(j));
                }
                String input = args.get(1);

                Command command = null;
                try {
                    command = factory.create(input);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                assert command != null ;
                channel.sendMessage(command.displayMessage()).queue();
                command.run(args, member, message);
                if (command.extraMessage() != null) {
                    if(command.extraMessage().length() > 2000) {
                        channel.sendMessage(command.extraMessage().substring(0, 2000)).queue();
                        return;
                    }
                    channel.sendMessage(command.extraMessage()).queue();

                }


            }
        }
    }//public boolean isAuto() {return auto;}
    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("aaaaS");
        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle( App.getInfo() + " is now online!");
        eb.addField("Help", "If you need help with commands type [!help]", false);
        eb.addField("Info", "Tabber was created so that you could do a bit of trolling on your friends lol, don't be a bitch tho", false);
        eb.setAuthor("[Tabber " + App.version + "]");
        eb.setColor(new Color(0x816DE8));

        java.util.List<TextChannel> channels = App.jda.getTextChannelsByName("online", true);
        for(TextChannel ch : channels)
        {
            ch.sendMessageEmbeds(eb.build()).queue();
        }
    }
}