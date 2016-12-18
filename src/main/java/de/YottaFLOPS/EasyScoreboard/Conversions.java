package de.YottaFLOPS.EasyScoreboard;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.api.text.Text;

import de.YottaFLOPS.EasyScoreboard.Replacements.Colors;
import de.YottaFLOPS.EasyScoreboard.Replacements.Replacements;
import de.YottaFLOPS.EasyScoreboard.Replacements.Styles;

public class Conversions {
    //Converts a line-string into the Sponge text for multiple colors
    static Text lineToTexts(String s) {
        String[] strings = s.split(";");

        List<Text> texts = new ArrayList<>();

        for(String string : strings) {
            texts.add(stringToText(string.replaceAll(";","")));
        }

        return Text.join(texts);
    }

    //Converts a string into the Sponge Text
    private static Text stringToText(String s) {
        return Text.of(Colors.getColor(s), Styles.getStyles(s), Replacements.replacePlaceholders(s));
    }

    //Converts a time in seconds into a human readable format
    static String secondsToTime(int secondsGiven){
        int secondsLeft = secondsGiven;
        String hours = "0";
        String minutes = "0";
        String seconds;
        String time;

        while(secondsLeft >= 3600) {
            hours = String.valueOf(Integer.valueOf(hours) + 1);
            secondsLeft = secondsLeft - 3600;
        }
        while(secondsLeft >= 60) {
            minutes = String.valueOf(Integer.valueOf(minutes) + 1);
            secondsLeft = secondsLeft - 60;
        }

        seconds = String.valueOf(secondsLeft);

        if(hours.length() == 1) {
            hours = "0" + hours;
        }
        if(minutes.length() == 1) {
            minutes = "0" + minutes;
        }
        if(seconds.length() == 1) {
            seconds = "0" + seconds;
        }

        if(!hours.equals("00")) {
            time = hours + ":" + minutes + ":" + seconds;
        } else if(!minutes.equals("00")) {
            time = minutes + ":" + seconds;
        } else {
            time = seconds;
        }

        return  time;
    }

    //Converts a time in ticks into a human readable format
    public static String ticksToTime(long ticksGiven){
        long ticksLeft = ticksGiven;
        String hours = "0";
        String minutes = "0";

        while(ticksLeft >= 1000) {
            hours = String.valueOf(Integer.valueOf(hours) + 1);
            ticksLeft = ticksLeft - 1000;
        }
        while(ticksLeft >= 167) {
            minutes = String.valueOf(Integer.valueOf(minutes) + 10);
            ticksLeft = ticksLeft - 167;
        }

        if(hours.length() == 1) {
            hours = "0" + hours;
        }
        if(minutes.length() == 1) {
            minutes = "0" + minutes;
        }

        return hours + ":" + minutes;
    }
}
