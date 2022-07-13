package Events;

import GDSCtestBot.testBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter
{
    String[] messages = {
            "[member] joined. You must construct additional pylons.",
            "Never gonna give [member] up. Never let [member] down!",
            "Hey! Listen! [member] has joined!",
            "Ha! [member] has joined! You activated my trap card!",
            "We've been expecting you, [member].",
            "It's dangerous to go alone, take [member]!",
            "Swoooosh. [member] just landed.",
            "Brace yourselves. [member] just joined the server.",
            "A wild [member] appeared."
    };

    public void onGuildMemberJoin(GuildMemberJoinEvent event)
    {
        Random rand = new Random();
        int number = rand.nextInt(messages.length);  // pick any random number

        EmbedBuilder joinEmbed = new EmbedBuilder();
        joinEmbed.setColor(Color.cyan);
        joinEmbed.setDescription(messages[number].replace("[member]", event.getMember().getAsMention() ) );
        joinEmbed.appendDescription("\nFill the form to get verified : " + testBot.gform);

        event.getGuild().getDefaultChannel().sendMessage(joinEmbed.build()).queue();


        // Add role
        event.getGuild().addRoleToMember(event.getMember(),
//                Objects.requireNonNull(event.getGuild().getRoleById("896010312015306813")));
                (Role) event.getGuild().getRolesByName("test member", true).get(0)).complete();

//        String memberID = event.getMember().toString();

//        updating spreadsheet in infoListener.java
    }

}
