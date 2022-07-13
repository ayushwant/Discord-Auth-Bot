package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import GDSCtestBot.testBot;

import java.util.List;

public class clearCommand extends ListenerAdapter
{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        // clear n number of messages
        if(args[0].equalsIgnoreCase(testBot.prefix +"clear") )
        {
            if( args.length<2 ) // to check for argument
            {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setTitle("🕵️‍ Specify amount to delete");
                usage.setDescription("Usage: " + testBot.prefix + "clear [# of msg]" );
                usage.setColor(0xf45642);

                event.getChannel().sendMessage(usage.build()).queue();
            }

            else
            {
                //Discord lets bots delete only past 100 messages at a time
                // and also can't delete messages older than 2 weeks. So use try-catch

                try{
                    // get the required number of messages
                    List<Message> messages = event.getChannel().getHistory().
                            retrievePast(Integer.parseInt(args[1])+1).complete();

                    // delete the messages.
                    event.getChannel().deleteMessages(messages).queue();

                    // if successful -> isn't deleting it's own message rn coz event is older, and this message is new
                    event.getChannel().sendMessage("Deleted " +Integer.parseInt(args[1]) +" messages")
                            .queue();
//                    event.getChannel().sendMessage("for you baby @" +event.getAuthor())
//                            .queue();
//                    event.getChannel().deleteMessages(event.getChannel().getHistory().
//                            retrievePast(2).complete()).queue();
                }
                catch (Exception e)
                {
                    if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval limit is betw"))
                        System.out.println("too many messages to delete");
//                    else
//                        System.out.println("can't delete older than 2 weeks");
                    else
                        e.printStackTrace();
                }

            }

        }


    }

}
