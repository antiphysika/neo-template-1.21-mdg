/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.template.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import antiphysika.template.TemplateMod;
import static antiphysika.template.TemplateMod.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents
{
  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event)
  {
    // Some client setup code
    TemplateMod.getLogger().info("In ClientEvents#onClientSetup");
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :