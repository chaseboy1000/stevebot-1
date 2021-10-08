package stevebot;

import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        
        if (args[0].equalsIgnoreCase(SteveBot.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Information");
            info.setDescription("Sign Up and Play at Hackero.io");
            info.addField("Ceator", "SteveBot", false);
            info.setColor(Color.BLUE);
            info.setFooter("Responding to " + event.getMember().getUser().getName(), event.getMember().getUser().getAvatarUrl());
            
            event.getChannel().sendMessage(info.build()).queue();
        }
        
        if (args[0].equalsIgnoreCase(SteveBot.prefix + "stevecheck")) {
            if (event.getMember().getUser().getId().equals("245158026904993793")) {
                event.getChannel().sendMessage("You are Steve!").queue();
            } else {
                event.getChannel().sendMessage("You are a FRAUD!!!").queue();
            }
        }
        
        if (args[0].equalsIgnoreCase(SteveBot.prefix + "help")) {
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("Commands");
            help.setDescription("\\Help - Displays this menu"
                    + "\n\\Info - Gives you information"
                    + "\n\\SteveCheck - Checks if you are steve");
            help.setFooter("Responding to " + event.getMember().getUser().getName(), event.getMember().getUser().getAvatarUrl());
            
            event.getChannel().sendMessage(help.build()).queue();
        }
    }
}
