/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.template.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import org.jetbrains.annotations.NotNull;

import antiphysika.template.registry.Registrar;
import static antiphysika.template.TemplateMod.MOD_ID;

public class ModBlockModels extends BlockStateProvider
{
  public ModBlockModels(PackOutput output, ExistingFileHelper exFileHelper)
  {
    super(output, MOD_ID, exFileHelper);
  }

  private void simpleBlockWithItem (@NotNull DeferredBlock<Block> block)
  {
    simpleBlockWithItem(block.get(), cubeAll(block.get()));
  }

  @Override
  protected void registerStatesAndModels()
  {
    simpleBlockWithItem(Registrar.EXAMPLE_BLOCK);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :
