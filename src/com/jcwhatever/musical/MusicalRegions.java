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


package com.jcwhatever.musical;

import com.jcwhatever.musical.commands.MusicCommandDispatcher;
import com.jcwhatever.musical.regions.RegionManager;
import com.jcwhatever.nucleus.NucleusPlugin;

import org.bukkit.ChatColor;

/**
 * Musical Regions plugin.
 *
 * <p>Uses NucleusFramework sounds and regions to play music to players that
 * enter a musical region.</p>
 */
public class MusicalRegions extends NucleusPlugin {

    private static MusicalRegions _instance;

    private RegionManager _regionManager;

    public static MusicalRegions getPlugin() {
        return _instance;
    }

    public static RegionManager getRegionManager() {
        return _instance._regionManager;
    }

    public MusicalRegions() {
        super();
    }

    @Override
    protected void onInit() {
        _instance = this;
    }

    @Override
    public String getChatPrefix() {
        return ChatColor.LIGHT_PURPLE + "[Music] " + ChatColor.RESET;
    }

    @Override
    public String getConsolePrefix() {
        return "[Music] ";
    }

    @Override
    protected void onEnablePlugin() {

        _instance = this;

        _regionManager = new RegionManager(this.getDataNode().getNode("regions"));

        registerCommands(new MusicCommandDispatcher());
        registerEventListeners(new BukkitEventListener());
    }

    @Override
    protected void onDisablePlugin() {
        _instance = null;
    }
}