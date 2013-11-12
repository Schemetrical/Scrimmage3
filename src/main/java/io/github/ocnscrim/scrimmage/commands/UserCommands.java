/*
* The MIT License
*
* Copyright 2013 OCN Scrim Plugin Team.
*
* Permission is hereby granted, free of charge, to any person obtaining amplifier copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/
package io.github.ocnscrim.scrimmage.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import io.github.ocnscrim.scrimmage.map.MapTeam;
import io.github.ocnscrim.scrimmage.match.TeamHandler;
import io.github.ocnscrim.scrimmage.modules.Module;
import io.github.ocnscrim.scrimmage.modules.TeamModule;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Random;

/**
 * Class that manages all user commands
 *
 * @author Eric Zeiberg (MasterEjay)
 */
public class UserCommands {

    TeamHandler teamHandler = new TeamHandler();


    @Command(aliases = {"join"}, desc = "Join a team", usage = "/join [team]" , min = 0, max = 1)
    public void join(final CommandContext args, CommandSender sender) throws Exception {
       if (args.argsLength() == 1){
        if (teamHandler.getTeamByName(args.getString(1)) == null){
            sender.sendMessage(ChatColor.RED + "That team could not be found! Perhaps you are spelling it wrong");
            return;
        }
        MapTeam team = teamHandler.getTeamByName(args.getString(1));
        team.addPlayer(sender.getName());
        sender.sendMessage("You have joined " + team.getColor() + team.getName() + ".");

       }
        if (args.argsLength() == 0){
             List<MapTeam> teams = teamHandler.getAllTeams();
             MapTeam randomTeam = teams.get(new Random().nextInt(teams.size()));
            randomTeam.addPlayer(sender.getName());
            sender.sendMessage("You have joined " + randomTeam.getColor() + randomTeam.getName() + ".");
        }
    }

}
