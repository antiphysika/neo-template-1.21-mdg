/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.template.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static antiphysika.template.TemplateMod.MOD_ID;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class DataGenerators
{
  public static void generateBlockStateData (GatherDataEvent event, PackOutput output,
                                             ExistingFileHelper exFileHelper)
  {
    event.getGenerator().addProvider(
      event.includeServer(),
      new ModBlockModels(output, exFileHelper)
    );
  }

  public static void generateBlockLootTables (GatherDataEvent event, PackOutput output,
                                             ExistingFileHelper exFileHelper)
  {
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    event.getGenerator().addProvider(
      event.includeServer(),
      new LootTableProvider(output, Collections.emptySet(), List.of(
        new LootTableProvider.SubProviderEntry(
          ModBlockLoot::new,
          LootContextParamSets.BLOCK)), lookupProvider)
    );
  }

  public static void generateBlockTags (GatherDataEvent event, PackOutput output,
                                              ExistingFileHelper exFileHelper)
  {
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    event.getGenerator().addProvider(
      event.includeServer(),
      new ModBlockTags(output, lookupProvider, exFileHelper)
    );
  }

  public static void generateTranslations (GatherDataEvent event, PackOutput output,
                                        ExistingFileHelper exFileHelper)
  {
    event.getGenerator().addProvider(
      true,
      new ModTranslations(output, "en_us")
    );
  }

  @SubscribeEvent
  public static void gatherData (GatherDataEvent event)
  {
    DataGenerator generator = event.getGenerator();
    PackOutput output = generator.getPackOutput();
    ExistingFileHelper exFileHelper = event.getExistingFileHelper();

    // Block/item models
    generateBlockStateData(event, output, exFileHelper);

    // Block loot tables
    generateBlockLootTables(event, output, exFileHelper);

    // Block tags
    generateBlockTags(event, output, exFileHelper);

    // Default en_us translations
    generateTranslations(event, output, exFileHelper);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :