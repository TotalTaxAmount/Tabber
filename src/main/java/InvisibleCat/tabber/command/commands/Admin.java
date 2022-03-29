package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.command.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import static java.lang.System.setErr;
import static java.util.prefs.Preferences.systemRoot;

public class Admin implements Command {
    private final String displayMessage;
    private String extra = "";
    public Admin(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    @Override
    public String extraMessage() {
        return extra;
    }

    @Override
    public String displayMessage() {
        return this.displayMessage;
    }

    @Override
    public void run(ArrayList<String> args, Member author, Message message) {
        if(isRunningAsAdministrator()) {
            extra = "Tabber is running as admin";
            return;
        }
        extra = "Tabber is not admin";
    }


    private static boolean isRunningAsAdministrator()
    {
        Preferences preferences = systemRoot();

        synchronized (System.err)
        {
            setErr(new PrintStream(new OutputStream()
            {
                @Override
                public void write(int b)
                {
                }
            }));

            try
            {
                preferences.put("foo", "bar"); // SecurityException on Windows
                preferences.remove("foo");
                preferences.flush(); // BackingStoreException on Linux
                return true;
            } catch (Exception e)
            {
                return false;
            } finally
            {
                //setErr(System.err);
            }
        }
    }
}
