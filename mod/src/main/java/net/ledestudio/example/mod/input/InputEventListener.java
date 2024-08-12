package net.ledestudio.example.mod.input;






import net.ledestudio.example.mod.ExampleMod;


import net.ledestudio.example.mod.charge.Send;
import net.ledestudio.example.mod.client.Charge;
import net.ledestudio.example.mod.client.Client;
import net.ledestudio.example.mod.client.ClientInboundHandler;
import net.ledestudio.example.mod.screen.Layer;

import net.minecraft.client.Minecraft;

import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import static net.ledestudio.example.mod.ExampleMod.*;


@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME,  value = Dist.CLIENT)
public class InputEventListener {


    private static boolean isPressed = false;

    public static final Layer layer = ExampleMod.layer;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onClientTick(ClientTickEvent.Post event) {

        Minecraft minecraft = Minecraft.getInstance(); // Minecraft 인스턴스 가져오기
        Player player = minecraft.player; // 플레이어 인스턴스 가져오기

        if (InputMapping.KEY_EXAMPLE.get().consumeClick()) {



            if (player != null) {
                String playerName = player.getName().getString();



                if (gauge.getGauge() == 0) {

                    isPressed = true;



                    Send send = new Send();
                    send.packet(playerName,(int) gauge.getGauge(), isPressed);

                    gauge.gaugeUp();

                } else {
                    isPressed = false;
                    layer.setRender(ClientInboundHandler.isBoolean);
                    gauge.gaugeUp();
                    ExampleMod.logger().info("charging: " + gauge.getGauge());
                }

            }

        } else {
            if (player == null){
                return;
            }

                String playerName = player.getName().getString();
                isPressed = true;

                if (gauge.getGauge() > 0.5) {
                    ExampleMod.logger().info("last " + gauge.getGauge());


                    Send send = new Send();
                    send.packet(playerName,(int) gauge.getGauge(), isPressed);



                        layer.setRender(false);
                        gauge.setGauge(0);


                }
            }
        }
    }



