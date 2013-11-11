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
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Class that is used for controlling teams based on XML
 *
 * @author Eric Zeiberg (MasterEjay)
 */


public class AdminCommands {

    @Command(aliases = {"start"}, desc = "Starts the match", usage = "/start" , min = 0, max = 1)
    public static void start(final CommandContext args, CommandSender sender) throws Exception {
         if (args.argsLength() == 1){
             sender.sendMessage(ChatColor.RED + "This function is not supported yet!");
             sender.sendMessage(ChatColor.YELLOW + "Countdown time set to " + args.getInteger(1));
         }
        else {
             sender.sendMessage(ChatColor.RED + "This function is not supported yet!");
         }
    }
}
