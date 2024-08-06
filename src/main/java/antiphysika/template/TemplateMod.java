package antiphysika.template;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import antiphysika.template.registry.Registrar;

@Mod(TemplateMod.MOD_ID)
public class TemplateMod
{
  public static final String MOD_ID = "template";

  private static TemplateMod INSTANCE;
  private static final Logger LOGGER = LogUtils.getLogger();

  public TemplateMod (IEventBus bus, ModContainer container)
  {
    INSTANCE = this;

    // Add listener for FMLCommonSetupEvent event
    bus.addListener(this::initCommon);

    // Deferred registers
    Registrar.register(bus);

    // Register ourselves on the game bus
    NeoForge.EVENT_BUS.register(this);
  }

  public static TemplateMod getInstance ()
  {
    return INSTANCE;
  }

  public static Logger getLogger ()
  {
    return LOGGER;
  }

  private void initCommon (final FMLCommonSetupEvent event)
  {
    LOGGER.info("In {}.initCommon()", MOD_ID);
  }

  @SubscribeEvent
  public void onServerStarting (ServerStartingEvent event)
  {
    TemplateMod.getLogger().info("In ServerEvents.onServerStarting()");
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :