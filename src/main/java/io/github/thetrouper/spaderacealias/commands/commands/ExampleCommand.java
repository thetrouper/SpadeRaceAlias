package io.github.thetrouper.spaderacealias.commands.commands;

import io.github.thetrouper.spaderacealias.commands.CustomCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ExampleCommand extends CustomCommand {

    // Register this in plugin main class!
    public ExampleCommand() {
        super("plugintemplateexample"); // This name would go into plugin.yml folder!
    }

    @Override
    public void dispatchCommand(CommandSender sender, Command command, String label, String[] args) {
        // Run anything here on command execute
        sender.sendMessage("Hello world!");
    }

    @Override
    public void registerCompletions(CompletionBuilder builder) {
        // Tab completions
        builder.addCompletion(1, "examplearg");
        builder.addCompletion(2, "argtwo");
    }
}
