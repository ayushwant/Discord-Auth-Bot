package Commands;

import GDSCtestBot.testBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class infoListener extends ListenerAdapter
{
    // capture any and every event that happens
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        // listen to "~info"
        if( args[0].equalsIgnoreCase(testBot.prefix + "info" ) )
        {
            // sending embeds
            EmbedBuilder infoEmbed = new EmbedBuilder();
            infoEmbed.setTitle("🕵️‍ Auth Bot information");
            infoEmbed.setDescription("Trying to show info thru embeds");
            infoEmbed.addField("Owner of bot", "iamspeed", false);
            infoEmbed.setColor(0xf45642);

            infoEmbed.addField("Asked by:" , event.getAuthor().getName(), true );
            infoEmbed.setFooter("Your ID: " + event.getAuthor().getId(), event.getMember().getUser().getAvatarUrl());

            event.getChannel().sendMessage((infoEmbed.build())).queue();

            // sending messages
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Hello dear sir. I'm a test bot being currently developed by batman")
                    .queue();

            // checking getting username and ID
            String userID = event.getAuthor().getId();
            String userName = event.getAuthor().getName();
            event.getChannel().sendMessage("Your name is " + userName +" isn't it?")
                    .queue();
            event.getChannel().sendMessage("Your ID is " + userID)
                    .queue();

            infoEmbed.clear();
        }

        if( args[0].equalsIgnoreCase(testBot.prefix + "me" ) )
        {
            String userID = event.getAuthor().getId();
            String userName = event.getAuthor().getName();
            String identifier = event.getAuthor().getDiscriminator();

        }


    }

}
