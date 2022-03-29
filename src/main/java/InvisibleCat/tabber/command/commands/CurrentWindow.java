package InvisibleCat.tabber.command.commands;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.Command;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;

public class CurrentWindow implements Command {
    private String displayMessage = "Window info for " + App.getInfo();
    private String extra = "Error";

    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = Native.load("user32", User32.class);
        WinDef.HWND GetForegroundWindow();
        void GetWindowTextW(WinDef.HWND hWnd, char[] lpString, int nMaxCount);
    }

    public CurrentWindow() {
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
    public void run(ArrayList<String> args, Member author, Message message) {
        char[] buffer = new char[1024 * 2];
        User32.INSTANCE.GetWindowTextW(User32.INSTANCE.GetForegroundWindow(), buffer, 1024);
        extra = "Active window title: " + Native.toString(buffer);
    }
}
