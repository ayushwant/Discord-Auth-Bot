package GDSCtestBot;

import Commands.clearCommand;
import Commands.infoListener;
import Commands.muteCommand;
import Events.GuildMemberJoin;
import Events.GuildMessageReactionAdd;
import Events.emojiCheck;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class testBot
{
    public static JDA jda;
    public static String prefix = "!"; // to listen to commands
    private static final String botToken = "ODk0ODU0MjI4NTc1Njc4NDk1.YVwD8Q.WtBb-SP4VEoksGmdXitce54cSIY";
    public static final String adminRoleID = "890327239571406909";
    public static final String mutedRoleID = "919586767747825684";
    public static final String gform = "https://forms.gle/bWvt6QhrxtdCgHB86";

    public static void main(String[] args) throws LoginException
    {
//        jda = new JDABuilder(AccountType.BOT).setToken().build();
        // connect instance to bot
//        jda = JDABuilder.createDefault(botToken)
//                .build();

        JDABuilder builder = JDABuilder.createDefault(botToken);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        JDA jda = builder.build();

        // set online status
//        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setIdle(true);
        jda.getPresence().setActivity(Activity.watching("Mamma mia!! Here we go again"));

        jda.addEventListener(new infoListener());
        jda.addEventListener(new clearCommand());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new emojiCheck());
        jda.addEventListener(new GuildMessageReactionAdd());
        jda.addEventListener(new muteCommand());

    }
}
