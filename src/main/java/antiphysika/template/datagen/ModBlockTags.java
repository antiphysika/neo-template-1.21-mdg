/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.template.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;

import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import antiphysika.template.registry.Registrar;
import static antiphysika.template.TemplateMod.MOD_ID;

public class ModBlockTags extends BlockTagsProvider
{
  public ModBlockTags(PackOutput output,
                      CompletableFuture<HolderLookup.Provider> lookupProvider,
                      @Nullable ExistingFileHelper exFileHelper)
  {
    super(output, lookupProvider, MOD_ID, exFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider)
  {
    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registrar.EXAMPLE_BLOCK.get());
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :