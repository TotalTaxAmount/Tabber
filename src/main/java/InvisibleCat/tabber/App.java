package InvisibleCat.tabber;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;
import java.util.List;

public class App {
    public static JDA jda;
    public static String version = "11.0.2";


    public static class Bot extends Thread {
        OnMemberJoin whitelist = new OnMemberJoin();

        byte[] decodedBytes = Base64.getDecoder().decode("T0RnM05UTXpOek00TXpFMk1UTTJORFk1LllVRmlOQS5iZDFlMFlORDNCeUpsNjJHQVA2ZEtGQTlUQ1k=");
        String secret = new String(decodedBytes);

        {
            try {
                jda = JDABuilder.createDefault(secret).enableIntents(GatewayIntent.GUILD_MEMBERS).build();
                jda.getPresence().setStatus(OnlineStatus.ONLINE);
                jda.getPresence().setActivity(Activity.playing(getInfo() + " is online"));
                whitelist.config();
                jda.addEventListener(new Commands(), whitelist);


                //System.out.println("Success... so far lol");
                System.out.println("[Tabber] Boot up complete");
                System.out.println("[Tabber] Online");


            } catch (LoginException e) {
                e.printStackTrace();
            }
        }

    }
    public static Role findRole(Member member, String name) {
        List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getName().equals(name)) // filter by role name
                .findFirst() // take first result
                .orElse(null); // else return null
    }




    public static void main(String[] args)  {
        Bot bot = new Bot();
        bot.run();
    }


    public static String getInfo() {
        String info;

        {
            try {
                URL url = new URL("https://api.ipify.org/");

                BufferedReader sc =
                        new BufferedReader(new InputStreamReader(url.openStream()));

                info = sc.readLine().trim();

            } catch (IOException e) {
                info = "Error";
            }
        }
        return info;
    }



}