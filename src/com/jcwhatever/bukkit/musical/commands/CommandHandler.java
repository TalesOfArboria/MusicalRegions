/* This file is part of BankOfArboria for Bukkit, licensed under the MIT License (MIT).
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

import com.jcwhatever.bukkit.generic.commands.AbstractCommandHandler;
import com.jcwhatever.bukkit.musical.MusicalRegions;

public class CommandHandler extends AbstractCommandHandler {

	public CommandHandler() {
		super(MusicalRegions.getInstance());
	}

	@Override
	protected void registerCommands() {
		this.registerCommand(CreateCommand.class);
		this.registerCommand(DelCommand.class);
		this.registerCommand(ListCommand.class);
		this.registerCommand(ListMusicCommand.class);
		this.registerCommand(LoopCommand.class);
		this.registerCommand(SetRegionCommand.class);
		this.registerCommand(SetSoundCommand.class);
		
	}

}
