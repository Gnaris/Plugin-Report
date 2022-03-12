package fr.gnaris.message;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TextComponentBuilder {
	
	private String msg_click = null;
	private String msg_hover = "No Text Entry";
	private String cmd = null;
	private ChatColor msg_click_color = null;
	private boolean bold = false;
	private boolean underline = false;
	private ClickEvent.Action clickevent = ClickEvent.Action.RUN_COMMAND;
	
	
	public TextComponentBuilder setMessageClick(String msg) {
		this.msg_click = msg;
		return this;
	}
	
	public TextComponentBuilder setMessageHover(String msg) {
		this.msg_hover = msg;
		return this;
	}
	
	public TextComponentBuilder setCommand(String cmd) {
		this.cmd = cmd;
		return this;
	}
	
	public TextComponentBuilder setColor(ChatColor couleur) {
		this.msg_click_color = couleur;
		return this;
	}
	
	public TextComponentBuilder setBold(boolean response) {
		this.bold = response;
		return this;
	}
	
	public TextComponentBuilder setUnderline(boolean response) {
		this.underline = response;
		return this;
	}
	
	public TextComponentBuilder setClickEvent(ClickEvent.Action event) {
		this.clickevent = event;
		return this;
	}
	
	public TextComponent build() {
		TextComponent message = new TextComponent(this.msg_click);
		message.setColor(this.msg_click_color);
		message.setBold(this.bold);
		message.setUnderlined(this.underline);
		message.setClickEvent(new ClickEvent(this.clickevent, this.cmd));
		message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(this.msg_hover).create()));
		return message;
	}
}
