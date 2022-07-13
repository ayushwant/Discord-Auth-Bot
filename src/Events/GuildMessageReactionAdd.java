package Events;

import GDSCtestBot.testBot;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


// checks if X is reacted by the admin, then it deletes the msg, else it removes the reaction
public class GuildMessageReactionAdd extends ListenerAdapter
{
    @Override
    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event)
    {
        boolean isCrossEmoji = event.getReactionEmote().getName().equals("❎");
//        boolean emojiAddedByBot = event.getUser().isBot();

        boolean emojiAddedByBot = event.getMember().getUser().equals(event.getJDA().getSelfUser()); // to check for our bot
//        boolean ownerOfMsg = event.getMember().isOwner();
//        boolean ownerOFMsg = event.getMember().getUser().equals( event.getChannel().getLatestMessageId())
        boolean reactedByAdmin = event.getMember().getRoles().contains( event.getGuild().getRoleById(testBot.adminRoleID) );



        if(isCrossEmoji && !emojiAddedByBot)
        {
            if(reactedByAdmin)
                event.getChannel().deleteMessageById( event.getMessageId() ).queue();
            else event.getReaction().removeReaction().queue();
        }

    }

    public static void main(String[] args)
    {
    }
}
