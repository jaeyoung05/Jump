package net.ledestudio.example.plugin;

import net.ledestudio.example.plugin.jump.Asa;
import net.ledestudio.example.plugin.jump.Jump;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static net.ledestudio.example.common.charge.server.ServerInboundHandler.gauge1;

public class Command extends BukkitCommand {

    public Command(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)){
            return false;
        }

        if (strings.length == 0) {
            return false;
        }

        switch (strings[0].toLowerCase()){

            case "hi" -> {
                Asa.player(player);

            }

            case "go" -> {
                Jump jump = new Jump();
                jump.superJump(player, gauge1);
            }


        }






        return false;
    }

}
