/*
 * SteveBot
 * 10/8/21
 * JDK 1.8.0
 */

package stevebot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Activity.ActivityType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class SteveBot {

    public static JDABuilder builder;
    public static String prefix = "\\";
    
    //Main method
    public static void main(String[] args) throws LoginException {
        String token = "ODk1OTA2MTU0Mjg1MjQ4NTUz.YV_XoA.nDbhQiUxITPboKBQ6Lm4QRrgv3E";
        builder = JDABuilder.createDefault(token);
        
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        
        builder.setBulkDeleteSplittingEnabled(true);
        
        builder.setCompression(Compression.NONE);
        
        builder.setActivity(Activity.playing("Hackero.io"));
        
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        
        builder.addEventListeners(new Commands());
        
        builder.build();
        
    }
    
}
