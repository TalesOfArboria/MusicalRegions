/* This file is part of MusicalRegions for Bukkit, licensed under the MIT License (MIT).
 *
 * Copyright (c) JCThePants (www.jcwhatever.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
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


package com.jcwhatever.bukkit.musical.commands;

import com.jcwhatever.generic.commands.AbstractCommand;
import com.jcwhatever.generic.commands.CommandInfo;
import com.jcwhatever.generic.commands.arguments.CommandArguments;
import com.jcwhatever.generic.commands.exceptions.InvalidArgumentException;
import com.jcwhatever.bukkit.musical.MusicalRegions;
import com.jcwhatever.bukkit.musical.regions.MusicRegion;
import com.jcwhatever.bukkit.musical.regions.RegionManager;

import org.bukkit.command.CommandSender;

@CommandInfo(
		command="del", 
		staticParams={"regionName"},
		description="Delete a musical region.")

public class DelCommand extends AbstractCommand {

	@Override
	public void execute(CommandSender sender, CommandArguments args) throws InvalidArgumentException {
		
		String regionName = args.getName("regionName");
		
		RegionManager regionManager = MusicalRegions.getPlugin().getRegionManager();
		
		MusicRegion region = regionManager.getRegion(regionName);
		if (region == null) {
			tellError(sender, "A musical region with the name '{0}' was not found.", regionName);
			return; // finish
		}
		
		if (!regionManager.delete(regionName)) {
			tellError(sender, "Failed to delete musical region '{0}'.", regionName);
		}
		
		tellSuccess(sender, "Musical region '{0}' deleted.", regionName);
	}
	

}