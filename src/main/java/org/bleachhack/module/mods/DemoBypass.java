package org.bleachhack.module.mods;

import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import org.bleachhack.event.events.EventPacket;
import org.bleachhack.eventbus.BleachSubscribe;
import org.bleachhack.module.Module;
import org.bleachhack.event.Event;

import static org.bleachhack.module.ModuleCategory.OVERFLOW;

public class DemoBypass extends Module {

    public DemoBypass() {
        super("DemoBypass", KEY_UNBOUND, OVERFLOW, "Bypasses the demo messages");
    }

    @BleachSubscribe
    public void DemoBypass1(EventPacket.Read eventReadPacket) {
        if (eventReadPacket.getPacket().equals(GameStateChangeS2CPacket.DEMO_MESSAGE_SHOWN)) {
            Event.setCancelled(true);
        }
    }

    @BleachSubscribe
    public void DemoBypass2(EventPacket.Read eventReadPacket) {
        if (eventReadPacket.getPacket().equals(GameStateChangeS2CPacket.GAME_WON)) {
            Event.setCancelled(true);
        }
    }
}
