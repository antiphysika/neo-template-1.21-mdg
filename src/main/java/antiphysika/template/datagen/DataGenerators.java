package antiphysika.template.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static antiphysika.template.TemplateMod.MOD_ID;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class DataGenerators
{
  @SubscribeEvent
  public static void gatherData (GatherDataEvent event)
  {
    DataGenerator generator = event.getGenerator();
    PackOutput output = generator.getPackOutput();
    ExistingFileHelper exFileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    generator.addProvider(
      event.includeServer(),
      new ModBlockstateProvider(output, exFileHelper)
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :