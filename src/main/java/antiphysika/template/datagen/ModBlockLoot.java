/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.template.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

import antiphysika.template.registry.Registrar;

public class ModBlockLoot extends BlockLootSubProvider
{
  public ModBlockLoot(HolderLookup.Provider lookupProvider)
  {
    super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
  }

  @Override
  protected Iterable<Block> getKnownBlocks ()
  {
    return Registrar.BLOCKS.getEntries()
      .stream()
      .map(e -> (Block) e.value())
      .toList();
  }

  @Override
  protected void generate ()
  {
    dropSelf(Registrar.EXAMPLE_BLOCK.get());
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :