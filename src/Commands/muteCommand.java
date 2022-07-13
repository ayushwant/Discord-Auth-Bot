package Commands;

import GDSCtestBot.testBot;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.WidgetUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class muteCommand extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
//        Member memberToBeMuted = event.getGuild().getMemberById(
//                args[1].replace("<@", "").replace(">", "") );
        Member memberToBeMuted = event.getMessage().getMentionedMembers().get(0);


        if(args[0].equalsIgnoreCase(testBot.prefix +"mute") && args.length>1)
        {
            assert memberToBeMuted != null;
            event.getGuild().addRoleToMember( memberToBeMuted ,
                    Objects.requireNonNull(event.getGuild().getRoleById(testBot.mutedRoleID))).complete();

        }

//        else if(args[0].equalsIgnoreCase(testBot.prefix +"unmute") )

    }
}
