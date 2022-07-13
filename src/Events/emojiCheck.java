package Events;

import GDSCtestBot.testBot;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

// adds X emoji to the ~emoji-check msg
public class emojiCheck extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(testBot.prefix +"emoji-check") )
            event.getMessage().addReaction("❎").queue();
    }



}
